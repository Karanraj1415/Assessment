import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Properties.Propertiesfiles;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Report.class)
public class WebPage {
	WebDriver driver;
	SoftAssert softAssert;
	Alert A;
	Propertiesfiles propfiles;

	@BeforeSuite
	public void setup() throws Exception {
		propfiles = new Propertiesfiles();
		String browser1 = propfiles.read("browser");
		String url1 = propfiles.read("url");

		if (browser1.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser1.equalsIgnoreCase("Edge"))

		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.get(url1);
		softAssert = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 0)
	public void login() {
		WebElement usernameInput = driver.findElement(By.name("username"));
		usernameInput.sendKeys("Admin");
		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("Admin123");

		WebElement locationSelect = driver.findElement(By.xpath("//li[text()='Laboratory']"));
		locationSelect.click();
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		loginButton.click();
		softAssert.assertTrue(driver.getTitle().contains("OpenMRS"));

	}

	@Test(priority = 1)
	public void reg() {
		WebElement registerPatientButton = driver.findElement(By.xpath("(//a[@type='button'])[4]"));
		registerPatientButton.click();
		WebElement nameInput = driver.findElement(By.name("givenName"));
		nameInput.sendKeys("test1");
		WebElement name = driver.findElement(By.name("familyName"));
		name.sendKeys("test1");
		WebElement next = driver.findElement(By.xpath("//button[@id='next-button']"));
		next.click();

		WebElement genderSelect = driver.findElement(By.name("gender"));
		genderSelect.sendKeys("Male");
		WebElement next1 = driver.findElement(By.xpath("//button[@id='next-button']"));
		next1.click();
	}

	@Test(priority = 2)
	public void dob() {

		WebElement birthdateInput = driver.findElement(By.id("birthdateDay-field"));
		birthdateInput.sendKeys("01");
		WebElement birthdateInput1 = driver.findElement(By.name("birthdateMonth"));
		birthdateInput1.click();
		WebElement birthdateInput4 = driver.findElement(By.xpath("//option[text()='May']"));
		birthdateInput4.click();
		WebElement birthdateInput3 = driver.findElement(By.name("birthdateYear"));
		birthdateInput3.sendKeys("1999");
		WebElement next2 = driver.findElement(By.xpath("//button[@id='next-button']"));
		next2.click();
	}

	@Test(priority = 3)
	public void address() {

		WebElement addressInput = driver.findElement(By.id("address1"));
		addressInput.sendKeys("no:1/921");
		WebElement addressInput1 = driver.findElement(By.id("address2"));
		addressInput1.sendKeys("main road");

		WebElement addressInput3 = driver.findElement(By.id("cityVillage"));
		addressInput3.sendKeys("cmb");
		WebElement addressInput4 = driver.findElement(By.id("stateProvince"));
		addressInput4.sendKeys("TamilNadu");
		WebElement addressInput5 = driver.findElement(By.id("country"));
		addressInput5.sendKeys("cmb");
		WebElement addressInput6 = driver.findElement(By.id("postalCode"));
		addressInput6.sendKeys("600074");
		WebElement next3 = driver.findElement(By.xpath("//button[@id='next-button']"));
		next3.click();

		WebElement phoneNumberInput = driver.findElement(By.name("phoneNumber"));
		phoneNumberInput.sendKeys("123-456-7890");

		WebElement next4 = driver.findElement(By.xpath("//button[@id='next-button']"));
		next4.click();
	}

	@Test(priority = 4)
	public void patientdet() {

		WebElement patientrel = driver.findElement(By.id("relationship_type"));
		Select Sel = new Select(patientrel);
		Sel.selectByVisibleText("Parent");
		WebElement patientrel1 = driver.findElement(By.xpath("//input[@placeholder='Person Name']"));
		patientrel1.sendKeys("karan");

		WebElement next5 = driver.findElement(By.xpath("//button[@id='next-button']"));
		next5.click();

		WebElement confirmButton = driver.findElement(By.xpath("//input[@id='submit']"));
		confirmButton.click();

	}

	@Test(priority = 5)
	public void startvist() throws Exception {
		WebElement startVisitButton = driver.findElement(By.xpath("//div[contains(text(),'Start Visit')]"));
		startVisitButton.click();
		WebElement startVisitButton1 = driver
				.findElement(By.xpath("//button[@id='start-visit-with-visittype-confirm']"));
		startVisitButton1.click();
		WebElement attachmentButton = driver
				.findElement(By.xpath("//a[@id='attachments.attachments.visitActions.default']"));
		attachmentButton.click();
		WebElement attachmentButton1 = driver.findElement(By.xpath("//form[@id='visit-documents-dropzone']"));
		Thread.sleep(1000);
		attachmentButton1.click();
		Thread.sleep(1000);
		Robot r = new Robot();
		StringSelection str = new StringSelection(
				"C:\\Users\\donka\\OneDrive\\Documents\\New\\OpenMRS\\src\\sample\\test.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, str);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement attachmentButton3 = driver.findElement(By.xpath("//textarea[@placeholder='Enter a caption']"));
		attachmentButton3.sendKeys("hi");
		WebElement confirmVisitButton = driver.findElement(By.xpath("//button[@class='confirm ng-binding']"));
		confirmVisitButton.click();

//		softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-item toast-type-success']")).getText()
//				.contains("Attachment uploaded successfully"));

		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();

//		softAssert.assertTrue(driver.findElement(By.xpath("//div[text()='Attachment Upload']")).getText()
//				.contains("Attachment Upload"));

		Thread.sleep(5000);
		WebElement endvisit = driver.findElement(By.xpath("(//div[normalize-space()='End Visit'])[3]"));
		endvisit.click();

		WebElement yes = driver.findElement(By.xpath("(//button[normalize-space()='Yes'])[2]"));
		yes.click();

	}

	@Test(priority = 6)
	public void delete() {
		WebElement deletePatientButton = driver.findElement(By.xpath("//div[contains(text(),'Delete Patient')]"));
		deletePatientButton.click();
		WebElement reasonInput = driver.findElement(By.xpath("//input[@id='delete-reason']"));
		reasonInput.sendKeys("Test data");
		WebElement reasonInput1 = driver.findElement(By.xpath("(//button[text()='Confirm'])[3]"));
		reasonInput1.click();

	}

	@AfterMethod
	public void Screenshot(ITestResult result) throws Exception {
		if (!(ITestResult.FAILURE == result.getStatus())) {

			ScreenshotUtlities.takeScreenshot(driver, result.getName());

		}

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
