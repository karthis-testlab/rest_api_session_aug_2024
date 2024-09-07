package week3.day1;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.List;

public class ServiceNowIncidentTest extends BaseRequest {
	
	@Test(priority = 0)
	public void shouldUserAbleToCreateAIncident() {		
		sys_id = given()				
		.header("Content-Type", "application/json")
		.pathParam("table_name", "incident")
		.log().all()
		.when()
		.body(new File("src/main/resources/request-payload/create-incident.json"))
		.post()
		.then()		
		.assertThat()
		.statusCode(201)
		.statusLine(containsStringIgnoringCase("created"))
		.body("result.description", equalTo("RAS"))
		.body("result.short_description", containsString("Short Description for RAS"))
		.body("result.caller_id.value", equalTo("413a4d35eb32010045e1a5115206fe6b"))
		.extract()
		.jsonPath()
		.getString("result.sys_id");
		
		System.out.println(sys_id);
	}
	
	@Test(priority = 1)
	public void shouldUserAbleGetAllIncidents() {		
		List<String> list = given()		
		.header("Content-Type", "application/json")
		.pathParam("table_name", "incident")
		.queryParam("sysparm_query", "category=software")
		.log().all()
		.when()		
		.get()
		.then()
		.assertThat()
		.statusCode(200)
		.statusLine(equalTo("HTTP/1.1 200 OK"))
		.extract()
		.jsonPath()
		.getList("result.sys_id");
		
		System.out.println(list);
		
	}
	
	@Test(priority = 2)
	public void shouldUserAbleGetASingleIncident() {
		given()		
		.header("Content-Type", "application/json")
		.pathParam("table_name", "incident")
		.pathParam("sys_id", sys_id)
		.log().all()
		.when()		
		.get("/{sys_id}")
		.then()
		.assertThat()
		.statusCode(200)
		.statusLine(equalTo("HTTP/1.1 200 OK"));
	}
	
	@Test(priority = 3)
	public void shouldUserAbleToUpdateTheExisitingIncident() {
		given()		
		.header("Content-Type", "application/json")
		.pathParam("table_name", "incident")
		.pathParam("sys_id", sys_id)
		.log().all()
		.when()
		.body(new File("src/main/resources/request-payload/update-incident.json"))
		.put("/{sys_id}")
		.then()
		.assertThat()
		.statusCode(200)
		.statusLine(equalTo("HTTP/1.1 200 OK"));
	}
	
	@Test(priority = 4)
	public void shouldUserAbleToDeleteTheExisitingIncident() {
		given()		
		.pathParam("table_name", "incident")
		.pathParam("sys_id", sys_id)
		.log().all()
		.when()
		.delete("/{sys_id}")
		.then()
		.assertThat()
		.statusCode(204)
		.statusLine(containsString("No Content"));
	}

}
