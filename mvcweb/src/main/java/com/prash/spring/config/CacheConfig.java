package com.prash.spring.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;

import net.sf.ehcache.Ehcache;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public EhCacheFactoryBean ehCacheFactoryBean(){
        EhCacheFactoryBean ehCacheFactory = new EhCacheFactoryBean();
        ehCacheFactory.setCacheManager(cacheManagerFactoryBean().getObject());
        return ehCacheFactory;
    }
    
    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(cacheManagerFactoryBean().getObject());
    }
    
    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactoryBean() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cacheManagerFactoryBean.setCacheManagerName("userCache");
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }
    
    
    @Bean
	public UserCache userCache() {
        EhCacheBasedUserCache userCache = new EhCacheBasedUserCache();
        userCache.setCache((Ehcache)cacheManager().getCache("userCache").getNativeCache());
        return userCache;
    }
}
