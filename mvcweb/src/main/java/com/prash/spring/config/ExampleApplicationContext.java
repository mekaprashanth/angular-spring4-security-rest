package com.prash.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.prash.camel.config.AppCamelConfiguration;

@Configuration
@ComponentScan("com.prash.spring")
@PropertySource({ "classpath:application.properties", "classpath:config.properties", "classpath:database.properties" })
@Import({ AppCamelConfiguration.class })
public class ExampleApplicationContext {

	@Bean
	PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
