package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ROLE_FUNCTION database table.
 * 
 */
@Entity
@Table(name="ROLE_FUNCTION")
@NamedQuery(name="RoleFunction.findAll", query="SELECT r FROM RoleFunction r")
public class RoleFunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLE_FUNCTION_ROLEFUNCTIONID_GENERATOR", sequenceName="SEQ_ROLE_FUNCTION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_FUNCTION_ROLEFUNCTIONID_GENERATOR")
	@Column(name="ROLE_FUNCTION_ID", unique=true, nullable=false, precision=10)
	private long roleFunctionId;

	@Column(name="CAN_CREATE", nullable=false, precision=1)
	private BigDecimal canCreate;

	@Column(name="CAN_READ", nullable=false, precision=1)
	private BigDecimal canRead;

	@Column(name="CAN_UPDATE", nullable=false, precision=1)
	private BigDecimal canUpdate;

	//bi-directional many-to-one association to PortalFunction
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PORTAL_FUNCTION_ID", nullable=false)
	private PortalFunction portalFunction;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROLE_ID", nullable=false)
	private Role role;

	//bi-directional many-to-one association to UserFunction
	@OneToMany(mappedBy="roleFunction")
	private List<UserFunction> userFunctions;

	public RoleFunction() {
	}

	public long getRoleFunctionId() {
		return this.roleFunctionId;
	}

	public void setRoleFunctionId(long roleFunctionId) {
		this.roleFunctionId = roleFunctionId;
	}

	public BigDecimal getCanCreate() {
		return this.canCreate;
	}

	public void setCanCreate(BigDecimal canCreate) {
		this.canCreate = canCreate;
	}

	public BigDecimal getCanRead() {
		return this.canRead;
	}

	public void setCanRead(BigDecimal canRead) {
		this.canRead = canRead;
	}

	public BigDecimal getCanUpdate() {
		return this.canUpdate;
	}

	public void setCanUpdate(BigDecimal canUpdate) {
		this.canUpdate = canUpdate;
	}

	public PortalFunction getPortalFunction() {
		return this.portalFunction;
	}

	public void setPortalFunction(PortalFunction portalFunction) {
		this.portalFunction = portalFunction;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<UserFunction> getUserFunctions() {
		return this.userFunctions;
	}

	public void setUserFunctions(List<UserFunction> userFunctions) {
		this.userFunctions = userFunctions;
	}

	public UserFunction addUserFunction(UserFunction userFunction) {
		getUserFunctions().add(userFunction);
		userFunction.setRoleFunction(this);

		return userFunction;
	}

	public UserFunction removeUserFunction(UserFunction userFunction) {
		getUserFunctions().remove(userFunction);
		userFunction.setRoleFunction(null);

		return userFunction;
	}

}