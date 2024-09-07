package week3.day1;

import java.io.File;

import io.restassured.RestAssured;

public class CreateNewIncident {

	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/api/now/table/{table_name}";		
		RestAssured.given()
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .header("Content-Type", "application/json")
		           .pathParam("table_name", "incident")
		           .log()
		           .all()
		           .when()
		           .body(new File("src/main/resources/request-payload/create-incident.json"))
		           .post(url)
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(201);

	}

}
