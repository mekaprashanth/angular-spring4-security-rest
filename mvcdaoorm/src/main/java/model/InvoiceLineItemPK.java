package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INVOICE_LINE_ITEM database table.
 * 
 */
@Embeddable
public class InvoiceLineItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INVOICE_LINE_ITEM_ID", unique=true, nullable=false, precision=10)
	private long invoiceLineItemId;

	@Column(name="PLATFORM_ID", unique=true, nullable=false, precision=3)
	private long platformId;

	public InvoiceLineItemPK() {
	}
	public long getInvoiceLineItemId() {
		return this.invoiceLineItemId;
	}
	public void setInvoiceLineItemId(long invoiceLineItemId) {
		this.invoiceLineItemId = invoiceLineItemId;
	}
	public long getPlatformId() {
		return this.platformId;
	}
	public void setPlatformId(long platformId) {
		this.platformId = platformId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InvoiceLineItemPK)) {
			return false;
		}
		InvoiceLineItemPK castOther = (InvoiceLineItemPK)other;
		return 
			(this.invoiceLineItemId == castOther.invoiceLineItemId)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.invoiceLineItemId ^ (this.invoiceLineItemId >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}