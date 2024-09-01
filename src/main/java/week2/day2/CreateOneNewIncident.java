package week2.day2;

import io.restassured.RestAssured;

public class CreateOneNewIncident {
	
	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/api/now/table/incident";
		String requestPayload = "{\r\n"
				+ "    \"caller_id\": \"413a4d35eb32010045e1a5115206fe6b\",\r\n"
				+ "    \"short_description\": \"Short Description for RAS\",\r\n"
				+ "    \"description\": \"RAS\"\r\n"
				+ "}";
		RestAssured.given()
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .header("Content-Type", "application/json")
		           .log()
		           .all()
		           .when()
		           .body(requestPayload)
		           .post(url)
		           .then()
		           .log()
		           .all();
        
	}

}