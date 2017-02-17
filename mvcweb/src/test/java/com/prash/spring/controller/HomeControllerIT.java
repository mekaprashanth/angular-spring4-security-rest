/**
 * 
 */
package com.prash.spring.controller;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.prash.spring.test.base.FunctionalTest;


/**
 * @author Prashanth_Meka
 *
 */
public class HomeControllerIT extends FunctionalTest {

	@Test
	public void homeTest()	{
		given().when().get("/").then().statusCode(200);
	}
	
	@Test
	public void indexTest() throws Exception	{
		given().when().get("/test").then().statusCode(401);
	}

}
