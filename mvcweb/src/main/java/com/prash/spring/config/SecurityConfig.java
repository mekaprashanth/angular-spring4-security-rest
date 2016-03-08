//package com.prash.spring.config;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.security.GeneralSecurityException;
//
//import javax.servlet.Filter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserCache;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.prash.spring.authentication.CustomLogoutHandler;
//import com.prash.spring.authentication.CustomUserDetailService;
//import com.prash.spring.authentication.HeaderAuthenticationFilter;
//import com.prash.spring.authentication.HeaderUtil;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	protected final Log logger = LogFactory.getLog(getClass());
//
//	@Autowired
//	DataSource datasource;
//
//	@Autowired
//	private UserCache userCache;
//	
//	@Autowired
//	@Qualifier("customUserDetailsService")
//	UserDetailsService userDetailsServiceWithCache;
//	
//	@Autowired
//	@Qualifier("customUserDetailsService")
//	UserDetailsService userDetailsServiceWithoutCache;
//
//	@Autowired
//	private HeaderUtil headerUtil;
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.userDetailsService(userDetailsService()).and()
//        .authenticationProvider(authenticationProviderBean())
//        .eraseCredentials(false);
//	}
//
//	@Bean
//	public AuthenticationProvider authenticationProviderBean() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsServiceWithoutCache());
//
//		return authenticationProvider;
//	}
//
//	private Filter authenticationFilter() {
//		HeaderAuthenticationFilter headerAuthenticationFilter = new HeaderAuthenticationFilter();
//		headerAuthenticationFilter.userDetailsService(userDetailsServiceWithCache());
//		headerAuthenticationFilter.headerUtil(headerUtil);
//		return headerAuthenticationFilter;
//	}
//	
//	
//	private CustomLogoutHandler customLogoutHandler() {
//		CustomLogoutHandler logoutHandler = new CustomLogoutHandler();
//		logoutHandler.setUserCache(userCache);
//	    return logoutHandler;
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		CustomAuthenticationSuccessHandler successHandler = new CustomAuthenticationSuccessHandler();
//		successHandler.headerUtil(headerUtil);
//		http.addFilterBefore(authenticationFilter(), LogoutFilter.class).
//		csrf().disable().
//		formLogin().successHandler(successHandler).loginProcessingUrl("/login").
//		and().
//		logout().logoutSuccessUrl("/logout").addLogoutHandler(customLogoutHandler()).
//		and().
//		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
//		and().
//		exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
//				.authenticationEntryPoint(new CustomAuthenticationEntryPoint()).
//		and().
//		authorizeRequests()
//		.antMatchers(HttpMethod.POST, "/login").permitAll()
//				.antMatchers(HttpMethod.POST, "/logout")
//				.authenticated()
//				.antMatchers(HttpMethod.GET, "/**").access("hasRole('USER')")
//				.antMatchers(HttpMethod.GET, "/**").access("hasRole('ADMIN')")
//				.antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
//				.antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN").anyRequest().authenticated();
//	}
//
//	protected UserDetailsService userDetailsServiceWithCache() {
//		((CustomUserDetailService)userDetailsServiceWithCache).setUserCache(userCache);
//		logger.debug("Injecting userdetailsservice with cache "+userDetailsServiceWithCache);
//		return userDetailsServiceWithCache;
//	}
//	
//	protected UserDetailsService userDetailsServiceWithoutCache() {
//		logger.debug("Injecting userdetailsservice without cache "+userDetailsServiceWithoutCache);
//		return userDetailsServiceWithoutCache;
//	}
//
//	private static class CustomAccessDeniedHandler implements AccessDeniedHandler {
//		@Override
//		public void handle(HttpServletRequest request, HttpServletResponse response,
//				AccessDeniedException accessDeniedException) throws IOException, ServletException {
//
//			response.setContentType("application/json");
//			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//			PrintWriter out = response.getWriter();
//			out.print("Access Denied for the user");
//			out.flush();
//			out.close();
//
//		}
//	}
//
//	private static class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//		@Override
//		public void commence(HttpServletRequest request, HttpServletResponse response,
//				AuthenticationException authException) throws IOException, ServletException {
//
//			response.setContentType("application/json");
//			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			PrintWriter out = response.getWriter();
//			out.print("Unauthorized access attempted");
//			out.flush();
//			out.close();
//		}
//	}
//
//	private static class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//		private HeaderUtil headerUtil;
//
//		@Override
//		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//				Authentication authentication) throws ServletException, IOException {
//			try {
//				String token = headerUtil.createAuthToken(((User) authentication.getPrincipal()).getUsername());
//				ObjectMapper mapper = new ObjectMapper();
//				ObjectNode node = mapper.createObjectNode().put("token", token);
//				PrintWriter out = response.getWriter();
//				out.print(node.toString());
//				out.flush();
//				out.close();
//			} catch (GeneralSecurityException e) {
//				throw new ServletException("Unable to create the auth token", e);
//			}
//			clearAuthenticationAttributes(request);
//
//		}
//
//		private void headerUtil(HeaderUtil headerUtil) {
//			this.headerUtil = headerUtil;
//		}
//	}
//
//}