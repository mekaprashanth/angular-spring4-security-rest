package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACCOUNT_TYPE database table.
 * 
 */
@Entity
@Table(name="ACCOUNT_TYPE")
@NamedQuery(name="AccountType.findAll", query="SELECT a FROM AccountType a")
public class AccountType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCOUNT_TYPE_ACCOUNTTYPEID_GENERATOR", sequenceName="SEQ_ACCOUNT_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_TYPE_ACCOUNTTYPEID_GENERATOR")
	@Column(name="ACCOUNT_TYPE_ID", unique=true, nullable=false, precision=10)
	private long accountTypeId;

	@Column(nullable=false, precision=10)
	private BigDecimal description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="accountType")
	private List<Account> accounts;

	//bi-directional many-to-one association to PaymentAccount
	@OneToMany(mappedBy="accountType")
	private List<PaymentAccount> paymentAccounts;

	public AccountType() {
	}

	public long getAccountTypeId() {
		return this.accountTypeId;
	}

	public void setAccountTypeId(long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public BigDecimal getDescription() {
		return this.description;
	}

	public void setDescription(BigDecimal description) {
		this.description = description;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setAccountType(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setAccountType(null);

		return account;
	}

	public List<PaymentAccount> getPaymentAccounts() {
		return this.paymentAccounts;
	}

	public void setPaymentAccounts(List<PaymentAccount> paymentAccounts) {
		this.paymentAccounts = paymentAccounts;
	}

	public PaymentAccount addPaymentAccount(PaymentAccount paymentAccount) {
		getPaymentAccounts().add(paymentAccount);
		paymentAccount.setAccountType(this);

		return paymentAccount;
	}

	public PaymentAccount removePaymentAccount(PaymentAccount paymentAccount) {
		getPaymentAccounts().remove(paymentAccount);
		paymentAccount.setAccountType(null);

		return paymentAccount;
	}

}