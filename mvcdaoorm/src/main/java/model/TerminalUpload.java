package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TERMINAL_UPLOADS database table.
 * 
 */
@Entity
@Table(name="TERMINAL_UPLOADS")
@NamedQuery(name="TerminalUpload.findAll", query="SELECT t FROM TerminalUpload t")
public class TerminalUpload implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TerminalUploadPK id;

	@Column(name="UPLOAD_AMOUNT", nullable=false, precision=23, scale=3)
	private BigDecimal uploadAmount;

	@Column(name="UPLOAD_VOLUME", nullable=false, precision=10)
	private BigDecimal uploadVolume;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UPLOAD_CURRRENCY_ID", nullable=false)
	private Currency currency;

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
	@JoinColumn(name="UPLOAD_DATE_ID", nullable=false, insertable=false, updatable=false)
	private PortalDate portalDate1;

	//bi-directional many-to-one association to PortalDate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROCESSING_DATE_ID", nullable=false)
	private PortalDate portalDate2;

	//bi-directional many-to-one association to Terminal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="PLATFORM_ID", referencedColumnName="PLATFORM_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="TERMINAL_ID", referencedColumnName="TERMINAL_ID", nullable=false)
		})
	private Terminal terminal;

	public TerminalUpload() {
	}

	public TerminalUploadPK getId() {
		return this.id;
	}

	public void setId(TerminalUploadPK id) {
		this.id = id;
	}

	public BigDecimal getUploadAmount() {
		return this.uploadAmount;
	}

	public void setUploadAmount(BigDecimal uploadAmount) {
		this.uploadAmount = uploadAmount;
	}

	public BigDecimal getUploadVolume() {
		return this.uploadVolume;
	}

	public void setUploadVolume(BigDecimal uploadVolume) {
		this.uploadVolume = uploadVolume;
	}

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
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

	public Terminal getTerminal() {
		return this.terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

}