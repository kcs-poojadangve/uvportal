package org.uvportal.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.uvportal.helpers.PersonServiceHelper;

public class TestVehicleServices {
	
	private PersonServiceHelper personServiceHelper;
	
	@BeforeClass
	public void init()
	{
		personServiceHelper = new PersonServiceHelper();
	}
	
	@Test
	public void testVehicleServices()
	{
		personServiceHelper.getAccessToken();
		personServiceHelper.getVehicle();
		personServiceHelper.getVehicleGETALL();
		personServiceHelper.getVehicleGETAllForModel();
		personServiceHelper.getVehicleGetEmployeeLeaseVehicle();
		personServiceHelper.getModel();
		personServiceHelper.getModelGetAll();
		personServiceHelper.getModelOptionGetAllForModel();
		personServiceHelper.getModelColoursForModel();
		
	}

}
