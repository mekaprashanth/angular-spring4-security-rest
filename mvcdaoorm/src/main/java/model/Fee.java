package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FEE database table.
 * 
 */
@Entity
@Table(name="FEE")
@NamedQuery(name="Fee.findAll", query="SELECT f FROM Fee f")
public class Fee implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FeePK id;

	@Column(name="CHARGE_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal chargeAmount;

	@Column(name="CHARGE_CURRENCY_ID", nullable=false, precision=5)
	private BigDecimal chargeCurrencyId;

	@Column(name="FEE_BASE", nullable=false, precision=23, scale=3)
	private BigDecimal feeBase;

	@Column(name="FEE_PERCENTAEGE", nullable=false, precision=23, scale=3)
	private BigDecimal feePercentaege;

	@Column(name="POSTED_NET_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal postedNetAmount;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to ChargeType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CHARGE_TYPE_ID", nullable=false)
	private ChargeType chargeType;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FEE_CURRENCY_ID", nullable=false)
	private Currency currency;

	//bi-directional many-to-one association to Funding
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CHARGE_SLIP_NUMBER", referencedColumnName="FUNDING_SLIP_NUMBER", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="PLATFORM_ID", referencedColumnName="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
		})
	private Funding funding;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
	private Platform platform;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="POSTING_DATE_ID", nullable=false)
	private PortalDate portalDate;

	public Fee() {
	}

	public FeePK getId() {
		return this.id;
	}

	public void setId(FeePK id) {
		this.id = id;
	}

	public BigDecimal getChargeAmount() {
		return this.chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public BigDecimal getChargeCurrencyId() {
		return this.chargeCurrencyId;
	}

	public void setChargeCurrencyId(BigDecimal chargeCurrencyId) {
		this.chargeCurrencyId = chargeCurrencyId;
	}

	public BigDecimal getFeeBase() {
		return this.feeBase;
	}

	public void setFeeBase(BigDecimal feeBase) {
		this.feeBase = feeBase;
	}

	public BigDecimal getFeePercentaege() {
		return this.feePercentaege;
	}

	public void setFeePercentaege(BigDecimal feePercentaege) {
		this.feePercentaege = feePercentaege;
	}

	public BigDecimal getPostedNetAmount() {
		return this.postedNetAmount;
	}

	public void setPostedNetAmount(BigDecimal postedNetAmount) {
		this.postedNetAmount = postedNetAmount;
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

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Funding getFunding() {
		return this.funding;
	}

	public void setFunding(Funding funding) {
		this.funding = funding;
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

}