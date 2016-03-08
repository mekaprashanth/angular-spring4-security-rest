package com.prash.spring.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler implements LogoutHandler {

	protected final Log logger = LogFactory.getLog(getClass());

	UserCache userCache = new NullUserCache();

	public UserCache getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// if at all there is session
		try {
			request.getSession().invalidate();
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			logger.info("logging out "+ authentication);
			if (authentication == null) {
				out.print("Not an Authenticated request to logout");
				
			}else	{
				userCache.removeUserFromCache(authentication.getName());
				out.print("Successfully Logged out User " + authentication.getName());
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Error while logout", e);
			throw new RuntimeException(e);
		}

	}
}