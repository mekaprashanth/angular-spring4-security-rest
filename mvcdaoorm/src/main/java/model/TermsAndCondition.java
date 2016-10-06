package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TERMS_AND_CONDITIONS database table.
 * 
 */
@Entity
@Table(name="TERMS_AND_CONDITIONS")
@NamedQuery(name="TermsAndCondition.findAll", query="SELECT t FROM TermsAndCondition t")
public class TermsAndCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TERMS_AND_CONDITIONS_TERMSIDPK_GENERATOR", sequenceName="SEQ_TERMS_AND_CONDITIONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TERMS_AND_CONDITIONS_TERMSIDPK_GENERATOR")
	@Column(name="TERMS_ID_PK", unique=true, nullable=false, precision=10)
	private long termsIdPk;

	@Lob
	@Column(nullable=false)
	private String description;

	@Column(name="DOCUMENT_LINK", nullable=false, length=255)
	private String documentLink;

	@Column(name="LANGUAGE_CODE", length=2)
	private String languageCode;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to UserTermsAcceptance
	@OneToMany(mappedBy="termsAndCondition")
	private List<UserTermsAcceptance> userTermsAcceptances;

	public TermsAndCondition() {
	}

	public long getTermsIdPk() {
		return this.termsIdPk;
	}

	public void setTermsIdPk(long termsIdPk) {
		this.termsIdPk = termsIdPk;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumentLink() {
		return this.documentLink;
	}

	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
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

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public List<UserTermsAcceptance> getUserTermsAcceptances() {
		return this.userTermsAcceptances;
	}

	public void setUserTermsAcceptances(List<UserTermsAcceptance> userTermsAcceptances) {
		this.userTermsAcceptances = userTermsAcceptances;
	}

	public UserTermsAcceptance addUserTermsAcceptance(UserTermsAcceptance userTermsAcceptance) {
		getUserTermsAcceptances().add(userTermsAcceptance);
		userTermsAcceptance.setTermsAndCondition(this);

		return userTermsAcceptance;
	}

	public UserTermsAcceptance removeUserTermsAcceptance(UserTermsAcceptance userTermsAcceptance) {
		getUserTermsAcceptances().remove(userTermsAcceptance);
		userTermsAcceptance.setTermsAndCondition(null);

		return userTermsAcceptance;
	}

}