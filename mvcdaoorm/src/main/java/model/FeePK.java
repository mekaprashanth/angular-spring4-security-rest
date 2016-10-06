package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FEE database table.
 * 
 */
@Embeddable
public class FeePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	@Column(name="PRESENTMENT_SLIP", unique=true, nullable=false, precision=12)
	private long presentmentSlip;

	@Column(name="CHARGE_SLIP_NUMBER", insertable=false, updatable=false, unique=true, nullable=false, precision=12)
	private long chargeSlipNumber;

	public FeePK() {
	}
	public long getPlatformId() {
		return this.platformId;
	}
	public void setPlatformId(long platformId) {
		this.platformId = platformId;
	}
	public long getPresentmentSlip() {
		return this.presentmentSlip;
	}
	public void setPresentmentSlip(long presentmentSlip) {
		this.presentmentSlip = presentmentSlip;
	}
	public long getChargeSlipNumber() {
		return this.chargeSlipNumber;
	}
	public void setChargeSlipNumber(long chargeSlipNumber) {
		this.chargeSlipNumber = chargeSlipNumber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FeePK)) {
			return false;
		}
		FeePK castOther = (FeePK)other;
		return 
			(this.platformId == castOther.platformId)
			&& (this.presentmentSlip == castOther.presentmentSlip)
			&& (this.chargeSlipNumber == castOther.chargeSlipNumber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		hash = hash * prime + ((int) (this.presentmentSlip ^ (this.presentmentSlip >>> 32)));
		hash = hash * prime + ((int) (this.chargeSlipNumber ^ (this.chargeSlipNumber >>> 32)));
		
		return hash;
	}
}