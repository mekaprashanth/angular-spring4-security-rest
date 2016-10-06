package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name="ROLE")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLE_ROLEID_GENERATOR", sequenceName="SEQ_ROLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_ROLEID_GENERATOR")
	@Column(name="ROLE_ID", unique=true, nullable=false, precision=10)
	private long roleId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to RoleFunction
	@OneToMany(mappedBy="role")
	private List<RoleFunction> roleFunctions;

	public Role() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
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

	public List<RoleFunction> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(List<RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	public RoleFunction addRoleFunction(RoleFunction roleFunction) {
		getRoleFunctions().add(roleFunction);
		roleFunction.setRole(this);

		return roleFunction;
	}

	public RoleFunction removeRoleFunction(RoleFunction roleFunction) {
		getRoleFunctions().remove(roleFunction);
		roleFunction.setRole(null);

		return roleFunction;
	}

}