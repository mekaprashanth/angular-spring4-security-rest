package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CURRENCY database table.
 * 
 */
@Entity
@Table(name="CURRENCY")
@NamedQuery(name="Currency.findAll", query="SELECT c FROM Currency c")
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CURRENCY_CURRENCYID_GENERATOR", sequenceName="SEQ_CURRENCY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CURRENCY_CURRENCYID_GENERATOR")
	@Column(name="CURRENCY_ID", unique=true, nullable=false, precision=5)
	private long currencyId;

	@Column(name="CURRENCY_ALPHA3", nullable=false, length=3)
	private String currencyAlpha3;

	@Column(name="CURRENCY_CODE_NUMERIC", nullable=false, length=4)
	private String currencyCodeNumeric;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="currency")
	private List<Account> accounts;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="currency1")
	private List<Authorisation> authorisations1;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="currency2")
	private List<Authorisation> authorisations2;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="currency1")
	private List<Clearing> clearings1;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="currency2")
	private List<Clearing> clearings2;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="currency3")
	private List<Clearing> clearings3;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="currency4")
	private List<Clearing> clearings4;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="currency")
	private List<Fee> fees;

	//bi-directional many-to-one association to MerchantNode
	@OneToMany(mappedBy="currency")
	private List<MerchantNode> merchantNodes;

	//bi-directional many-to-one association to TerminalUpload
	@OneToMany(mappedBy="currency")
	private List<TerminalUpload> terminalUploads;

	public Currency() {
	}

	public long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyAlpha3() {
		return this.currencyAlpha3;
	}

	public void setCurrencyAlpha3(String currencyAlpha3) {
		this.currencyAlpha3 = currencyAlpha3;
	}

	public String getCurrencyCodeNumeric() {
		return this.currencyCodeNumeric;
	}

	public void setCurrencyCodeNumeric(String currencyCodeNumeric) {
		this.currencyCodeNumeric = currencyCodeNumeric;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
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
		account.setCurrency(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setCurrency(null);

		return account;
	}

	public List<Authorisation> getAuthorisations1() {
		return this.authorisations1;
	}

	public void setAuthorisations1(List<Authorisation> authorisations1) {
		this.authorisations1 = authorisations1;
	}

	public Authorisation addAuthorisations1(Authorisation authorisations1) {
		getAuthorisations1().add(authorisations1);
		authorisations1.setCurrency1(this);

		return authorisations1;
	}

	public Authorisation removeAuthorisations1(Authorisation authorisations1) {
		getAuthorisations1().remove(authorisations1);
		authorisations1.setCurrency1(null);

		return authorisations1;
	}

	public List<Authorisation> getAuthorisations2() {
		return this.authorisations2;
	}

	public void setAuthorisations2(List<Authorisation> authorisations2) {
		this.authorisations2 = authorisations2;
	}

	public Authorisation addAuthorisations2(Authorisation authorisations2) {
		getAuthorisations2().add(authorisations2);
		authorisations2.setCurrency2(this);

		return authorisations2;
	}

	public Authorisation removeAuthorisations2(Authorisation authorisations2) {
		getAuthorisations2().remove(authorisations2);
		authorisations2.setCurrency2(null);

		return authorisations2;
	}

	public List<Clearing> getClearings1() {
		return this.clearings1;
	}

	public void setClearings1(List<Clearing> clearings1) {
		this.clearings1 = clearings1;
	}

	public Clearing addClearings1(Clearing clearings1) {
		getClearings1().add(clearings1);
		clearings1.setCurrency1(this);

		return clearings1;
	}

	public Clearing removeClearings1(Clearing clearings1) {
		getClearings1().remove(clearings1);
		clearings1.setCurrency1(null);

		return clearings1;
	}

	public List<Clearing> getClearings2() {
		return this.clearings2;
	}

	public void setClearings2(List<Clearing> clearings2) {
		this.clearings2 = clearings2;
	}

	public Clearing addClearings2(Clearing clearings2) {
		getClearings2().add(clearings2);
		clearings2.setCurrency2(this);

		return clearings2;
	}

	public Clearing removeClearings2(Clearing clearings2) {
		getClearings2().remove(clearings2);
		clearings2.setCurrency2(null);

		return clearings2;
	}

	public List<Clearing> getClearings3() {
		return this.clearings3;
	}

	public void setClearings3(List<Clearing> clearings3) {
		this.clearings3 = clearings3;
	}

	public Clearing addClearings3(Clearing clearings3) {
		getClearings3().add(clearings3);
		clearings3.setCurrency3(this);

		return clearings3;
	}

	public Clearing removeClearings3(Clearing clearings3) {
		getClearings3().remove(clearings3);
		clearings3.setCurrency3(null);

		return clearings3;
	}

	public List<Clearing> getClearings4() {
		return this.clearings4;
	}

	public void setClearings4(List<Clearing> clearings4) {
		this.clearings4 = clearings4;
	}

	public Clearing addClearings4(Clearing clearings4) {
		getClearings4().add(clearings4);
		clearings4.setCurrency4(this);

		return clearings4;
	}

	public Clearing removeClearings4(Clearing clearings4) {
		getClearings4().remove(clearings4);
		clearings4.setCurrency4(null);

		return clearings4;
	}

	public List<Fee> getFees() {
		return this.fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public Fee addFee(Fee fee) {
		getFees().add(fee);
		fee.setCurrency(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setCurrency(null);

		return fee;
	}

	public List<MerchantNode> getMerchantNodes() {
		return this.merchantNodes;
	}

	public void setMerchantNodes(List<MerchantNode> merchantNodes) {
		this.merchantNodes = merchantNodes;
	}

	public MerchantNode addMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().add(merchantNode);
		merchantNode.setCurrency(this);

		return merchantNode;
	}

	public MerchantNode removeMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().remove(merchantNode);
		merchantNode.setCurrency(null);

		return merchantNode;
	}

	public List<TerminalUpload> getTerminalUploads() {
		return this.terminalUploads;
	}

	public void setTerminalUploads(List<TerminalUpload> terminalUploads) {
		this.terminalUploads = terminalUploads;
	}

	public TerminalUpload addTerminalUpload(TerminalUpload terminalUpload) {
		getTerminalUploads().add(terminalUpload);
		terminalUpload.setCurrency(this);

		return terminalUpload;
	}

	public TerminalUpload removeTerminalUpload(TerminalUpload terminalUpload) {
		getTerminalUploads().remove(terminalUpload);
		terminalUpload.setCurrency(null);

		return terminalUpload;
	}

}