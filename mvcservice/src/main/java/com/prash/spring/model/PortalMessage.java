/**
 * 
 */
package com.prash.spring.model;

/**
 * @author Prashanth_Meka
 *
 */
public class PortalMessage {
	
	private int id;
	private String name;
	
	private UserValue user;
	
	public UserValue getUser() {
		return user;
	}

	public void setUser(UserValue user) {
		this.user = user;
	}

	public PortalMessage(int id, String name, UserValue user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}

	public PortalMessage(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
