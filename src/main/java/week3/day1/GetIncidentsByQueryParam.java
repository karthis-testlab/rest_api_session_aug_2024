package week3.day1;

import io.restassured.RestAssured;

public class GetIncidentsByQueryParam {

	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/api/now/table/{table_name}";
		RestAssured.given()
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .pathParam("table_name", "incident")
		           .queryParam("sysparm_fields", "number,sys_id,description,short_description,category")
		           .queryParam("sysparm_limit", 2)
		           .queryParam("sysparm_query", "short_descriptionENDSWITHRAS^description=RAS")
		           .log()
		           .all()
		           .when()
		           .get(url)
		           .then()
		           .log()
		           .all();

	}

}
