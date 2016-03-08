/**
 * 
 */
package com.prash.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Prashanth_Meka
 *
 */
@Entity
@Table(name="PORTAL_ROLE_FUNCTION")
public class PortalRoleFunction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_FUNCTION_ID")
	private Long roleFunctionId;
	@Column(name="CAN_READ")
	private int canRead;
	@Column(name="CAN_CREATE")
	private int canCreate;
	@Column(name="CAN_UPDATE")
	private int canUpdate;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="ROLE_ID")
	private PortalRole portalRole;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="PORTAL_FUNCTION_ID")
	private PortalFunction portalFunction;
	
	public Long getRoleFunctionId() {
		return roleFunctionId;
	}
	public void setRoleFunctionId(Long roleFunctionId) {
		this.roleFunctionId = roleFunctionId;
	}
	public int getCanRead() {
		return canRead;
	}
	public void setCanRead(int canRead) {
		this.canRead = canRead;
	}
	public int getCanCreate() {
		return canCreate;
	}
	public void setCanCreate(int canCreate) {
		this.canCreate = canCreate;
	}
	public int getCanUpdate() {
		return canUpdate;
	}
	public void setCanUpdate(int canUpdate) {
		this.canUpdate = canUpdate;
	}
	public PortalRole getPortalRole() {
		return portalRole;
	}
	public void setPortalRole(PortalRole portalRole) {
		this.portalRole = portalRole;
	}
	public PortalFunction getPortalFunction() {
		return portalFunction;
	}
	public void setPortalFunction(PortalFunction portalFunction) {
		this.portalFunction = portalFunction;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleFunctionId == null) ? 0 : roleFunctionId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortalRoleFunction other = (PortalRoleFunction) obj;
		if (roleFunctionId == null) {
			if (other.roleFunctionId != null)
				return false;
		} else if (!roleFunctionId.equals(other.roleFunctionId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PortalRoleFunction [roleFunctionId=" + roleFunctionId + ", canRead=" + canRead + ", canCreate="
				+ canCreate + ", canUpdate=" + canUpdate + ", portalRole=" + portalRole + ", portalFunction="
				+ portalFunction + "]";
	}
	
	
	

}
