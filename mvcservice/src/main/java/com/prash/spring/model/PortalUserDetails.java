/**
 * 
 */
package com.prash.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Prashanth_Meka
 *
 */
public class PortalUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="NotEmpty")
	private String password;
	@NotEmpty(message="field.empty")
	private String username;
	private Set<GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private Integer passcode;
	@NotEmpty(message="field.empty")
	private String firstName;
	@NotEmpty(message="field.empty")
	private String lastName;
	private Long merchantId;
	@NotEmpty(message="{field.empty}")
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
	private List<String> roles = new ArrayList<>();

	
	public PortalUserDetails() {

	}
	
	public PortalUserDetails(String password, String username, Set<GrantedAuthority> authorities,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled,
			Integer passcode, String firstName, String lastName, Long merchantId, String emailAddress, Long phoneNumber,
			Long mobileNumber, int isActive, Long blockCode, Date creationDate, Date activationDate, Date lastLoginDate,
			Long allianceId, String token, String ipAddress, Integer loginCount, Date accountExpirationDate,
			String accountStatus, Date passwordExpirationDate) {
		super();
		this.password = password;
		this.username = username;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public boolean isAccountNonExpired() {
		accountNonExpired = (accountExpirationDate == null)?true:accountExpirationDate.after(new Date());
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		accountNonLocked = blockCode == null;
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	

}
