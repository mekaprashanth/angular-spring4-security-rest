package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MERCHANT_NODE database table.
 * 
 */
@Entity
@Table(name="MERCHANT_NODE")
@NamedQuery(name="MerchantNode.findAll", query="SELECT m FROM MerchantNode m")
public class MerchantNode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MERCHANT_NODE_MERCHANTID_GENERATOR", sequenceName="SEQ_MERCHANT_NODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MERCHANT_NODE_MERCHANTID_GENERATOR")
	@Column(name="MERCHANT_ID", unique=true, nullable=false, precision=10)
	private long merchantId;

	@Column(name="ADDRES_LINE_4", length=255)
	private String addresLine4;

	@Column(name="ADDRESS_LINE_1", nullable=false, length=255)
	private String addressLine1;

	@Column(name="ADDRESS_LINE_2", nullable=false, length=255)
	private String addressLine2;

	@Column(name="ADDRESS_LINE_3", length=255)
	private String addressLine3;

	@Column(name="ADDRESS_LINE_5", length=255)
	private String addressLine5;

	@Column(name="ADDRESS_LINE_6", length=40)
	private String addressLine6;

	@Column(name="AGREEMENT_ID", precision=10)
	private BigDecimal agreementId;

	@Column(nullable=false, length=50)
	private String city;

	@Column(name="EXTERNAL_MERCHANT_ID", nullable=false, length=30)
	private String externalMerchantId;

	@Temporal(TemporalType.DATE)
	@Column(name="FIRST_POSTING_DATE")
	private Date firstPostingDate;

	@Column(name="INVOICE_GROUP_ID", precision=10)
	private BigDecimal invoiceGroupId;

	@Column(name="MERCHANT_POI_NAME", length=150)
	private String merchantPoiName;

	@Column(nullable=false, length=30)
	private String name;

	@Column(name="POST_ZIP_CODE", nullable=false, length=8)
	private String postZipCode;

	@Column(name="TRADE_NAME", nullable=false, length=255)
	private String tradeName;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="merchantNode")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="merchantNode")
	private List<Clearing> clearings;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="merchantNode")
	private List<Fee> fees;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="merchantNode")
	private List<Funding> fundings;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="merchantNode")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to MasterHierarchy
	@OneToMany(mappedBy="merchantNode1")
	private List<MasterHierarchy> masterHierarchies1;

	//bi-directional many-to-one association to MasterHierarchy
	@OneToMany(mappedBy="merchantNode2")
	private List<MasterHierarchy> masterHierarchies2;

	//bi-directional many-to-one association to MerchantEmail
	@OneToMany(mappedBy="merchantNode")
	private List<MerchantEmail> merchantEmails;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_CODE_ID", nullable=false)
	private Country country;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BASE_CURRENCY_ID", nullable=false)
	private Currency currency;

	//bi-directional many-to-one association to MerchantType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_TYPE_ID", nullable=false)
	private MerchantType merchantType;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false)
	private Platform platform;

	//bi-directional many-to-one association to SettlementGroupId
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="PLATFORM_ID", referencedColumnName="PLATFORM_ID", nullable=false),
		@JoinColumn(name="SETTLEMENT_GROUP_ID", referencedColumnName="SETTLEMENT_GROUP_ID", nullable=false)
		})
	private SettlementGroupId settlementGroupIdBean;

	//bi-directional many-to-one association to MerchantSm
	@OneToMany(mappedBy="merchantNode")
	private List<MerchantSm> merchantSms;

	//bi-directional many-to-one association to OfflineReport
	@OneToMany(mappedBy="merchantNode")
	private List<OfflineReport> offlineReports;

	//bi-directional many-to-one association to Terminal
	@OneToMany(mappedBy="merchantNode")
	private List<Terminal> terminals;

	//bi-directional many-to-one association to TerminalUpload
	@OneToMany(mappedBy="merchantNode")
	private List<TerminalUpload> terminalUploads;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="merchantNode")
	private List<User> users;

	public MerchantNode() {
	}

	public long getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public String getAddresLine4() {
		return this.addresLine4;
	}

	public void setAddresLine4(String addresLine4) {
		this.addresLine4 = addresLine4;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine5() {
		return this.addressLine5;
	}

	public void setAddressLine5(String addressLine5) {
		this.addressLine5 = addressLine5;
	}

	public String getAddressLine6() {
		return this.addressLine6;
	}

	public void setAddressLine6(String addressLine6) {
		this.addressLine6 = addressLine6;
	}

	public BigDecimal getAgreementId() {
		return this.agreementId;
	}

	public void setAgreementId(BigDecimal agreementId) {
		this.agreementId = agreementId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getExternalMerchantId() {
		return this.externalMerchantId;
	}

	public void setExternalMerchantId(String externalMerchantId) {
		this.externalMerchantId = externalMerchantId;
	}

	public Date getFirstPostingDate() {
		return this.firstPostingDate;
	}

	public void setFirstPostingDate(Date firstPostingDate) {
		this.firstPostingDate = firstPostingDate;
	}

	public BigDecimal getInvoiceGroupId() {
		return this.invoiceGroupId;
	}

	public void setInvoiceGroupId(BigDecimal invoiceGroupId) {
		this.invoiceGroupId = invoiceGroupId;
	}

	public String getMerchantPoiName() {
		return this.merchantPoiName;
	}

	public void setMerchantPoiName(String merchantPoiName) {
		this.merchantPoiName = merchantPoiName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostZipCode() {
		return this.postZipCode;
	}

	public void setPostZipCode(String postZipCode) {
		this.postZipCode = postZipCode;
	}

	public String getTradeName() {
		return this.tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setMerchantNode(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setMerchantNode(null);

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
		clearing.setMerchantNode(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setMerchantNode(null);

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
		fee.setMerchantNode(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setMerchantNode(null);

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
		funding.setMerchantNode(this);

		return funding;
	}

	public Funding removeFunding(Funding funding) {
		getFundings().remove(funding);
		funding.setMerchantNode(null);

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
		invoice.setMerchantNode(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setMerchantNode(null);

		return invoice;
	}

	public List<MasterHierarchy> getMasterHierarchies1() {
		return this.masterHierarchies1;
	}

	public void setMasterHierarchies1(List<MasterHierarchy> masterHierarchies1) {
		this.masterHierarchies1 = masterHierarchies1;
	}

	public MasterHierarchy addMasterHierarchies1(MasterHierarchy masterHierarchies1) {
		getMasterHierarchies1().add(masterHierarchies1);
		masterHierarchies1.setMerchantNode1(this);

		return masterHierarchies1;
	}

	public MasterHierarchy removeMasterHierarchies1(MasterHierarchy masterHierarchies1) {
		getMasterHierarchies1().remove(masterHierarchies1);
		masterHierarchies1.setMerchantNode1(null);

		return masterHierarchies1;
	}

	public List<MasterHierarchy> getMasterHierarchies2() {
		return this.masterHierarchies2;
	}

	public void setMasterHierarchies2(List<MasterHierarchy> masterHierarchies2) {
		this.masterHierarchies2 = masterHierarchies2;
	}

	public MasterHierarchy addMasterHierarchies2(MasterHierarchy masterHierarchies2) {
		getMasterHierarchies2().add(masterHierarchies2);
		masterHierarchies2.setMerchantNode2(this);

		return masterHierarchies2;
	}

	public MasterHierarchy removeMasterHierarchies2(MasterHierarchy masterHierarchies2) {
		getMasterHierarchies2().remove(masterHierarchies2);
		masterHierarchies2.setMerchantNode2(null);

		return masterHierarchies2;
	}

	public List<MerchantEmail> getMerchantEmails() {
		return this.merchantEmails;
	}

	public void setMerchantEmails(List<MerchantEmail> merchantEmails) {
		this.merchantEmails = merchantEmails;
	}

	public MerchantEmail addMerchantEmail(MerchantEmail merchantEmail) {
		getMerchantEmails().add(merchantEmail);
		merchantEmail.setMerchantNode(this);

		return merchantEmail;
	}

	public MerchantEmail removeMerchantEmail(MerchantEmail merchantEmail) {
		getMerchantEmails().remove(merchantEmail);
		merchantEmail.setMerchantNode(null);

		return merchantEmail;
	}

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public MerchantType getMerchantType() {
		return this.merchantType;
	}

	public void setMerchantType(MerchantType merchantType) {
		this.merchantType = merchantType;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public SettlementGroupId getSettlementGroupIdBean() {
		return this.settlementGroupIdBean;
	}

	public void setSettlementGroupIdBean(SettlementGroupId settlementGroupIdBean) {
		this.settlementGroupIdBean = settlementGroupIdBean;
	}

	public List<MerchantSm> getMerchantSms() {
		return this.merchantSms;
	}

	public void setMerchantSms(List<MerchantSm> merchantSms) {
		this.merchantSms = merchantSms;
	}

	public MerchantSm addMerchantSm(MerchantSm merchantSm) {
		getMerchantSms().add(merchantSm);
		merchantSm.setMerchantNode(this);

		return merchantSm;
	}

	public MerchantSm removeMerchantSm(MerchantSm merchantSm) {
		getMerchantSms().remove(merchantSm);
		merchantSm.setMerchantNode(null);

		return merchantSm;
	}

	public List<OfflineReport> getOfflineReports() {
		return this.offlineReports;
	}

	public void setOfflineReports(List<OfflineReport> offlineReports) {
		this.offlineReports = offlineReports;
	}

	public OfflineReport addOfflineReport(OfflineReport offlineReport) {
		getOfflineReports().add(offlineReport);
		offlineReport.setMerchantNode(this);

		return offlineReport;
	}

	public OfflineReport removeOfflineReport(OfflineReport offlineReport) {
		getOfflineReports().remove(offlineReport);
		offlineReport.setMerchantNode(null);

		return offlineReport;
	}

	public List<Terminal> getTerminals() {
		return this.terminals;
	}

	public void setTerminals(List<Terminal> terminals) {
		this.terminals = terminals;
	}

	public Terminal addTerminal(Terminal terminal) {
		getTerminals().add(terminal);
		terminal.setMerchantNode(this);

		return terminal;
	}

	public Terminal removeTerminal(Terminal terminal) {
		getTerminals().remove(terminal);
		terminal.setMerchantNode(null);

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
		terminalUpload.setMerchantNode(this);

		return terminalUpload;
	}

	public TerminalUpload removeTerminalUpload(TerminalUpload terminalUpload) {
		getTerminalUploads().remove(terminalUpload);
		terminalUpload.setMerchantNode(null);

		return terminalUpload;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setMerchantNode(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setMerchantNode(null);

		return user;
	}

}