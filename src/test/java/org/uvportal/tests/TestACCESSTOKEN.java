package org.uvportal.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.uvportal.helpers.PersonServiceHelper;

import io.restassured.path.json.JsonPath;

public class TestACCESSTOKEN {
	
	private PersonServiceHelper personServiceHelper;
	
	@BeforeClass
	public void init()
	{
		personServiceHelper = new PersonServiceHelper();	
	}

	@Test
	public void testGETAccessToken()
	{
		String token =  personServiceHelper.getAccessToken();
		
	}
	
}
