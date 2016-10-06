package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SETTLEMENT_GROUP_ID database table.
 * 
 */
@Embeddable
public class SettlementGroupIdPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SETTLEMENT_GROUP_ID", unique=true, nullable=false, precision=10)
	private long settlementGroupId;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public SettlementGroupIdPK() {
	}
	public long getSettlementGroupId() {
		return this.settlementGroupId;
	}
	public void setSettlementGroupId(long settlementGroupId) {
		this.settlementGroupId = settlementGroupId;
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
		if (!(other instanceof SettlementGroupIdPK)) {
			return false;
		}
		SettlementGroupIdPK castOther = (SettlementGroupIdPK)other;
		return 
			(this.settlementGroupId == castOther.settlementGroupId)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.settlementGroupId ^ (this.settlementGroupId >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}