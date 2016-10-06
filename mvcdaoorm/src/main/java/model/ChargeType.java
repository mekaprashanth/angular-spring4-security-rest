package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CHARGE_TYPE database table.
 * 
 */
@Entity
@Table(name="CHARGE_TYPE")
@NamedQuery(name="ChargeType.findAll", query="SELECT c FROM ChargeType c")
public class ChargeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CHARGE_TYPE_FEETYPEID_GENERATOR", sequenceName="SEQ_CHARGE_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHARGE_TYPE_FEETYPEID_GENERATOR")
	@Column(name="FEE_TYPE_ID", unique=true, nullable=false, precision=5)
	private long feeTypeId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="chargeType")
	private List<Fee> fees;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="chargeType")
	private List<Funding> fundings;

	public ChargeType() {
	}

	public long getFeeTypeId() {
		return this.feeTypeId;
	}

	public void setFeeTypeId(long feeTypeId) {
		this.feeTypeId = feeTypeId;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Fee> getFees() {
		return this.fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public Fee addFee(Fee fee) {
		getFees().add(fee);
		fee.setChargeType(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setChargeType(null);

		return fee;
	}

	public List<Funding> getFundings() {
		return this.fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	public Funding addFunding(Funding funding) {
		getFundings().add(funding);
		funding.setChargeType(this);

		return funding;
	}

	public Funding removeFunding(Funding funding) {
		getFundings().remove(funding);
		funding.setChargeType(null);

		return funding;
	}

}