package week3.day2;

import static io.restassured.RestAssured.given;
import static week3.day2.Config.getPassword;
import static week3.day2.Config.getUserName;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class IncidentGetRequestDeSerializationTest {
	
	@Test
	public void shouldUserAbleToFetchAllIncidentRecor() {
		String url = "https://dev262949.service-now.com/api/now/table/{table_name}";
		
		List<ResultModal> response = given()
		.auth()
		.basic(getUserName(), getPassword())
		.pathParam("table_name", "incident")
		.queryParam("sysparm_limit", 3)
		.queryParam("sysparm_fields", "number,sys_id,description,short_description,category,opened_at,caller_id")
		.queryParam("sysparm_query", "category=hardware")
		.when()
		.get(url)
		.then()
		.extract()
		.jsonPath()
		.getList("result", ResultModal.class);
		
		for (ResultModal resultModal : response) {
			System.out.println(resultModal.getNumber());
			System.out.println(resultModal.getDescription());
			System.out.println(resultModal.getShort_description());
			System.out.println(resultModal.getCategory());
			System.out.println(resultModal.getOpened_at());
			System.out.println(resultModal.getSys_id());
			System.out.println(resultModal.getCaller_id().getValue());
			System.out.println(resultModal.getCaller_id().getLink());			
			System.out.println(" ");
			
			//Assert the get all incident records only hardware category
			assertThat(resultModal.getCategory(), equalTo("hardware"));
			
		}
	}

}