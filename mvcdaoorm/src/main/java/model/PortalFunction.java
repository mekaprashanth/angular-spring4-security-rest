package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PORTAL_FUNCTION database table.
 * 
 */
@Entity
@Table(name="PORTAL_FUNCTION")
@NamedQuery(name="PortalFunction.findAll", query="SELECT p FROM PortalFunction p")
public class PortalFunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PORTAL_FUNCTION_PORTALFUNCTIONID_GENERATOR", sequenceName="SEQ_PORTAL_FUNCTION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PORTAL_FUNCTION_PORTALFUNCTIONID_GENERATOR")
	@Column(name="PORTAL_FUNCTION_ID", unique=true, nullable=false, precision=10)
	private long portalFunctionId;

	@Column(length=200)
	private String description;

	@Column(nullable=false, length=30)
	private String name;

	@Column(name="REST_URL", nullable=false, length=200)
	private String restUrl;

	//bi-directional many-to-one association to RoleFunction
	@OneToMany(mappedBy="portalFunction")
	private List<RoleFunction> roleFunctions;

	public PortalFunction() {
	}

	public long getPortalFunctionId() {
		return this.portalFunctionId;
	}

	public void setPortalFunctionId(long portalFunctionId) {
		this.portalFunctionId = portalFunctionId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestUrl() {
		return this.restUrl;
	}

	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}

	public List<RoleFunction> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(List<RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	public RoleFunction addRoleFunction(RoleFunction roleFunction) {
		getRoleFunctions().add(roleFunction);
		roleFunction.setPortalFunction(this);

		return roleFunction;
	}

	public RoleFunction removeRoleFunction(RoleFunction roleFunction) {
		getRoleFunctions().remove(roleFunction);
		roleFunction.setPortalFunction(null);

		return roleFunction;
	}

}