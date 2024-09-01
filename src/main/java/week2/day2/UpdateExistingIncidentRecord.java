package week2.day2;

import io.restassured.RestAssured;

public class UpdateExistingIncidentRecord {

	public static void main(String[] args) {
		String updatePaylod = "{\r\n"
				+ "    \"short_description\": \"My Offic PC unable to reboot.\",\r\n"
				+ "    \"description\": \"DELL PC\"\r\n"
				+ "}";
		String url = "https://dev262949.service-now.com/api/now/table/incident/f1d6bc6283145210695bc7b6feaad36a";
		RestAssured.given()
        .auth()
        .basic("admin", "vW0eDfd+A0V-")
        .header("Content-Type", "application/json")
        .log()
        .all()
        .when()
        .body(updatePaylod)
        .put(url)
        .then()
        .log()        
        .all();
	}

}
