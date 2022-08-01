package org.uvportal.helpers;

import static io.restassured.RestAssured.given;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.uvportal.constants.EndPoints;
import org.uvportal.model.PostalAddress;
import org.uvportal.model.Profile;
import org.uvportal.model.ResidentialAddress;
import org.uvportal.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class PersonServiceHelper {

	public static String token;
	public Logger log;

	private static final String Base_URL = ConfigManager.getInstance().getString("base_url");

	public PersonServiceHelper() {
		RestAssured.baseURI = Base_URL;
		RestAssured.useRelaxedHTTPSValidation();
		log = Logger.getLogger("RestAPI");
		PropertyConfigurator.configure("C:\\Users\\pooja.dangve\\eclipse-workspace\\apidemo\\resources\\log4j.properties");
		log.setLevel(Level.ALL);

	}

	public String getAccessToken() {
		log.info("---- GET ACCESS TOken-------");
		SessionFilter session = new SessionFilter();

		String response = given().log().all().filter(session).when().get(EndPoints.GET_ACCESS_TOKEN).then().log().all()
				.extract().response().asString();
		JsonPath js = new JsonPath(response);
		token = js.getString("AccessToken");
		System.out.println("Access Token is : " + token);
		return response;
	}

	public String addProfile() {
		
		log.info("------POSTRequest------");

		// PersonServiceHelper ps = new PersonServiceHelper();

		// System.out.println("Token : " +ps.getAccessToken());

		Profile profile = new Profile();

		profile.setSAPNumber("1222");
		profile.setFirstName("Raj");
		profile.setSurname("Sharma");
		profile.setIDNumber("0846043987");
		profile.setIsRetired(false);
		profile.setYearsOfService(0);
		profile.setRetirementDate("null");
		profile.setEmailAddress("raj@gmail.com");
		profile.setAlternativeEmailAddress("sharma@gamil.com");
		profile.setContactNumber("8888888888");
		profile.setAlternativeContactNumber("9999999999");
		profile.setPreferedCommunicationMethod(1);

		ResidentialAddress rs = new ResidentialAddress();

		rs.setAddressID(0);
		rs.setIDNumber("null");
		rs.setSAPNumber("1222");
		rs.setAddressLine1("aaaaa");
		rs.setAddressLine2("bbbbbb");
		rs.setSuburb("cccccc");
		rs.setCity("ddddd");
		rs.setCountry("eeee");
		rs.setPostalCode("11111");
		rs.setAddressTypeID(1);
		profile.setResidentialAddress(rs);

		PostalAddress pa = new PostalAddress();

		pa.setAddressID(0);
		pa.setIDNumber("null");
		pa.setSAPNumber("1222");
		pa.setAddressLine1("aaaaaa");
		pa.setAddressLine2("bbbbbb");
		pa.setSuburb("cccccc");
		pa.setCity("dddddd");
		pa.setCountry("eeeee");
		pa.setPostalCode("22222");
		pa.setAddressTypeID(2);
		profile.setPostalAddress(pa);

		/*
		 * Response response = RestAssured.given().log().all().header(
		 * "Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJUZXN0LmNvbSIsImF1ZCI6IlRlc3QiLCJleHAiOjE2NTgyOTg0MjcsIm5iZiI6MTY1ODIxMjAyN30.hav5KU2li5DbJT5KLquubikhX8Jq8TUBth2ZUqKApfY"
		 * ).contentType(ContentType.JSON).body(profile).when()
		 * .post(EndPoints.POST_PROFILE).andReturn(); return response;
		 */

		String response = RestAssured.given().log().all().header("Authorization", "Bearer " + token)
				.contentType(ContentType.JSON).body(profile).when().post(EndPoints.POST_PROFILE).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		System.out.println("token value is : " + token);
		return response;

	}

	public String getProfile() {
		
		log.info("-----GET REquest-------");
		// PersonServiceHelper ps = new PersonServiceHelper();
		// ps.getAccessToken();

		/*
		 * System.out.println("token value : " +token); String response =
		 * RestAssured.given().log().all().queryParam("SAPNo", "113").header(
		 * "Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJUZXN0LmNvbSIsImF1ZCI6IlRlc3QiLCJleHAiOjE2NTgyOTg0MjcsIm5iZiI6MTY1ODIxMjAyN30.hav5KU2li5DbJT5KLquubikhX8Jq8TUBth2ZUqKApfY"
		 * ).when().get(EndPoints.GET_PROFILE)
		 * .then().log().all().assertThat().statusCode(200).extract().response().
		 * asString(); return response;
		 */
		System.out.println("token value1 :" + token);

		String response = RestAssured.given().log().all().queryParam("SAPNo", "1222")
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_PROFILE).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();

		// System.out.println("token value2 :" +token);
		return response;

	}
	
	public String updateProfile()
	{
		
		log.info("--------UPDATE REQUEST------- ");
		Profile profile = new Profile();

		profile.setSAPNumber("1222");
		profile.setFirstName("priti");
		profile.setSurname("varma");
		profile.setIDNumber("0846043987");
		profile.setIsRetired(false);
		profile.setYearsOfService(0);
		profile.setRetirementDate("null");
		profile.setEmailAddress("priti@gmail.com");
		profile.setAlternativeEmailAddress("varma@gamil.com");
		profile.setContactNumber("555555555");
		profile.setAlternativeContactNumber("444444444");
		profile.setPreferedCommunicationMethod(1);

		ResidentialAddress rs = new ResidentialAddress();

		rs.setAddressID(0);
		rs.setIDNumber("null");
		rs.setSAPNumber("1221");
		rs.setAddressLine1("ABC CHOWK");
		rs.setAddressLine2("Laxmi Road");
		rs.setSuburb("pune camp");
		rs.setCity("Pune");
		rs.setCountry("India");
		rs.setPostalCode("411017");
		rs.setAddressTypeID(1);
		profile.setResidentialAddress(rs);

		PostalAddress pa = new PostalAddress();

		pa.setAddressID(0);
		pa.setIDNumber("null");
		pa.setSAPNumber("1221");
		pa.setAddressLine1("ABC CHOWK1");
		pa.setAddressLine2("Laxmi chowk1");
		pa.setSuburb("Pune camp1");
		pa.setCity("pune2");
		pa.setCountry("India2");
		pa.setPostalCode("22222");
		pa.setAddressTypeID(2);
		profile.setPostalAddress(pa);

		/*
		 * Response response = RestAssured.given().log().all().header(
		 * "Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJUZXN0LmNvbSIsImF1ZCI6IlRlc3QiLCJleHAiOjE2NTgyOTg0MjcsIm5iZiI6MTY1ODIxMjAyN30.hav5KU2li5DbJT5KLquubikhX8Jq8TUBth2ZUqKApfY"
		 * ).contentType(ContentType.JSON).body(profile).when()
		 * .post(EndPoints.POST_PROFILE).andReturn(); return response;
		 */

		String response = RestAssured.given().log().all().header("Authorization", "Bearer " + token)
				.contentType(ContentType.JSON).body(profile).when().post(EndPoints.UPDATE_PROFILE).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		System.out.println("token value is : " + token);
		return response;
	}
	
	public String getVehicle()
	{
		String response = RestAssured.given().log().all().queryParam("VINNumber", "05/08/199X")
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_VEHICLE).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		return response;

	}
	
	public String getVehicleGETALL()
	{
		String response = RestAssured.given().log().all()
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_VEHICLE_GETALL).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		return response;
	}
	
	public String getVehicleGETAllForModel()
	{
		String response = RestAssured.given().log().all().queryParam("ModelCode", "1J12J4")
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_VEHICLE_GETALLFORMODEL).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		return response;
	}
	
	public String getVehicleGetEmployeeLeaseVehicle()
	{
		String response = RestAssured.given().log().all().queryParam("SAPNo", "CY 16545")
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_VEHICLE_GETEMPLOYEELEASEVEHICLE).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		return response;
	}

	public String getModel()
	{
		String response = RestAssured.given().log().all().queryParam("ModelCode", "1632L1")
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_MODEL).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		return response;
	}
	
	public String getModelGetAll()
	{
		String response = RestAssured.given().log().all()
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_MODEL_GETALL).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		return response;
	}
	
	public String getModelOptionGetAllForModel()
	{
		String response = RestAssured.given().log().all().queryParam("ModelCode", "1222D1")
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_MODELOPTION_GETALLFORMODEL).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		return response;
	}
	
	public String getModelColoursForModel()
	{
		String response = RestAssured.given().log().all().queryParam("ModelCode", "9V41F4")
				.header("Authorization", "Bearer " + token).when().get(EndPoints.GET_MODEL_COLOURSFORMODEL).then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		return response;
	}

}
