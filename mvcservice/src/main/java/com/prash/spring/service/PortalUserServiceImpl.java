/**
 * 
 */
package com.prash.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prash.spring.dao.PortalUserDAO;
import com.prash.spring.entities.PortalFunction;
import com.prash.spring.entities.PortalRole;
import com.prash.spring.entities.PortalRoleFunction;
import com.prash.spring.entities.PortalUser;
import com.prash.spring.entities.PortalUserFunction;
import com.prash.spring.model.PortalUserDetails;
import com.prash.spring.repositories.PortalFunctionRepository;
import com.prash.spring.repositories.PortalRoleFunctionRepository;
import com.prash.spring.repositories.PortalRoleRepository;
import com.prash.spring.repositories.PortalUserFunctionRepository;
import com.prash.spring.repositories.PortalUserRepository;

/**
 * @author Prashanth_Meka
 *
 */

@Service
public class PortalUserServiceImpl implements PortalUserService {

	@Autowired
	PortalUserRepository portalUserRepository;

	@Autowired
	PortalUserFunctionRepository portalUserFunctionRepository;

	@Autowired
	PortalRoleRepository portalRoleRepository;

	@Autowired
	PortalFunctionRepository portalFunctionRepository;

	@Autowired
	PortalRoleFunctionRepository portalRoleFunctionRepository;
	
	@Autowired
	PortalUserDAO portalUserDAO;

	@Override
	public PortalUser getUser(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		return portalUser;
	}

	@Override
	public void save(PortalUser portalUser) {
		List<PortalRoleFunction> roleFunctions = portalUser.getPortalRoleFunctions();
		for (PortalRoleFunction roleFunction : roleFunctions) {
			String roleName = roleFunction.getPortalRole().getName();
			String functionName = roleFunction.getPortalFunction().getName();
			List<PortalRole> portalRoles = portalRoleRepository.findByName(roleName);
			PortalFunction portalFunction = portalFunctionRepository.findByName(functionName);
			for (PortalRole portalRole : portalRoles) {
				roleFunction.setPortalFunction(portalFunction);
				roleFunction.setPortalRole(portalRole);

			}
		}
		portalUserRepository.save(portalUser);
	}

	@Override
	public List<PortalUser> list() {
//		return portalUserRepository.findAll();
		return portalUserDAO.findAllNative();
	}

	@Override
	public Integer getMaxUserId() {
		return portalUserRepository.getMaxUserId();
	}

	@Override
	public void updateResetLoginAttemptsAndLoginTime(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		portalUser.setLoginCount(0);
		portalUser.setLastLoginDate(new Date());
		portalUser.setBlockCode(null);
		portalUserRepository.save(portalUser);
	}

	@Override
	public void updateIncrementLoginAttempts(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		portalUser.setLoginCount(portalUser.getLoginCount() + 1);
		portalUserRepository.save(portalUser);
	}

	@Override
	public void updateLoginAttemptsAndBlockStatusTemporary(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		portalUser.setLoginCount(portalUser.getLoginCount() + 1);
		portalUser.setBlockCode(0L);
		portalUser.setLastLoginDate(new Date());
		portalUserRepository.save(portalUser);
	}

	@Override
	public void updateLoginAttemptsAndBlockStatusPermanent(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		portalUser.setLoginCount(portalUser.getLoginCount() + 1);
		portalUser.setBlockCode(1L);
		portalUserRepository.save(portalUser);
	}

	@Transactional
	@Override
	public void savePortalUser(PortalUserDetails portalUserDetails) {
		// List<PortalFunction> portalFunctions =
		// portalFunctionRepository.findAll();

		List<PortalRoleFunction> portalRoleFunctions = new ArrayList<PortalRoleFunction>();
		/* for (PortalFunction portalFunction : portalFunctions) { */
		for (String authority : portalUserDetails.getRoles()) {
			List<PortalRole> portalRoles = portalRoleRepository.findByName(authority);
			for (PortalRole portalRole : portalRoles) {
				portalRoleFunctions.addAll(portalRoleFunctionRepository.findByPortalRole(portalRole));
				/*
				 * portalRoleFunction.setPortalRole(portalRole);
				 * portalRoleFunction.setPortalFunction(portalFunction);
				 * portalRoleFunction.setCanCreate(1);
				 * portalRoleFunction.setCanRead(1);
				 * portalRoleFunction.setCanUpdate(1);
				 * portalRoleFunctions.add(portalRoleFunction);
				 */
			}
		}

		PortalUser portalUser = new PortalUser(portalUserDetails.getUsername(), portalUserDetails.getPassword(),
				portalUserDetails.getPasscode(), portalUserDetails.getFirstName(), portalUserDetails.getLastName(),
				portalUserDetails.getMerchantId(), portalUserDetails.getEmailAddress(),
				portalUserDetails.getPhoneNumber(), portalUserDetails.getMobileNumber(),
				portalUserDetails.getIsActive(), portalUserDetails.getBlockCode(), portalUserDetails.getCreationDate(),
				portalUserDetails.getActivationDate(), portalUserDetails.getLastLoginDate(),
				portalUserDetails.getAllianceId(), portalUserDetails.getToken(), portalUserDetails.getIpAddress(),
				portalUserDetails.getLoginCount(), portalUserDetails.getAccountExpirationDate(),
				portalUserDetails.getAccountStatus(), portalUserDetails.getPasswordExpirationDate(),
				portalRoleFunctions);
		System.out.println(portalUser);
		portalUserRepository.save(portalUser);
		for (PortalUser portalUser1 : portalUserRepository.findAll()) {
			System.out.println(portalUser1);
			System.out.println();
		}

		for (PortalRoleFunction prf : portalRoleFunctionRepository.findAll()) {
			System.out.println(prf);
			System.out.println();
		}

		for (PortalUserFunction puf : portalUserFunctionRepository.findAll()) {
			System.out.println(puf);
			System.out.println();
		}
	}

}
