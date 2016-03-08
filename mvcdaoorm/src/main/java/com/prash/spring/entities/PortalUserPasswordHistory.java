/**
 * 
 */
package com.prash.spring.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Prashanth_Meka
 *
 */
public class PortalUserPasswordHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long userPasswordId;
	private String password;
	private PortalUser user;
	private Date dateChanged;
	private int passwordCount;
	
	public PortalUserPasswordHistory() {
		
	}

	public long getUserPasswordId() {
		return userPasswordId;
	}

	public void setUserPasswordId(long userPasswordId) {
		this.userPasswordId = userPasswordId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PortalUser getUser() {
		return user;
	}

	public void setUser(PortalUser user) {
		this.user = user;
	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public int getPasswordCount() {
		return passwordCount;
	}

	public void setPasswordCount(int passwordCount) {
		this.passwordCount = passwordCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userPasswordId ^ (userPasswordId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortalUserPasswordHistory other = (PortalUserPasswordHistory) obj;
		if (userPasswordId != other.userPasswordId)
			return false;
		return true;
	}
	
	

}
