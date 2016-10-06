package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the WALLET_TYPE database table.
 * 
 */
@Entity
@Table(name="WALLET_TYPE")
@NamedQuery(name="WalletType.findAll", query="SELECT w FROM WalletType w")
public class WalletType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WALLET_TYPE_WALLETTYPEID_GENERATOR", sequenceName="SEQ_WALLET_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WALLET_TYPE_WALLETTYPEID_GENERATOR")
	@Column(name="WALLET_TYPE_ID", unique=true, nullable=false, precision=3)
	private long walletTypeId;

	@Column(nullable=false, length=150)
	private String description;

	@Column(name="WALLET_TYPE", nullable=false, length=20)
	private String walletType;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="walletType")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="walletType")
	private List<Clearing> clearings;

	public WalletType() {
	}

	public long getWalletTypeId() {
		return this.walletTypeId;
	}

	public void setWalletTypeId(long walletTypeId) {
		this.walletTypeId = walletTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWalletType() {
		return this.walletType;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setWalletType(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setWalletType(null);

		return authorisation;
	}

	public List<Clearing> getClearings() {
		return this.clearings;
	}

	public void setClearings(List<Clearing> clearings) {
		this.clearings = clearings;
	}

	public Clearing addClearing(Clearing clearing) {
		getClearings().add(clearing);
		clearing.setWalletType(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setWalletType(null);

		return clearing;
	}

}