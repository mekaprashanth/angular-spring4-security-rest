package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CLEARING database table.
 * 
 */
@Entity
@Table(name="CLEARING")
@NamedQuery(name="Clearing.findAll", query="SELECT c FROM Clearing c")
public class Clearing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLEARING_CLEARINGID_GENERATOR", sequenceName="SEQ_CLEARING")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLEARING_CLEARINGID_GENERATOR")
	@Column(name="CLEARING_ID", unique=true, nullable=false, precision=10)
	private long clearingId;

	@Column(nullable=false, precision=23)
	private BigDecimal arn;

	@Column(name="AUTH_CODE", nullable=false, length=6)
	private String authCode;

	@Column(name="CASHBACK_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal cashbackAmount;

	@Column(length=150)
	private String cashier;

	@Column(name="CAT_ID", nullable=false, length=1)
	private String catId;

	@Column(name="CHARGE_DESCRIPTION", nullable=false, length=25)
	private String chargeDescription;

	@Column(name="DCC_INDICATOR", nullable=false, length=1)
	private String dccIndicator;

	@Column(name="FUND_DCC_COMM", nullable=false, precision=23, scale=3)
	private BigDecimal fundDccComm;

	@Column(name="FUNDING_GROSS_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal fundingGrossAmount;

	@Column(name="FUNDING_NET_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal fundingNetAmount;

	@Column(name="FUNDING_SPOT_RATE", nullable=false, precision=23, scale=3)
	private BigDecimal fundingSpotRate;

	@Column(name="FUNDNG_CHARGE_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal fundngChargeAmount;

	@Column(name="HAS_ARILINE_ADDENDUM", nullable=false, precision=1)
	private BigDecimal hasArilineAddendum;

	@Column(name="HAS_CAR_RENTAL_ADDENDUM", nullable=false, precision=1)
	private BigDecimal hasCarRentalAddendum;

	@Column(name="HAS_COMMERCIAL_ADDENDUM", nullable=false, precision=1)
	private BigDecimal hasCommercialAddendum;

	@Column(name="HAS_EMV_ADDENDUM", nullable=false, precision=1)
	private BigDecimal hasEmvAddendum;

	@Column(name="HAS_HOTEL_ADDENDUM", nullable=false, precision=1)
	private BigDecimal hasHotelAddendum;

	@Column(name="ICHANGE_PLAN", nullable=false, length=6)
	private String ichangePlan;

	@Column(name="ICHANGE_PROGRAM_VALUE", nullable=false, length=1)
	private String ichangeProgramValue;

	@Column(name="ICHANGE_SERVICE_TYPE", nullable=false, length=1)
	private String ichangeServiceType;

	@Column(name="INSTRUMENT_NUMBER", nullable=false, length=40)
	private String instrumentNumber;

	@Column(name="INSTRUMENT_SUBTYPE", nullable=false, precision=10)
	private BigDecimal instrumentSubtype;

	@Column(name="INTERCHANGE_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal interchangeAmount;

	@Column(name="INTERCHANGE_FEE_BASE_AMT", nullable=false, precision=7, scale=3)
	private BigDecimal interchangeFeeBaseAmt;

	@Column(name="INTERCHANGE_FEE_PERCENT", nullable=false, precision=5, scale=3)
	private BigDecimal interchangeFeePercent;

	@Column(name="MERCHANT_TRAN_REFERENCE", nullable=false, length=30)
	private String merchantTranReference;

	@Column(name="MSC_FEE_MAXIMUM", precision=7, scale=3)
	private BigDecimal mscFeeMaximum;

	@Column(name="MSC_FEE_MINIMUM", precision=7, scale=3)
	private BigDecimal mscFeeMinimum;

	@Column(name="MSC_INT_FEE_BASE_AMT", nullable=false, precision=7, scale=3)
	private BigDecimal mscIntFeeBaseAmt;

	@Column(name="MSC_INT_FEE_PERCENT", nullable=false, precision=5, scale=3)
	private BigDecimal mscIntFeePercent;

	@Column(name="ORIG_SLIP_NUM", nullable=false, length=50)
	private String origSlipNum;

	@Column(name="POS_TERMINAL_CAPABILITY_ID", nullable=false, precision=5)
	private BigDecimal posTerminalCapabilityId;

	@Column(name="RECURRING_FLAG", nullable=false, precision=3)
	private BigDecimal recurringFlag;

	@Column(name="SETTLE_CASH_ADVANCE_REFUND", nullable=false, precision=23, scale=3)
	private BigDecimal settleCashAdvanceRefund;

	@Column(name="SLIP_NUMBER", nullable=false, precision=10)
	private BigDecimal slipNumber;

	@Column(nullable=false, precision=23, scale=3)
	private BigDecimal surcharge;

	@Column(name="TERM_BATCH_NUM", nullable=false, precision=10)
	private BigDecimal termBatchNum;

	@Column(name="TERMINAL_ID", nullable=false, length=8)
	private String terminalId;

	@Column(name="TRACE_ID", nullable=false, length=15)
	private String traceId;

	@Column(name="TRAN_TIME", nullable=false)
	private Object tranTime;

	@Column(name="TRANSACTION_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal transactionAmount;

	@Column(name="TRANSACTION_CURR_ID", nullable=false, precision=5)
	private BigDecimal transactionCurrId;

	//bi-directional many-to-one association to Agent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to AuthenticationMethod
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTHENTICATION_METHOD_ID", nullable=false)
	private AuthenticationMethod authenticationMethod;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ISSUER_LOCATION_ID", nullable=false)
	private Country country1;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRAN_LOCATION_ID", nullable=false)
	private Country country2;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INTERCHANGE_CURRENCY_ID", nullable=false)
	private Currency currency1;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FUNDING_CURR_ID", nullable=false)
	private Currency currency2;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MSC_INT_FEE_BASE_CURRENCY_ID", nullable=false)
	private Currency currency3;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INTERCHANGE_BASE_CURRENCY_ID", nullable=false)
	private Currency currency4;

	//bi-directional many-to-one association to Funding
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="FUNDING_SLIP_NUMBER", referencedColumnName="FUNDING_SLIP_NUMBER", nullable=false),
		@JoinColumn(name="PLATFORM_ID", referencedColumnName="PLATFORM_ID", nullable=false)
		})
	private Funding funding;

	//bi-directional many-to-one association to InstrumentType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INSTRUMENT_TYPE", nullable=false)
	private InstrumentType instrumentTypeBean;

	//bi-directional many-to-one association to MccId
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCC_ID", nullable=false)
	private MccId mccIdBean;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false)
	private Platform platform;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="POSTING_DATE_ID", nullable=false)
	private PortalDate portalDate1;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FUNDING_DATE_ID", nullable=false)
	private PortalDate portalDate2;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRAN_DATE_ID", nullable=false)
	private PortalDate portalDate3;

	//bi-directional many-to-one association to PosEntry
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="POS_ENTRY_ID", nullable=false)
	private PosEntry posEntry;

	//bi-directional many-to-one association to ProcessingStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROCESSING_STATUS_ID", nullable=false)
	private ProcessingStatus processingStatus;

	//bi-directional many-to-one association to TransactionType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRANSACTION_TYPE_ID", nullable=false)
	private TransactionType transactionType;

	//bi-directional many-to-one association to TranSource
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRAN_SOURCE_ID", nullable=false)
	private TranSource tranSource;

	//bi-directional many-to-one association to Ucafeci
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UCAFECI_ID", nullable=false)
	private Ucafeci ucafeci;

	//bi-directional many-to-one association to WalletType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WALLET_TYPE_ID", nullable=false)
	private WalletType walletType;

	//bi-directional many-to-one association to ClearingToAuth
	@OneToMany(mappedBy="clearing")
	private List<ClearingToAuth> clearingToAuths;

	public Clearing() {
	}

	public long getClearingId() {
		return this.clearingId;
	}

	public void setClearingId(long clearingId) {
		this.clearingId = clearingId;
	}

	public BigDecimal getArn() {
		return this.arn;
	}

	public void setArn(BigDecimal arn) {
		this.arn = arn;
	}

	public String getAuthCode() {
		return this.authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public BigDecimal getCashbackAmount() {
		return this.cashbackAmount;
	}

	public void setCashbackAmount(BigDecimal cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}

	public String getCashier() {
		return this.cashier;
	}

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	public String getCatId() {
		return this.catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getChargeDescription() {
		return this.chargeDescription;
	}

	public void setChargeDescription(String chargeDescription) {
		this.chargeDescription = chargeDescription;
	}

	public String getDccIndicator() {
		return this.dccIndicator;
	}

	public void setDccIndicator(String dccIndicator) {
		this.dccIndicator = dccIndicator;
	}

	public BigDecimal getFundDccComm() {
		return this.fundDccComm;
	}

	public void setFundDccComm(BigDecimal fundDccComm) {
		this.fundDccComm = fundDccComm;
	}

	public BigDecimal getFundingGrossAmount() {
		return this.fundingGrossAmount;
	}

	public void setFundingGrossAmount(BigDecimal fundingGrossAmount) {
		this.fundingGrossAmount = fundingGrossAmount;
	}

	public BigDecimal getFundingNetAmount() {
		return this.fundingNetAmount;
	}

	public void setFundingNetAmount(BigDecimal fundingNetAmount) {
		this.fundingNetAmount = fundingNetAmount;
	}

	public BigDecimal getFundingSpotRate() {
		return this.fundingSpotRate;
	}

	public void setFundingSpotRate(BigDecimal fundingSpotRate) {
		this.fundingSpotRate = fundingSpotRate;
	}

	public BigDecimal getFundngChargeAmount() {
		return this.fundngChargeAmount;
	}

	public void setFundngChargeAmount(BigDecimal fundngChargeAmount) {
		this.fundngChargeAmount = fundngChargeAmount;
	}

	public BigDecimal getHasArilineAddendum() {
		return this.hasArilineAddendum;
	}

	public void setHasArilineAddendum(BigDecimal hasArilineAddendum) {
		this.hasArilineAddendum = hasArilineAddendum;
	}

	public BigDecimal getHasCarRentalAddendum() {
		return this.hasCarRentalAddendum;
	}

	public void setHasCarRentalAddendum(BigDecimal hasCarRentalAddendum) {
		this.hasCarRentalAddendum = hasCarRentalAddendum;
	}

	public BigDecimal getHasCommercialAddendum() {
		return this.hasCommercialAddendum;
	}

	public void setHasCommercialAddendum(BigDecimal hasCommercialAddendum) {
		this.hasCommercialAddendum = hasCommercialAddendum;
	}

	public BigDecimal getHasEmvAddendum() {
		return this.hasEmvAddendum;
	}

	public void setHasEmvAddendum(BigDecimal hasEmvAddendum) {
		this.hasEmvAddendum = hasEmvAddendum;
	}

	public BigDecimal getHasHotelAddendum() {
		return this.hasHotelAddendum;
	}

	public void setHasHotelAddendum(BigDecimal hasHotelAddendum) {
		this.hasHotelAddendum = hasHotelAddendum;
	}

	public String getIchangePlan() {
		return this.ichangePlan;
	}

	public void setIchangePlan(String ichangePlan) {
		this.ichangePlan = ichangePlan;
	}

	public String getIchangeProgramValue() {
		return this.ichangeProgramValue;
	}

	public void setIchangeProgramValue(String ichangeProgramValue) {
		this.ichangeProgramValue = ichangeProgramValue;
	}

	public String getIchangeServiceType() {
		return this.ichangeServiceType;
	}

	public void setIchangeServiceType(String ichangeServiceType) {
		this.ichangeServiceType = ichangeServiceType;
	}

	public String getInstrumentNumber() {
		return this.instrumentNumber;
	}

	public void setInstrumentNumber(String instrumentNumber) {
		this.instrumentNumber = instrumentNumber;
	}

	public BigDecimal getInstrumentSubtype() {
		return this.instrumentSubtype;
	}

	public void setInstrumentSubtype(BigDecimal instrumentSubtype) {
		this.instrumentSubtype = instrumentSubtype;
	}

	public BigDecimal getInterchangeAmount() {
		return this.interchangeAmount;
	}

	public void setInterchangeAmount(BigDecimal interchangeAmount) {
		this.interchangeAmount = interchangeAmount;
	}

	public BigDecimal getInterchangeFeeBaseAmt() {
		return this.interchangeFeeBaseAmt;
	}

	public void setInterchangeFeeBaseAmt(BigDecimal interchangeFeeBaseAmt) {
		this.interchangeFeeBaseAmt = interchangeFeeBaseAmt;
	}

	public BigDecimal getInterchangeFeePercent() {
		return this.interchangeFeePercent;
	}

	public void setInterchangeFeePercent(BigDecimal interchangeFeePercent) {
		this.interchangeFeePercent = interchangeFeePercent;
	}

	public String getMerchantTranReference() {
		return this.merchantTranReference;
	}

	public void setMerchantTranReference(String merchantTranReference) {
		this.merchantTranReference = merchantTranReference;
	}

	public BigDecimal getMscFeeMaximum() {
		return this.mscFeeMaximum;
	}

	public void setMscFeeMaximum(BigDecimal mscFeeMaximum) {
		this.mscFeeMaximum = mscFeeMaximum;
	}

	public BigDecimal getMscFeeMinimum() {
		return this.mscFeeMinimum;
	}

	public void setMscFeeMinimum(BigDecimal mscFeeMinimum) {
		this.mscFeeMinimum = mscFeeMinimum;
	}

	public BigDecimal getMscIntFeeBaseAmt() {
		return this.mscIntFeeBaseAmt;
	}

	public void setMscIntFeeBaseAmt(BigDecimal mscIntFeeBaseAmt) {
		this.mscIntFeeBaseAmt = mscIntFeeBaseAmt;
	}

	public BigDecimal getMscIntFeePercent() {
		return this.mscIntFeePercent;
	}

	public void setMscIntFeePercent(BigDecimal mscIntFeePercent) {
		this.mscIntFeePercent = mscIntFeePercent;
	}

	public String getOrigSlipNum() {
		return this.origSlipNum;
	}

	public void setOrigSlipNum(String origSlipNum) {
		this.origSlipNum = origSlipNum;
	}

	public BigDecimal getPosTerminalCapabilityId() {
		return this.posTerminalCapabilityId;
	}

	public void setPosTerminalCapabilityId(BigDecimal posTerminalCapabilityId) {
		this.posTerminalCapabilityId = posTerminalCapabilityId;
	}

	public BigDecimal getRecurringFlag() {
		return this.recurringFlag;
	}

	public void setRecurringFlag(BigDecimal recurringFlag) {
		this.recurringFlag = recurringFlag;
	}

	public BigDecimal getSettleCashAdvanceRefund() {
		return this.settleCashAdvanceRefund;
	}

	public void setSettleCashAdvanceRefund(BigDecimal settleCashAdvanceRefund) {
		this.settleCashAdvanceRefund = settleCashAdvanceRefund;
	}

	public BigDecimal getSlipNumber() {
		return this.slipNumber;
	}

	public void setSlipNumber(BigDecimal slipNumber) {
		this.slipNumber = slipNumber;
	}

	public BigDecimal getSurcharge() {
		return this.surcharge;
	}

	public void setSurcharge(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}

	public BigDecimal getTermBatchNum() {
		return this.termBatchNum;
	}

	public void setTermBatchNum(BigDecimal termBatchNum) {
		this.termBatchNum = termBatchNum;
	}

	public String getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTraceId() {
		return this.traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public Object getTranTime() {
		return this.tranTime;
	}

	public void setTranTime(Object tranTime) {
		this.tranTime = tranTime;
	}

	public BigDecimal getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public BigDecimal getTransactionCurrId() {
		return this.transactionCurrId;
	}

	public void setTransactionCurrId(BigDecimal transactionCurrId) {
		this.transactionCurrId = transactionCurrId;
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

	public AuthenticationMethod getAuthenticationMethod() {
		return this.authenticationMethod;
	}

	public void setAuthenticationMethod(AuthenticationMethod authenticationMethod) {
		this.authenticationMethod = authenticationMethod;
	}

	public Country getCountry1() {
		return this.country1;
	}

	public void setCountry1(Country country1) {
		this.country1 = country1;
	}

	public Country getCountry2() {
		return this.country2;
	}

	public void setCountry2(Country country2) {
		this.country2 = country2;
	}

	public Currency getCurrency1() {
		return this.currency1;
	}

	public void setCurrency1(Currency currency1) {
		this.currency1 = currency1;
	}

	public Currency getCurrency2() {
		return this.currency2;
	}

	public void setCurrency2(Currency currency2) {
		this.currency2 = currency2;
	}

	public Currency getCurrency3() {
		return this.currency3;
	}

	public void setCurrency3(Currency currency3) {
		this.currency3 = currency3;
	}

	public Currency getCurrency4() {
		return this.currency4;
	}

	public void setCurrency4(Currency currency4) {
		this.currency4 = currency4;
	}

	public Funding getFunding() {
		return this.funding;
	}

	public void setFunding(Funding funding) {
		this.funding = funding;
	}

	public InstrumentType getInstrumentTypeBean() {
		return this.instrumentTypeBean;
	}

	public void setInstrumentTypeBean(InstrumentType instrumentTypeBean) {
		this.instrumentTypeBean = instrumentTypeBean;
	}

	public MccId getMccIdBean() {
		return this.mccIdBean;
	}

	public void setMccIdBean(MccId mccIdBean) {
		this.mccIdBean = mccIdBean;
	}

	public MerchantNode getMerchantNode() {
		return this.merchantNode;
	}

	public void setMerchantNode(MerchantNode merchantNode) {
		this.merchantNode = merchantNode;
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

	public PortalDate getPortalDate3() {
		return this.portalDate3;
	}

	public void setPortalDate3(PortalDate portalDate3) {
		this.portalDate3 = portalDate3;
	}

	public PosEntry getPosEntry() {
		return this.posEntry;
	}

	public void setPosEntry(PosEntry posEntry) {
		this.posEntry = posEntry;
	}

	public ProcessingStatus getProcessingStatus() {
		return this.processingStatus;
	}

	public void setProcessingStatus(ProcessingStatus processingStatus) {
		this.processingStatus = processingStatus;
	}

	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public TranSource getTranSource() {
		return this.tranSource;
	}

	public void setTranSource(TranSource tranSource) {
		this.tranSource = tranSource;
	}

	public Ucafeci getUcafeci() {
		return this.ucafeci;
	}

	public void setUcafeci(Ucafeci ucafeci) {
		this.ucafeci = ucafeci;
	}

	public WalletType getWalletType() {
		return this.walletType;
	}

	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}

	public List<ClearingToAuth> getClearingToAuths() {
		return this.clearingToAuths;
	}

	public void setClearingToAuths(List<ClearingToAuth> clearingToAuths) {
		this.clearingToAuths = clearingToAuths;
	}

	public ClearingToAuth addClearingToAuth(ClearingToAuth clearingToAuth) {
		getClearingToAuths().add(clearingToAuth);
		clearingToAuth.setClearing(this);

		return clearingToAuth;
	}

	public ClearingToAuth removeClearingToAuth(ClearingToAuth clearingToAuth) {
		getClearingToAuths().remove(clearingToAuth);
		clearingToAuth.setClearing(null);

		return clearingToAuth;
	}

}