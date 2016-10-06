package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ACCOUNT database table.
 * 
 */
@Embeddable
public class AccountPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ACCOUNT_ID", unique=true, nullable=false, precision=10)
	private long accountId;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public AccountPK() {
	}
	public long getAccountId() {
		return this.accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
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
		if (!(other instanceof AccountPK)) {
			return false;
		}
		AccountPK castOther = (AccountPK)other;
		return 
			(this.accountId == castOther.accountId)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.accountId ^ (this.accountId >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}