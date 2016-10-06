package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FUNDING database table.
 * 
 */
@Embeddable
public class FundingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FUNDING_SLIP_NUMBER", unique=true, nullable=false, precision=12)
	private long fundingSlipNumber;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public FundingPK() {
	}
	public long getFundingSlipNumber() {
		return this.fundingSlipNumber;
	}
	public void setFundingSlipNumber(long fundingSlipNumber) {
		this.fundingSlipNumber = fundingSlipNumber;
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
		if (!(other instanceof FundingPK)) {
			return false;
		}
		FundingPK castOther = (FundingPK)other;
		return 
			(this.fundingSlipNumber == castOther.fundingSlipNumber)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fundingSlipNumber ^ (this.fundingSlipNumber >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}