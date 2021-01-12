package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {
	public static RequestSpecification requestSpecificationnew;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		if(requestSpecificationnew== null)
		{
		PrintStream logPrintStream =new PrintStream(new FileOutputStream("loggingnew.txt"));
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		requestSpecificationnew =new RequestSpecBuilder().setBaseUri(getGlobalValue("Baseurl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(logPrintStream))
				.addFilter(ResponseLoggingFilter.logResponseTo(logPrintStream))
				.setContentType(ContentType.JSON).build();

		// responseSpecification=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    return requestSpecificationnew;
		}
		return requestSpecificationnew; 
	}

	public static String getGlobalValue(String Key) throws IOException
	{
		Properties properties = new Properties();
		
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\arden\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		properties.load(fileInputStream);
		//System.out.println(properties.getProperty(Key));
		return properties.getProperty(Key);
		
		
	}
	public String getJsonValue(Response respString ,String key)
	{
		String resp=respString.asString();
		
		JsonPath jsonPath=new JsonPath(resp);
		return jsonPath.get(key).toString();
		
	}

}
