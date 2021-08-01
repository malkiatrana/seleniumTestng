package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigReader {
	public static WebDriver driver;
	public static Properties pro;

	public ConfigReader()

	{
		
		try {
			// Specify the path
			File src = new File("./Configuration/config.property");

			// Convert into input stream
			FileInputStream fis = new FileInputStream(src);

			// Create Properties class object to read properties file
			pro = new Properties();

			// Load file so we can use into our script
			pro.load(fis);

		} catch (Exception e) {

			System.out.println("Exception is : " + e.getMessage());
		}

	}

	public String getExcelData()

	{
		return pro.getProperty("aiw.excelinputdata.path");
	}

	public String getBrowser()

	{
		return pro.getProperty("aiw.selectBrowser");
	}

	public String getBrowserF()

	{
		return pro.getProperty("aiw.selectBrowserF");
	}

	public String getCustomerURL()

	{
		return pro.getProperty("navigate.to.url");
	}

	public String getChromeDriverPath()

	{
		return pro.getProperty("aiw.chromedriverpath");
	}

	public String getUsername()

	{
		return pro.getProperty("user.name");
	}

	public String getPassword()

	{
		return pro.getProperty("user.password");
	}
	public String getWelcomeMessage()
	{
		return pro.getProperty("welcome.message");
	}
	public String getSavingsAccountNumber()
	{
		return pro.getProperty("SAVINGS");
	}
	
	public String getCheckingAccountNumber()
	{
		return pro.getProperty("CHECKING");
	}
	
	
}



