/**
 * 
 */
package com.prash.spring.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Prashanth_Meka
 *
 */

@Component
public class TestComponent {
	
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    
    public void runJob(String caller)	{
    	log.info("TestComponent Called by "+caller);
    }


}
