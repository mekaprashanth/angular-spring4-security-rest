package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INVOICE_GROUP_ID database table.
 * 
 */
@Embeddable
public class InvoiceGroupIdPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INVOICE_GROUP_ID", unique=true, nullable=false, precision=10)
	private long invoiceGroupId;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public InvoiceGroupIdPK() {
	}
	public long getInvoiceGroupId() {
		return this.invoiceGroupId;
	}
	public void setInvoiceGroupId(long invoiceGroupId) {
		this.invoiceGroupId = invoiceGroupId;
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
		if (!(other instanceof InvoiceGroupIdPK)) {
			return false;
		}
		InvoiceGroupIdPK castOther = (InvoiceGroupIdPK)other;
		return 
			(this.invoiceGroupId == castOther.invoiceGroupId)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.invoiceGroupId ^ (this.invoiceGroupId >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}