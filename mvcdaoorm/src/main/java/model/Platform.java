package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PLATFORM database table.
 * 
 */
@Entity
@Table(name="PLATFORM")
@NamedQuery(name="Platform.findAll", query="SELECT p FROM Platform p")
public class Platform implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PLATFORM_PLATFORMID_GENERATOR", sequenceName="SEQ_PLATFORM")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PLATFORM_PLATFORMID_GENERATOR")
	@Column(name="PLATFORM_ID", unique=true, nullable=false, precision=3)
	private long platformId;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="platform")
	private List<Account> accounts;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="platform")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="platform")
	private List<Clearing> clearings;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="platform")
	private List<Fee> fees;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="platform")
	private List<Funding> fundings;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="platform")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to InvoiceGroupId
	@OneToMany(mappedBy="platform")
	private List<InvoiceGroupId> invoiceGroupIds;

	//bi-directional many-to-one association to MerchantNode
	@OneToMany(mappedBy="platform")
	private List<MerchantNode> merchantNodes;

	//bi-directional many-to-one association to PurchaseAddendumDetail
	@OneToMany(mappedBy="platform")
	private List<PurchaseAddendumDetail> purchaseAddendumDetails;

	//bi-directional many-to-one association to SettlementGroupId
	@OneToMany(mappedBy="platform")
	private List<SettlementGroupId> settlementGroupIds;

	//bi-directional many-to-one association to Terminal
	@OneToMany(mappedBy="platform")
	private List<Terminal> terminals;

	//bi-directional many-to-one association to TerminalUpload
	@OneToMany(mappedBy="platform")
	private List<TerminalUpload> terminalUploads;

	public Platform() {
	}

	public long getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(long platformId) {
		this.platformId = platformId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		account.setPlatform(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setPlatform(null);

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
		authorisation.setPlatform(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setPlatform(null);

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
		clearing.setPlatform(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setPlatform(null);

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
		fee.setPlatform(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setPlatform(null);

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
		funding.setPlatform(this);

		return funding;
	}

	public Funding removeFunding(Funding funding) {
		getFundings().remove(funding);
		funding.setPlatform(null);

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
		invoice.setPlatform(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setPlatform(null);

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
		invoiceGroupId.setPlatform(this);

		return invoiceGroupId;
	}

	public InvoiceGroupId removeInvoiceGroupId(InvoiceGroupId invoiceGroupId) {
		getInvoiceGroupIds().remove(invoiceGroupId);
		invoiceGroupId.setPlatform(null);

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
		merchantNode.setPlatform(this);

		return merchantNode;
	}

	public MerchantNode removeMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().remove(merchantNode);
		merchantNode.setPlatform(null);

		return merchantNode;
	}

	public List<PurchaseAddendumDetail> getPurchaseAddendumDetails() {
		return this.purchaseAddendumDetails;
	}

	public void setPurchaseAddendumDetails(List<PurchaseAddendumDetail> purchaseAddendumDetails) {
		this.purchaseAddendumDetails = purchaseAddendumDetails;
	}

	public PurchaseAddendumDetail addPurchaseAddendumDetail(PurchaseAddendumDetail purchaseAddendumDetail) {
		getPurchaseAddendumDetails().add(purchaseAddendumDetail);
		purchaseAddendumDetail.setPlatform(this);

		return purchaseAddendumDetail;
	}

	public PurchaseAddendumDetail removePurchaseAddendumDetail(PurchaseAddendumDetail purchaseAddendumDetail) {
		getPurchaseAddendumDetails().remove(purchaseAddendumDetail);
		purchaseAddendumDetail.setPlatform(null);

		return purchaseAddendumDetail;
	}

	public List<SettlementGroupId> getSettlementGroupIds() {
		return this.settlementGroupIds;
	}

	public void setSettlementGroupIds(List<SettlementGroupId> settlementGroupIds) {
		this.settlementGroupIds = settlementGroupIds;
	}

	public SettlementGroupId addSettlementGroupId(SettlementGroupId settlementGroupId) {
		getSettlementGroupIds().add(settlementGroupId);
		settlementGroupId.setPlatform(this);

		return settlementGroupId;
	}

	public SettlementGroupId removeSettlementGroupId(SettlementGroupId settlementGroupId) {
		getSettlementGroupIds().remove(settlementGroupId);
		settlementGroupId.setPlatform(null);

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
		terminal.setPlatform(this);

		return terminal;
	}

	public Terminal removeTerminal(Terminal terminal) {
		getTerminals().remove(terminal);
		terminal.setPlatform(null);

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
		terminalUpload.setPlatform(this);

		return terminalUpload;
	}

	public TerminalUpload removeTerminalUpload(TerminalUpload terminalUpload) {
		getTerminalUploads().remove(terminalUpload);
		terminalUpload.setPlatform(null);

		return terminalUpload;
	}

}