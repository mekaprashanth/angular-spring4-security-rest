package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MERCHANT_SMS database table.
 * 
 */
@Entity
@Table(name="MERCHANT_SMS")
@NamedQuery(name="MerchantSm.findAll", query="SELECT m FROM MerchantSm m")
public class MerchantSm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MERCHANT_SMS_SMSID_GENERATOR", sequenceName="SEQ_MERCHANT_SMS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MERCHANT_SMS_SMSID_GENERATOR")
	@Column(name="SMS_ID", unique=true, nullable=false, precision=10)
	private long smsId;

	@Column(nullable=false, precision=1)
	private BigDecimal active;

	@Lob
	@Column(name="\"BODY\"")
	private String body;

	@Column(name="FROM_SMS_ADDRESS", length=400)
	private String fromSmsAddress;

	@Column(name="MERCHANT_SMS_TEMPLATE_ID", nullable=false, precision=10)
	private BigDecimal merchantSmsTemplateId;

	@Column(name="SMS_TYPE", nullable=false, length=255)
	private String smsType;

	@Column(length=255)
	private String subject;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	public MerchantSm() {
	}

	public long getSmsId() {
		return this.smsId;
	}

	public void setSmsId(long smsId) {
		this.smsId = smsId;
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

	public String getFromSmsAddress() {
		return this.fromSmsAddress;
	}

	public void setFromSmsAddress(String fromSmsAddress) {
		this.fromSmsAddress = fromSmsAddress;
	}

	public BigDecimal getMerchantSmsTemplateId() {
		return this.merchantSmsTemplateId;
	}

	public void setMerchantSmsTemplateId(BigDecimal merchantSmsTemplateId) {
		this.merchantSmsTemplateId = merchantSmsTemplateId;
	}

	public String getSmsType() {
		return this.smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public MerchantNode getMerchantNode() {
		return this.merchantNode;
	}

	public void setMerchantNode(MerchantNode merchantNode) {
		this.merchantNode = merchantNode;
	}

}