package week5.day1;

import java.io.File;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JIRAService {
	
	public static void main(String[] args) {
		String url = "https://karthikeselene.atlassian.net/rest/api/3";
		RestAssured.given()
		           .auth()
		           .preemptive()
		           .basic("karthike.selene@gmail.com", "")
		           .header("X-Atlassian-Token", "no-check")
		           .pathParam("issueIdOrKey", "10020")
		           .log()
		           .all()
		           .when()		           
		           .multiPart(new File("src/main/resources/jsonformatter.txt"))
		           .post(url+"/issue/{issueIdOrKey}/attachments")
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(200)
		           .statusLine(Matchers.containsString("OK"))
		           .contentType(ContentType.JSON);
	}	

}