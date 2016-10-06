package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INVOICE database table.
 * 
 */
@Entity
@Table(name="INVOICE")
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InvoicePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="INVOICE_DATE", nullable=false)
	private Date invoiceDate;

	@Temporal(TemporalType.DATE)
	@Column(name="INVOICE_FROM", nullable=false)
	private Date invoiceFrom;

	@Column(name="INVOICE_GROSSS_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal invoiceGrosssAmount;

	@Column(name="INVOICE_NET_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal invoiceNetAmount;

	@Column(name="INVOICE_NUMBER", nullable=false, length=100)
	private String invoiceNumber;

	@Column(name="INVOICE_REF", nullable=false, precision=10)
	private BigDecimal invoiceRef;

	@Temporal(TemporalType.DATE)
	@Column(name="INVOICE_TO", nullable=false)
	private Date invoiceTo;

	@Column(name="VAT_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal vatAmount;

	//bi-directional many-to-one association to Agent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
	private Platform platform;

	//bi-directional many-to-one association to InvoiceLineItem
	@OneToMany(mappedBy="invoice")
	private List<InvoiceLineItem> invoiceLineItems;

	public Invoice() {
	}

	public InvoicePK getId() {
		return this.id;
	}

	public void setId(InvoicePK id) {
		this.id = id;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getInvoiceFrom() {
		return this.invoiceFrom;
	}

	public void setInvoiceFrom(Date invoiceFrom) {
		this.invoiceFrom = invoiceFrom;
	}

	public BigDecimal getInvoiceGrosssAmount() {
		return this.invoiceGrosssAmount;
	}

	public void setInvoiceGrosssAmount(BigDecimal invoiceGrosssAmount) {
		this.invoiceGrosssAmount = invoiceGrosssAmount;
	}

	public BigDecimal getInvoiceNetAmount() {
		return this.invoiceNetAmount;
	}

	public void setInvoiceNetAmount(BigDecimal invoiceNetAmount) {
		this.invoiceNetAmount = invoiceNetAmount;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public BigDecimal getInvoiceRef() {
		return this.invoiceRef;
	}

	public void setInvoiceRef(BigDecimal invoiceRef) {
		this.invoiceRef = invoiceRef;
	}

	public Date getInvoiceTo() {
		return this.invoiceTo;
	}

	public void setInvoiceTo(Date invoiceTo) {
		this.invoiceTo = invoiceTo;
	}

	public BigDecimal getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
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

	public List<InvoiceLineItem> getInvoiceLineItems() {
		return this.invoiceLineItems;
	}

	public void setInvoiceLineItems(List<InvoiceLineItem> invoiceLineItems) {
		this.invoiceLineItems = invoiceLineItems;
	}

	public InvoiceLineItem addInvoiceLineItem(InvoiceLineItem invoiceLineItem) {
		getInvoiceLineItems().add(invoiceLineItem);
		invoiceLineItem.setInvoice(this);

		return invoiceLineItem;
	}

	public InvoiceLineItem removeInvoiceLineItem(InvoiceLineItem invoiceLineItem) {
		getInvoiceLineItems().remove(invoiceLineItem);
		invoiceLineItem.setInvoice(null);

		return invoiceLineItem;
	}

}