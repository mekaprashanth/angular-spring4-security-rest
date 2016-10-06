package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AUTH_RESP_CODE database table.
 * 
 */
@Entity
@Table(name="AUTH_RESP_CODE")
@NamedQuery(name="AuthRespCode.findAll", query="SELECT a FROM AuthRespCode a")
public class AuthRespCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTH_RESP_CODE_AUTHRESPCODEID_GENERATOR", sequenceName="SEQ_AUTH_RESP_CODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTH_RESP_CODE_AUTHRESPCODEID_GENERATOR")
	@Column(name="AUTH_RESP_CODE_ID", unique=true, nullable=false, precision=5)
	private long authRespCodeId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="RESP_CODE", nullable=false, length=10)
	private String respCode;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="authRespCode")
	private List<Authorisation> authorisations;

	public AuthRespCode() {
	}

	public long getAuthRespCodeId() {
		return this.authRespCodeId;
	}

	public void setAuthRespCodeId(long authRespCodeId) {
		this.authRespCodeId = authRespCodeId;
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

	public String getRespCode() {
		return this.respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setAuthRespCode(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setAuthRespCode(null);

		return authorisation;
	}

}