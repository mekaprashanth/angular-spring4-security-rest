package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the USER_HISTORY database table.
 * 
 */
@Entity
@Table(name="USER_HISTORY")
@NamedQuery(name="UserHistory.findAll", query="SELECT u FROM UserHistory u")
public class UserHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="STATUS_DATE", nullable=false, precision=10)
	private BigDecimal statusDate;

	//bi-directional many-to-one association to AccountStaut
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACCOUNT_STATUS_ID", nullable=false)
	private AccountStaut accountStaut;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;

	public UserHistory() {
	}

	public BigDecimal getStatusDate() {
		return this.statusDate;
	}

	public void setStatusDate(BigDecimal statusDate) {
		this.statusDate = statusDate;
	}

	public AccountStaut getAccountStaut() {
		return this.accountStaut;
	}

	public void setAccountStaut(AccountStaut accountStaut) {
		this.accountStaut = accountStaut;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}