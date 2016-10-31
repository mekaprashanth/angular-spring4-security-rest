/**
 * 
 */
package com.prash.spring.repositories;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Prashanth_Meka
 *
 */

public class PortalUserTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String username;
	private String password;
	private Integer passcode;
	private String firstName;
	private String lastName;
	private Long merchantId;
	private String emailAddress;
	private Long phoneNumber;
	private Long mobileNumber;
	private int isActive;
	private Long blockCode;
	private Date creationDate;
	private Date activationDate;
	private Date lastLoginDate;
	private Long allianceId;
	private String token;
	private String ipAddress;
	private Integer loginCount;
	private Date accountExpirationDate;
	private String accountStatus;
	private Date passwordExpirationDate;
	
	
	
	
	
	public PortalUserTest(String username, String password, Integer passcode, String firstName, String lastName,
			Long merchantId, String emailAddress, Long phoneNumber, Long mobileNumber, int isActive, Long blockCode,
			Date creationDate, Date activationDate, Date lastLoginDate, Long allianceId, String token, String ipAddress,
			Integer loginCount, Date accountExpirationDate, String accountStatus, Date passwordExpirationDate) {
		super();
		this.username = username;
		this.password = password;
		this.passcode = passcode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.merchantId = merchantId;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.isActive = isActive;
		this.blockCode = blockCode;
		this.creationDate = creationDate;
		this.activationDate = activationDate;
		this.lastLoginDate = lastLoginDate;
		this.allianceId = allianceId;
		this.token = token;
		this.ipAddress = ipAddress;
		this.loginCount = loginCount;
		this.accountExpirationDate = accountExpirationDate;
		this.accountStatus = accountStatus;
		this.passwordExpirationDate = passwordExpirationDate;
	}

	public PortalUserTest() {
		
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPasscode() {
		return passcode;
	}

	public void setPasscode(Integer passcode) {
		this.passcode = passcode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Long getBlockCode() {
		return blockCode;
	}

	public void setBlockCode(Long blockCode) {
		this.blockCode = blockCode;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Long getAllianceId() {
		return allianceId;
	}

	public void setAllianceId(Long allianceId) {
		this.allianceId = allianceId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getLoginCount() {
		loginCount = (loginCount == null)?0:loginCount;
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getAccountExpirationDate() {
		return accountExpirationDate;
	}

	public void setAccountExpirationDate(Date accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getPasswordExpirationDate() {
		return passwordExpirationDate;
	}

	public void setPasswordExpirationDate(Date passwordExpirationDate) {
		this.passwordExpirationDate = passwordExpirationDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		PortalUserTest other = (PortalUserTest) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PortalUser [userId=" + userId + ", username=" + username + ", password=" + password + ", passcode="
				+ passcode + ", firstName=" + firstName + ", lastName=" + lastName + ", merchantId=" + merchantId
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", mobileNumber=" + mobileNumber
				+ ", isActive=" + isActive + ", blockCode=" + blockCode + ", creationDate=" + creationDate
				+ ", activationDate=" + activationDate + ", lastLoginDate=" + lastLoginDate + ", allianceId="
				+ allianceId + ", token=" + token + ", ipAddress=" + ipAddress + ", loginCount=" + loginCount
				+ ", accountExpirationDate=" + accountExpirationDate + ", accountStatus=" + accountStatus
				+ ", passwordExpirationDate=" + passwordExpirationDate 
				+ "]";
	}
	
	
	
}
