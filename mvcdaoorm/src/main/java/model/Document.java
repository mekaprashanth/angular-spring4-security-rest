package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DOCUMENTS database table.
 * 
 */
@Entity
@Table(name="DOCUMENTS")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="INVOICE_ID", nullable=false, precision=10)
	private BigDecimal invoiceId;

	//bi-directional many-to-one association to InvoiceLineItem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="INVOICE_LINE_ITEM_ID", referencedColumnName="INVOICE_LINE_ITEM_ID", nullable=false),
		@JoinColumn(name="PLATFORM_ID", referencedColumnName="PLATFORM_ID", nullable=false)
		})
	private InvoiceLineItem invoiceLineItem;

	public Document() {
	}

	public BigDecimal getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(BigDecimal invoiceId) {
		this.invoiceId = invoiceId;
	}

	public InvoiceLineItem getInvoiceLineItem() {
		return this.invoiceLineItem;
	}

	public void setInvoiceLineItem(InvoiceLineItem invoiceLineItem) {
		this.invoiceLineItem = invoiceLineItem;
	}

}