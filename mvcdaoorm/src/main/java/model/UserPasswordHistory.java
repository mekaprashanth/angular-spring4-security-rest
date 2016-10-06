package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the USER_PASSWORD_HISTORY database table.
 * 
 */
@Entity
@Table(name="USER_PASSWORD_HISTORY")
@NamedQuery(name="UserPasswordHistory.findAll", query="SELECT u FROM UserPasswordHistory u")
public class UserPasswordHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_PASSWORD_HISTORY_USERPASSWORDID_GENERATOR", sequenceName="SEQ_USER_PASSWORD_HISTORY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_PASSWORD_HISTORY_USERPASSWORDID_GENERATOR")
	@Column(name="USER_PASSWORD_ID", unique=true, nullable=false, precision=10)
	private long userPasswordId;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CHANGED")
	private Date dateChanged;

	@Column(length=12)
	private String password;

	@Column(name="PASSWORD_COUNT", precision=1)
	private BigDecimal passwordCount;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;

	public UserPasswordHistory() {
	}

	public long getUserPasswordId() {
		return this.userPasswordId;
	}

	public void setUserPasswordId(long userPasswordId) {
		this.userPasswordId = userPasswordId;
	}

	public Date getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getPasswordCount() {
		return this.passwordCount;
	}

	public void setPasswordCount(BigDecimal passwordCount) {
		this.passwordCount = passwordCount;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}