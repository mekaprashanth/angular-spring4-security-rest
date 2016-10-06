package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INVOICE database table.
 * 
 */
@Embeddable
public class InvoicePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INVOICE_ID", unique=true, nullable=false, precision=10)
	private long invoiceId;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public InvoicePK() {
	}
	public long getInvoiceId() {
		return this.invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
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
		if (!(other instanceof InvoicePK)) {
			return false;
		}
		InvoicePK castOther = (InvoicePK)other;
		return 
			(this.invoiceId == castOther.invoiceId)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.invoiceId ^ (this.invoiceId >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}