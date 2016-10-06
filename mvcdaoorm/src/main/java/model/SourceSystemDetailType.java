package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SOURCE_SYSTEM_DETAIL_TYPE database table.
 * 
 */
@Entity
@Table(name="SOURCE_SYSTEM_DETAIL_TYPE")
@NamedQuery(name="SourceSystemDetailType.findAll", query="SELECT s FROM SourceSystemDetailType s")
public class SourceSystemDetailType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOURCE_SYSTEM_DETAIL_TYPE_TRANSOURCEDETAILID_GENERATOR", sequenceName="SEQ_SOURCE_SYSTEM_DETAIL_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOURCE_SYSTEM_DETAIL_TYPE_TRANSOURCEDETAILID_GENERATOR")
	@Column(name="TRAN_SOURCE_DETAIL_ID", unique=true, nullable=false, precision=3)
	private long tranSourceDetailId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="sourceSystemDetailType")
	private List<Authorisation> authorisations;

	public SourceSystemDetailType() {
	}

	public long getTranSourceDetailId() {
		return this.tranSourceDetailId;
	}

	public void setTranSourceDetailId(long tranSourceDetailId) {
		this.tranSourceDetailId = tranSourceDetailId;
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
		authorisation.setSourceSystemDetailType(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setSourceSystemDetailType(null);

		return authorisation;
	}

}