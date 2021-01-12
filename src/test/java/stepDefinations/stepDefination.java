package stepDefinations;
import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import groovyjarjarantlr.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;
import pojo.addnew;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utility;
import pojo.addLocation;
public class stepDefination extends Utility{
	
	RequestSpecification requestSpecification1;
	ResponseSpecification responseSpecification;
	Response rsResponse;
	JsonPath js ;
	static String place_id;
	TestDataBuild testdataObject=new TestDataBuild();
	@Given("Add place payload with {string},{string},{string}")
	public void add_place_payload_with(String name, String address, String language) throws IOException {
		
			
			
		// responseSpecification=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 requestSpecification1=given().spec(requestSpecification()).body(testdataObject.addPlacePayload(name,address,language));
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
		}


		@When("user calls {string} with {string} http request")
		public void user_calls_with_post_http_request(String string,String method) {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println(string);
			ApiResources aResources = ApiResources.valueOf(string);
			System.out.println(aResources.getResources());
			 responseSpecification=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			if(method.equalsIgnoreCase("POST"))
			{
			 rsResponse=requestSpecification1.when().post(aResources.getResources());
			}
			else if(method.equalsIgnoreCase("GET"))
			{
				rsResponse=requestSpecification1.when().get(aResources.getResources());
			}
			System.out.println(rsResponse);
		   // throw new io.cucumber.java.PendingException();
		}
		@Then("the API call got success with Status Code {int}")
		public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(rsResponse.getStatusCode(),200);
		
		
		    // Write code here that turns the phrase above into concrete actions
		  //  throw new io.cucumber.java.PendingException();
		}
		@Then("{string} in response body is {string}")
		public void in_response_body_is(String expectedString, String actualstring) {
		    // Write code here that turns the phrase above into concrete actions
			String respString=rsResponse.asString();
			js = new JsonPath(respString);
			assertEquals(getJsonValue(rsResponse,expectedString),actualstring);
		   // throw new io.cucumber.java.PendingException();
		} 
	//	io.cucumber.junit.UndefinedStepException: The step "Verify that place_id created using "GetPlaceAPI" maps to "AAhouse"" is undefined. You can implement it using the snippet(s) below:

			@Then("Verify that place_id created using {string} maps to {string}")
			public void verify_that_place_id_created_using_maps_to(String string, String string2) throws IOException {
			    // Write code here that turns the phrase above into concrete actions
				place_id=getJsonValue(rsResponse,"place_id");
				requestSpecification1=given().spec(requestSpecification()).queryParam("place_id", place_id);
				user_calls_with_post_http_request(string,"GET");
				String  name=getJsonValue(rsResponse,"name");
				assertEquals(name,string2);
			   // throw new io.cucumber.java.PendingException();
			}


				@Given("Delete place payload")
				public void delete_place_payload() throws IOException {
				    // Write code here that turns the phrase above into concrete actions
				   // throw new io.cucumber.java.PendingException();
					 requestSpecification1=given().spec(requestSpecification()).body(testdataObject.deletePlacePayload(place_id));
				}
				








}
