package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import pojo.addLocation;
import pojo.addnew;

public class TestDataBuild {
	
	public addnew addPlacePayload(String name,String address,String language)
	{
		addnew a1=new addnew();
		a1.setAccuracy(50);
		a1.setAddress(address);
		a1.setLanguage(language);
		a1.setName(name);
		a1.setPhone_number("(+91) 983 893 3937");
		a1.setWebsite("http://google.com");
		List<String> list1=new ArrayList<String>();
		list1.add("shoe park");
		list1.add("shop");
		a1.setTypes(list1);
		addLocation location =new addLocation();
		location.setLat(-38.383494);
		location.setLng(33.427362);	
		a1.setLocation(location);
		return a1;
	}
	
public String deletePlacePayload(String place_id)
{
	return "{\r\n \"place_id\":\""+place_id+"\"\r\n}";
	
}
}
