package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TERMINAL database table.
 * 
 */
@Embeddable
public class TerminalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TERMINAL_ID", unique=true, nullable=false, precision=10)
	private long terminalId;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public TerminalPK() {
	}
	public long getTerminalId() {
		return this.terminalId;
	}
	public void setTerminalId(long terminalId) {
		this.terminalId = terminalId;
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
		if (!(other instanceof TerminalPK)) {
			return false;
		}
		TerminalPK castOther = (TerminalPK)other;
		return 
			(this.terminalId == castOther.terminalId)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.terminalId ^ (this.terminalId >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}