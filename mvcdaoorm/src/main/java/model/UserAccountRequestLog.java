package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the USER_ACCOUNT_REQUEST_LOG database table.
 * 
 */
@Entity
@Table(name="USER_ACCOUNT_REQUEST_LOG")
@NamedQuery(name="UserAccountRequestLog.findAll", query="SELECT u FROM UserAccountRequestLog u")
public class UserAccountRequestLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AGREEMENT_ID", precision=10)
	private BigDecimal agreementId;

	@Column(name="ALLIANCE_ID", nullable=false, precision=5)
	private BigDecimal allianceId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="EMAIL_ADDRESS", nullable=false, length=50)
	private String emailAddress;

	@Column(name="ERROR_FLAG", nullable=false, precision=3)
	private BigDecimal errorFlag;

	@Column(length=30)
	private String forename;

	@Column(name="IP_ADDRESS", length=20)
	private String ipAddress;

	@Column(name="MERCHANT_ID", nullable=false, precision=10)
	private BigDecimal merchantId;

	@Column(name="MOBILE_NUMBER", precision=10)
	private BigDecimal mobileNumber;

	@Column(nullable=false, precision=6)
	private BigDecimal passcode;

	@Column(name="PHONE_NUMBER", precision=10)
	private BigDecimal phoneNumber;

	@Column(nullable=false, precision=10)
	private BigDecimal surname;

	@Column(name="TAX_ID", precision=10)
	private BigDecimal taxId;

	@Column(precision=10)
	private BigDecimal username;

	public UserAccountRequestLog() {
	}

	public BigDecimal getAgreementId() {
		return this.agreementId;
	}

	public void setAgreementId(BigDecimal agreementId) {
		this.agreementId = agreementId;
	}

	public BigDecimal getAllianceId() {
		return this.allianceId;
	}

	public void setAllianceId(BigDecimal allianceId) {
		this.allianceId = allianceId;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public BigDecimal getErrorFlag() {
		return this.errorFlag;
	}

	public void setErrorFlag(BigDecimal errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String getForename() {
		return this.forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public BigDecimal getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(BigDecimal merchantId) {
		this.merchantId = merchantId;
	}

	public BigDecimal getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(BigDecimal mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public BigDecimal getPasscode() {
		return this.passcode;
	}

	public void setPasscode(BigDecimal passcode) {
		this.passcode = passcode;
	}

	public BigDecimal getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(BigDecimal phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSurname() {
		return this.surname;
	}

	public void setSurname(BigDecimal surname) {
		this.surname = surname;
	}

	public BigDecimal getTaxId() {
		return this.taxId;
	}

	public void setTaxId(BigDecimal taxId) {
		this.taxId = taxId;
	}

	public BigDecimal getUsername() {
		return this.username;
	}

	public void setUsername(BigDecimal username) {
		this.username = username;
	}

}