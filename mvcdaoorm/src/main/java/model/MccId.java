package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MCC_ID database table.
 * 
 */
@Entity
@Table(name="MCC_ID")
@NamedQuery(name="MccId.findAll", query="SELECT m FROM MccId m")
public class MccId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MCC_ID_MCCID_GENERATOR", sequenceName="SEQ_MCC_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MCC_ID_MCCID_GENERATOR")
	@Column(name="MCC_ID", unique=true, nullable=false, precision=5)
	private long mccId;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="MCC_CATEGORY", nullable=false, length=100)
	private String mccCategory;

	@Column(name="MCC_DESCRIPTION", nullable=false, length=100)
	private String mccDescription;

	@Column(name="MCC_ISO", nullable=false, length=4)
	private String mccIso;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="mccIdBean")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="mccIdBean")
	private List<Clearing> clearings;

	public MccId() {
	}

	public long getMccId() {
		return this.mccId;
	}

	public void setMccId(long mccId) {
		this.mccId = mccId;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getMccCategory() {
		return this.mccCategory;
	}

	public void setMccCategory(String mccCategory) {
		this.mccCategory = mccCategory;
	}

	public String getMccDescription() {
		return this.mccDescription;
	}

	public void setMccDescription(String mccDescription) {
		this.mccDescription = mccDescription;
	}

	public String getMccIso() {
		return this.mccIso;
	}

	public void setMccIso(String mccIso) {
		this.mccIso = mccIso;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setMccIdBean(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setMccIdBean(null);

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
		clearing.setMccIdBean(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setMccIdBean(null);

		return clearing;
	}

}