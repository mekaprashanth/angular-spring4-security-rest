package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PAYMENT_STATUS_TYPE database table.
 * 
 */
@Entity
@Table(name="PAYMENT_STATUS_TYPE")
@NamedQuery(name="PaymentStatusType.findAll", query="SELECT p FROM PaymentStatusType p")
public class PaymentStatusType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAYMENT_STATUS_TYPE_PAYMENTSTATUSTYPEID_GENERATOR", sequenceName="SEQ_PAYMENT_STATUS_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYMENT_STATUS_TYPE_PAYMENTSTATUSTYPEID_GENERATOR")
	@Column(name="PAYMENT_STATUS_TYPE_ID", unique=true, nullable=false, precision=5)
	private long paymentStatusTypeId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(name="PAYMENT_STATUS_CODE", nullable=false, length=30)
	private String paymentStatusCode;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="paymentStatusType")
	private List<Funding> fundings;

	public PaymentStatusType() {
	}

	public long getPaymentStatusTypeId() {
		return this.paymentStatusTypeId;
	}

	public void setPaymentStatusTypeId(long paymentStatusTypeId) {
		this.paymentStatusTypeId = paymentStatusTypeId;
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

	public String getPaymentStatusCode() {
		return this.paymentStatusCode;
	}

	public void setPaymentStatusCode(String paymentStatusCode) {
		this.paymentStatusCode = paymentStatusCode;
	}

	public List<Funding> getFundings() {
		return this.fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	public Funding addFunding(Funding funding) {
		getFundings().add(funding);
		funding.setPaymentStatusType(this);

		return funding;
	}

	public Funding removeFunding(Funding funding) {
		getFundings().remove(funding);
		funding.setPaymentStatusType(null);

		return funding;
	}

}