package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the POS_TERMINAL_CAPABILITY database table.
 * 
 */
@Entity
@Table(name="POS_TERMINAL_CAPABILITY")
@NamedQuery(name="PosTerminalCapability.findAll", query="SELECT p FROM PosTerminalCapability p")
public class PosTerminalCapability implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POS_TERMINAL_CAPABILITY_POSTERMINALCAPABILITYID_GENERATOR", sequenceName="SEQ_POS_TERMINAL_CAPABILITY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POS_TERMINAL_CAPABILITY_POSTERMINALCAPABILITYID_GENERATOR")
	@Column(name="POS_TERMINAL_CAPABILITY_ID", unique=true, nullable=false, precision=5)
	private long posTerminalCapabilityId;

	@Column(nullable=false, length=200)
	private String desription;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="TERMINAL_CAPABILITY", nullable=false, length=10)
	private String terminalCapability;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="posTerminalCapability")
	private List<Authorisation> authorisations;

	public PosTerminalCapability() {
	}

	public long getPosTerminalCapabilityId() {
		return this.posTerminalCapabilityId;
	}

	public void setPosTerminalCapabilityId(long posTerminalCapabilityId) {
		this.posTerminalCapabilityId = posTerminalCapabilityId;
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

	public String getTerminalCapability() {
		return this.terminalCapability;
	}

	public void setTerminalCapability(String terminalCapability) {
		this.terminalCapability = terminalCapability;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setPosTerminalCapability(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setPosTerminalCapability(null);

		return authorisation;
	}

}