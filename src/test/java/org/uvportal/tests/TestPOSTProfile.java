package org.uvportal.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.uvportal.helpers.PersonServiceHelper;

public class TestPOSTProfile {

	private PersonServiceHelper personServiceHelper;

	@BeforeClass
	public void init() {
		personServiceHelper = new PersonServiceHelper();
	}

	@Test
	public void testPOSTProfileRequest() {
		personServiceHelper.addProfile();
	}
	

}
