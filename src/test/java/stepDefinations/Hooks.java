package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@NeedAuth")
	public void getIdAndToken() throws Throwable {
		LoginSteps ls = new LoginSteps();
		ls.user_payload_for_addalltype_as_login("pratheekp@gmail.com", "PRtk@2821", "email");
		ls.user_calls_something_with_something_http_request("LoginaddAllTypeUser","post");
		ls.something_in_response_body_is("data.userId", "51646033558537");
	}
}
