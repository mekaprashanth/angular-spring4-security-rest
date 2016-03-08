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
@RequestMapping("/")
public class HomeController {
	
private static int count = 0;
	
	public HomeController() {
		System.out.println("HomeController initialized "+ ++count);
	}
	
	@RequestMapping
	public String home()	{
		return "index";
	}
	
	@RequestMapping("/test")
	public String test()	{
		return "index";
	}

}
