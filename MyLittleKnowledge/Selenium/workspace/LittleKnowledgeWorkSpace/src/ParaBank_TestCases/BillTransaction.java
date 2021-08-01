package ParaBank_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ParaBank_Pages.BillPay;
import ParaBank_Pages.UserLogin;
import utility.BrowserFactory;
import utility.ConfigReader;
import utility.ConfigWriter;
import utility.Reports;

public class BillTransaction extends Reports {

	ConfigReader config;
	ConfigWriter writer;
	
@BeforeTest
	public void setup()
	{
		config = new ConfigReader();
		writer = new ConfigWriter();
		// This will launch browser and specific url
		driver = BrowserFactory.startBrowser(config.getBrowser(),
				                    config.getCustomerURL());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Setup is Ready");
	}

@Test
public void ParaBank_BillPayTransaction() throws InterruptedException, Exception {
	Report = extent.createTest("Parabank Transaction", "BillPay_Transaction");
    //Created Page Object using Page Factory
	UserLogin login_page = PageFactory
			.initElements(driver, UserLogin.class);
	//AccountCreation account_creation = PageFactory
	//		.initElements(driver, AccountCreation.class);
	BillPay billpay = PageFactory
			.initElements(driver, BillPay.class);
    //Call the method of the Common User class
	login_page.commonuserlogin();
	//account_creation.accountcreation("SAVINGS");
	billpay.billypay();
	System.out.println("Testcase passed successfully");
}
	}

