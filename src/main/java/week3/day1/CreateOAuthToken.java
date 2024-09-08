package week3.day1;

import static io.restassured.RestAssured.*;

import week3.day2.Config;

public class CreateOAuthToken {

	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/oauth_token.do";
		
		String access_token = given()
		.header("Content-Type", "application/x-www-form-urlencoded")
		.formParam("grant_type", "password")
		.formParam("client_id", Config.getClientId())
		.formParam("client_secret", Config.getClientSecret())
		.formParam("username", Config.getUserName())
		.formParam("password", Config.getPassword())
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