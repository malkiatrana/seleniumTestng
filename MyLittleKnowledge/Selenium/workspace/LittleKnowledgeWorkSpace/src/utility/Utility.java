package utility;

import java.awt.AWTException;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.google.common.base.Predicate;

public class Utility extends Reports {

	public static void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 25; i++) {
			try {
				if (PageReady(js) == true) {
					break;
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	private static  boolean PageReady(JavascriptExecutor js) {		

		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return true;
		}

		return false;
	}

	public static void capture(String screenshotName) throws IOException, InterruptedException, AWTException {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
		screenshotName = screenshotName + "_" + formatter.format(currentDate).toString() + ".png";
		String dest = System.getProperty("user.dir") + "./test-output/html/Screenshots/" + screenshotName;
		File destination = new File(dest);
		FileUtils.copyFile(file, destination);
		Reporter.log("<br><img src=./Screenshots/" + screenshotName + " height='50%' width='60%'/><br>");
		// ************************************************************this code will
		// capture the console log as well***************************************
		Thread.sleep(5000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_J);
//		robot.keyRelease(KeyEvent.VK_J);
//		robot.keyRelease(KeyEvent.VK_SHIFT);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(5000);
//		robot.delay(40);
//		BufferedImage screenShot = robot
//				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//		File fileconsole = new File("./test-output/html/Screenshots/" + "Console_" + screenshotName);
//		ImageIO.write(screenShot, "PNG", fileconsole);
//		Thread.sleep(5000);
//		Reporter.log("<br><img src=./Screenshots/" + "Console_" + screenshotName + " height='50%' width='60%'/><br>");
		 JavascriptExecutor jse = (JavascriptExecutor)driver; 
		    Long clent_height = (Long) jse.executeScript("return window.document.documentElement.clientHeight");
	        Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.delay(40);
	        // AWT Toolkit For Window
	        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	        int taskBarHeight = screenSize.height - winSize.height;
	        System.out.println("Screen : "+screenSize.height +","+screenSize.width);
	        int yaxis =   (int) (screenSize.getHeight() - (taskBarHeight + clent_height.intValue()));
	            int x = 0, y = yaxis;     
	            int width = (int) screenSize.getWidth(), height = (int) screenSize.getHeight();
	         Rectangle area = new Rectangle(x, y, width, height-taskBarHeight-y);
	         BufferedImage bufferedImage = robot.createScreenCapture(area);
	     	File fileconsole = new File("./test-output/html/Screenshots/" + "Console_" + screenshotName);
	         ImageIO.write(bufferedImage, "jpg",fileconsole);
	         Reporter.log("<br><img src=./Screenshots/" + "Console_" + screenshotName + " height='50%' width='60%'/><br>");
	         robot.keyPress(KeyEvent.VK_F12); 
	         robot.keyPress(KeyEvent.VK_F12);
	}

	public static void waitUntilSelectOptionsPopulated(final Select select) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS)
                .until(new Predicate<WebDriver>() {
                    public boolean apply(WebDriver d) {
                        return (select.getOptions().size() > 1);
                    }
                });
    }

}