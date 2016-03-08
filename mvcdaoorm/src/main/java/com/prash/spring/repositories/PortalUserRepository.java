package com.prash.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prash.spring.entities.PortalUser;

@Transactional
@Repository
public interface PortalUserRepository
        extends JpaRepository<PortalUser, Long> {
		
	public PortalUser findByUsername(String username);
	
	@Query("select max(p.userId) from PortalUser p")
	 public Integer getMaxUserId();

}