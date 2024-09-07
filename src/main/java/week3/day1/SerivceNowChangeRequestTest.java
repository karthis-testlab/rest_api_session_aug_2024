package week3.day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class SerivceNowChangeRequestTest extends BaseRequest {
	
	@Test
	public void shouldUserAbleGetAllIncidents() {		
		given()		
		.header("Content-Type", "application/json")
		.pathParam("table_name", "change_request")
		.log().all()
		.when()		
		.get()
		.then()
		.assertThat()
		.statusCode(200)
		.statusLine(equalTo("HTTP/1.1 200 OK"));
	}

}
