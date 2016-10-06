package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name="ACCOUNT")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AccountPK id;

	@Column(name="ACCOUNT_NAME", nullable=false, length=50)
	private String accountName;

	@Column(name="ACCOUNT_NUMBER", nullable=false, length=50)
	private String accountNumber;

	@Column(name="MERCHANT_ID", nullable=false, precision=10)
	private BigDecimal merchantId;

	//bi-directional many-to-one association to AccountType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACCOUNT_TYPE_ID", nullable=false)
	private AccountType accountType;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CURRENCY_ID", nullable=false)
	private Currency currency;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
	private Platform platform;

	public Account() {
	}

	public AccountPK getId() {
		return this.id;
	}

	public void setId(AccountPK id) {
		this.id = id;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(BigDecimal merchantId) {
		this.merchantId = merchantId;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

}