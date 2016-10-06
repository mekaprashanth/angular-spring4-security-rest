package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ALLIANCE database table.
 * 
 */
@Entity
@Table(name="ALLIANCE")
@NamedQuery(name="Alliance.findAll", query="SELECT a FROM Alliance a")
public class Alliance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ALLIANCE_ALLIANCEID_GENERATOR", sequenceName="SEQ_ALLIANCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALLIANCE_ALLIANCEID_GENERATOR")
	@Column(name="ALLIANCE_ID", unique=true, nullable=false, precision=3)
	private long allianceId;

	@Column(length=200)
	private String description;

	@Column(name="LABGUAGE_CODE", nullable=false, precision=2)
	private BigDecimal labguageCode;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="alliance")
	private List<Account> accounts;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="alliance")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="alliance")
	private List<Clearing> clearings;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="alliance")
	private List<Fee> fees;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="alliance")
	private List<Funding> fundings;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="alliance")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to InvoiceGroupId
	@OneToMany(mappedBy="alliance")
	private List<InvoiceGroupId> invoiceGroupIds;

	//bi-directional many-to-one association to MerchantNode
	@OneToMany(mappedBy="alliance")
	private List<MerchantNode> merchantNodes;

	//bi-directional many-to-one association to SettlementGroupId
	@OneToMany(mappedBy="alliance")
	private List<SettlementGroupId> settlementGroupIds;

	//bi-directional many-to-one association to Terminal
	@OneToMany(mappedBy="alliance")
	private List<Terminal> terminals;

	//bi-directional many-to-one association to TerminalUpload
	@OneToMany(mappedBy="alliance")
	private List<TerminalUpload> terminalUploads;

	//bi-directional many-to-one association to TermsAndCondition
	@OneToMany(mappedBy="alliance")
	private List<TermsAndCondition> termsAndConditions;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="alliance")
	private List<User> users;

	public Alliance() {
	}

	public long getAllianceId() {
		return this.allianceId;
	}

	public void setAllianceId(long allianceId) {
		this.allianceId = allianceId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getLabguageCode() {
		return this.labguageCode;
	}

	public void setLabguageCode(BigDecimal labguageCode) {
		this.labguageCode = labguageCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setAlliance(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setAlliance(null);

		return account;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setAlliance(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setAlliance(null);

		return authorisation;
	}

	public List<Clearing> getClearings() {
		return this.clearings;
	}

	public void setClearings(List<Clearing> clearings) {
		this.clearings = clearings;
	}

	public Clearing addClearing(Clearing clearing) {
		getClearings().add(clearing);
		clearing.setAlliance(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setAlliance(null);

		return clearing;
	}

	public List<Fee> getFees() {
		return this.fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public Fee addFee(Fee fee) {
		getFees().add(fee);
		fee.setAlliance(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setAlliance(null);

		return fee;
	}

	public List<Funding> getFundings() {
		return this.fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	public Funding addFunding(Funding funding) {
		getFundings().add(funding);
		funding.setAlliance(this);

		return funding;
	}

	public Funding removeFunding(Funding funding) {
		getFundings().remove(funding);
		funding.setAlliance(null);

		return funding;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setAlliance(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setAlliance(null);

		return invoice;
	}

	public List<InvoiceGroupId> getInvoiceGroupIds() {
		return this.invoiceGroupIds;
	}

	public void setInvoiceGroupIds(List<InvoiceGroupId> invoiceGroupIds) {
		this.invoiceGroupIds = invoiceGroupIds;
	}

	public InvoiceGroupId addInvoiceGroupId(InvoiceGroupId invoiceGroupId) {
		getInvoiceGroupIds().add(invoiceGroupId);
		invoiceGroupId.setAlliance(this);

		return invoiceGroupId;
	}

	public InvoiceGroupId removeInvoiceGroupId(InvoiceGroupId invoiceGroupId) {
		getInvoiceGroupIds().remove(invoiceGroupId);
		invoiceGroupId.setAlliance(null);

		return invoiceGroupId;
	}

	public List<MerchantNode> getMerchantNodes() {
		return this.merchantNodes;
	}

	public void setMerchantNodes(List<MerchantNode> merchantNodes) {
		this.merchantNodes = merchantNodes;
	}

	public MerchantNode addMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().add(merchantNode);
		merchantNode.setAlliance(this);

		return merchantNode;
	}

	public MerchantNode removeMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().remove(merchantNode);
		merchantNode.setAlliance(null);

		return merchantNode;
	}

	public List<SettlementGroupId> getSettlementGroupIds() {
		return this.settlementGroupIds;
	}

	public void setSettlementGroupIds(List<SettlementGroupId> settlementGroupIds) {
		this.settlementGroupIds = settlementGroupIds;
	}

	public SettlementGroupId addSettlementGroupId(SettlementGroupId settlementGroupId) {
		getSettlementGroupIds().add(settlementGroupId);
		settlementGroupId.setAlliance(this);

		return settlementGroupId;
	}

	public SettlementGroupId removeSettlementGroupId(SettlementGroupId settlementGroupId) {
		getSettlementGroupIds().remove(settlementGroupId);
		settlementGroupId.setAlliance(null);

		return settlementGroupId;
	}

	public List<Terminal> getTerminals() {
		return this.terminals;
	}

	public void setTerminals(List<Terminal> terminals) {
		this.terminals = terminals;
	}

	public Terminal addTerminal(Terminal terminal) {
		getTerminals().add(terminal);
		terminal.setAlliance(this);

		return terminal;
	}

	public Terminal removeTerminal(Terminal terminal) {
		getTerminals().remove(terminal);
		terminal.setAlliance(null);

		return terminal;
	}

	public List<TerminalUpload> getTerminalUploads() {
		return this.terminalUploads;
	}

	public void setTerminalUploads(List<TerminalUpload> terminalUploads) {
		this.terminalUploads = terminalUploads;
	}

	public TerminalUpload addTerminalUpload(TerminalUpload terminalUpload) {
		getTerminalUploads().add(terminalUpload);
		terminalUpload.setAlliance(this);

		return terminalUpload;
	}

	public TerminalUpload removeTerminalUpload(TerminalUpload terminalUpload) {
		getTerminalUploads().remove(terminalUpload);
		terminalUpload.setAlliance(null);

		return terminalUpload;
	}

	public List<TermsAndCondition> getTermsAndConditions() {
		return this.termsAndConditions;
	}

	public void setTermsAndConditions(List<TermsAndCondition> termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public TermsAndCondition addTermsAndCondition(TermsAndCondition termsAndCondition) {
		getTermsAndConditions().add(termsAndCondition);
		termsAndCondition.setAlliance(this);

		return termsAndCondition;
	}

	public TermsAndCondition removeTermsAndCondition(TermsAndCondition termsAndCondition) {
		getTermsAndConditions().remove(termsAndCondition);
		termsAndCondition.setAlliance(null);

		return termsAndCondition;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAlliance(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAlliance(null);

		return user;
	}

}