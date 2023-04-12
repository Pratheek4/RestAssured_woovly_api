package stepDefinations;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resource.ApiResource;
import resource.TestBuildData;
import resource.Utils;


public class CartFlowSteps extends Utils {
			
	Response res;
	RequestSpecification req;
	ResponseSpecification resSpec;
	TestBuildData tbd = new TestBuildData();
	ApiResource apiRes;
	
//	@Given("^User add (.+) to cart with its (.+) and (.+)$")
//    public void user_add_to_cart_with_its_and(String productid, int qty, String varientid) throws IOException{
//		req = given().spec(requestSpecification()).headers("x-key",LoginSteps.userId).headers("x-access-token",LoginSteps.token).body(tbd.addToCart(productid, qty, varientid));
//    }
	
	
			
}
