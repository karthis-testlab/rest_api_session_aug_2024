package week3.day1;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;

import org.testng.annotations.BeforeMethod;

public class BaseRequest {
	
	protected String sys_id;
	
	@BeforeMethod
	public void beforeMethod() {		
		baseURI =  "https://dev262949.service-now.com";
		basePath = "/api/now/table/{table_name}";
		authentication = basic("admin", "vW0eDfd+A0V-");
	}

}
