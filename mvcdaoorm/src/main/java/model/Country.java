package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the COUNTRY database table.
 * 
 */
@Entity
@Table(name="COUNTRY")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COUNTRY_COUNTRYCODEID_GENERATOR", sequenceName="SEQ_COUNTRY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COUNTRY_COUNTRYCODEID_GENERATOR")
	@Column(name="COUNTRY_CODE_ID", unique=true, nullable=false, precision=5)
	private long countryCodeId;

	@Column(nullable=false, length=200)
	private String descritption;

	@Column(name="ISO_COUNTRY_CODE", nullable=false, precision=3)
	private BigDecimal isoCountryCode;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="country1")
	private List<Authorisation> authorisations1;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="country2")
	private List<Authorisation> authorisations2;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="country1")
	private List<Clearing> clearings1;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="country2")
	private List<Clearing> clearings2;

	//bi-directional many-to-one association to InvoiceGroupId
	@OneToMany(mappedBy="country")
	private List<InvoiceGroupId> invoiceGroupIds;

	//bi-directional many-to-one association to MerchantNode
	@OneToMany(mappedBy="country")
	private List<MerchantNode> merchantNodes;

	public Country() {
	}

	public long getCountryCodeId() {
		return this.countryCodeId;
	}

	public void setCountryCodeId(long countryCodeId) {
		this.countryCodeId = countryCodeId;
	}

	public String getDescritption() {
		return this.descritption;
	}

	public void setDescritption(String descritption) {
		this.descritption = descritption;
	}

	public BigDecimal getIsoCountryCode() {
		return this.isoCountryCode;
	}

	public void setIsoCountryCode(BigDecimal isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public List<Authorisation> getAuthorisations1() {
		return this.authorisations1;
	}

	public void setAuthorisations1(List<Authorisation> authorisations1) {
		this.authorisations1 = authorisations1;
	}

	public Authorisation addAuthorisations1(Authorisation authorisations1) {
		getAuthorisations1().add(authorisations1);
		authorisations1.setCountry1(this);

		return authorisations1;
	}

	public Authorisation removeAuthorisations1(Authorisation authorisations1) {
		getAuthorisations1().remove(authorisations1);
		authorisations1.setCountry1(null);

		return authorisations1;
	}

	public List<Authorisation> getAuthorisations2() {
		return this.authorisations2;
	}

	public void setAuthorisations2(List<Authorisation> authorisations2) {
		this.authorisations2 = authorisations2;
	}

	public Authorisation addAuthorisations2(Authorisation authorisations2) {
		getAuthorisations2().add(authorisations2);
		authorisations2.setCountry2(this);

		return authorisations2;
	}

	public Authorisation removeAuthorisations2(Authorisation authorisations2) {
		getAuthorisations2().remove(authorisations2);
		authorisations2.setCountry2(null);

		return authorisations2;
	}

	public List<Clearing> getClearings1() {
		return this.clearings1;
	}

	public void setClearings1(List<Clearing> clearings1) {
		this.clearings1 = clearings1;
	}

	public Clearing addClearings1(Clearing clearings1) {
		getClearings1().add(clearings1);
		clearings1.setCountry1(this);

		return clearings1;
	}

	public Clearing removeClearings1(Clearing clearings1) {
		getClearings1().remove(clearings1);
		clearings1.setCountry1(null);

		return clearings1;
	}

	public List<Clearing> getClearings2() {
		return this.clearings2;
	}

	public void setClearings2(List<Clearing> clearings2) {
		this.clearings2 = clearings2;
	}

	public Clearing addClearings2(Clearing clearings2) {
		getClearings2().add(clearings2);
		clearings2.setCountry2(this);

		return clearings2;
	}

	public Clearing removeClearings2(Clearing clearings2) {
		getClearings2().remove(clearings2);
		clearings2.setCountry2(null);

		return clearings2;
	}

	public List<InvoiceGroupId> getInvoiceGroupIds() {
		return this.invoiceGroupIds;
	}

	public void setInvoiceGroupIds(List<InvoiceGroupId> invoiceGroupIds) {
		this.invoiceGroupIds = invoiceGroupIds;
	}

	public InvoiceGroupId addInvoiceGroupId(InvoiceGroupId invoiceGroupId) {
		getInvoiceGroupIds().add(invoiceGroupId);
		invoiceGroupId.setCountry(this);

		return invoiceGroupId;
	}

	public InvoiceGroupId removeInvoiceGroupId(InvoiceGroupId invoiceGroupId) {
		getInvoiceGroupIds().remove(invoiceGroupId);
		invoiceGroupId.setCountry(null);

		return invoiceGroupId;
	}

	public List<MerchantNode> getMerchantNodes() {
		return this.merchantNodes;
	}

	public void setMerchantNodes(List<MerchantNode> merchantNodes) {
		this.merchantNodes = merchantNodes;
	}

	public MerchantNode addMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().add(merchantNode);
		merchantNode.setCountry(this);

		return merchantNode;
	}

	public MerchantNode removeMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().remove(merchantNode);
		merchantNode.setCountry(null);

		return merchantNode;
	}

}