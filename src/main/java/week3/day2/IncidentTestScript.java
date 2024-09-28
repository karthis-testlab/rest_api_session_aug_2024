package week3.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class IncidentTestScript {
	
	@DataProvider
	public String[][] getData() {
		return DataHandler.readCsvData("incidents");
	}
	
	@Test(dataProvider = "getData")
	public void shouldUserAbleToCreateNewIncident(String shortDescription, String description, String  urgency, String state, String callerId) {
		CreateIncidentModal payload = new CreateIncidentModal();
		payload.setCaller_id(shortDescription);
		payload.setShort_description(description);
		payload.setDescription(urgency);
		payload.setUrgency(state);
		payload.setState(callerId);
		
		String url = "https://dev262949.service-now.com/api/now/table/{table_name}";		
		RestAssured.given()
		           .auth()		           
		           .basic(Config.getUserName(), Config.getPassword())
		           .header("Content-Type", "application/json")
		           .pathParam("table_name", "incident")
		           .log()
		           .all()
		           .when()
		           .body(payload)
		           .post(url)
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(201);
	}
	
	@Test
	public void shouldUserUpdateTheExisitingIncident() {
		CreateIncidentModal payload = new CreateIncidentModal();
		payload.setShort_description("Update");
		payload.setDescription("Modified the exisiting the description value");
		
		String url = "https://dev262949.service-now.com/api/now/table/{table_name}/{sys_id}";		
		RestAssured.given()
		           .auth()
		           .basic(Config.getUserName(), Config.getPassword())
		           .header("Content-Type", "application/json")
		           .pathParam("table_name", "incident")
		           .pathParam("sys_id", "1c741bd70b2322007518478d83673af3")
		           .log()
		           .all()
		           .when()
		           .body(payload)
		           .put(url)
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(200);
		
	}

}
