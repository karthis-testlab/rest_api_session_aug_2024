package week3.day2;

import com.google.gson.Gson;

public class CreateIncidentModalTest {

	public static void main(String[] args) {
		
		CreateIncidentModal payload = new CreateIncidentModal();
		payload.setCaller_id("5137153cc611227c000bbd1bd8cd2006");
		payload.setShort_description("Stage server say shut down");
		payload.setDescription("Shut Down");
		payload.setUrgency("1");
		payload.setState("1");
		
		Gson gson = new Gson();
		String json = gson.toJson(payload);
		
		System.out.println(json);

	}

}
