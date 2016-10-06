package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TRAN_MESSAGE_TYPE database table.
 * 
 */
@Entity
@Table(name="TRAN_MESSAGE_TYPE")
@NamedQuery(name="TranMessageType.findAll", query="SELECT t FROM TranMessageType t")
public class TranMessageType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRAN_MESSAGE_TYPE_TRANMSGTYPEID_GENERATOR", sequenceName="SEQ_TRAN_MESSAGE_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRAN_MESSAGE_TYPE_TRANMSGTYPEID_GENERATOR")
	@Column(name="TRAN_MSG_TYPE_ID", unique=true, nullable=false, precision=5)
	private long tranMsgTypeId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="MESSAGE_TYPE_CODE", nullable=false, length=4)
	private String messageTypeCode;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="tranMessageType")
	private List<Authorisation> authorisations;

	public TranMessageType() {
	}

	public long getTranMsgTypeId() {
		return this.tranMsgTypeId;
	}

	public void setTranMsgTypeId(long tranMsgTypeId) {
		this.tranMsgTypeId = tranMsgTypeId;
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

	public String getMessageTypeCode() {
		return this.messageTypeCode;
	}

	public void setMessageTypeCode(String messageTypeCode) {
		this.messageTypeCode = messageTypeCode;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setTranMessageType(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setTranMessageType(null);

		return authorisation;
	}

}