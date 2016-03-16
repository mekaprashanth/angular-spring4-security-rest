/**
 * 
 */
package com.prash.spring.controller;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.restlet.data.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.firstdata.services.common.notification.AdditionalMessageData;
import com.firstdata.services.common.notification.MsgField;
import com.firstdata.services.common.notification.Notification;
import com.firstdata.services.common.notification.NotificationHeader;
import com.firstdatacorp.services.firstvision.voicesagetext.Contact;
import com.firstdatacorp.services.firstvision.voicesagetext.Keyvaluepair;
import com.firstdatacorp.services.firstvision.voicesagetext.Parameters;
import com.firstdatacorp.services.firstvision.voicesagetext.Schedules;
import com.firstdatacorp.services.firstvision.voicesagetext.TextSchedulerReq;
import com.prash.spring.entities.Employee;
import com.prash.spring.entities.Role;
import com.prash.spring.model.ErrorDetail;
import com.prash.spring.model.PortalResponse;
import com.prash.spring.model.PortalUserDetails;
import com.prash.spring.model.UserValue;
import com.prash.spring.service.EmployeeService;
import com.prash.spring.service.PortalUserService;
import com.prash.spring.service.RoleService;
import com.prash.spring.service.util.CommonUtil;
import com.prash.spring.service.web.helper.PortalResponseBuilder;

/**
 * @author Prashanth_Meka
 *
 */
@RestController()
// @RequestMapping("rest")
public class UserController {

	private static int count = 0;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	EmployeeService userService;

	@Autowired
	PortalUserService portalUserService;

	@Autowired
	RoleService roleService;

	@Autowired
	ObjectMapper objectMaper;

	@Autowired
	CamelContext camelContext;

	public UserController() {
		System.out.println("UserController initialized " + ++count);
	}

	@RequestMapping(value = "user/{username}", produces = "application/json")

	public UserValue getUser(@PathVariable("username") String pathParam,
			@RequestParam("username") String requestParam) {
		System.out.println("@Pathvariable " + pathParam + " @RequestParam " + requestParam);
		String username = (pathParam == null || pathParam.isEmpty()) ? requestParam : pathParam;
		Employee employee = userService.getUser(username);
		UserValue user = new UserValue(employee.getFirstname(), employee.getLastname(), employee.getUsername(),
				employee.getPassword());
		return user;
	}

	@RequestMapping(value = "users", produces = "application/json")
	public List<Employee> list() throws JsonProcessingException {
		ObjectWriter writer = objectMaper.writerWithDefaultPrettyPrinter();
		List<Employee> employees = userService.list();
		System.out.println("json \n" + writer.writeValueAsString(employees));
		return employees;
	}

	@RequestMapping(value = "user", produces = "application/json", method = RequestMethod.POST)
	public UserValue create(@RequestBody UserValue user, HttpServletResponse response) {
		logger.debug("uservalue " + user);
		int maxId = roleService.findTopOrderByRoleid();
		int maxUserId = userService.getMaxUserid();
		Employee newEmployee = new Employee(user.getUserName(), user.getPassword(), true, user.getFirstName(),
				user.getLastName());
		newEmployee.setUserid(++maxUserId);
		List<Role> roles = new ArrayList<Role>();
		for (String role : user.getRoles()) {
			Role roleObj = new Role();
			roleObj.setRoleid(++maxId);
			roleObj.setRole(role);
			// roleObj.setEmployee(newEmployee);
			roleObj.setUserid(newEmployee.getUserid());
			roles.add(roleObj);
		}
		newEmployee.setRole(roles);
		logger.debug(newEmployee.toString());
		userService.save(newEmployee);
		return user;
	}

	@RequestMapping(value = "portaluser", produces = "application/json", method = RequestMethod.POST)
	public PortalUserDetails createPortalUser(@Valid @RequestBody PortalUserDetails user,
			HttpServletResponse response) {
		portalUserService.savePortalUser(user);
		return user;
	}

