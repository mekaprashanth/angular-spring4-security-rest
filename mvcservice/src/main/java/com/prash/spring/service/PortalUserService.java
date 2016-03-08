/**
 * 
 */
package com.prash.spring.service;

import java.util.List;

import com.prash.spring.entities.PortalUser;
import com.prash.spring.model.PortalUserDetails;

/**
 * @author Prashanth_Meka
 *
 */
public interface PortalUserService {
	
	public PortalUser getUser(String username);
	
	public void save(PortalUser portalUser);
	
	public List<PortalUser> list();
	
	public Integer getMaxUserId();
	
	public void updateResetLoginAttemptsAndLoginTime(String username);
	
	public void updateIncrementLoginAttempts(String username);
	
	public void updateLoginAttemptsAndBlockStatusTemporary(String username);
	
	public void updateLoginAttemptsAndBlockStatusPermanent(String username);

	public void savePortalUser(PortalUserDetails portalUserDetails);
	
	
	
	
	


}
