package com.prash.spring.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prash.spring.entities.PortalRole;

@Transactional
@Repository
public interface PortalRoleRepository
        extends JpaRepository<PortalRole, Long> {
		
	public List<PortalRole> findByName(String roleName);
}