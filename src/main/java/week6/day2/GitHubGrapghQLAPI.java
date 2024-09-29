package week6.day2;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;

public class GitHubGrapghQLAPI {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/graphql";
		
		String query = """
								query {
				  viewer {
				    login
				    name
				    avatarUrl
				    repositories {
				      totalCount
				    }
				    followers{
				      totalCount
				    }
				    email
				    status {
				      createdAt
				    }
				  }
				}
								""";
		
		
		RestAssured.given()
		           .header(new Header("Authorization", "Bearer "))
		           .log().all()
		           .when()
		           .body(convertQueryToJsonString(query))
		           .post(url)
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);
		

	}
	
	public static String convertQueryToJsonString(String query) {
		JSONObject obj = new JSONObject();
		obj.put("query", query);
		return obj.toString();
	}

}