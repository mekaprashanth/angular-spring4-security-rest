/**
 * 
 */
package com.prash.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Prashanth_Meka
 *
 */
public class PortalResponse<T,E> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String status;
	
	private T response;
	
	private List<E> errors;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T t) {
		this.response = t;
	}

	public List<E> getErrors() {
		return errors;
	}

	public void setErrors(List<E> errors) {
		this.errors = errors;
	}
	
	public void addError(E e)	{
		this.errors = (this.errors == null)? new ArrayList<E>():this.errors;
		this.errors.add(e);
	}

}
