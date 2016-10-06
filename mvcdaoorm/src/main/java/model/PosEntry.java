package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the POS_ENTRY database table.
 * 
 */
@Entity
@Table(name="POS_ENTRY")
@NamedQuery(name="PosEntry.findAll", query="SELECT p FROM PosEntry p")
public class PosEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POS_ENTRY_POSENTRYID_GENERATOR", sequenceName="SEQ_POS_ENTRY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POS_ENTRY_POSENTRYID_GENERATOR")
	@Column(name="POS_ENTRY_ID", unique=true, nullable=false, precision=5)
	private long posEntryId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGAUAGE_CODE", nullable=false, length=2)
	private String langauageCode;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="posEntry")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="posEntry")
	private List<Clearing> clearings;

	public PosEntry() {
	}

	public long getPosEntryId() {
		return this.posEntryId;
	}

	public void setPosEntryId(long posEntryId) {
		this.posEntryId = posEntryId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLangauageCode() {
		return this.langauageCode;
	}

	public void setLangauageCode(String langauageCode) {
		this.langauageCode = langauageCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setPosEntry(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setPosEntry(null);

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
		clearing.setPosEntry(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setPosEntry(null);

		return clearing;
	}

}