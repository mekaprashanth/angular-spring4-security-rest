package com.prash.spring.service.exception;

import org.springframework.security.authentication.AccountStatusException;

public class AccountTemporarilyBlockedException extends AccountStatusException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountTemporarilyBlockedException(String msg) {
		super(msg);
	}

	public AccountTemporarilyBlockedException(String msg, Throwable t) {
		super(msg, t);
	}
}