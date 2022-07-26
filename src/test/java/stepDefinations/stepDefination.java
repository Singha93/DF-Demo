package stepDefinations;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.AddPlace;
import pojo.Location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination {

	AddPlace a = new AddPlace();

	@Given("Enter {string} and {string} Values")
	public void enter_and_values(String langugae, String Name) {
	   
		a.setLanguage(langugae);
		a.setName(Name);
	}
	@When("Enter Remaining Values")
	public void enter_remaining_values() throws JsonProcessingException {
		
		a.setWebsite("http://google.com");
		a.setAccuracy(50);
		a.setPhone_number("(+91) 983 893 3937");
		a.setAddress("29, side layout, cohen 09");
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		
		List<String> mylist =  new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		
		a.setTypes(mylist);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		a.setLocation(l);
		
		
		//Response res = given().log().all().queryParam("key", "qaclick123").body(a).
				//when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();
		
		//String ResponseString= res.asString();
		
		//System.out.println(ResponseString);
		ObjectMapper objMap= new ObjectMapper();
		String mydata=objMap.writerWithDefaultPrettyPrinter().writeValueAsString(a);
		
		
		System.out.println(mydata);

	}




	}



