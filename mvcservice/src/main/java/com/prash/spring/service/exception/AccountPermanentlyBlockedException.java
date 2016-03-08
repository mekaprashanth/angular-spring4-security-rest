package com.prash.spring.service.exception;

import org.springframework.security.authentication.AccountStatusException;

public class AccountPermanentlyBlockedException extends AccountStatusException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountPermanentlyBlockedException(String msg) {
		super(msg);
	}

	public AccountPermanentlyBlockedException(String msg, Throwable t) {
		super(msg, t);
	}
}