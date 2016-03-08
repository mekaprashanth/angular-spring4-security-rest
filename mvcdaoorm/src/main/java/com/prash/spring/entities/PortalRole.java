/**
 * 
 */
package com.prash.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Prashanth_Meka
 *
 */
@Entity
@Table(name="PORTAL_ROLE")
public class PortalRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_ID")
	private Long roleId;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy="portalRole")
	private List<PortalRoleFunction> portalRoleFunctions;
	
	public PortalRole() {
		
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PortalRoleFunction> getPortalRoleFunctions() {
		return portalRoleFunctions;
	}

	public void setPortalRoleFunctions(List<PortalRoleFunction> portalRoleFunctions) {
		this.portalRoleFunctions = portalRoleFunctions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		PortalRole other = (PortalRole) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PortalRole [roleId=" + roleId + ", name=" + name + ", description=" + description + "]";
	}

	
}
