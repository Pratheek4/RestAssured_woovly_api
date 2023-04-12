package resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqSpec ;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqSpec == null) {
			PrintStream log = new PrintStream(new FileOutputStream("allLogs.txt"));
			reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValues("alpha"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
				 
			return reqSpec;
		}
		return reqSpec;
	}
	
	public String getGlobalValues(String get) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/woovly/Desktop/FILES/Selenium - Framwork/woovly.api/src/test/java/resource/global.properties");
		prop.load(fis);
		return prop.getProperty(get);
	}
	
	public String getJsonPath(Response response, String key) {
		
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.get(key).toString();
		
	}
}

