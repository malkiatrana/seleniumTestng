package APITesting;



import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import utility.ConfigReader;

public class APITesting{
	ConfigReader config;
	
	@Test()
	public void Test_Amount_Transfer() {
		config = new ConfigReader();
		RestAssured.given().queryParam("fromAccountId", config.getSavingsAccountNumber()).queryParam("toAccountId", config.getCheckingAccountNumber()).queryParam("amount", "2")
	.accept(ContentType.JSON).
	post("https://parabank.parasoft.com/parabank/services/bank/transfer").
	then().
	statusCode(200).
	log().all().assertThat().body(Matchers.equalTo("Successfully transferred $2 from account #"+config.getSavingsAccountNumber()+" to account #"+config.getCheckingAccountNumber()));
	}

    @Test
	public void GetAmountBalance_CheckingAccount()
    {
    	config = new ConfigReader();
        RestAssured.given().when().get("https://parabank.parasoft.com/parabank/services/bank/accounts/"+config.getCheckingAccountNumber()+"/transactions").
    	then().assertThat().
		body("transactions.transaction[0].type", Matchers.equalTo("Credit"));
       	
}
    @Test
	public void GetAmountBalance_SavingsAccount()
    {
    	config = new ConfigReader();
        RestAssured.given().when().get("https://parabank.parasoft.com/parabank/services/bank/accounts/"+config.getSavingsAccountNumber()+"/transactions").
    	then().assertThat().
		body("transactions.transaction[0].type", Matchers.equalTo("Debit"));
       	
}

}
