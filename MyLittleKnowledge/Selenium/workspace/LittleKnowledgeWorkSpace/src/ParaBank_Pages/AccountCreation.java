package ParaBank_Pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.ConfigReader;
import utility.ConfigWriter;
import utility.Reports;
import utility.Utility;


public class AccountCreation extends Reports {
	ConfigReader config;
	ConfigWriter configwriter;
	WebDriver driver;

	public AccountCreation(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(how = How.CSS, using = "a[href=\"/parabank/openaccount.htm\"]")
	WebElement LinkOpenNewAccount;

	@FindBy(how = How.CSS, using = "div[ng-app='AddAccountApp']")
	WebElement AddAccountPanel;

	@FindBy(how = How.CSS, using = "div [class='button'][value='Open New Account']")
	WebElement OpenNewAccount_Button;
	
	@FindBy(how = How.ID, using = "newAccountId")
	WebElement NewAccountCreatedId;	
	
	@FindBy(how = How.CSS, using = "a[href=\"/parabank/logout.htm\"]")
	WebElement Logout_Button;
	
	@FindBy(how = How.CSS, using = "[ng-if='showDetails'] td[id='accountId']")
	WebElement AccountNumberLabel;
	
	@FindBy(how = How.CSS, using = "div [class='button'][value='Go']")
	WebElement Go_Button;
	
	// This function is used to login into application for live videos
	public void accountcreation(String accountType) throws Exception {
		
		Logger log = Logger.getLogger(Logger.class.getName());
		PropertyConfigurator.configure("Configuration/Log4j.properties");
		config = new ConfigReader();
		configwriter = new ConfigWriter();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(LinkOpenNewAccount));
		LinkOpenNewAccount.click();
		wait.until(ExpectedConditions.visibilityOf(AddAccountPanel));
		OpenNewAccount_Button.click();
	    Utility.checkPageIsReady();
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fromAccountId"))));
	    Select accountTypeDrop= new Select(driver.findElement(By.id("type")));
	    accountTypeDrop.selectByVisibleText(accountType);
	    Select fromAccount= new Select(driver.findElement(By.id("fromAccountId")));
	    fromAccount.selectByIndex(0);
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    new Actions(driver).moveToElement(OpenNewAccount_Button).perform();
	    executor.executeScript("arguments[0].click();", OpenNewAccount_Button);
	    wait.until(ExpectedConditions.visibilityOf(NewAccountCreatedId));
	    String value= NewAccountCreatedId.getText();
	    log.info(value);
	    configwriter.writeData(accountType,value);
	    NewAccountCreatedId.click();
	    Thread.sleep(2000);
	    wait.until(ExpectedConditions.visibilityOf(AccountNumberLabel));
		Assert.assertEquals(AccountNumberLabel.getText(), value);
	    Logout_Button.click();
	    }
}

