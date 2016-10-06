package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PROCESSING_STATUS database table.
 * 
 */
@Entity
@Table(name="PROCESSING_STATUS")
@NamedQuery(name="ProcessingStatus.findAll", query="SELECT p FROM ProcessingStatus p")
public class ProcessingStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROCESSING_STATUS_PROCESSINGSTATUSID_GENERATOR", sequenceName="SEQ_PROCESSING_STATUS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROCESSING_STATUS_PROCESSINGSTATUSID_GENERATOR")
	@Column(name="PROCESSING_STATUS_ID", unique=true, nullable=false, precision=5)
	private long processingStatusId;

	@Column(nullable=false, precision=10)
	private BigDecimal description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="SYSTEM_DESCRIPTION", nullable=false, length=120)
	private String systemDescription;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="processingStatus")
	private List<Clearing> clearings;

	public ProcessingStatus() {
	}

	public long getProcessingStatusId() {
		return this.processingStatusId;
	}

	public void setProcessingStatusId(long processingStatusId) {
		this.processingStatusId = processingStatusId;
	}

	public BigDecimal getDescription() {
		return this.description;
	}

	public void setDescription(BigDecimal description) {
		this.description = description;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getSystemDescription() {
		return this.systemDescription;
	}

	public void setSystemDescription(String systemDescription) {
		this.systemDescription = systemDescription;
	}

	public List<Clearing> getClearings() {
		return this.clearings;
	}

	public void setClearings(List<Clearing> clearings) {
		this.clearings = clearings;
	}

	public Clearing addClearing(Clearing clearing) {
		getClearings().add(clearing);
		clearing.setProcessingStatus(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setProcessingStatus(null);

		return clearing;
	}

}