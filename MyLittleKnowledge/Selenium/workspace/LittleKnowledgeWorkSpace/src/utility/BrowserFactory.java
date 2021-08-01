package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	static WebDriver driver;
//	static HtmlUnitDriver driver1;
	static ConfigReader config;
	
	public static WebDriver startBrowser(String browserName, String url) {

		config = new ConfigReader();
		
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			//Set ACCEPT_SSL_CERTS  variable to true
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
			driver = new ChromeDriver(options);
		}
		if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		if (browserName.equalsIgnoreCase("Html")) {
//			driver = new HtmlUnitDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}

}
