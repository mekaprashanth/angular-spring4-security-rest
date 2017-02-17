package com.prash.spring.config;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.prash.spring.model.PortalUserDetails;

@Configuration
@EnableAuthorizationServer
@Order(3)
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsServiceWithoutCache;
	

	@Autowired
	private AuthenticationManager authenticationManager;

	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
		.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()")
		 .allowFormAuthenticationForClients()
				;
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("web_app").scopes("write", "foo", "read")
//		.autoApprove(true)
//		.redirectUris("http://localhost:8081/mvcsample/index.html")
				.authorities("FOO_READ", "FOO_WRITE")
				
				.authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		.prefix("/rest")
		.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer())
		.authenticationManager(this.authenticationManager)
		.userDetailsService(userDetailsServiceWithoutCache)
		.pathMapping("/oauth/confirm_access", "/rest/oauth/confirm_access")
		
		;
	}
	

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtTokenEnhancer());
	}

	@Bean
	protected JwtAccessTokenConverter jwtTokenEnhancer() {
		JwtAccessTokenConverter converter = new CustomTokenEnhancer();
		converter.setSigningKey("123");
		return converter;
	}
	
	protected static class CustomTokenEnhancer extends JwtAccessTokenConverter {

        @Override
        public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                OAuth2Authentication authentication) {

            PortalUserDetails user = (PortalUserDetails) authentication.getPrincipal();
            Map<String, Object> info = new LinkedHashMap<String, Object>(
                    accessToken.getAdditionalInformation());

            info.put("username", user.getUsername());
            info.put("alliaceId", user.getFirstName());

            DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
            customAccessToken.setAdditionalInformation(info);
            return super.enhance(customAccessToken, authentication);

        }
	}
	
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(Base64.getEncoder().encode("web_app:".getBytes("UTF-8")).toString());
	}
}