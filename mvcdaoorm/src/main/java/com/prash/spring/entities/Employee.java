/**
 * 
 */
package com.prash.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Prashanth_Meka
 *
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)

	private int userid;
	private String username;
	
	private String password;
	private boolean enabled;
	private String firstname;
	private String lastname;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="userid")
	@Fetch(FetchMode.JOIN)
	@JsonBackReference	
	private List<Role> role;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password, boolean enabled, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "Employee [userid=" + userid + ", username=" + username + ", password=" + password + ", enabled="
				+ enabled + ", firstname=" + firstname + ", lastname=" + lastname + ", role=" + role + "]";
	}
	
}
