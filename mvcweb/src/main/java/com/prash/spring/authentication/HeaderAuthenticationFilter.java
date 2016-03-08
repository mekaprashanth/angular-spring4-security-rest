package com.prash.spring.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

public class HeaderAuthenticationFilter extends GenericFilterBean {
	
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private UserDetailsService userDetailsService;

    private HeaderUtil headerUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

    	if (SecurityContextHolder.getContext().getAuthentication() != null) {
    		logger.debug("SecurityContextHolder is populated with authentication object, as it already contained: '" + SecurityContextHolder.getContext().getAuthentication() + "' "
    				+ "so skipping Header Authentication");
            filterChain.doFilter(request, response);
            return;

    	}

        UserDetails userDetails = loadUserDetails((HttpServletRequest) request);
        if(userDetails != null)	{
        	 logger.debug("username loaded "+ userDetails.getUsername());
        }
       
        SecurityContext contextBeforeChainExecution = createSecurityContext(userDetails);

        try {
            SecurityContextHolder.setContext(contextBeforeChainExecution);
            if (contextBeforeChainExecution.getAuthentication() != null && contextBeforeChainExecution.getAuthentication().isAuthenticated()) {
                String userName = (String) contextBeforeChainExecution.getAuthentication().getPrincipal();
                headerUtil.addHeader((HttpServletResponse) response, userName);
            }
            filterChain.doFilter(request, response);
        }
        finally {
            // Clear the context and free the thread local
            SecurityContextHolder.clearContext();
        }
    }

    private SecurityContext createSecurityContext(UserDetails userDetails) {
        if (userDetails != null) {
            SecurityContextImpl securityContext = new SecurityContextImpl();
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
            securityContext.setAuthentication(authentication);
            return securityContext;
        }
        return SecurityContextHolder.createEmptyContext();
    }

    private UserDetails loadUserDetails(HttpServletRequest request) {
        String userName = headerUtil.getUserName(request);

        return userName != null
                ? userDetailsService.loadUserByUsername(userName)
                : null;
    }

    public void userDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public void headerUtil(HeaderUtil headerUtil) {
        this.headerUtil = headerUtil;
    }
}
