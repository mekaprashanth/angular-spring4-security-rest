package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TERMINAL_STATUS database table.
 * 
 */
@Entity
@Table(name="TERMINAL_STATUS")
@NamedQuery(name="TerminalStatus.findAll", query="SELECT t FROM TerminalStatus t")
public class TerminalStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TERMINAL_STATUS_TERMINALSTATUSID_GENERATOR", sequenceName="SEQ_TERMINAL_STATUS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TERMINAL_STATUS_TERMINALSTATUSID_GENERATOR")
	@Column(name="TERMINAL_STATUS_ID", unique=true, nullable=false, precision=10)
	private long terminalStatusId;

	@Column(length=150)
	private String description;

	@Column(name="LANGUAGE_CODE", nullable=false, length=4)
	private String languageCode;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Terminal
	@OneToMany(mappedBy="terminalStatus")
	private List<Terminal> terminals;

	public TerminalStatus() {
	}

	public long getTerminalStatusId() {
		return this.terminalStatusId;
	}

	public void setTerminalStatusId(long terminalStatusId) {
		this.terminalStatusId = terminalStatusId;
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

	public List<Terminal> getTerminals() {
		return this.terminals;
	}

	public void setTerminals(List<Terminal> terminals) {
		this.terminals = terminals;
	}

	public Terminal addTerminal(Terminal terminal) {
		getTerminals().add(terminal);
		terminal.setTerminalStatus(this);

		return terminal;
	}

	public Terminal removeTerminal(Terminal terminal) {
		getTerminals().remove(terminal);
		terminal.setTerminalStatus(null);

		return terminal;
	}

}