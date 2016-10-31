/**
 * 
 */
package com.prash.spring.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.prash.spring.authentication.CustomDAOAuthenticationProviderWrapper;
import com.prash.spring.authentication.CustomLogoutHandler;
import com.prash.spring.authentication.CustomUserDetailService;
import com.prash.spring.authentication.HeaderAuthenticationFilter;
import com.prash.spring.authentication.HeaderUtil;
import com.prash.spring.authentication.RequestHeaderCheckingPersistentTokenBasedRememberMeServices;
import com.prash.spring.model.ErrorDetail;
import com.prash.spring.model.PortalResponse;
import com.prash.spring.model.PortalUserDetails;
import com.prash.spring.model.UserValue;
import com.prash.spring.service.PortalUserService;
import com.prash.spring.service.exception.AccountInactiveException;
import com.prash.spring.service.exception.AccountPermanentlyBlockedException;
import com.prash.spring.service.exception.AccountTemporarilyBlockedException;
import com.prash.spring.service.web.helper.PortalResponseBuilder;

/**
 * @author Prashanth_Meka
 *
 */
@Configuration
@EnableWebSecurity
public class RemembermeSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String ACCESS_DENIED_JSON = "{\"message\":\"You are not privileged to request this resource.\", \"access-denied\":true,\"cause\":\"AUTHORIZATION_FAILURE\"}";
	private static final String UNAUTHORIZED_JSON = "{\"message\":\"Full authentication is required to access this resource.\", \"access-denied\":true,\"cause\":\"NOT AUTHENTICATED\"}";
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
		web.ignoring().antMatchers("/resources/**").antMatchers("/js/**").antMatchers("/css/**")
				.antMatchers("/fonts/**").antMatchers("/resources/**").antMatchers("/partials/**")
//				.antMatchers("/rest/**")
				.antMatchers("/").antMatchers("/index.html");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CustomAuthenticationSuccessHandler successHandler = new CustomAuthenticationSuccessHandler();
		successHandler.setHeaderUtil(headerUtil);
		successHandler.setObjectMapper(objectMapper);

		http.csrf().disable()
