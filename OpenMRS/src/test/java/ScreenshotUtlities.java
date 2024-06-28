import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtlities {
	


	
	public static void takeScreenshot(WebDriver driver, String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\donka\\OneDrive\\Documents\\New\\OpenMRS\\src\\ScreenShot" + testName + ".png"));
        } catch (IOException e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
    }

    public static void takeScreenshotAfterEachTest(WebDriver driver, String testName) {
        takeScreenshot(driver, testName);
    }

}
