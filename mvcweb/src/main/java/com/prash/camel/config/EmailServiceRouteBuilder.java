package com.prash.camel.config;

import java.io.IOException;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.apache.camel.spring.SpringRouteBuilder;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.firstdata.services.common.notification.CdataWriterInterceptor;
import com.firstdata.services.common.notification.NotificationPortType;

@Component
public class EmailServiceRouteBuilder extends SpringRouteBuilder {
	final static Logger LOG = LoggerFactory.getLogger(EmailServiceRouteBuilder.class);

	public void configure() throws Exception {
		CamelContext camelContext = getContext();
		CxfEndpoint cxfEndpoint = new CxfEndpoint();
		cxfEndpoint.setCamelContext(camelContext);
		cxfEndpoint.setAddress("http://localhost:8080/cxfjaxws/service/AccountWS");
		cxfEndpoint.setDataFormat(DataFormat.POJO);
		cxfEndpoint.setServiceClass(NotificationPortType.class);
		
		cxfEndpoint.getOutInterceptors().add(new CdataWriterInterceptor());
		cxfEndpoint.getOutInterceptors().add(new LoggingOutInterceptor());
		
		camelContext.addEndpoint("emailEndpoint", cxfEndpoint);

		onException(Exception.class).log(LoggingLevel.ERROR,"Simple Error in Email").maximumRedeliveries(3);
		from("direct:sendEmail")
		.to("emailEndpoint");
	}
}
