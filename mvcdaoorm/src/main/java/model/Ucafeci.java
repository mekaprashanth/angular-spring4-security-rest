package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the UCAFECI database table.
 * 
 */
@Entity
@Table(name="UCAFECI")
@NamedQuery(name="Ucafeci.findAll", query="SELECT u FROM Ucafeci u")
public class Ucafeci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UCAFECI_UCAFECIID_GENERATOR", sequenceName="SEQ_UCAFECI")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UCAFECI_UCAFECIID_GENERATOR")
	@Column(name="UCAFECI_ID", unique=true, nullable=false, precision=10)
	private long ucafeciId;

	@Column(nullable=false, precision=10)
	private BigDecimal description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="UCAFECI_VALUE", nullable=false, length=4)
	private String ucafeciValue;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="ucafeci")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="ucafeci")
	private List<Clearing> clearings;

	public Ucafeci() {
	}

	public long getUcafeciId() {
		return this.ucafeciId;
	}

	public void setUcafeciId(long ucafeciId) {
		this.ucafeciId = ucafeciId;
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

	public String getUcafeciValue() {
		return this.ucafeciValue;
	}

	public void setUcafeciValue(String ucafeciValue) {
		this.ucafeciValue = ucafeciValue;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setUcafeci(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setUcafeci(null);

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
		clearing.setUcafeci(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setUcafeci(null);

		return clearing;
	}

}