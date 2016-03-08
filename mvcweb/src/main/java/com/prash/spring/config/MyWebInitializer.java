package com.prash.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ExampleApplicationContext.class };
//		return new Class[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] { ExampleApplicationContext.class };
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/rest/*" };
	}

}