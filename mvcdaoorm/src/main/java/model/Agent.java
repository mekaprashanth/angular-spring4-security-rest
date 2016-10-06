package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AGENT database table.
 * 
 */
@Entity
@Table(name="AGENT")
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGENT_AGENTID_GENERATOR", sequenceName="SEQ_AGENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGENT_AGENTID_GENERATOR")
	@Column(name="AGENT_ID", unique=true, nullable=false, precision=3)
	private long agentId;

	@Column(name="AGENT_SHORT_NAME", nullable=false, length=4)
	private String agentShortName;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=2)
	private String languageCode;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="agent")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="agent")
	private List<Clearing> clearings;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="agent")
	private List<Funding> fundings;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="agent")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to OfflineReport
	@OneToMany(mappedBy="agent")
	private List<OfflineReport> offlineReports;

	//bi-directional many-to-one association to PurchaseAddendumDetail
	@OneToMany(mappedBy="agent")
	private List<PurchaseAddendumDetail> purchaseAddendumDetails;

	public Agent() {
	}

	public long getAgentId() {
		return this.agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public String getAgentShortName() {
		return this.agentShortName;
	}

	public void setAgentShortName(String agentShortName) {
		this.agentShortName = agentShortName;
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

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setAgent(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setAgent(null);

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
		clearing.setAgent(this);

		return clearing;
	}

	public Clearing removeClearing(Clearing clearing) {
		getClearings().remove(clearing);
		clearing.setAgent(null);

		return clearing;
	}

	public List<Funding> getFundings() {
		return this.fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	public Funding addFunding(Funding funding) {
		getFundings().add(funding);
		funding.setAgent(this);

		return funding;
	}

	public Funding removeFunding(Funding funding) {
		getFundings().remove(funding);
		funding.setAgent(null);

		return funding;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setAgent(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setAgent(null);

		return invoice;
	}

	public List<OfflineReport> getOfflineReports() {
		return this.offlineReports;
	}

	public void setOfflineReports(List<OfflineReport> offlineReports) {
		this.offlineReports = offlineReports;
	}

	public OfflineReport addOfflineReport(OfflineReport offlineReport) {
		getOfflineReports().add(offlineReport);
		offlineReport.setAgent(this);

		return offlineReport;
	}

	public OfflineReport removeOfflineReport(OfflineReport offlineReport) {
		getOfflineReports().remove(offlineReport);
		offlineReport.setAgent(null);

		return offlineReport;
	}

	public List<PurchaseAddendumDetail> getPurchaseAddendumDetails() {
		return this.purchaseAddendumDetails;
	}

	public void setPurchaseAddendumDetails(List<PurchaseAddendumDetail> purchaseAddendumDetails) {
		this.purchaseAddendumDetails = purchaseAddendumDetails;
	}

	public PurchaseAddendumDetail addPurchaseAddendumDetail(PurchaseAddendumDetail purchaseAddendumDetail) {
		getPurchaseAddendumDetails().add(purchaseAddendumDetail);
		purchaseAddendumDetail.setAgent(this);

		return purchaseAddendumDetail;
	}

	public PurchaseAddendumDetail removePurchaseAddendumDetail(PurchaseAddendumDetail purchaseAddendumDetail) {
		getPurchaseAddendumDetails().remove(purchaseAddendumDetail);
		purchaseAddendumDetail.setAgent(null);

		return purchaseAddendumDetail;
	}

}