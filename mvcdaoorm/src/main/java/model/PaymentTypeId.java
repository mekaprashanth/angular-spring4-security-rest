package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PAYMENT_TYPE_ID database table.
 * 
 */
@Entity
@Table(name="PAYMENT_TYPE_ID")
@NamedQuery(name="PaymentTypeId.findAll", query="SELECT p FROM PaymentTypeId p")
public class PaymentTypeId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAYMENT_TYPE_ID_PAYMENTTYPEID_GENERATOR", sequenceName="SEQ_PAYMENT_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYMENT_TYPE_ID_PAYMENTTYPEID_GENERATOR")
	@Column(name="PAYMENT_TYPE_ID", unique=true, nullable=false, precision=5)
	private long paymentTypeId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="paymentTypeIdBean")
	private List<Funding> fundings;

	public PaymentTypeId() {
	}

	public long getPaymentTypeId() {
		return this.paymentTypeId;
	}

	public void setPaymentTypeId(long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
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

	public List<Funding> getFundings() {
		return this.fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	public Funding addFunding(Funding funding) {
		getFundings().add(funding);
		funding.setPaymentTypeIdBean(this);

		return funding;
	}

	public Funding removeFunding(Funding funding) {
		getFundings().remove(funding);
		funding.setPaymentTypeIdBean(null);

		return funding;
	}

}