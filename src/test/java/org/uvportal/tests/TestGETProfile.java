package org.uvportal.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.uvportal.helpers.PersonServiceHelper;

import io.restassured.path.json.JsonPath;

public class TestGETProfile {

	private PersonServiceHelper personServiceHelper;

	@BeforeClass
	public void init() {
		personServiceHelper = new PersonServiceHelper();
	}

	@Test
	public void testGETProfileRequest() throws Exception {
		
		personServiceHelper.getAccessToken();
		personServiceHelper.addProfile();
		 personServiceHelper.getProfile();
		 personServiceHelper.updateProfile();
		 personServiceHelper.getProfile();
	}

}
