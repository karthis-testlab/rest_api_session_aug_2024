package week6.day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class ValidateJsonSchema {
	
	//@Test
	public void validateJsonSchemaOfDemoStore() {
		
		String jsonSchema = """
				{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "array",
  "items": [
    {
      "type": "object",
      "properties": {
        "id": {
          "type": "integer"
        },
        "name": {
          "type": "string"
        },
        "slug": {
          "type": "string"
        },
        "sorting": {
          "type": "integer"
        }
      },
      "required": [
        "id",
        "name",
        "slug",
        "sorting"
      ]
    }
  ]
}
				""";
		
		RestAssured.given()
		           .when()
		           .get("https://demostore.gatling.io/api/category")
		           .then()
		           .assertThat()
		           .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));	
	}
	
	@Test
	public void validateJsonSchemaOfDemoStoreAsaFile() {
		RestAssured.given()
        .when()
        .get("https://demostore.gatling.io/api/category")
        .then()
        .assertThat()
        .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/json-schema/get-all-json-schem.json")));
	}

}