//		.formLogin().loginProcessingUrl("/login").usernameParameter("username")
//		.passwordParameter("password").successHandler(successHandler).failureHandler(new AuthFailureHandler())
		//.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
		.authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/rest/protected/**").access("hasRole('USER')")
//		.antMatchers(HttpMethod.GET, "/rest/protected/**").access("hasRole('ADMIN')")
//		.antMatchers(HttpMethod.POST, "/rest/protected/**").access("hasRole('ADMIN')")
//		.antMatchers(HttpMethod.DELETE, "/**").access("hasRole('ADMIN')")
		.antMatchers("/**").authenticated()
//		.antMatchers("/oauth/token").permitAll()
		.and()
		.httpBasic()
		
//		.and()
		;
//		.addFilterAfter(authenticationFilter(), RememberMeAuthenticationFilter.class).rememberMe()
//		.rememberMeServices(tokenBasedRememberMeService()).tokenRepository(persistentTokenRepository()).and()
//		.logout().logoutUrl("/logout").deleteCookies("remember_me_cookie", "JSESSIONID")
//		.addLogoutHandler(customLogoutHandler()).and().exceptionHandling()
//		.accessDeniedHandler(new CustomAccessDeniedHandler())
//		.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
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

	public Filter customAuthenticationFilter() {
		CustomUsernamePasswordAuthenticationFilter customFilter = new CustomUsernamePasswordAuthenticationFilter();
		customFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
		// customFilter.setAuthenticationDetailsSource(authenticationDetailsSource);
		return null;
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
	public RequestHeaderCheckingPersistentTokenBasedRememberMeServices customTokenBasedRememberMeService() {
		RequestHeaderCheckingPersistentTokenBasedRememberMeServices service = null;
		try {
			service = new RequestHeaderCheckingPersistentTokenBasedRememberMeServices(tokenKey,
					userDetailsServiceWithoutCache, persistentTokenRepository());
			service.setTokenValiditySeconds(1209600);
			service.setAlwaysRemember(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	@Bean
	public PersistentTokenBasedRememberMeServices tokenBasedRememberMeService() {
		PersistentTokenBasedRememberMeServices service = null;
		try {
			service = new PersistentTokenBasedRememberMeServices(tokenKey, userDetailsServiceWithoutCache,
					persistentTokenRepository());
			service.setParameter("rememberme");
			service.setTokenValiditySeconds(1209600);
			service.setCookieName("remember_me_cookie");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(datasource);
		return db;
	}

	private Filter authenticationFilter() {
		HeaderAuthenticationFilter headerAuthenticationFilter = new HeaderAuthenticationFilter();
		((CustomUserDetailService) userDetailsServiceWithCache).setUserCache(userCache);
		headerAuthenticationFilter.userDetailsService(userDetailsServiceWithCache);
		headerAuthenticationFilter.headerUtil(headerUtil);
		return headerAuthenticationFilter;
	}

	private CustomLogoutHandler customLogoutHandler() {
		CustomLogoutHandler logoutHandler = new CustomLogoutHandler();
		return logoutHandler;
	}

	@Bean
	RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
		return new RememberMeAuthenticationProvider(tokenKey);
	}

	private class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			System.out.println("AuthFailureHandler Login failed due to " + exception.getClass());
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			Class<?> clazz = exception.getCause().getClass();
			List<ErrorDetail> errodDetails = new ArrayList<>();

			if (clazz == AccountInactiveException.class) {
				errodDetails.add(PortalResponseBuilder.buildErrorResponse("MPERR01", "Account is Inactive"));
			} else if (clazz == AccountExpiredException.class) {
				errodDetails.add(PortalResponseBuilder.buildErrorResponse("MPERR02", "Account has Expired"));
			} else if (clazz == AccountTemporarilyBlockedException.class) {
				ErrorDetail errorDetail = PortalResponseBuilder.buildErrorResponse("MPERR03",
						"Account blocked Temporarily");
				if (exception.getMessage().indexOf("Alert") > -1) {
					errorDetail = PortalResponseBuilder.buildErrorResponse("MPERR03",
							"Account blocked Temporarily - Warn Last Attempt");
				}
				errodDetails.add(errorDetail);
			} else if (clazz == AccountPermanentlyBlockedException.class) {
				errodDetails.add(PortalResponseBuilder.buildErrorResponse("MPERR04", "Account blocked Permanently"));
			} else if (clazz == BadCredentialsException.class) {
				errodDetails.add(PortalResponseBuilder.buildErrorResponse("MPERR05", "Insufficient credentials"));
			} else {
				errodDetails.add(PortalResponseBuilder.buildErrorResponse("MPERR06", "Insufficient credentials"));
			}
			PortalResponse<Void, ErrorDetail> pr = PortalResponseBuilder.buildErrorResponse(errodDetails);
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json");
			writer.write(objectMapper.writeValueAsString(pr));
			writer.flush();
		}
	}

	private static class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

		private HeaderUtil headerUtil;
		private ObjectMapper objectMapper;

		@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication authentication) throws ServletException, IOException {
			try {
				String token = request.getHeader(HeaderUtil.HEADER_NAME);
				if (token == null || token == "") {
					token = headerUtil.createAuthToken(((UserDetails) authentication.getPrincipal()).getUsername());
				}
				PortalUserDetails user = (PortalUserDetails) authentication.getPrincipal();
				UserValue userValue = new UserValue(user.getFirstName(), user.getLastName(), user.getUsername(),
						user.getPassword());
				userValue.setRoles(Arrays.asList("ADMIN", "USER"));
				PortalResponse<UserValue, Void> pr = PortalResponseBuilder.buildSuccessResponse(userValue);

				ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();

				response.setHeader(HeaderUtil.HEADER_NAME, token);
				PrintWriter out = response.getWriter();
				out.print(writer.writeValueAsString(pr));
				out.flush();
				out.close();
			} catch (Exception e) {
				throw new ServletException("Unable to create the auth token", e);
			}
			clearAuthenticationAttributes(request);

		}

		public void setHeaderUtil(HeaderUtil headerUtil) {
			this.headerUtil = headerUtil;
		}

		public void setObjectMapper(ObjectMapper objectMapper) {
			this.objectMapper = objectMapper;
		}

	}

	private static class CustomAccessDeniedHandler implements AccessDeniedHandler {
		@Override
		public void handle(HttpServletRequest request, HttpServletResponse response,
				AccessDeniedException accessDeniedException) throws IOException, ServletException {

			System.out.println("CustomAccessDeniedHandler Login failed due to " + accessDeniedException.getClass());
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			PrintWriter out = response.getWriter();
			out.print(ACCESS_DENIED_JSON);
			out.flush();
			out.close();

		}
	}

	private static class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException, ServletException {
			System.out.println("CustomAuthenticationEntryPoint Login failed due to " + authException.getClass());
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			PrintWriter out = response.getWriter();
			out.print(UNAUTHORIZED_JSON);
			out.flush();
			out.close();
		}
	}

}
