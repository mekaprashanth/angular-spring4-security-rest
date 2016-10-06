package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TERMINAL_UPLOADS database table.
 * 
 */
@Embeddable
public class TerminalUploadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BATCH_NUMBER", unique=true, nullable=false, precision=10)
	private long batchNumber;

	@Column(name="UPLOAD_DATE_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long uploadDateId;

	@Column(name="PLATFORM_ID", insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long platformId;

	public TerminalUploadPK() {
	}
	public long getBatchNumber() {
		return this.batchNumber;
	}
	public void setBatchNumber(long batchNumber) {
		this.batchNumber = batchNumber;
	}
	public long getUploadDateId() {
		return this.uploadDateId;
	}
	public void setUploadDateId(long uploadDateId) {
		this.uploadDateId = uploadDateId;
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
		if (!(other instanceof TerminalUploadPK)) {
			return false;
		}
		TerminalUploadPK castOther = (TerminalUploadPK)other;
		return 
			(this.batchNumber == castOther.batchNumber)
			&& (this.uploadDateId == castOther.uploadDateId)
			&& (this.platformId == castOther.platformId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.batchNumber ^ (this.batchNumber >>> 32)));
		hash = hash * prime + ((int) (this.uploadDateId ^ (this.uploadDateId >>> 32)));
		hash = hash * prime + ((int) (this.platformId ^ (this.platformId >>> 32)));
		
		return hash;
	}
}