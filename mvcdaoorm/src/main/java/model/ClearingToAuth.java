package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CLEARING_TO_AUTH database table.
 * 
 */
@Entity
@Table(name="CLEARING_TO_AUTH")
@NamedQuery(name="ClearingToAuth.findAll", query="SELECT c FROM ClearingToAuth c")
public class ClearingToAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLEARING_TO_AUTH_CLEARINGTOAUTHID_GENERATOR", sequenceName="SEQ_CLEARING_TO_AUTH")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLEARING_TO_AUTH_CLEARINGTOAUTHID_GENERATOR")
	@Column(name="CLEARING_TO_AUTH_ID", unique=true, nullable=false, precision=10)
	private long clearingToAuthId;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="TRAN_STATUS", nullable=false, length=1)
	private String tranStatus;

	//bi-directional many-to-one association to Authorisation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTH_ID")
	private Authorisation authorisation;

	//bi-directional many-to-one association to Clearing
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLEARING_ID")
	private Clearing clearing;

	public ClearingToAuth() {
	}

	public long getClearingToAuthId() {
		return this.clearingToAuthId;
	}

	public void setClearingToAuthId(long clearingToAuthId) {
		this.clearingToAuthId = clearingToAuthId;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getTranStatus() {
		return this.tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public Authorisation getAuthorisation() {
		return this.authorisation;
	}

	public void setAuthorisation(Authorisation authorisation) {
		this.authorisation = authorisation;
	}

	public Clearing getClearing() {
		return this.clearing;
	}

	public void setClearing(Clearing clearing) {
		this.clearing = clearing;
	}

}