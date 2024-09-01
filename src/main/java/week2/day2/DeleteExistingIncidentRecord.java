package week2.day2;

import io.restassured.RestAssured;

public class DeleteExistingIncidentRecord {

	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/api/now/table/incident/f1d6bc6283145210695bc7b6feaad36a";
		RestAssured.given()
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .log()
		           .all()
		           .when()
		           .delete(url)
		           .then()
		           .log()
		           .all();

	}

}
