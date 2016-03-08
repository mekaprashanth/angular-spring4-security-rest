/**
 * 
 */
package com.prash.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prash.spring.entities.Employee;
import com.prash.spring.repositories.EmployeeRepository;

/**
 * @author Prashanth_Meka
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee getUser(String userName) {
		Employee employee = employeeRepository.findByUsername(userName);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> list() {
		return employeeRepository.findAll();
	}

	@Override
	public Integer getMaxUserid() {
		return employeeRepository.getMaxUserid();
	}

}
