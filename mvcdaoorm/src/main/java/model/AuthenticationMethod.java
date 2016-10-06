package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AUTHENTICATION_METHOD database table.
 * 
 */
@Entity
@Table(name="AUTHENTICATION_METHOD")
@NamedQuery(name="AuthenticationMethod.findAll", query="SELECT a FROM AuthenticationMethod a")
public class AuthenticationMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTHENTICATION_METHOD_AUTHENTICATIONMETHODID_GENERATOR", sequenceName="SEQ_AUTHENTICATION_METHOD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHENTICATION_METHOD_AUTHENTICATIONMETHODID_GENERATOR")
	@Column(name="AUTHENTICATION_METHOD_ID", unique=true, nullable=false, precision=5)
	private long authenticationMethodId;

	@Column(name="AUTHENTICATION_METHOD", nullable=false, length=10)
	private String authenticationMethod;

	@Column(nullable=false, length=150)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="authenticationMethod")
	private List<Clearing> clearings;

	public AuthenticationMethod() {
	}

	public long getAuthenticationMethodId() {
		return this.authenticationMethodId;
	}

	public void setAuthenticationMethodId(long authenticationMethodId) {
		this.authenticationMethodId = authenticationMethodId;
	}

	public String getAuthenticationMethod() {
		return this.authenticationMethod;
	}

	public void setAuthenticationMethod(String authenticationMethod) {
		this.authenticationMethod = authenticationMethod;
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

	public List<Clearing> getClearings() {
		return this.clearings;
	}

	public void setClearings(List<Clearing> clearings) {
		this.clearings = clearings;
	}

	public Clearing addClearing(Clearing clearing) {
		getClearings().add(clearing);
		clearing.setAuthenticationMethod(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setAuthenticationMethod(null);

		return clearing;
	}

}