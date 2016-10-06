package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TERMINAL database table.
 * 
 */
@Entity
@Table(name="TERMINAL")
@NamedQuery(name="Terminal.findAll", query="SELECT t FROM Terminal t")
public class Terminal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TerminalPK id;

	@Column(name="EXTERNAL_TERMINAL_ID", nullable=false, length=20)
	private String externalTerminalId;

	@Column(name="INVENTORY_NR", precision=10)
	private BigDecimal inventoryNr;

	@Column(nullable=false, length=30)
	private String name;

	@Column(name="SERIAL_NUMBER", precision=10)
	private BigDecimal serialNumber;

	@Column(name="TERMINAL_MODEL", length=150)
	private String terminalModel;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
	private Platform platform;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DATE_ID", nullable=false)
	private PortalDate portalDate1;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INSTALLATION_DATE_ID", nullable=false)
	private PortalDate portalDate2;

	//bi-directional many-to-one association to TerminalStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TERMINAL_STATUS_ID", nullable=false)
	private TerminalStatus terminalStatus;

	//bi-directional many-to-one association to TerminalUpload
	@OneToMany(mappedBy="terminal")
	private List<TerminalUpload> terminalUploads;

	public Terminal() {
	}

	public TerminalPK getId() {
		return this.id;
	}

	public void setId(TerminalPK id) {
		this.id = id;
	}

	public String getExternalTerminalId() {
		return this.externalTerminalId;
	}

	public void setExternalTerminalId(String externalTerminalId) {
		this.externalTerminalId = externalTerminalId;
	}

	public BigDecimal getInventoryNr() {
		return this.inventoryNr;
	}

	public void setInventoryNr(BigDecimal inventoryNr) {
		this.inventoryNr = inventoryNr;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(BigDecimal serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getTerminalModel() {
		return this.terminalModel;
	}

	public void setTerminalModel(String terminalModel) {
		this.terminalModel = terminalModel;
	}

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public MerchantNode getMerchantNode() {
		return this.merchantNode;
	}

	public void setMerchantNode(MerchantNode merchantNode) {
		this.merchantNode = merchantNode;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public PortalDate getPortalDate1() {
		return this.portalDate1;
	}

	public void setPortalDate1(PortalDate portalDate1) {
		this.portalDate1 = portalDate1;
	}

	public PortalDate getPortalDate2() {
		return this.portalDate2;
	}

	public void setPortalDate2(PortalDate portalDate2) {
		this.portalDate2 = portalDate2;
	}

	public TerminalStatus getTerminalStatus() {
		return this.terminalStatus;
	}

	public void setTerminalStatus(TerminalStatus terminalStatus) {
		this.terminalStatus = terminalStatus;
	}

	public List<TerminalUpload> getTerminalUploads() {
		return this.terminalUploads;
	}

	public void setTerminalUploads(List<TerminalUpload> terminalUploads) {
		this.terminalUploads = terminalUploads;
	}

	public TerminalUpload addTerminalUpload(TerminalUpload terminalUpload) {
		getTerminalUploads().add(terminalUpload);
		terminalUpload.setTerminal(this);

		return terminalUpload;
	}

	public TerminalUpload removeTerminalUpload(TerminalUpload terminalUpload) {
		getTerminalUploads().remove(terminalUpload);
		terminalUpload.setTerminal(null);

		return terminalUpload;
	}

}