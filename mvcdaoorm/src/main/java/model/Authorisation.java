package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AUTHORISATION database table.
 * 
 */
@Entity
@Table(name="AUTHORISATION")
@NamedQuery(name="Authorisation.findAll", query="SELECT a FROM Authorisation a")
public class Authorisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTHORISATION_AUTHID_GENERATOR", sequenceName="SEQ_AUTHORISATION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHORISATION_AUTHID_GENERATOR")
	@Column(name="AUTH_ID", unique=true, nullable=false, precision=10)
	private long authId;

	@Column(name="ADDITIONAL_DATA", length=40)
	private String additionalData;

	@Column(name="APPROVED_FLAG", nullable=false, precision=3)
	private BigDecimal approvedFlag;

	@Column(name="AUTH_CODE", nullable=false, length=6)
	private String authCode;

	@Column(name="AUTH_FLAG", nullable=false, length=1)
	private String authFlag;

	@Column(name="AUTH_SEQ", precision=10)
	private BigDecimal authSeq;

	@Column(name="AUTH_TIME", nullable=false)
	private Object authTime;

	@Column(name="AUTH_TRAN_CURR_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal authTranCurrAmount;

	@Column(name="CVV2_RESULT_CODE", nullable=false, length=1)
	private String cvv2ResultCode;

	@Column(name="DCC_INDICATOR", nullable=false, length=1)
	private String dccIndicator;

	@Column(name="DCC_RATE", nullable=false, precision=10, scale=6)
	private BigDecimal dccRate;

	@Column(name="INSTRUMENT_NUMBER", nullable=false, length=25)
	private String instrumentNumber;

	@Column(name="INSTRUMENT_SUBTYPE", nullable=false, length=30)
	private String instrumentSubtype;

	@Column(name="IP_ADDRESS", nullable=false, length=23)
	private String ipAddress;

	@Column(name="MOTO_INDICATOR", nullable=false, length=1)
	private String motoIndicator;

	@Column(name="RECURRING_FLAG", nullable=false, precision=1)
	private BigDecimal recurringFlag;

	@Column(name="RET_REF_NUM", nullable=false, length=12)
	private String retRefNum;

	@Column(name="REVERSAL_FLAG", nullable=false, precision=1)
	private BigDecimal reversalFlag;

	@Column(name="SHOPPER_REFERENCE", nullable=false, length=25)
	private String shopperReference;

	@Column(name="STORE_ID", length=20)
	private String storeId;

	@Column(name="TERM_BATCH_NUM", nullable=false, precision=10)
	private BigDecimal termBatchNum;

	@Column(name="TERM_CURR_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal termCurrAmount;

	@Column(name="TERMINAL_ID", nullable=false, length=8)
	private String terminalId;

	@Column(name="TERMINAL_SEQ_NUM", nullable=false, precision=10)
	private BigDecimal terminalSeqNum;

	@Column(name="TRACE_ID", nullable=false, length=15)
	private String traceId;

	//bi-directional many-to-one association to Agent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to AuthRespCode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTH_RESP_CODE_ID", nullable=false)
	private AuthRespCode authRespCode;

	//bi-directional many-to-one association to AvsResponseCode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AVS_RESPONSE_CODE_ID", nullable=false)
	private AvsResponseCode avsResponseCode;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRAN_LOCATION_ID", nullable=false)
	private Country country1;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ISSUER_LOCATION_ID", nullable=false)
	private Country country2;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TERM_CURR_CODE_ID", nullable=false)
	private Currency currency1;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTH_TRAN_CURR_CODE_ID", nullable=false)
	private Currency currency2;

	//bi-directional many-to-one association to InstrumentType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INSTRUMENT_TYPE_ID", nullable=false)
	private InstrumentType instrumentType;

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
	@JoinColumn(name="AUTH_DATE_ID", nullable=false)
	private PortalDate portalDate;

	//bi-directional many-to-one association to PosEntry
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="POS_ENTRY_ID", nullable=false)
	private PosEntry posEntry;

	//bi-directional many-to-one association to PosTerminalCapability
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="POS_TERMINAL_CAPABILITY_ID", nullable=false)
	private PosTerminalCapability posTerminalCapability;

	//bi-directional many-to-one association to Responder
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RESPONDER_ID", nullable=false)
	private Responder responder;

	//bi-directional many-to-one association to SourceSystemDetailType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SOURCE_SYSTEM_DETAIL_TYPE_ID", nullable=false)
	private SourceSystemDetailType sourceSystemDetailType;

	//bi-directional many-to-one association to TransactionType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRANSACTION_TYPE_ID", nullable=false)
	private TransactionType transactionType;

	//bi-directional many-to-one association to TranMessageType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRAN_MSG_TYPE_ID", nullable=false)
	private TranMessageType tranMessageType;

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
	@OneToMany(mappedBy="authorisation")
	private List<ClearingToAuth> clearingToAuths;

	public Authorisation() {
	}

	public long getAuthId() {
		return this.authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

	public String getAdditionalData() {
		return this.additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	public BigDecimal getApprovedFlag() {
		return this.approvedFlag;
	}

	public void setApprovedFlag(BigDecimal approvedFlag) {
		this.approvedFlag = approvedFlag;
	}

	public String getAuthCode() {
		return this.authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthFlag() {
		return this.authFlag;
	}

	public void setAuthFlag(String authFlag) {
		this.authFlag = authFlag;
	}

	public BigDecimal getAuthSeq() {
		return this.authSeq;
	}

	public void setAuthSeq(BigDecimal authSeq) {
		this.authSeq = authSeq;
	}

	public Object getAuthTime() {
		return this.authTime;
	}

	public void setAuthTime(Object authTime) {
		this.authTime = authTime;
	}

	public BigDecimal getAuthTranCurrAmount() {
		return this.authTranCurrAmount;
	}

	public void setAuthTranCurrAmount(BigDecimal authTranCurrAmount) {
		this.authTranCurrAmount = authTranCurrAmount;
	}

	public String getCvv2ResultCode() {
		return this.cvv2ResultCode;
	}

	public void setCvv2ResultCode(String cvv2ResultCode) {
		this.cvv2ResultCode = cvv2ResultCode;
	}

	public String getDccIndicator() {
		return this.dccIndicator;
	}

	public void setDccIndicator(String dccIndicator) {
		this.dccIndicator = dccIndicator;
	}

	public BigDecimal getDccRate() {
		return this.dccRate;
	}

	public void setDccRate(BigDecimal dccRate) {
		this.dccRate = dccRate;
	}

	public String getInstrumentNumber() {
		return this.instrumentNumber;
	}

	public void setInstrumentNumber(String instrumentNumber) {
		this.instrumentNumber = instrumentNumber;
	}

	public String getInstrumentSubtype() {
		return this.instrumentSubtype;
	}

	public void setInstrumentSubtype(String instrumentSubtype) {
		this.instrumentSubtype = instrumentSubtype;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMotoIndicator() {
		return this.motoIndicator;
	}

	public void setMotoIndicator(String motoIndicator) {
		this.motoIndicator = motoIndicator;
	}

	public BigDecimal getRecurringFlag() {
		return this.recurringFlag;
	}

	public void setRecurringFlag(BigDecimal recurringFlag) {
		this.recurringFlag = recurringFlag;
	}

	public String getRetRefNum() {
		return this.retRefNum;
	}

	public void setRetRefNum(String retRefNum) {
		this.retRefNum = retRefNum;
	}

	public BigDecimal getReversalFlag() {
		return this.reversalFlag;
	}

	public void setReversalFlag(BigDecimal reversalFlag) {
		this.reversalFlag = reversalFlag;
	}

	public String getShopperReference() {
		return this.shopperReference;
	}

	public void setShopperReference(String shopperReference) {
		this.shopperReference = shopperReference;
	}

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getTermBatchNum() {
		return this.termBatchNum;
	}

	public void setTermBatchNum(BigDecimal termBatchNum) {
		this.termBatchNum = termBatchNum;
	}

	public BigDecimal getTermCurrAmount() {
		return this.termCurrAmount;
	}

	public void setTermCurrAmount(BigDecimal termCurrAmount) {
		this.termCurrAmount = termCurrAmount;
	}

	public String getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public BigDecimal getTerminalSeqNum() {
		return this.terminalSeqNum;
	}

	public void setTerminalSeqNum(BigDecimal terminalSeqNum) {
		this.terminalSeqNum = terminalSeqNum;
	}

	public String getTraceId() {
		return this.traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
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

	public AuthRespCode getAuthRespCode() {
		return this.authRespCode;
	}

	public void setAuthRespCode(AuthRespCode authRespCode) {
		this.authRespCode = authRespCode;
	}

	public AvsResponseCode getAvsResponseCode() {
		return this.avsResponseCode;
	}

	public void setAvsResponseCode(AvsResponseCode avsResponseCode) {
		this.avsResponseCode = avsResponseCode;
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

	public InstrumentType getInstrumentType() {
		return this.instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
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

	public PortalDate getPortalDate() {
		return this.portalDate;
	}

	public void setPortalDate(PortalDate portalDate) {
		this.portalDate = portalDate;
	}

	public PosEntry getPosEntry() {
		return this.posEntry;
	}

	public void setPosEntry(PosEntry posEntry) {
		this.posEntry = posEntry;
	}

	public PosTerminalCapability getPosTerminalCapability() {
		return this.posTerminalCapability;
	}

	public void setPosTerminalCapability(PosTerminalCapability posTerminalCapability) {
		this.posTerminalCapability = posTerminalCapability;
	}

	public Responder getResponder() {
		return this.responder;
	}

	public void setResponder(Responder responder) {
		this.responder = responder;
	}

	public SourceSystemDetailType getSourceSystemDetailType() {
		return this.sourceSystemDetailType;
	}

	public void setSourceSystemDetailType(SourceSystemDetailType sourceSystemDetailType) {
		this.sourceSystemDetailType = sourceSystemDetailType;
	}

	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public TranMessageType getTranMessageType() {
		return this.tranMessageType;
	}

	public void setTranMessageType(TranMessageType tranMessageType) {
		this.tranMessageType = tranMessageType;
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
		clearingToAuth.setAuthorisation(this);

		return clearingToAuth;
	}

	public ClearingToAuth removeClearingToAuth(ClearingToAuth clearingToAuth) {
		getClearingToAuths().remove(clearingToAuth);
		clearingToAuth.setAuthorisation(null);

		return clearingToAuth;
	}

}