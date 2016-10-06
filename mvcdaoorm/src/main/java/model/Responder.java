package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RESPONDER database table.
 * 
 */
@Entity
@Table(name="RESPONDER")
@NamedQuery(name="Responder.findAll", query="SELECT r FROM Responder r")
public class Responder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESPONDER_RESPONDERID_GENERATOR", sequenceName="SEQ_RESPONDER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESPONDER_RESPONDERID_GENERATOR")
	@Column(name="RESPONDER_ID", unique=true, nullable=false, precision=3)
	private long responderId;

	@Column(nullable=false, length=200)
	private String desription;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="responder")
	private List<Authorisation> authorisations;

	public Responder() {
	}

	public long getResponderId() {
		return this.responderId;
	}

	public void setResponderId(long responderId) {
		this.responderId = responderId;
	}

	public String getDesription() {
		return this.desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
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
		authorisation.setResponder(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setResponder(null);

		return authorisation;
	}

}