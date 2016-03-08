/**
 * 
 */
package com.prash.spring.authentication;

import java.util.Date;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.prash.spring.model.PortalUserDetails;
import com.prash.spring.service.PortalUserService;
import com.prash.spring.service.exception.AccountInactiveException;
import com.prash.spring.service.exception.AccountPermanentlyBlockedException;
import com.prash.spring.service.exception.AccountTemporarilyBlockedException;
import com.prash.spring.service.util.CommonUtil;

/**
 * @author Prashanth_Meka
 *
 */

public class CustomDAOAuthenticationProviderWrapper extends DaoAuthenticationProvider {
	
	PortalUserService portalUserService;
		
	public void setPortalUserService(PortalUserService portalUserService)	{
		this.portalUserService = portalUserService;
	}
	
	public void setUserDetailsService(UserDetailsService userDetailsService)	{
		super.setUserDetailsService(userDetailsService);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Authentication authenticate(Authentication authentication) 
          throws AuthenticationException {
		PortalUserDetails portalUserDetails = null;
		Throwable cause = null;
		try	{
			UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)authentication;
			String username = auth.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();
			String presentedPassword = auth.getCredentials().toString();
			portalUserDetails = (PortalUserDetails)getUserDetailsService().loadUserByUsername(username);	
			if(!portalUserDetails.getAccountStatus().equals("ACTIVE"))	{
				cause =  new AccountInactiveException("User account is INACTIVE");
			}else if(!portalUserDetails.isAccountNonExpired())	{
				cause = new AccountExpiredException("User account has Expired");
			}else if(portalUserDetails.getBlockCode() == null)	{
				if(getPasswordEncoder().isPasswordValid(portalUserDetails.getPassword(), presentedPassword, null))	{
					portalUserService.updateResetLoginAttemptsAndLoginTime(username);
				}else	{
					if((portalUserDetails.getLoginCount()+1) == 3)	{
						portalUserService.updateLoginAttemptsAndBlockStatusTemporary(username);
						cause = new AccountTemporarilyBlockedException("User account is temporariliy Blocked");
					}else	{
						portalUserService.updateIncrementLoginAttempts(username);
						cause = new BadCredentialsException("Bad Credentials");						
					}
				}
			}else	{
				if(portalUserDetails.getBlockCode() == 0L)	{
					if(CommonUtil.hasXSecondsPassed(portalUserDetails.getLastLoginDate(), 10))	{
						if(getPasswordEncoder().isPasswordValid(portalUserDetails.getPassword(), presentedPassword, null))	{
							portalUserService.updateResetLoginAttemptsAndLoginTime(username);
						}else	{
							if((portalUserDetails.getLoginCount()+1) == 5)	{
								portalUserService.updateIncrementLoginAttempts(username);
								cause = new AccountTemporarilyBlockedException("Alert User of last attempt");
							}else if((portalUserDetails.getLoginCount()+1) == 6)	{
								portalUserService.updateLoginAttemptsAndBlockStatusPermanent(username);
								cause = new AccountTemporarilyBlockedException("User account is temporariliy Blocked");								
							}else	{
								portalUserService.updateIncrementLoginAttempts(username);
								cause = new AccountTemporarilyBlockedException("User account is temporariliy Blocked");								
							}
						}
					}else	{
						cause = new AccountTemporarilyBlockedException("User account is temporariliy Blocked");
					}
				}else	{
					cause = new AccountPermanentlyBlockedException("User account is permanently Blocked");
				}
			}
			
		}catch(Exception e)	{
			cause = e;
		}
		if(cause != null)	{
			logger.error(cause.getMessage(), cause);
			throw new InsufficientAuthenticationException(cause.getMessage(), cause);
		}
		
		return createSuccessAuthentication(portalUserDetails, authentication, portalUserDetails);
	}

}
