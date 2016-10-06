package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the FUNDING database table.
 * 
 */
@Entity
@Table(name="FUNDING")
@NamedQuery(name="Funding.findAll", query="SELECT f FROM Funding f")
public class Funding implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FundingPK id;

	@Column(name="ACCOUNT_CURRENCY_ID", nullable=false, precision=10)
	private BigDecimal accountCurrencyId;

	@Column(name="ACCOUNT_ID", nullable=false, precision=10)
	private BigDecimal accountId;

	@Column(name="GROSS_ACCT_AMOUNT", precision=23, scale=3)
	private BigDecimal grossAcctAmount;

	@Column(precision=10)
	private BigDecimal msc;

	@Column(name="NET_ACCT_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal netAcctAmount;

	@Column(name="NO_OF_SLIPS", nullable=false, precision=10)
	private BigDecimal noOfSlips;

	@Column(name="OTHER_DEBIT", precision=23, scale=3)
	private BigDecimal otherDebit;

	@Column(name="PAYMENT_REFERENCE_NUMBER", nullable=false, precision=10)
	private BigDecimal paymentReferenceNumber;

	@Column(precision=23, scale=3)
	private BigDecimal surcharge;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="funding")
	private List<Clearing> clearings;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="funding")
	private List<Fee> fees;

	//bi-directional many-to-one association to Agent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to ChargeType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRANSACTION_TYPE_ID", nullable=false)
	private ChargeType chargeType;

	//bi-directional many-to-one association to InstrumentType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INSTRUMENT_TYPE_ID", nullable=false)
	private InstrumentType instrumentType;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	//bi-directional many-to-one association to PaymentStatusType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PAYMENT_STATUS_TYPE_ID", nullable=false)
	private PaymentStatusType paymentStatusType;

	//bi-directional many-to-one association to PaymentTypeId
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PAYMENT_TYPE_ID", nullable=false)
	private PaymentTypeId paymentTypeIdBean;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
	private Platform platform;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FUNDING_DATE_ID", nullable=false)
	private PortalDate portalDate1;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="POSTING_DATE_ID", nullable=false)
	private PortalDate portalDate2;

	public Funding() {
	}

	public FundingPK getId() {
		return this.id;
	}

	public void setId(FundingPK id) {
		this.id = id;
	}

	public BigDecimal getAccountCurrencyId() {
		return this.accountCurrencyId;
	}

	public void setAccountCurrencyId(BigDecimal accountCurrencyId) {
		this.accountCurrencyId = accountCurrencyId;
	}

	public BigDecimal getAccountId() {
		return this.accountId;
	}

	public void setAccountId(BigDecimal accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getGrossAcctAmount() {
		return this.grossAcctAmount;
	}

	public void setGrossAcctAmount(BigDecimal grossAcctAmount) {
		this.grossAcctAmount = grossAcctAmount;
	}

	public BigDecimal getMsc() {
		return this.msc;
	}

	public void setMsc(BigDecimal msc) {
		this.msc = msc;
	}

	public BigDecimal getNetAcctAmount() {
		return this.netAcctAmount;
	}

	public void setNetAcctAmount(BigDecimal netAcctAmount) {
		this.netAcctAmount = netAcctAmount;
	}

	public BigDecimal getNoOfSlips() {
		return this.noOfSlips;
	}

	public void setNoOfSlips(BigDecimal noOfSlips) {
		this.noOfSlips = noOfSlips;
	}

	public BigDecimal getOtherDebit() {
		return this.otherDebit;
	}

	public void setOtherDebit(BigDecimal otherDebit) {
		this.otherDebit = otherDebit;
	}

	public BigDecimal getPaymentReferenceNumber() {
		return this.paymentReferenceNumber;
	}

	public void setPaymentReferenceNumber(BigDecimal paymentReferenceNumber) {
		this.paymentReferenceNumber = paymentReferenceNumber;
	}

	public BigDecimal getSurcharge() {
		return this.surcharge;
	}

	public void setSurcharge(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}

	public List<Clearing> getClearings() {
		return this.clearings;
	}

	public void setClearings(List<Clearing> clearings) {
		this.clearings = clearings;
	}

	public Clearing addClearing(Clearing clearing) {
		getClearings().add(clearing);
		clearing.setFunding(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setFunding(null);

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
		fee.setFunding(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setFunding(null);

		return fee;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public ChargeType getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	public InstrumentType getInstrumentType() {
		return this.instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public MerchantNode getMerchantNode() {
		return this.merchantNode;
	}

	public void setMerchantNode(MerchantNode merchantNode) {
		this.merchantNode = merchantNode;
	}

	public PaymentStatusType getPaymentStatusType() {
		return this.paymentStatusType;
	}

	public void setPaymentStatusType(PaymentStatusType paymentStatusType) {
		this.paymentStatusType = paymentStatusType;
	}

	public PaymentTypeId getPaymentTypeIdBean() {
		return this.paymentTypeIdBean;
	}

	public void setPaymentTypeIdBean(PaymentTypeId paymentTypeIdBean) {
		this.paymentTypeIdBean = paymentTypeIdBean;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public PortalDate getPortalDate1() {
		return this.portalDate1;
	}

	public void setPortalDate1(PortalDate portalDate1) {
		this.portalDate1 = portalDate1;
	}

	public PortalDate getPortalDate2() {
		return this.portalDate2;
	}

	public void setPortalDate2(PortalDate portalDate2) {
		this.portalDate2 = portalDate2;
	}

}