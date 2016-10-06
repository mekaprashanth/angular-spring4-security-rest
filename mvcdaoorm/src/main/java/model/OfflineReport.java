package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the OFFLINE_REPORTS database table.
 * 
 */
@Entity
@Table(name="OFFLINE_REPORTS")
@NamedQuery(name="OfflineReport.findAll", query="SELECT o FROM OfflineReport o")
public class OfflineReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFLINE_REPORTS_REPORTID_GENERATOR", sequenceName="SEQ_OFFLINE_REPORTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFLINE_REPORTS_REPORTID_GENERATOR")
	@Column(name="REPORT_ID", unique=true, nullable=false, precision=10)
	private long reportId;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FROM", nullable=false)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_TO", nullable=false)
	private Date dateTo;

	@Column(nullable=false, length=1)
	private String freequency;

	@Lob
	@Column(name="REPORT_FILE", nullable=false)
	private byte[] reportFile;

	@Column(name="REPORT_NAME", nullable=false, length=150)
	private String reportName;

	@Column(name="REPORT_TYPE", nullable=false, length=150)
	private String reportType;

	//bi-directional many-to-one association to Agent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantNode merchantNode;

	public OfflineReport() {
	}

	public long getReportId() {
		return this.reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getFreequency() {
		return this.freequency;
	}

	public void setFreequency(String freequency) {
		this.freequency = freequency;
	}

	public byte[] getReportFile() {
		return this.reportFile;
	}

	public void setReportFile(byte[] reportFile) {
		this.reportFile = reportFile;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportType() {
		return this.reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public MerchantNode getMerchantNode() {
		return this.merchantNode;
	}

	public void setMerchantNode(MerchantNode merchantNode) {
		this.merchantNode = merchantNode;
	}

}