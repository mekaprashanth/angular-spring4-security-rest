package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_FUNCTION database table.
 * 
 */
@Entity
@Table(name="USER_FUNCTION")
@NamedQuery(name="UserFunction.findAll", query="SELECT u FROM UserFunction u")
public class UserFunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_FUNCTION_USERFUNCTIONID_GENERATOR", sequenceName="SEQ_USER_FUNCTION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_FUNCTION_USERFUNCTIONID_GENERATOR")
	@Column(name="USER_FUNCTION_ID", unique=true, nullable=false, precision=10)
	private long userFunctionId;

	//bi-directional many-to-one association to RoleFunction
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROLE_FUNCTION_ID", nullable=false)
	private RoleFunction roleFunction;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;

	public UserFunction() {
	}

	public long getUserFunctionId() {
		return this.userFunctionId;
	}

	public void setUserFunctionId(long userFunctionId) {
		this.userFunctionId = userFunctionId;
	}

	public RoleFunction getRoleFunction() {
		return this.roleFunction;
	}

	public void setRoleFunction(RoleFunction roleFunction) {
		this.roleFunction = roleFunction;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}