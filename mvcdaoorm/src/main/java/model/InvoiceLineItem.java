package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the INVOICE_LINE_ITEM database table.
 * 
 */
@Entity
@Table(name="INVOICE_LINE_ITEM")
@NamedQuery(name="InvoiceLineItem.findAll", query="SELECT i FROM InvoiceLineItem i")
public class InvoiceLineItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InvoiceLineItemPK id;

	@Column(name="INVOICE_LINE_ITEM_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal invoiceLineItemAmount;

	@Column(name="LINE_ITEM_DESCRIPTION", nullable=false, length=200)
	private String lineItemDescription;

	@Column(name="TERMINAL_ID", nullable=false, precision=10)
	private BigDecimal terminalId;

	@Column(name="TOTAL_AMOUNT_GROSS", nullable=false, precision=23, scale=3)
	private BigDecimal totalAmountGross;

	@Column(name="TOTAL_AMOUNT_NET", nullable=false, precision=23, scale=3)
	private BigDecimal totalAmountNet;

	@Column(name="UNIT_GROSS_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal unitGrossAmount;

	@Column(name="UNIT_NET_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal unitNetAmount;

	@Column(name="VAT_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal vatAmount;

	@Column(name="VAT_RATE", nullable=false, precision=5, scale=3)
	private BigDecimal vatRate;

	@Column(nullable=false, precision=10)
	private BigDecimal volume;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="invoiceLineItem")
	private List<Document> documents;

	//bi-directional many-to-one association to Invoice
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="INVOICE_ID", referencedColumnName="INVOICE_ID", nullable=false),
		@JoinColumn(name="PLATFORM_ID2", referencedColumnName="PLATFORM_ID", nullable=false)
		})
	private Invoice invoice;

	public InvoiceLineItem() {
	}

	public InvoiceLineItemPK getId() {
		return this.id;
	}

	public void setId(InvoiceLineItemPK id) {
		this.id = id;
	}

	public BigDecimal getInvoiceLineItemAmount() {
		return this.invoiceLineItemAmount;
	}

	public void setInvoiceLineItemAmount(BigDecimal invoiceLineItemAmount) {
		this.invoiceLineItemAmount = invoiceLineItemAmount;
	}

	public String getLineItemDescription() {
		return this.lineItemDescription;
	}

	public void setLineItemDescription(String lineItemDescription) {
		this.lineItemDescription = lineItemDescription;
	}

	public BigDecimal getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalId(BigDecimal terminalId) {
		this.terminalId = terminalId;
	}

	public BigDecimal getTotalAmountGross() {
		return this.totalAmountGross;
	}

	public void setTotalAmountGross(BigDecimal totalAmountGross) {
		this.totalAmountGross = totalAmountGross;
	}

	public BigDecimal getTotalAmountNet() {
		return this.totalAmountNet;
	}

	public void setTotalAmountNet(BigDecimal totalAmountNet) {
		this.totalAmountNet = totalAmountNet;
	}

	public BigDecimal getUnitGrossAmount() {
		return this.unitGrossAmount;
	}

	public void setUnitGrossAmount(BigDecimal unitGrossAmount) {
		this.unitGrossAmount = unitGrossAmount;
	}

	public BigDecimal getUnitNetAmount() {
		return this.unitNetAmount;
	}

	public void setUnitNetAmount(BigDecimal unitNetAmount) {
		this.unitNetAmount = unitNetAmount;
	}

	public BigDecimal getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public BigDecimal getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setInvoiceLineItem(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setInvoiceLineItem(null);

		return document;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}