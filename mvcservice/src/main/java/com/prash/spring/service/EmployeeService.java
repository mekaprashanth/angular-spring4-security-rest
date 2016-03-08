/**
 * 
 */
package com.prash.spring.service;

import java.util.List;

import com.prash.spring.entities.Employee;

/**
 * @author Prashanth_Meka
 *
 */
public interface EmployeeService {
	
	public Employee getUser(String username);
	
	public void save(Employee employee);
	
	public List<Employee> list();
	
	public Integer getMaxUserid();


}
