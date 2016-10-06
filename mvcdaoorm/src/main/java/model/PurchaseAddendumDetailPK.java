package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PURCHASE_ADDENDUM_DETAILS database table.
 * 
 */
@Embeddable
public class PurchaseAddendumDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SLIP_NUMBER", unique=true, nullable=false, precision=10)
	private long slipNumber;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public PurchaseAddendumDetailPK() {
	}
	public long getSlipNumber() {
		return this.slipNumber;
	}
	public void setSlipNumber(long slipNumber) {
		this.slipNumber = slipNumber;
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
		if (!(other instanceof PurchaseAddendumDetailPK)) {
			return false;
		}
		PurchaseAddendumDetailPK castOther = (PurchaseAddendumDetailPK)other;
		return 
			(this.slipNumber == castOther.slipNumber)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.slipNumber ^ (this.slipNumber >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}