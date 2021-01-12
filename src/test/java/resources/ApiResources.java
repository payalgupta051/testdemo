package resources;

public enum ApiResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	GetPlaceAPI("/maps/api/place/get/json");
	private String resource;
	ApiResources(String resource) {
		
		this.resource=resource;
		// TODO Auto-generated constructor stub
	}
	
public String getResources()
{
	return resource;
}
}
