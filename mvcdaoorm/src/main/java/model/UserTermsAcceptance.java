package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the USER_TERMS_ACCEPTANCE database table.
 * 
 */
@Entity
@Table(name="USER_TERMS_ACCEPTANCE")
@NamedQuery(name="UserTermsAcceptance.findAll", query="SELECT u FROM UserTermsAcceptance u")
public class UserTermsAcceptance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_TERMS_ACCEPTANCE_ACCEPTANCEID_GENERATOR", sequenceName="SEQ_USER_TERMS_ACCEPTANCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_TERMS_ACCEPTANCE_ACCEPTANCEID_GENERATOR")
	@Column(name="ACCEPTANCE_ID", unique=true, nullable=false, precision=10)
	private long acceptanceId;

	@Column(name="HAS_ACCEPTED", nullable=false, precision=1)
	private BigDecimal hasAccepted;

	//bi-directional many-to-one association to TermsAndCondition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TERMS_ID", nullable=false)
	private TermsAndCondition termsAndCondition;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;

	public UserTermsAcceptance() {
	}

	public long getAcceptanceId() {
		return this.acceptanceId;
	}

	public void setAcceptanceId(long acceptanceId) {
		this.acceptanceId = acceptanceId;
	}

	public BigDecimal getHasAccepted() {
		return this.hasAccepted;
	}

	public void setHasAccepted(BigDecimal hasAccepted) {
		this.hasAccepted = hasAccepted;
	}

	public TermsAndCondition getTermsAndCondition() {
		return this.termsAndCondition;
	}

	public void setTermsAndCondition(TermsAndCondition termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}