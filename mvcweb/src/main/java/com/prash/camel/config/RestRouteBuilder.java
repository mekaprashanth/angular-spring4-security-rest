package com.prash.camel.config;

import org.apache.camel.CamelException;
import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder extends SpringRouteBuilder {
	final static Logger LOG = LoggerFactory.getLogger(RestRouteBuilder.class);

	public void configure() throws Exception {
		
				
		
		onException(Exception.class).log(LoggingLevel.ERROR,"Simple Error in SMS").handled(false).maximumRedeliveries(3)
		;
		from("direct:sendSmsText")
		.log("${body}")
		.to("restlet:http://localhost:8080/test/get/company?restletMethod=post");
	}
}
