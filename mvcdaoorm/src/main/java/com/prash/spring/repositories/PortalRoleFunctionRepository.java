package com.prash.spring.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prash.spring.entities.PortalRole;
import com.prash.spring.entities.PortalRoleFunction;

@Transactional
@Repository
public interface PortalRoleFunctionRepository
        extends JpaRepository<PortalRoleFunction, Long> {
		
	public List<PortalRoleFunction> findByPortalRole(PortalRole portalRole);
}



