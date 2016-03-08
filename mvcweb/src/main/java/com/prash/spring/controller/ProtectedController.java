/**
 * 
 */
package com.prash.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Prashanth_Meka
 *
 */
@Controller
@RequestMapping("/protected")
public class ProtectedController {
	
private static int count = 0;
	
	public ProtectedController() {
		System.out.println("ProtectedController initialized "+ ++count);
	}
	
	@RequestMapping("/page1")
	public String home()	{
		return "page1";
	}
	
	@RequestMapping("/page2")
	public String test()	{
		return "page2";
	}

}
