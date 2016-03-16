/**
 * 
 */
package com.prash.camel.sample.jaxws.values;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author prashanthmeka
 *
 */
@XmlRootElement
public class PersonDetails {
	
	private String firstName;
	private String lastName;
	private String proxyNumber;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProxyNumber() {
		return proxyNumber;
	}
	public void setProxyNumber(String proxyNumber) {
		this.proxyNumber = proxyNumber;
	}
	@Override
	public String toString() {
		return "PersonDetails [firstName=" + firstName + ", lastName="
				+ lastName + ", proxyNumber=" + proxyNumber + "]";
	}
	
	

}
