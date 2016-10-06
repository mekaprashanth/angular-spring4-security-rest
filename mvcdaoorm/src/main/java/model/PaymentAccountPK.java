package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PAYMENT_ACCOUNT database table.
 * 
 */
@Embeddable
public class PaymentAccountPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SETTLEMENT_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long settlementId;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public PaymentAccountPK() {
	}
	public long getSettlementId() {
		return this.settlementId;
	}
	public void setSettlementId(long settlementId) {
		this.settlementId = settlementId;
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
		if (!(other instanceof PaymentAccountPK)) {
			return false;
		}
		PaymentAccountPK castOther = (PaymentAccountPK)other;
		return 
			(this.settlementId == castOther.settlementId)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.settlementId ^ (this.settlementId >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}