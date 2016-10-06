package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INSTRUMENT_TYPE database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_TYPE")
@NamedQuery(name="InstrumentType.findAll", query="SELECT i FROM InstrumentType i")
public class InstrumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INSTRUMENT_TYPE_INSTRUMENTTYPEID_GENERATOR", sequenceName="SEQ_INSTRUMENT_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUMENT_TYPE_INSTRUMENTTYPEID_GENERATOR")
	@Column(name="INSTRUMENT_TYPE_ID", unique=true, nullable=false, precision=5)
	private long instrumentTypeId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="INSTUMNT_TYPE", nullable=false, length=30)
	private String instumntType;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="instrumentType")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="instrumentTypeBean")
	private List<Clearing> clearings;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="instrumentType")
	private List<Funding> fundings;

	public InstrumentType() {
	}

	public long getInstrumentTypeId() {
		return this.instrumentTypeId;
	}

	public void setInstrumentTypeId(long instrumentTypeId) {
		this.instrumentTypeId = instrumentTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstumntType() {
		return this.instumntType;
	}

	public void setInstumntType(String instumntType) {
		this.instumntType = instumntType;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setInstrumentType(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setInstrumentType(null);

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
		clearing.setInstrumentTypeBean(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setInstrumentTypeBean(null);

		return clearing;
	}

	public List<Funding> getFundings() {
		return this.fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	public Funding addFunding(Funding funding) {
		getFundings().add(funding);
		funding.setInstrumentType(this);

		return funding;
	}

	public Funding removeFunding(Funding funding) {
		getFundings().remove(funding);
		funding.setInstrumentType(null);

		return funding;
	}

}