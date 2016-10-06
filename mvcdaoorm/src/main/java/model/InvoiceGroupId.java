package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INVOICE_GROUP_ID database table.
 * 
 */
@Entity
@Table(name="INVOICE_GROUP_ID")
@NamedQuery(name="InvoiceGroupId.findAll", query="SELECT i FROM InvoiceGroupId i")
public class InvoiceGroupId implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InvoiceGroupIdPK id;

	@Column(name="ADDRES_LINE_4", length=255)
	private String addresLine4;

	@Column(name="ADDRESS_LINE_1", nullable=false, length=255)
	private String addressLine1;

	@Column(name="ADDRESS_LINE_2", nullable=false, length=255)
	private String addressLine2;

	@Column(name="ADDRESS_LINE_3", length=255)
	private String addressLine3;

	@Column(name="ADDRESS_LINE_5", length=255)
	private String addressLine5;

	@Column(name="ADDRESS_LINE_6", length=40)
	private String addressLine6;

	@Column(nullable=false, length=50)
	private String city;

	@Column(name="MERCHANT_INVOICE_GROUP_ID", nullable=false, length=150)
	private String merchantInvoiceGroupId;

	@Column(name="POST_ZIP_CODE", nullable=false, length=8)
	private String postZipCode;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_CODE_ID", nullable=false)
	private Country country;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
	private Platform platform;

	public InvoiceGroupId() {
	}

	public InvoiceGroupIdPK getId() {
		return this.id;
	}

	public void setId(InvoiceGroupIdPK id) {
		this.id = id;
	}

	public String getAddresLine4() {
		return this.addresLine4;
	}

	public void setAddresLine4(String addresLine4) {
		this.addresLine4 = addresLine4;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine5() {
		return this.addressLine5;
	}

	public void setAddressLine5(String addressLine5) {
		this.addressLine5 = addressLine5;
	}

	public String getAddressLine6() {
		return this.addressLine6;
	}

	public void setAddressLine6(String addressLine6) {
		this.addressLine6 = addressLine6;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMerchantInvoiceGroupId() {
		return this.merchantInvoiceGroupId;
	}

	public void setMerchantInvoiceGroupId(String merchantInvoiceGroupId) {
		this.merchantInvoiceGroupId = merchantInvoiceGroupId;
	}

	public String getPostZipCode() {
		return this.postZipCode;
	}

	public void setPostZipCode(String postZipCode) {
		this.postZipCode = postZipCode;
	}

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

}