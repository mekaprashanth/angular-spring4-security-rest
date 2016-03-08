/**
 * 
 */
package com.prash.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import com.prash.spring.entities.Employee;
import com.prash.spring.entities.Role;
import com.prash.spring.model.PortalUserDetails;
import com.prash.spring.model.UserValue;
import com.prash.spring.service.EmployeeService;
import com.prash.spring.service.PortalUserService;
import com.prash.spring.service.RoleService;

/**
 * @author Prashanth_Meka
 *
 */
@RestController()
//@RequestMapping("rest")
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

	public UserController() {
		System.out.println("UserController initialized " + ++count);
	}

	@RequestMapping(value = "user/{username}", produces = "application/json")

	public UserValue getUser(@PathVariable("username") String pathParam, @RequestParam("username") String requestParam) {
		System.out.println("@Pathvariable " + pathParam + " @RequestParam " + requestParam);
		String username = (pathParam == null || pathParam.isEmpty()) ? requestParam : pathParam;
		Employee employee = userService.getUser(username);
		UserValue user = new UserValue(employee.getFirstname(), employee.getLastname(), employee.getUsername(),
				employee.getPassword());
		return user;
	}
	
	
	@RequestMapping(value = "users", produces = "application/json")
	public List<Employee> list() throws JsonProcessingException	{
		ObjectWriter writer = objectMaper.writerWithDefaultPrettyPrinter();
		List<Employee> employees = userService.list();
		System.out.println("json \n"+writer.writeValueAsString(employees));
		return employees;
	}

	@RequestMapping(value = "user", 
			produces = "application/json", 
			method=RequestMethod.POST)
	public UserValue create(@RequestBody UserValue user, HttpServletResponse response) {
		logger.debug("uservalue "+user);
		int maxId =roleService.findTopOrderByRoleid();
		int maxUserId = userService.getMaxUserid();
		Employee newEmployee = new Employee(user.getUserName(),user.getPassword(),true,user.getFirstName(),user.getLastName());
		newEmployee.setUserid(++maxUserId);
		List<Role> roles = new ArrayList<Role>();
		for(String role:user.getRoles())	{
			Role roleObj = new Role();
			roleObj.setRoleid(++maxId);
			roleObj.setRole(role);
//			roleObj.setEmployee(newEmployee);
			roleObj.setUserid(newEmployee.getUserid());
			roles.add(roleObj);
		}
		newEmployee.setRole(roles);
		logger.debug(newEmployee.toString());
		userService.save(newEmployee);
		return user;
	}
	
	@RequestMapping(value = "portaluser", 
			produces = "application/json", 
			method=RequestMethod.POST)
	public PortalUserDetails createPortalUser(@Valid @RequestBody PortalUserDetails user, HttpServletResponse response) {
		portalUserService.savePortalUser(user);
		return user;
	}
	
	@RequestMapping(value = "/checklogin", 
			produces = "application/json", 
			method=RequestMethod.GET)
	public UserValue checkLogin(Authentication authentication)	{
		User user = (User)authentication.getPrincipal();
		UserValue userValue = new UserValue("", "", user.getUsername(), user.getPassword());
		userValue.setRoles(Arrays.asList("ADMIN","USER"));
		return userValue;
	}
	
	@RequestMapping(value = "/user/{username}}", 
			produces = "application/json", 
			consumes = "application/json",
			method=RequestMethod.PUT)
	public UserValue update(UserValue user, HttpServletResponse response) {
		Employee employee = userService.getUser(user.getUserName());
		employee.setPassword(user.getPassword());
		userService.save(employee);
		return user;
	}
	
	

}
