package APITesting;





import org.testng.Assert;
import org.testng.annotations.Test;



import utility.Reports;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetRequest {

	@Test
	public void Test_03() {
		
				 RestAssured.baseURI = 
				 "http://restapi.demoqa.com/utilities/weather/city";
				 RequestSpecification httpRequest = RestAssured.given();
				 Response response = httpRequest.request(Method.GET, "/Hyderabad");
				System.out.println(response.statusCode());
				String responseBody = response.getBody().asString();
				 System.out.println("Response Body is =>  " + responseBody);
		}
}
