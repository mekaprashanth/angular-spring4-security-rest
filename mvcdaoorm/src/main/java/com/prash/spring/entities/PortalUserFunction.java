/**
 * 
 */
package com.prash.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Prashanth_Meka
 *
 */
@Entity
@Table(name="PORTAL_USER_FUNCTION")
public class PortalUserFunction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="USER_FUNCTION_ID")
	private Long userFunctionId;
	
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="ROLE_FUNCTION_ID")
	private Long roleFunctionId;

	public Long getUserFunctionId() {
		return userFunctionId;
	}

	public void setUserFunctionId(Long userFunctionId) {
		this.userFunctionId = userFunctionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleFunctionId() {
		return roleFunctionId;
	}

	public void setRoleFunctionId(Long roleFunctionId) {
		this.roleFunctionId = roleFunctionId;
	}

	@Override
	public String toString() {
		return "PortalUserFunction [userFunctionId=" + userFunctionId + ", userId=" + userId + ", roleFunctionId="
				+ roleFunctionId + "]";
	}
	
	
	
}
