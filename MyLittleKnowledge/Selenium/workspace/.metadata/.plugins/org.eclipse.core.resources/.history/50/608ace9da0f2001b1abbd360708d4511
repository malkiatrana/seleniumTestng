/**
 * 
 */
package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Ai-Media
 * 
 */
public class CaptureImage {
	static WebDriver driver;

	public static String captureScreenShot(WebDriver ldriver) {

		String imageName = null;
		TakesScreenshot src = ((TakesScreenshot) ldriver);
		File dest = src.getScreenshotAs(OutputType.FILE);

		// now copy the  screenshot to desired location using copyFile method

		try {
			imageName = System.currentTimeMillis() + ".png";
			FileUtils.copyFile(dest, new File("./Screenshots/" + imageName));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return imageName;
	}

	public static void getScreenshot(String imageName) throws IOException {

		if (imageName.equalsIgnoreCase("")) {

			imageName = "blank";
		}
		TakesScreenshot src = ((TakesScreenshot) driver);
		File image = src.getScreenshotAs(OutputType.FILE);
		// File image =
		// ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = System.getProperty(("user.dir")
				+ "./Screenshot/");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imageLocation + imageName + "_"
				+ formater.format(calendar.getTime() + ".png");
		File destFile = new File(actualImageName);
		FileUtils.copyFile(image, destFile);

	}

}
