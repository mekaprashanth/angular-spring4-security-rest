package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PORTAL_DATE database table.
 * 
 */
@Entity
@Table(name="PORTAL_DATE")
@NamedQuery(name="PortalDate.findAll", query="SELECT p FROM PortalDate p")
public class PortalDate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PORTAL_DATE_DATEID_GENERATOR", sequenceName="SEQ_PORTAL_DATE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PORTAL_DATE_DATEID_GENERATOR")
	@Column(name="DATE_ID", unique=true, nullable=false, precision=10)
	private long dateId;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DATE\"")
	private Date date;

	@Column(name="\"DAY\"", precision=2)
	private BigDecimal day;

	@Column(name="DAY_NAME", length=10)
	private String dayName;

	@Column(name="DAY_OF_YEAR", precision=3)
	private BigDecimal dayOfYear;

	@Column(name="\"MONTH\"", precision=2)
	private BigDecimal month;

	@Column(name="MONTH_END", precision=3)
	private BigDecimal monthEnd;

	@Column(name="MONTH_NAME", length=10)
	private String monthName;

	@Column(name="MONTH_START", precision=3)
	private BigDecimal monthStart;

	@Column(name="\"QUARTER\"", precision=10)
	private BigDecimal quarter;

	@Column(name="WEEK_OF_YEAR", precision=2)
	private BigDecimal weekOfYear;

	@Column(name="\"YEAR\"", precision=4)
	private BigDecimal year;

	//bi-directional many-to-one association to Authorisation
	@OneToMany(mappedBy="portalDate")
	private List<Authorisation> authorisations;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="portalDate1")
	private List<Clearing> clearings1;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="portalDate2")
	private List<Clearing> clearings2;

	//bi-directional many-to-one association to Clearing
	@OneToMany(mappedBy="portalDate3")
	private List<Clearing> clearings3;

	//bi-directional many-to-one association to Fee
	@OneToMany(mappedBy="portalDate")
	private List<Fee> fees;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="portalDate1")
	private List<Funding> fundings1;

	//bi-directional many-to-one association to Funding
	@OneToMany(mappedBy="portalDate2")
	private List<Funding> fundings2;

	//bi-directional many-to-one association to Terminal
	@OneToMany(mappedBy="portalDate1")
	private List<Terminal> terminals1;

	//bi-directional many-to-one association to Terminal
	@OneToMany(mappedBy="portalDate2")
	private List<Terminal> terminals2;

	//bi-directional many-to-one association to TerminalUpload
	@OneToMany(mappedBy="portalDate1")
	private List<TerminalUpload> terminalUploads1;

	//bi-directional many-to-one association to TerminalUpload
	@OneToMany(mappedBy="portalDate2")
	private List<TerminalUpload> terminalUploads2;

	public PortalDate() {
	}

	public long getDateId() {
		return this.dateId;
	}

	public void setDateId(long dateId) {
		this.dateId = dateId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getDay() {
		return this.day;
	}

	public void setDay(BigDecimal day) {
		this.day = day;
	}

	public String getDayName() {
		return this.dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public BigDecimal getDayOfYear() {
		return this.dayOfYear;
	}

	public void setDayOfYear(BigDecimal dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

	public BigDecimal getMonth() {
		return this.month;
	}

	public void setMonth(BigDecimal month) {
		this.month = month;
	}

	public BigDecimal getMonthEnd() {
		return this.monthEnd;
	}

	public void setMonthEnd(BigDecimal monthEnd) {
		this.monthEnd = monthEnd;
	}

	public String getMonthName() {
		return this.monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public BigDecimal getMonthStart() {
		return this.monthStart;
	}

	public void setMonthStart(BigDecimal monthStart) {
		this.monthStart = monthStart;
	}

	public BigDecimal getQuarter() {
		return this.quarter;
	}

	public void setQuarter(BigDecimal quarter) {
		this.quarter = quarter;
	}

	public BigDecimal getWeekOfYear() {
		return this.weekOfYear;
	}

	public void setWeekOfYear(BigDecimal weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	public BigDecimal getYear() {
		return this.year;
	}

	public void setYear(BigDecimal year) {
		this.year = year;
	}

	public List<Authorisation> getAuthorisations() {
		return this.authorisations;
	}

	public void setAuthorisations(List<Authorisation> authorisations) {
		this.authorisations = authorisations;
	}

	public Authorisation addAuthorisation(Authorisation authorisation) {
		getAuthorisations().add(authorisation);
		authorisation.setPortalDate(this);

		return authorisation;
	}

	public Authorisation removeAuthorisation(Authorisation authorisation) {
		getAuthorisations().remove(authorisation);
		authorisation.setPortalDate(null);

		return authorisation;
	}

	public List<Clearing> getClearings1() {
		return this.clearings1;
	}

	public void setClearings1(List<Clearing> clearings1) {
		this.clearings1 = clearings1;
	}

	public Clearing addClearings1(Clearing clearings1) {
		getClearings1().add(clearings1);
		clearings1.setPortalDate1(this);

		return clearings1;
	}

	public Clearing removeClearings1(Clearing clearings1) {
		getClearings1().remove(clearings1);
		clearings1.setPortalDate1(null);

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
		clearings2.setPortalDate2(this);

		return clearings2;
	}

	public Clearing removeClearings2(Clearing clearings2) {
		getClearings2().remove(clearings2);
		clearings2.setPortalDate2(null);

		return clearings2;
	}

	public List<Clearing> getClearings3() {
		return this.clearings3;
	}

	public void setClearings3(List<Clearing> clearings3) {
		this.clearings3 = clearings3;
	}

	public Clearing addClearings3(Clearing clearings3) {
		getClearings3().add(clearings3);
		clearings3.setPortalDate3(this);

		return clearings3;
	}

	public Clearing removeClearings3(Clearing clearings3) {
		getClearings3().remove(clearings3);
		clearings3.setPortalDate3(null);

		return clearings3;
	}

	public List<Fee> getFees() {
		return this.fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public Fee addFee(Fee fee) {
		getFees().add(fee);
		fee.setPortalDate(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setPortalDate(null);

		return fee;
	}

	public List<Funding> getFundings1() {
		return this.fundings1;
	}

	public void setFundings1(List<Funding> fundings1) {
		this.fundings1 = fundings1;
	}

	public Funding addFundings1(Funding fundings1) {
		getFundings1().add(fundings1);
		fundings1.setPortalDate1(this);

		return fundings1;
	}

	public Funding removeFundings1(Funding fundings1) {
		getFundings1().remove(fundings1);
		fundings1.setPortalDate1(null);

		return fundings1;
	}

	public List<Funding> getFundings2() {
		return this.fundings2;
	}

	public void setFundings2(List<Funding> fundings2) {
		this.fundings2 = fundings2;
	}

	public Funding addFundings2(Funding fundings2) {
		getFundings2().add(fundings2);
		fundings2.setPortalDate2(this);

		return fundings2;
	}

	public Funding removeFundings2(Funding fundings2) {
		getFundings2().remove(fundings2);
		fundings2.setPortalDate2(null);

		return fundings2;
	}

	public List<Terminal> getTerminals1() {
		return this.terminals1;
	}

	public void setTerminals1(List<Terminal> terminals1) {
		this.terminals1 = terminals1;
	}

	public Terminal addTerminals1(Terminal terminals1) {
		getTerminals1().add(terminals1);
		terminals1.setPortalDate1(this);

		return terminals1;
	}

	public Terminal removeTerminals1(Terminal terminals1) {
		getTerminals1().remove(terminals1);
		terminals1.setPortalDate1(null);

		return terminals1;
	}

	public List<Terminal> getTerminals2() {
		return this.terminals2;
	}

	public void setTerminals2(List<Terminal> terminals2) {
		this.terminals2 = terminals2;
	}

	public Terminal addTerminals2(Terminal terminals2) {
		getTerminals2().add(terminals2);
		terminals2.setPortalDate2(this);

		return terminals2;
	}

	public Terminal removeTerminals2(Terminal terminals2) {
		getTerminals2().remove(terminals2);
		terminals2.setPortalDate2(null);

		return terminals2;
	}

	public List<TerminalUpload> getTerminalUploads1() {
		return this.terminalUploads1;
	}

	public void setTerminalUploads1(List<TerminalUpload> terminalUploads1) {
		this.terminalUploads1 = terminalUploads1;
	}

	public TerminalUpload addTerminalUploads1(TerminalUpload terminalUploads1) {
		getTerminalUploads1().add(terminalUploads1);
		terminalUploads1.setPortalDate1(this);

		return terminalUploads1;
	}

	public TerminalUpload removeTerminalUploads1(TerminalUpload terminalUploads1) {
		getTerminalUploads1().remove(terminalUploads1);
		terminalUploads1.setPortalDate1(null);

		return terminalUploads1;
	}

	public List<TerminalUpload> getTerminalUploads2() {
		return this.terminalUploads2;
	}

	public void setTerminalUploads2(List<TerminalUpload> terminalUploads2) {
		this.terminalUploads2 = terminalUploads2;
	}

	public TerminalUpload addTerminalUploads2(TerminalUpload terminalUploads2) {
		getTerminalUploads2().add(terminalUploads2);
		terminalUploads2.setPortalDate2(this);

		return terminalUploads2;
	}

	public TerminalUpload removeTerminalUploads2(TerminalUpload terminalUploads2) {
		getTerminalUploads2().remove(terminalUploads2);
		terminalUploads2.setPortalDate2(null);

		return terminalUploads2;
	}

}