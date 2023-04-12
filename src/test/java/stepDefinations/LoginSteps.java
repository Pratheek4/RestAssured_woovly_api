package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resource.ApiResource;
import resource.TestBuildData;
import resource.Utils;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import addProductToCart.Parameter;

public class LoginSteps extends Utils {

	Response res;
	RequestSpecification req;
	ResponseSpecification resSpec;
	TestBuildData tbd = new TestBuildData();
	Parameter p = new Parameter();
	ApiResource apiRes ;
	static String userId;
	static String token;
	
	@Given("^Add User (.+) payload for (.+)$")
    public void add_user_payload_for(String data, String mailorphone) throws Throwable {
		
		if(mailorphone.equalsIgnoreCase("mail")) {
		req = given().spec(requestSpecification()).body(tbd.checkIfUserExistsPayloadEmail(data));
		}
		else {
		req = given().spec(requestSpecification()).body(tbd.checkIfUserExistsPayloadMobile(data));
		}
    }
	
	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String apiName, String httpMethod) throws Throwable {

		apiRes = ApiResource.valueOf(apiName);
    	resSpec = new ResponseSpecBuilder().expectStatusCode(200)
				 .expectContentType(ContentType.JSON).build();
		
    	if(httpMethod.equalsIgnoreCase("POST")) {
    		res = req.when().post(apiRes.getApi());
    		System.out.println(apiRes.getApi()+ " : Api called");
    	}
    	else if(httpMethod.equalsIgnoreCase("GET")) {
    		res = req.when().get(apiRes.getApi());
    		System.out.println(apiRes.getApi()+ " : Api called");
    	}
    }

	@Then("^Api call got success with status code (.+)$")
    public void api_call_got_success_with_status_code(int statuscode) throws Throwable {
    	assertEquals(res.getStatusCode(),statuscode);
    	System.out.println(apiRes.getApi()+ " : PASS with Response time - "+ res.getTime());
    }

    @And("^\"([^\"]*)\" in response body is (.+)$")
    public void something_in_response_body_is(String key, String value) throws Throwable {
       if(key.equalsIgnoreCase("data.userId")) {
    	   p.setUserId(getJsonPath(res, key));
    	   p.setTokenId(getJsonPath(res,"data.token"));
    	   userId = p.getUserId();
    	   token = p.getToken_id();   
       }
    	assertEquals(getJsonPath(res,key), value);	
    } 
    
    @Given("^User (.+) payload for addAllType (.+) as (.+) login$")
	public void user_payload_for_addalltype_as_login(String noemail, String tokenpswd, String logintype) throws Throwable {
		if(logintype.equalsIgnoreCase("mobile"))
		req = given().spec(requestSpecification()).body(tbd.addAllTypeUserPayload(noemail, tokenpswd));
		else 
		req = given().spec(requestSpecification()).body(tbd.addAllTypeUserPayload2(noemail, tokenpswd));
	}
    
    // addToCart
    
    @Given("^User add (.+) to cart with its (.+) and (.+)$")
    public void user_add_to_cart_with_its_and(String productid, int qty, String varientid) throws IOException {
		req = given().spec(requestSpecification()).headers("x-key",userId).headers("x-access-token",token).body(tbd.addToCart(productid, qty, varientid));
    }
    
    @Then("^AddToCart api call got success with status code (.+)$")
    public void addtocart_api_call_got_success_with_status_code(int statuscode) {
		assertEquals(res.getStatusCode(),statuscode);
    	System.out.println(apiRes.getApi()+ " : PASS with Response time - "+ res.getTime());
    }
    
    // fetchCartDetails
    @Given("^Send request body for (.+) ,(.+) ,(.+) and (.+)$")
    public void send_request_body_for_and(String coupontitle, String couponid, boolean iscoinsapply, String paymentmode) throws IOException {
    	req = given().spec(requestSpecification()).headers("x-key",userId).headers("x-access-token",token).body(tbd.fetchCartDetails(coupontitle, couponid, iscoinsapply, paymentmode));
    }
}