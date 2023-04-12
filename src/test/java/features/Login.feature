Feature: Vlidating the Login Api's

# Number Login flow 
# 1 : checkIfUserExistes  -> Check phone number or email is valid
# 2 : sendLoginOTP        -> Skip
# 3 : verifyLoginOtp      -> Mock this API response to the request body of addAllTypeUser API 
# 4 : addAllTypeUser      -> Send token and mobile number in body from verifyLoginOtp API statically

# G-mail Login Flow
# 1 : checkIfUserExistes  -> Check email is valid
# 2 : addAllTypeUser      -> Send email and Password in the API body

# Google Login
# 1 : Google authentication token 
	

@Regression 
Scenario Outline: Verify api is showing correct response on the given mail/phone

Given Add User <data> payload for <mailOrPhone>
When user calls "LoginChekIfUserExistes" with "post" http request
Then Api call got success with status code 200
And "isExisting" in response body is <isExist>
And "error.errMsg" in response body is <error.errMsg>

Examples:
|mailOrPhone|data                   |isExist|error.errMsg      |
|mail       |pratheekp@woovly.com   |true   |User already exist|
|mail       |pratheek12344@gmail.com|false  |Success           |
|phone      |9986696534             |true   |User already exist|
|phone      |9087654321             |false  |Success           |


@Regression @Smoke @addAllTypeUser 
Scenario Outline: Verify addAllTypeUser is generating user_Id and token

Given User <noemail> payload for addAllType <tokenpswd> as <loginType> login
When user calls "LoginaddAllTypeUser" with "post" http request
Then Api call got success with status code 200
And "data.userId" in response body is <userId>
And "error.errMsg" in response body is <errMsg>


Examples:
|tokenpswd                                                                                                                              |noemail            |userId        |errMsg                   |loginType|
|eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtb2JpbGUiOiI5OTg2Njk2NTM0IiwiaWF0IjoxNjgwNjExOTMzfQ.fBotPR3NgYdGBL2rAGcV5VlyDc0rfkgLIIo1JiIQLfM|9986696534         |51646033558537|User succesfully signedIn|mobile   |
|PRtk@2821                                                                                                                              |pratheekp@gmail.com|51646033558537|User succesfully signedIn|email    |
