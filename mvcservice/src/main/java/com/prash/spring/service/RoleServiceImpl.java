/**
 * 
 */
package com.prash.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prash.spring.entities.Employee;
import com.prash.spring.entities.Role;
import com.prash.spring.repositories.RoleRepository;

/**
 * @author Prashanth_Meka
 *
 */

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public int findTopOrderByRoleid() {
		int roleIid = roleRepository.getMaxRoleid();
		return roleIid;
	}

}
