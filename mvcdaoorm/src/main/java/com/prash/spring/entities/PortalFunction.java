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
@Table(name="PORTAL_FUNCTION")
public class PortalFunction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PORTAL_FUNCTION_ID")
	private Long portalFunctionId;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="REST_URL")
	private String restUrl;
	
	@OneToMany(mappedBy="portalFunction")
	private List<PortalRoleFunction> portalRoleFunctions;
	
	public PortalFunction() {
		
	}

	public Long getPortalFunctionId() {
		return portalFunctionId;
	}

	public void setPortalFunctionId(Long portalFunctionId) {
		this.portalFunctionId = portalFunctionId;
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

	public String getRestUrl() {
		return restUrl;
	}

	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
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
		result = prime * result + ((portalFunctionId == null) ? 0 : portalFunctionId.hashCode());
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
		PortalFunction other = (PortalFunction) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (portalFunctionId == null) {
			if (other.portalFunctionId != null)
				return false;
		} else if (!portalFunctionId.equals(other.portalFunctionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PortalFunction [portalFunctionId=" + portalFunctionId + ", name=" + name + ", description="
				+ description + ", restUrl=" + restUrl + "]";
	}
	
	

}
