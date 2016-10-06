package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MERCHANT_EMAIL database table.
 * 
 */
@Entity
@Table(name="MERCHANT_EMAIL")
@NamedQuery(name="MerchantEmail.findAll", query="SELECT m FROM MerchantEmail m")
public class MerchantEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MERCHANT_EMAIL_EMAILID_GENERATOR", sequenceName="SEQ_MERCHANT_EMAIL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MERCHANT_EMAIL_EMAILID_GENERATOR")
	@Column(name="EMAIL_ID", unique=true, nullable=false, precision=10)
	private long emailId;

	@Column(nullable=false, precision=1)
	private BigDecimal active;

	@Lob
	@Column(name="\"BODY\"")
	private String body;

	@Column(nullable=false, length=60)
	private String description;

	@Column(name="EMAIL_TYPE", nullable=false, length=255)
	private String emailType;

	@Column(name="FROM_EMAIL_ADDRESS", length=400)
	private String fromEmailAddress;

	@Column(name="MERCHANT_EMAIL_TEMPLATE_ID", nullable=false, precision=10)
	private BigDecimal merchantEmailTemplateId;

	@Column(length=255)
	private String subject;

	@Column(name="SYSTEM_GENERATED", precision=1)
	private BigDecimal systemGenerated;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	public MerchantEmail() {
	}

	public long getEmailId() {
		return this.emailId;
	}

	public void setEmailId(long emailId) {
		this.emailId = emailId;
	}

	public BigDecimal getActive() {
		return this.active;
	}

	public void setActive(BigDecimal active) {
		this.active = active;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailType() {
		return this.emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public String getFromEmailAddress() {
		return this.fromEmailAddress;
	}

	public void setFromEmailAddress(String fromEmailAddress) {
		this.fromEmailAddress = fromEmailAddress;
	}

	public BigDecimal getMerchantEmailTemplateId() {
		return this.merchantEmailTemplateId;
	}

	public void setMerchantEmailTemplateId(BigDecimal merchantEmailTemplateId) {
		this.merchantEmailTemplateId = merchantEmailTemplateId;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public BigDecimal getSystemGenerated() {
		return this.systemGenerated;
	}

	public void setSystemGenerated(BigDecimal systemGenerated) {
		this.systemGenerated = systemGenerated;
	}

	public MerchantNode getMerchantNode() {
		return this.merchantNode;
	}

	public void setMerchantNode(MerchantNode merchantNode) {
		this.merchantNode = merchantNode;
	}

}