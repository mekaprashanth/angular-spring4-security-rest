package com.prash.spring.authentication;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.stereotype.Service;

import com.prash.spring.entities.Employee;
import com.prash.spring.entities.PortalRoleFunction;
import com.prash.spring.entities.PortalUser;
import com.prash.spring.entities.Role;
import com.prash.spring.model.PortalUserDetails;
import com.prash.spring.service.EmployeeService;
import com.prash.spring.service.PortalUserService;

@Service("customUserDetailsService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomUserDetailService implements UserDetailsService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	PortalUserService portalUserService;

	UserCache userCache = new NullUserCache();

	public UserCache getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	public UserDetails loadUserByUsernameOld(final String username) throws UsernameNotFoundException {

		logger.info("loadUserByUsername username=" + username);
		Thread t1 = Thread.currentThread();
		logger.debug(t1.getStackTrace().toString());
		

		UserDetails user = userCache.getUserFromCache(username);
		
		if (user == null) {
			Employee employee = employeeService.getUser(username);
			if (employee == null) {
				throw new UsernameNotFoundException(username + " not found");
			}
			logger.debug(employee.toString());
			List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
			for (Role role : employee.getRole()) {
				auths.add(new SimpleGrantedAuthority(role.getRole()));
			}
			user = new User(employee.getUsername(),
					employee.getPassword(), true, true, true, true, auths);
			userCache.putUserInCache(user);
		}

		return user;

	}
	
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		logger.info("loadUserByUsername username=" + username);

		UserDetails user = userCache.getUserFromCache(username);
		
		if (user == null) {
			PortalUser portalUser = portalUserService.getUser(username);
			if (portalUser == null) {
				throw new UsernameNotFoundException(username + " not found");
			}
			logger.debug(portalUser.toString());
			Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
			for(PortalRoleFunction roleFunctions : portalUser.getPortalRoleFunctions())	{
				auths.add(new SimpleGrantedAuthority(roleFunctions.getPortalRole().getName()));
			}
			user = new PortalUserDetails(portalUser.getPassword(), portalUser.getUsername(),auths,true,
					true, true, portalUser.getAccountStatus().equals("ACTIVE"),portalUser.getPasscode(),portalUser.getFirstName(),
					portalUser.getLastName(),portalUser.getMerchantId(), portalUser.getEmailAddress(), portalUser.getPhoneNumber(), portalUser.getMobileNumber(),
					portalUser.getIsActive(), portalUser.getBlockCode(),portalUser.getCreationDate(), portalUser.getActivationDate(), portalUser.getLastLoginDate(),
					portalUser.getAllianceId(), portalUser.getToken(), portalUser.getIpAddress(),portalUser.getLoginCount(), portalUser.getAccountExpirationDate(), 
					portalUser.getAccountStatus(), portalUser.getPasswordExpirationDate());
			userCache.putUserInCache(user);
		}

		return user;

	}

}