package week3.day1;

import java.io.File;

import io.restassured.RestAssured;

public class UpdateExsitingIncident {

	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/api/now/table/incident/94e233e083289e10695bc7b6feaad327";		
		RestAssured.given()
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .header("Content-Type", "application/json")
		           .log()
		           .all()
		           .when()
		           .body(new File("src/main/resources/request-payload/update-incident.json"))
		           .put(url)
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(200);
	}

}
