package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACCOUNT_STAUTS database table.
 * 
 */
@Entity
@Table(name="ACCOUNT_STAUTS")
@NamedQuery(name="AccountStaut.findAll", query="SELECT a FROM AccountStaut a")
public class AccountStaut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCOUNT_STAUTS_ACCOUNTSTATUSID_GENERATOR", sequenceName="SEQ_ACCOUNT_STAUTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_STAUTS_ACCOUNTSTATUSID_GENERATOR")
	@Column(name="ACCOUNT_STATUS_ID", unique=true, nullable=false, precision=5)
	private long accountStatusId;

	@Column(precision=10)
	private BigDecimal description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=4)
	private String languageCode;

	//bi-directional many-to-one association to UserHistory
	@OneToMany(mappedBy="accountStaut")
	private List<UserHistory> userHistories;

	public AccountStaut() {
	}

	public long getAccountStatusId() {
		return this.accountStatusId;
	}

	public void setAccountStatusId(long accountStatusId) {
		this.accountStatusId = accountStatusId;
	}

	public BigDecimal getDescription() {
		return this.description;
	}

	public void setDescription(BigDecimal description) {
		this.description = description;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public List<UserHistory> getUserHistories() {
		return this.userHistories;
	}

	public void setUserHistories(List<UserHistory> userHistories) {
		this.userHistories = userHistories;
	}

	public UserHistory addUserHistory(UserHistory userHistory) {
		getUserHistories().add(userHistory);
		userHistory.setAccountStaut(this);

		return userHistory;
	}

	public UserHistory removeUserHistory(UserHistory userHistory) {
		getUserHistories().remove(userHistory);
		userHistory.setAccountStaut(null);

		return userHistory;
	}

}