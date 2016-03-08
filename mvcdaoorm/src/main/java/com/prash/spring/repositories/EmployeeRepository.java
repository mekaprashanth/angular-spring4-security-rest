package com.prash.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prash.spring.entities.Employee;

@Transactional
@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {
	
	public Employee findByUsername(String username);
	
	
	@Query("select max(e.userid) from Employee e")
	 public Integer getMaxUserid();
	

}