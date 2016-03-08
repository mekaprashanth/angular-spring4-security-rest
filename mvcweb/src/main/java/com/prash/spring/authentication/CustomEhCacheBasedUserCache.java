/**
 * 
 */
package com.prash.spring.authentication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Prashanth_Meka
 *
 */
public class CustomEhCacheBasedUserCache implements UserCache {

	private final Log logger = LogFactory.getLog(getClass());

	private final Cache cache;

	public CustomEhCacheBasedUserCache(Cache cache) {
		this.cache = cache;
	}

	@Override
	public UserDetails getUserFromCache(String paramString) {
		ValueWrapper vw = cache.get(paramString);
		if(logger.isDebugEnabled())	{
			logger.debug("Cache hit: " + (vw != null) + "; username: " + paramString);
		}
		if(vw == null)	{
			return null;
		}
		return (UserDetails) vw.get();
	}

	@Override
	public void putUserInCache(final UserDetails paramUserDetails) {
		ValueWrapper vw = new ValueWrapper()	{
			@Override
			public Object get() {
				return paramUserDetails;
			}
		};
		if(logger.isDebugEnabled())	{
			logger.debug("Cache put: " + paramUserDetails.getUsername());
		}
		cache.put(paramUserDetails.getUsername(), vw);

	}

	@Override
	public void removeUserFromCache(String paramString) {
		if(logger.isDebugEnabled())	{
			logger.debug("Cache remove: " + paramString);
		}
		cache.evict(paramString);
	}
	
	public void removeUserFromCache(UserDetails paramUserDetails) {
		if(logger.isDebugEnabled())	{
			logger.debug("Cache remove: " + paramUserDetails.getUsername());
		}
		cache.evict(paramUserDetails.getUsername());
	}
}
