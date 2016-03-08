package com.prash.spring.service.exception;

import org.springframework.security.authentication.AccountStatusException;

public class AccountInactiveException extends AccountStatusException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountInactiveException(String msg) {
		super(msg);
	}

	public AccountInactiveException(String msg, Throwable t) {
		super(msg, t);
	}
}