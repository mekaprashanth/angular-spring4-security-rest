package com.prash.spring.config;

import java.util.Map;

import javax.ws.rs.HttpMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {
	final static Logger LOG = LoggerFactory.getLogger(ResourceServerConfiguration.class);


	
	
	@Override
		public void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/oauth/token").permitAll()
					.antMatchers(HttpMethod.GET, "/foo").hasAuthority("FOO_READ")
					// .antMatchers(HttpMethod.GET,
					// "/rest/protected/**").hasAuthority("USER")
					.antMatchers(HttpMethod.GET, "/rest/protected/**").access("hasRole('USER')")
					.antMatchers(HttpMethod.GET, "/rest/protected/**").access("hasRole('ADMIN')")
					.antMatchers(HttpMethod.POST, "/rest/protected/**").access("hasRole('ADMIN')")
					.antMatchers(HttpMethod.DELETE, "/**").access("hasRole('ADMIN')").antMatchers("/welcome")
					.authenticated();
		}


	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		LOG.info("Configuring ResourceServerSecurityConfigurer ");
		resources.resourceId("foo").tokenStore(tokenStore());
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(getJwtAccessTokenConverter());
	}
	
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	@Autowired
	public void setJwtAccessTokenConverter(JwtAccessTokenConverter jwtAccessTokenConverter) {
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
		this.jwtAccessTokenConverter.setAccessTokenConverter(defaultAccessTokenConverter());
	}

	protected JwtAccessTokenConverter getJwtAccessTokenConverter() {
		return jwtAccessTokenConverter;
	}	
	
	public DefaultAccessTokenConverter defaultAccessTokenConverter()	{
		return new PortalUserAccessTokenConverter();
	}
	
	protected static class PortalUserAccessTokenConverter extends DefaultAccessTokenConverter	{
		
		@Override
		public OAuth2Authentication extractAuthentication(Map<String, ?> map)	{
			OAuth2Authentication authentication = super.extractAuthentication(map);
			PortalUserAwareRequest request = new PortalUserAwareRequest(authentication.getOAuth2Request());
			request.setAllianceId((String)map.get("allianceId"));
			request.setUsername((String)map.get("username"));
			return new OAuth2Authentication(request, authentication.getUserAuthentication());
		}
	}
	
	
	public static class PortalUserAwareRequest extends OAuth2Request {

		private static final long serialVersionUID = 1L;
		
		private String username;
	    private String allianceId;
	    
	    public PortalUserAwareRequest(OAuth2Request other) {
	        super(other);
	    }

	    public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}

		public String getAllianceId() {
			return allianceId;
		}

		public void setAllianceId(String allianceId) {
			this.allianceId = allianceId;
		}	    
	}
	
	/*
	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@Bean
    public ResourceServerTokenServices defaultTokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenEnhancer(getJwtAccessTokenConverter());
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setClientDetailsService(clientDetailsService);
        return defaultTokenServices;
    }*/
	
}