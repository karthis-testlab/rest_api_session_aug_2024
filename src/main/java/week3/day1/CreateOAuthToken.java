package week3.day1;

import static io.restassured.RestAssured.*;

public class CreateOAuthToken {

	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/oauth_token.do";
		
		String access_token = given()
		.header("Content-Type", "application/x-www-form-urlencoded")
		.formParam("grant_type", "password")
		.formParam("client_id", "c91a806ab7981210dcb0a51cb42164af")
		.formParam("client_secret", "~1E)cj#]`+")
		.formParam("username", "admin")
		.formParam("password", "vW0eDfd+A0V-")
		.when()
		.post(url)
		.then()
		.log()
		.all()
		.extract()
		.jsonPath()
		.getString("access_token");
		
		System.out.println("OAuth access token: "+access_token);		

	}

}