package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TRANSACTION_TYPE database table.
 * 
 */
@Entity
@Table(name="TRANSACTION_TYPE")
@NamedQuery(name="TransactionType.findAll", query="SELECT t FROM TransactionType t")
public class TransactionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSACTION_TYPE_TRANSACTIONTYPEID_GENERATOR", sequenceName="SEQ_TRANSACTION_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSACTION_TYPE_TRANSACTIONTYPEID_GENERATOR")
	@Column(name="TRANSACTION_TYPE_ID", unique=true, nullable=false, precision=5)
	private long transactionTypeId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="transactionType")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="transactionType")
	private List<Clearing> clearings;

	public TransactionType() {
	}

	public long getTransactionTypeId() {
		return this.transactionTypeId;
	}

	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
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
		authorisation.setTransactionType(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setTransactionType(null);

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
		clearing.setTransactionType(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setTransactionType(null);

		return clearing;
	}

}