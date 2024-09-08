package week3.day2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static week3.day2.Config.*;

import java.util.List;

public class GetIncidentByJsonPathQuery {
	
	@Test
	public void shouldUserAbleGetHardwareCategoryOnly() {
		String url = "https://dev262949.service-now.com/api/now/table/{table_name}";
		
		List<String> list = given()
		.auth()
		.basic(getUserName(), getPassword())
		.pathParam("table_name", "incident")
		.when()
		.get(url)
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.extract()
		.jsonPath()
		.getList("result.findAll{it.category == 'hardware'}.category");
		
		Assert.assertEquals(list.size(), 10);
		
		for (String category : list) {
			Assert.assertEquals(category, "hardware");
		}
		
	}

}