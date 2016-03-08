package com.prash.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prash.spring.entities.Role;

@Transactional
@Repository
public interface RoleRepository
        extends JpaRepository<Role, Integer> {
		
	 @Query("select max(r.roleid) from Role r")
	 public Integer getMaxRoleid();
	

}