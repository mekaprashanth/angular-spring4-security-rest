package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONFIGURATION database table.
 * 
 */
@Entity
@Table(name="CONFIGURATION")
@NamedQuery(name="Configuration.findAll", query="SELECT c FROM Configuration c")
public class Configuration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONFIGURATION_CONFIGURATIONID_GENERATOR", sequenceName="SEQ_CONFIGURATION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONFIGURATION_CONFIGURATIONID_GENERATOR")
	@Column(name="CONFIGURATION_ID", unique=true, nullable=false, precision=10)
	private long configurationId;

	@Column(nullable=false, length=20)
	private String name;

	@Column(name="\"VALUE\"", nullable=false, length=100)
	private String value;

	public Configuration() {
	}

	public long getConfigurationId() {
		return this.configurationId;
	}

	public void setConfigurationId(long configurationId) {
		this.configurationId = configurationId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}