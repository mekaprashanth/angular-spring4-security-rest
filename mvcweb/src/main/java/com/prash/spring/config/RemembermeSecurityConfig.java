/**
 * 
 */
package com.prash.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prash.spring.authentication.CustomDAOAuthenticationProviderWrapper;
import com.prash.spring.authentication.HeaderUtil;
import com.prash.spring.service.PortalUserService;

/**
 * @author Prashanth_Meka
 *
 */
@Configuration
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RemembermeSecurityConfig extends WebSecurityConfigurerAdapter {

	private String tokenKey = "CUSTOMHEADERTOKEN";

	@Autowired
	DataSource datasource;

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsServiceWithoutCache;

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsServiceWithCache;

	@Autowired
	UserCache userCache;

	@Autowired
	PortalUserService portalUserService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	HeaderUtil headerUtil;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/resources/**")
		.antMatchers("/js/**")
		.antMatchers("/css/**")
		.antMatchers("/fonts/**")
		.antMatchers("/resources/**")
		.antMatchers("/partials/**")
//		.antMatchers("/rest/**")
		.antMatchers("/")
		.antMatchers("/index.html");
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.requestMatchers().regexMatchers("/rest/login.*", "/rest/oauth.*", "/login", "/logout")
		.and()
		.authorizeRequests()
		.antMatchers("/rest/login").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/rest/oauth/**").permitAll()
		.and()
		.formLogin()
		.loginProcessingUrl("/rest/login")
//		.anyRequest().authenticated()
		;
	}
	
	/**
	 * Remember me config
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(rememberMeAuthenticationProvider())
				.authenticationProvider(daoAuthenticationProviderBean())
				// .userDetailsService(userDetailsServiceWithoutCache)
				;
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


	@Bean
	public AuthenticationProvider daoAuthenticationProviderBean() {
		CustomDAOAuthenticationProviderWrapper daoAuthenticationProvider = new CustomDAOAuthenticationProviderWrapper();
		daoAuthenticationProvider.setUserDetailsService(userDetailsServiceWithoutCache);
		daoAuthenticationProvider.setPortalUserService(portalUserService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
		return new RememberMeAuthenticationProvider(tokenKey);
	}


}
