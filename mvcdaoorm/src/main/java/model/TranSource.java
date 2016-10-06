package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TRAN_SOURCE database table.
 * 
 */
@Entity
@Table(name="TRAN_SOURCE")
@NamedQuery(name="TranSource.findAll", query="SELECT t FROM TranSource t")
public class TranSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRAN_SOURCE_TRANSOURCEID_GENERATOR", sequenceName="SEQ_TRAN_SOURCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRAN_SOURCE_TRANSOURCEID_GENERATOR")
	@Column(name="TRAN_SOURCE_ID", unique=true, nullable=false, precision=5)
	private long tranSourceId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="SOURCE_CODE", nullable=false, length=1)
	private String sourceCode;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="tranSource")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="tranSource")
	private List<Clearing> clearings;

	public TranSource() {
	}

	public long getTranSourceId() {
		return this.tranSourceId;
	}

	public void setTranSourceId(long tranSourceId) {
		this.tranSourceId = tranSourceId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getSourceCode() {
		return this.sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setTranSource(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setTranSource(null);

		return authorisation;
	}

	public List<Clearing> getClearings() {
		return this.clearings;
	}

	public void setClearings(List<Clearing> clearings) {
		this.clearings = clearings;
	}

	public Clearing addClearing(Clearing clearing) {
		getClearings().add(clearing);
		clearing.setTranSource(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setTranSource(null);

		return clearing;
	}

}