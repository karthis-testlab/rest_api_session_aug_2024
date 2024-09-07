package week3.day1;

import io.restassured.RestAssured;

public class GetASingleIncidetByPathParam {

	public static void main(String[] args) {
		String url = "https://dev262949.service-now.com/api/now/table/{table_name}/{sys_id}";
		RestAssured.given()
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .pathParam("table_name", "incident")
		           .pathParam("sys_id", "0dd49481839cd250695bc7b6feaad3d3")
		           .log()
		           .all()
		           .when()
		           .get(url)
		           .then()
		           .log()
		           .all();

	}

}
