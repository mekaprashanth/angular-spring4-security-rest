package com.prash.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prash.spring.entities.PortalUser;
import com.prash.spring.entities.PortalUserFunction;

@Transactional
@Repository
public interface PortalUserFunctionRepository
        extends JpaRepository<PortalUserFunction, Long> {
		


}