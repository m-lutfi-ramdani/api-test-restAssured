package Library;

import Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.junit.Assert;


public class ApiCall {
	private Response response = null;
	
	public void setBaseURI() {
        RestAssured.baseURI = Utils.env("HOST");
	}
	
	public void sendRequest(String method, String path) {
		switch (method.toUpperCase()) {
		case "GET":
			response = given()
					.contentType("application/json")
					.when()
		    		.get(path);
			break;
		case "POST":
			response = given()
					.contentType("application/json")
		    		.when()
		    		.post(path);
			break;
		default:
			System.out.println("Unexpected value : " + method.toUpperCase());
		}
		
		response.then().extract().response();
	}
	
	public void sendRequestWithBody(String method, String path, String body) {        
		switch (method.toUpperCase()) {
		case "GET":
			response = given()
					.contentType("application/json")
					.queryParam("params", body)
					.when()
		    		.get(path);
			break;
		case "POST":
			response = given()
					.contentType("application/json")
		    		.body(body)
		    		.when()
		    		.post(path);
			break;
		default:
			System.out.println("Unexpected value : " + method.toUpperCase());
		}
		
		response.then().extract().response();
	}
	
	public void assertDataEquals(String path, Object expected) {
		Assert.assertEquals(expected, response.body().jsonPath().getInt(path));
	}
	
	public void isResponseCode(int expected) {
		Assert.assertEquals(expected, response.getStatusCode());
	}
	
	public void isResponseMessageError(String expected) {
		Assert.assertEquals(expected, response.body().jsonPath().getString("error"));
	}
}
