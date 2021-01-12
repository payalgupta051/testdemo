package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import stepDefinations.stepDefination;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforescenrio() throws IOException
	{
		stepDefination m=new stepDefination();
		if(stepDefination.place_id==null)
		{
		m.add_place_payload_with("Payal", "Canara Apartment", "English");
		m.user_calls_with_post_http_request("AddPlaceAPI","Post");
		m.verify_that_place_id_created_using_maps_to("GetPlaceAPI","Payal");
		}
	}

}
