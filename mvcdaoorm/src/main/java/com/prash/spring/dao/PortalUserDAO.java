/**
 * 
 */
package com.prash.spring.dao;

import java.util.List;

import com.prash.spring.entities.PortalUser;

/**
 * @author Prashanth_Meka
 *
 */

public interface PortalUserDAO extends BaseDAO<PortalUser, Long> {

	public PortalUser findByUsername(String username);

	public Integer getMaxUserId();
	
	public List<PortalUser> findAllNative();
}
