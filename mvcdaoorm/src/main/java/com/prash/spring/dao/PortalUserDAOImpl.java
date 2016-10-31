/**
 * 
 */
package com.prash.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prash.spring.entities.PortalUser;
import com.prash.spring.repositories.PortalUserTest;

/**
 * @author Prashanth_Meka
 *
 */
@Repository
public class PortalUserDAOImpl implements PortalUserDAO {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	protected EntityManager em;
	 
	@Autowired
	ObjectMapper objectMaper;

	public EntityManager getEntityManager() {
        return em;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

	/* (non-Javadoc)
	 * @see com.prash.spring.dao.PortalUserDAO#findByUsername(java.lang.String)
	 */
	@Override
	public PortalUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.prash.spring.dao.PortalUserDAO#getMaxUserId()
	 */
	@Override
	public Integer getMaxUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PortalUser> findAll() {
		Query query = em.createQuery("Select p from PortalUser p");
		List<PortalUser>  portalUsers = query.getResultList();
		return portalUsers;
	}

	@Override
	public PortalUser save(PortalUser t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PortalUser findByPK(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PortalUser> findAllNative() {
		Query query = em.createNativeQuery("Select * from PORTAL_USER p", PortalUser.class);
		List<PortalUser>  portalUsers = query.getResultList();
		return portalUsers;
	}

}
