/**
 * 
 */
package com.prash.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prash.spring.model.PortalMessage;
import com.prash.spring.model.UserValue;

/**
 * @author Prashanth_Meka
 *
 */
@RestController
@RequestMapping("/")
public class TestRestController {
	
	private static int count = 0;
	
	public TestRestController() {
		System.out.println("RestController initialized "+ ++count);
	}

	@RequestMapping(value="/messages/{test}",produces="application/json")
	
	public PortalMessage getMessage(@PathVariable("test") String param)	{
		System.out.println("Pathvariable "+ param);
		PortalMessage m = new PortalMessage(1, param);
		UserValue u = new UserValue("Prashanth","Meka");
		m.setUser(u);
		return m;
	}

}
