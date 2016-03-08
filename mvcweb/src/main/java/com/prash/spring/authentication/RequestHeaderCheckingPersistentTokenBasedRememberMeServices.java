package com.prash.spring.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public class RequestHeaderCheckingPersistentTokenBasedRememberMeServices
		extends PersistentTokenBasedRememberMeServices {
	public RequestHeaderCheckingPersistentTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService, PersistentTokenRepository tokenRepository) throws Exception {
		super(key, userDetailsService, tokenRepository);
	}

	protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
		String value = request.getHeader(parameter);
		return value != null && Boolean.parseBoolean(value) ? Boolean.parseBoolean(value)
				: super.rememberMeRequested(request, parameter);
	}

	protected String extractRememberMeCookie(HttpServletRequest request) {
		String cookieValue = request.getHeader(getCookieName());
		return cookieValue;
	}

	protected void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
		String cookieValue = encodeCookie(tokens);
		response.setHeader(getCookieName(), cookieValue);
	}
}