package com.prash.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prash.spring.entities.PortalFunction;

@Transactional
@Repository
public interface PortalFunctionRepository
        extends JpaRepository<PortalFunction, Long> {
		
	public PortalFunction findByName(String functionName);
}