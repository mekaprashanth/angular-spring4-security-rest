package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AVS_RESPONSE_CODE database table.
 * 
 */
@Entity
@Table(name="AVS_RESPONSE_CODE")
@NamedQuery(name="AvsResponseCode.findAll", query="SELECT a FROM AvsResponseCode a")
public class AvsResponseCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AVS_RESPONSE_CODE_AVSRESPONSECODEID_GENERATOR", sequenceName="SEQ_AVS_RESPONSE_CODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AVS_RESPONSE_CODE_AVSRESPONSECODEID_GENERATOR")
	@Column(name="AVS_RESPONSE_CODE_ID", unique=true, nullable=false, precision=5)
	private long avsResponseCodeId;

	@Column(nullable=false, precision=10)
	private BigDecimal description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="RESPONSE_CODE", nullable=false, precision=10)
	private BigDecimal responseCode;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="avsResponseCode")
	private List<Authorisation> authorisations;

	public AvsResponseCode() {
	}

	public long getAvsResponseCodeId() {
		return this.avsResponseCodeId;
	}

	public void setAvsResponseCodeId(long avsResponseCodeId) {
		this.avsResponseCodeId = avsResponseCodeId;
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

	public BigDecimal getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(BigDecimal responseCode) {
		this.responseCode = responseCode;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setAvsResponseCode(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setAvsResponseCode(null);

		return authorisation;
	}

}