	@RequestMapping(value = "checkcamelsoap", produces = "application/json", method = RequestMethod.GET)
	public PortalResponse<?, ?> checkCamel(HttpServletResponse response) {

		ProducerTemplate template = camelContext.createProducerTemplate();
		Exchange camelResponse = template.request("direct:sendEmail", new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				exchange.setPattern(ExchangePattern.InOut);
				NotificationHeader notHeader = new NotificationHeader();
				notHeader.setActionNeeded("sendEmail");
				notHeader.setCategoryCode("Registration");
				notHeader.setCategoryKey("RegistrationKey");
				notHeader.setEventCode("RegEvent");
				notHeader.setEventTime("12/12/12");
				notHeader.setKeyLookup("RegKeyLookup");
				notHeader.setNotifyTime("12/12/12");
				notHeader.setPlatformCode("RegPlatCode");
				notHeader.setProcessID("RegProcessId");
				notHeader.setSequenceNum("100");

				AdditionalMessageData addMD = new AdditionalMessageData();
				List<MsgField> msgList = new ArrayList<>();
				MsgField m1 = new MsgField();
				m1.setFieldID("1");
				m1.setFieldName("name1");
				m1.setFieldType("type1");
				m1.setFieldValue("value1");
				URL loadedResource = this.getClass().getClassLoader().getResource("config.properties");
				InputStream is = loadedResource.openStream();
				byte[] data = CommonUtil.getBytesFromInputStream(is);
				MsgField m2 = new MsgField();
				m2.setFieldID("2");
				m2.setFieldName("name2");
				m2.setFieldType("type2");
				m2.setFieldValue(new String(data, "UTF-8"));
				msgList.add(m1);
				msgList.add(m2);
				addMD.getMsgField().addAll(msgList);

				Notification notification = new Notification();
				notification.setNotificationHeader(notHeader);
				notification.setAdditionalMessageData(addMD);
				exchange.getIn().setBody(notification);

			}
		});

		if (camelResponse.getException() != null) {
			logger.error("",camelResponse.getException());
			ErrorDetail ed = PortalResponseBuilder.buildErrorResponse("MPEMAILERR01", "Error while sending Email");
			return PortalResponseBuilder.buildErrorResponse(ed);
		}

		return PortalResponseBuilder.buildSuccessResponse(response);
	}

	@RequestMapping(value = "checkcamelrest", produces = "application/json", method = RequestMethod.GET)
	public PortalResponse<?, ?> checkCamelRest(HttpServletResponse response) throws DatatypeConfigurationException {
		ProducerTemplate template = camelContext.createProducerTemplate();
		Keyvaluepair kvp = new Keyvaluepair();
		kvp.setClientid("01043");
		kvp.setLogo("501");
		kvp.setOrg("735");
		kvp.setSMStype("Security Code");
		Contact cnt = new Contact();
		cnt.setContactRef("cref123");
		cnt.setForename("Gicnny");
		cnt.setNumber("447448806595");
		cnt.setSurname("STEPcHENS");
		cnt.getCustomValues().add(kvp);
		Schedules sch = new Schedules();
		sch.setExpiryPeriodHours(24);
		sch.setMessage(
				"Welcome to the Laura Ashley MasterCard. Your security code for purchases at laurashley.co.uk is 895.");
		sch.setOriginator("Lauraashley");
		sch.setScheduleDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar());
		sch.setScheduleRef("FA-FBSFC-123");
		sch.getContacts().add(cnt);
		Parameters p = new Parameters();
		p.setRequestRef("vsRequest123");
		p.setSecurityToken("F1istd!t@");
		p.setUserName("FD_NewDay_Testing");
		p.getSchedules().add(sch);
		final TextSchedulerReq t = new TextSchedulerReq();
		t.setHandlerName("Scheduler");
		t.setActionName("scheduleMessage");
		t.setParameters(p);
		try	{
			Object response1 = template.requestBodyAndHeader("direct:sendSmsText", t, Exchange.CONTENT_TYPE,
					MediaType.APPLICATION_JSON, Object.class);
			System.out.println("response1 " + response1);
		}catch(CamelExecutionException ex)	{
			ErrorDetail ed = PortalResponseBuilder.buildErrorResponse("MPEMAILERR01", "Error while sending SMS");			
			logger.error("",ex);
			return PortalResponseBuilder.buildErrorResponse(ed);
		}
		
		return PortalResponseBuilder.buildSuccessResponse(p);
	}

	@RequestMapping(value = "/checklogin", produces = "application/json", method = RequestMethod.GET)
	public UserValue checkLogin(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		UserValue userValue = new UserValue("", "", user.getUsername(), user.getPassword());
		userValue.setRoles(Arrays.asList("ADMIN", "USER"));
		return userValue;
	}

	@RequestMapping(value = "/user/{username}}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public UserValue update(UserValue user, HttpServletResponse response) {
		Employee employee = userService.getUser(user.getUserName());
		employee.setPassword(user.getPassword());
		userService.save(employee);
		return user;
	}

}
