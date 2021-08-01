package ParaBank_Pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ConfigReader;
import utility.Reports;
import utility.Utility;


public class UserLogin extends Reports {
	ConfigReader config;
	WebDriver driver;

	public UserLogin(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(how = How.CSS, using = "[class='login'] [name='username']")
	WebElement UserName_TextBox;

	@FindBy(how = How.CSS, using = "[class='login'] [name='password']")
	WebElement UserPassowrd_TextBox;

	@FindBy(how = How.CSS, using = "[class='login'] [value='Log In']")
	WebElement Login_Button;
	
	@FindBy(how = How.CSS, using = "div[id='bodyPanel'] div[id='leftPanel'] [class='smallText']")
	WebElement LeftPanel_Text;	

	// This function is used to login into application
	public void commonuserlogin() throws Exception {
		
		Logger log = Logger.getLogger(Logger.class.getName());
		PropertyConfigurator.configure("Configuration/Log4j.properties");
		config = new ConfigReader();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(UserName_TextBox));
		UserName_TextBox.sendKeys(config.getUsername());
	    log.info("Username");
	    UserPassowrd_TextBox.sendKeys(config.getPassword());
		log.info("Password");
		Login_Button.click();
		log.info("Login button clicked");
        Utility.checkPageIsReady();
	      try {	
			if(LeftPanel_Text.getText().contains(config.getWelcomeMessage()))
			 {
				log.info("User is logged in successfully");
			 }
	      } catch (NoSuchElementException e) {
				 log.info("User is not logged in");
			 }
	  	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='login'] [value='Log In']")));
	}
}

