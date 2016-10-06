package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "USER" database table.
 * 
 */
@Entity
@Table(name="USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_USERID_GENERATOR", sequenceName="SEQ_USER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_USERID_GENERATOR")
	@Column(name="USER_ID", unique=true, nullable=false, precision=10)
	private long userId;

	@Temporal(TemporalType.DATE)
	@Column(name="ACCOUNT_EXPIRATION_DATE")
	private Date accountExpirationDate;

	@Column(name="ACCOUNT_STATUS", nullable=false, length=15)
	private String accountStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTIVATION_DATE")
	private Date activationDate;

	@Column(name="AGREEMENT_ID", precision=10)
	private BigDecimal agreementId;

	@Column(name="BLOCK_CODE", precision=10)
	private BigDecimal blockCode;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="DOC_NOTIFICATION_FLAG", nullable=false, precision=3)
	private BigDecimal docNotificationFlag;

	@Column(name="DOC_USER_PREFERENCE", nullable=false, precision=10)
	private BigDecimal docUserPreference;

	@Column(name="EMAIL_ADDRESS", nullable=false, length=50)
	private String emailAddress;

	@Column(length=30)
	private String forename;

	@Column(name="IP_ADDRESS", length=20)
	private String ipAddress;

	@Column(name="LANGUAGE_PREFERENCE", nullable=false, length=2)
	private String languagePreference;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_BLOCKED_DATE")
	private Date lastBlockedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_LOGIN_DATE")
	private Date lastLoginDate;

	@Column(name="LAST_NAME", nullable=false, length=50)
	private String lastName;

	@Column(name="LOGIN_COUNT", precision=1)
	private BigDecimal loginCount;

	@Column(name="MOBILE_NUMBER", precision=15)
	private BigDecimal mobileNumber;

	@Column(nullable=false, precision=6)
	private BigDecimal passcode;

	@Column(nullable=false, length=64)
	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="PASSWORD_EXPIRATION_DATE", nullable=false)
	private Date passwordExpirationDate;

	@Column(name="PHONE_NUMBER", precision=10)
	private BigDecimal phoneNumber;

	@Column(name="SEND_NEWSLETTER", nullable=false, precision=1)
	private BigDecimal sendNewsletter;

	@Column(name="TAX_ID", precision=10)
	private BigDecimal taxId;

	@Column(length=64)
	private String token;

	@Column(nullable=false, length=50)
	private String username;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	//bi-directional many-to-one association to UserFunction
	@OneToMany(mappedBy="user")
	private List<UserFunction> userFunctions;

	//bi-directional many-to-one association to UserHistory
	@OneToMany(mappedBy="user")
	private List<UserHistory> userHistories;

	//bi-directional many-to-one association to UserPasswordHistory
	@OneToMany(mappedBy="user")
	private List<UserPasswordHistory> userPasswordHistories;

	//bi-directional many-to-one association to UserTermsAcceptance
	@OneToMany(mappedBy="user")
	private List<UserTermsAcceptance> userTermsAcceptances;

	public User() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getAccountExpirationDate() {
		return this.accountExpirationDate;
	}

	public void setAccountExpirationDate(Date accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getActivationDate() {
		return this.activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public BigDecimal getAgreementId() {
		return this.agreementId;
	}

	public void setAgreementId(BigDecimal agreementId) {
		this.agreementId = agreementId;
	}

	public BigDecimal getBlockCode() {
		return this.blockCode;
	}

	public void setBlockCode(BigDecimal blockCode) {
		this.blockCode = blockCode;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getDocNotificationFlag() {
		return this.docNotificationFlag;
	}

	public void setDocNotificationFlag(BigDecimal docNotificationFlag) {
		this.docNotificationFlag = docNotificationFlag;
	}

	public BigDecimal getDocUserPreference() {
		return this.docUserPreference;
	}

	public void setDocUserPreference(BigDecimal docUserPreference) {
		this.docUserPreference = docUserPreference;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getLanguagePreference() {
		return this.languagePreference;
	}

	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}

	public Date getLastBlockedDate() {
		return this.lastBlockedDate;
	}

	public void setLastBlockedDate(Date lastBlockedDate) {
		this.lastBlockedDate = lastBlockedDate;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(BigDecimal loginCount) {
		this.loginCount = loginCount;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPasswordExpirationDate() {
		return this.passwordExpirationDate;
	}

	public void setPasswordExpirationDate(Date passwordExpirationDate) {
		this.passwordExpirationDate = passwordExpirationDate;
	}

	public BigDecimal getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(BigDecimal phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSendNewsletter() {
		return this.sendNewsletter;
	}

	public void setSendNewsletter(BigDecimal sendNewsletter) {
		this.sendNewsletter = sendNewsletter;
	}

	public BigDecimal getTaxId() {
		return this.taxId;
	}

	public void setTaxId(BigDecimal taxId) {
		this.taxId = taxId;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public MerchantNode getMerchantNode() {
		return this.merchantNode;
	}

	public void setMerchantNode(MerchantNode merchantNode) {
		this.merchantNode = merchantNode;
	}

	public List<UserFunction> getUserFunctions() {
		return this.userFunctions;
	}

	public void setUserFunctions(List<UserFunction> userFunctions) {
		this.userFunctions = userFunctions;
	}

	public UserFunction addUserFunction(UserFunction userFunction) {
		getUserFunctions().add(userFunction);
		userFunction.setUser(this);

		return userFunction;
	}

	public UserFunction removeUserFunction(UserFunction userFunction) {
		getUserFunctions().remove(userFunction);
		userFunction.setUser(null);

		return userFunction;
	}

	public List<UserHistory> getUserHistories() {
		return this.userHistories;
	}

	public void setUserHistories(List<UserHistory> userHistories) {
		this.userHistories = userHistories;
	}

	public UserHistory addUserHistory(UserHistory userHistory) {
		getUserHistories().add(userHistory);
		userHistory.setUser(this);

		return userHistory;
	}

	public UserHistory removeUserHistory(UserHistory userHistory) {
		getUserHistories().remove(userHistory);
		userHistory.setUser(null);

		return userHistory;
	}

	public List<UserPasswordHistory> getUserPasswordHistories() {
		return this.userPasswordHistories;
	}

	public void setUserPasswordHistories(List<UserPasswordHistory> userPasswordHistories) {
		this.userPasswordHistories = userPasswordHistories;
	}

	public UserPasswordHistory addUserPasswordHistory(UserPasswordHistory userPasswordHistory) {
		getUserPasswordHistories().add(userPasswordHistory);
		userPasswordHistory.setUser(this);

		return userPasswordHistory;
	}

	public UserPasswordHistory removeUserPasswordHistory(UserPasswordHistory userPasswordHistory) {
		getUserPasswordHistories().remove(userPasswordHistory);
		userPasswordHistory.setUser(null);

		return userPasswordHistory;
	}

	public List<UserTermsAcceptance> getUserTermsAcceptances() {
		return this.userTermsAcceptances;
	}

	public void setUserTermsAcceptances(List<UserTermsAcceptance> userTermsAcceptances) {
		this.userTermsAcceptances = userTermsAcceptances;
	}

	public UserTermsAcceptance addUserTermsAcceptance(UserTermsAcceptance userTermsAcceptance) {
		getUserTermsAcceptances().add(userTermsAcceptance);
		userTermsAcceptance.setUser(this);

		return userTermsAcceptance;
	}

	public UserTermsAcceptance removeUserTermsAcceptance(UserTermsAcceptance userTermsAcceptance) {
		getUserTermsAcceptances().remove(userTermsAcceptance);
		userTermsAcceptance.setUser(null);

		return userTermsAcceptance;
	}

}