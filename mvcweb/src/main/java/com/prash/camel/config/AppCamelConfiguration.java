/**
 * 
 */
package com.prash.camel.config;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Prashanth_Meka
 *
 */
@Configuration
@ComponentScan(basePackages="com.prash.camel.config")
public class AppCamelConfiguration extends CamelConfiguration {
	
	@Override
	public List<RouteBuilder> routes()	{
		List<RouteBuilder> routes = super.routes();
		System.out.println("Routes configured "+routes);
		return routes;
	}

}
