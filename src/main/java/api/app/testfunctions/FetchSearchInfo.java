package api.app.testfunctions;

import java.util.Properties;

import org.junit.Assert;

import api.app.commons.AppUtils;
import api.app.commons.GenericUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FetchSearchInfo {
	
	public static Properties property = GenericUtils.AppFileReader("src/main/resources/data/api/App.properties");
	public static AppUtils data;
	
	public static void getDataSearchDetails() {
		RestAssured.baseURI = property.getProperty("Booking_URL");
		RequestSpecification httpRequest = RestAssured.given();
		Response res = httpRequest.request(Method.GET, "");
		data = new AppUtils(res.getStatusCode(), res.getBody().asString());
		System.out.println("Status detail and code : "+data.getStatusCode());
		System.out.println("Response details : "+data.getResponseData());
	}
	
	public static void verifyStatus(int code) {
		Assert.assertTrue("Verify status code", data.getStatusCode()==code);		
	}
}
