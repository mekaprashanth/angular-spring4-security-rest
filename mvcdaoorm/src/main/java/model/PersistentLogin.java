package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PERSISTENT_LOGINS database table.
 * 
 */
@Entity
@Table(name="PERSISTENT_LOGINS")
@NamedQuery(name="PersistentLogin.findAll", query="SELECT p FROM PersistentLogin p")
public class PersistentLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSISTENT_LOGINS_SERIES_GENERATOR", sequenceName="SEQ_PERSISTENT_LOGINS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSISTENT_LOGINS_SERIES_GENERATOR")
	@Column(unique=true, nullable=false, length=64)
	private String series;

	@Column(name="LAST_USED", nullable=false)
	private Timestamp lastUsed;

	@Column(nullable=false, length=64)
	private String token;

	@Column(nullable=false, length=50)
	private String username;

	public PersistentLogin() {
	}

	public String getSeries() {
		return this.series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public Timestamp getLastUsed() {
		return this.lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}