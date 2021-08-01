package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*
 * @author (Saurabh)
 *
 */
public class Reports {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest Report;
	public static WebDriver driver;
	static ConfigReader config;

	@BeforeSuite
	public void StartReport() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/Reports/ExtenReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Host Name", "Selenium");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("UserName", "Malkiat Singh");
		htmlReporter.config().setDocumentTitle(
				"Automation Testing AIW Report");
		htmlReporter.config().setReportName("ExtentReport");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	@AfterMethod
	public void GetReport(ITestResult result) throws IOException {

		config = new ConfigReader();
		
		System.out.println(this.getClass());
		
		if (ITestResult.FAILURE == result.getStatus()) {
			String imageName = CaptureImage.captureScreenShot(driver);
			System.out.println("Screenshot Captured Successfully");
			Report.log(
					Status.FAIL,
					MarkupHelper.createLabel(
							result.getName()
									+ "Test case Failed Please refer screenshot for more details: ",
							ExtentColor.RED));
			Report.fail(result.getThrowable());
			// log with snapshot
			Report.log(Status.INFO, "Screenshot Captured Successfully : ")
				.addScreenCaptureFromPath("../Screenshots/" + imageName);
			
			System.out.println(imageName);
		} else if (ITestResult.SUCCESS == result.getStatus()) {
			Report.log(
					Status.PASS,
					MarkupHelper.createLabel(result.getName()
							+ "Test case Passed ", ExtentColor.GREEN));
	//	Report.log(Status.INFO, "Browser Opened Successfully");
	//	Report.log(Status.INFO, "Current URL is :  " + driver.getCurrentUrl());
	//	Report.log(Status.INFO, "Title is :  " + driver.getTitle());
		
		} else {
			Report.log(Status.SKIP, MarkupHelper.createLabel(result.getName()
					+ "    Test case Skipped due to below issue:",
					ExtentColor.LIME));
			Report.skip(result.getThrowable());
		}

		}
	
	@AfterClass
	public void quitdriver()
	{
      driver.close();
		
	}

	@AfterSuite
	public void TearDown() {

		extent.flush();
	}

}