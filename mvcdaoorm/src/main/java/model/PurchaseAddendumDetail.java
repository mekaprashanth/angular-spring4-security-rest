package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PURCHASE_ADDENDUM_DETAILS database table.
 * 
 */
@Entity
@Table(name="PURCHASE_ADDENDUM_DETAILS")
@NamedQuery(name="PurchaseAddendumDetail.findAll", query="SELECT p FROM PurchaseAddendumDetail p")
public class PurchaseAddendumDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PurchaseAddendumDetailPK id;

	@Column(name="PRODUCT_LINE_GROSS_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal productLineGrossAmount;

	@Column(name="PRODUCT_NAME", nullable=false, length=150)
	private String productName;

	@Column(name="PRODUCT_TYPE", nullable=false, length=150)
	private String productType;

	@Column(name="PRODUCT_UNIT_PRICE_GROSS", nullable=false, precision=23, scale=3)
	private BigDecimal productUnitPriceGross;

	@Column(nullable=false, precision=10)
	private BigDecimal quantity;

	//bi-directional many-to-one association to Agent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	//bi-directional many-to-one association to MobileOperator
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MOBILE_OPERATOR", nullable=false)
	private MobileOperator mobileOperatorBean;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
	private Platform platform;

	public PurchaseAddendumDetail() {
	}

	public PurchaseAddendumDetailPK getId() {
		return this.id;
	}

	public void setId(PurchaseAddendumDetailPK id) {
		this.id = id;
	}

	public BigDecimal getProductLineGrossAmount() {
		return this.productLineGrossAmount;
	}

	public void setProductLineGrossAmount(BigDecimal productLineGrossAmount) {
		this.productLineGrossAmount = productLineGrossAmount;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getProductUnitPriceGross() {
		return this.productUnitPriceGross;
	}

	public void setProductUnitPriceGross(BigDecimal productUnitPriceGross) {
		this.productUnitPriceGross = productUnitPriceGross;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public MobileOperator getMobileOperatorBean() {
		return this.mobileOperatorBean;
	}

	public void setMobileOperatorBean(MobileOperator mobileOperatorBean) {
		this.mobileOperatorBean = mobileOperatorBean;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

}