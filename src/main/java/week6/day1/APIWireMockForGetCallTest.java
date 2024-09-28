package week6.day1;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class APIWireMockForGetCallTest {
	
	private WireMockServer mockServer;
	private String response_payload = """
			{
    "id": 7,
    "name": "Unisex",
    "slug": "unisex",
    "sorting": 100
}
			""";
	
	private String baseUri = "http://localhost:8080";
	
	@BeforeMethod
	public void startUp() {
		mockServer = new WireMockServer();
		mockServer.start();
	}
	
	@Test
	public void validateMockGetMethod() {
		
		mockServer.stubFor(WireMock.get("/api/category/7")
				           .willReturn(WireMock.aResponse()
				        		       .withStatus(200)
				        		       .withHeader("Content-Type", "application/json")
				        		       .withBody(response_payload)));
		
		RestAssured.given()
		           .when()
		           .get(baseUri+"/api/category/7")
		           .then()
		           .assertThat()
		           .statusCode(200)
		           .body("id", Matchers.equalTo(7))
		           .body("name", Matchers.equalTo("Unisex"));
		           
		           
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		mockServer.stop();
	}
	

}