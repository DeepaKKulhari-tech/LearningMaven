package MavenStructuredFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.gecko.driver",
				"D:\\Downloads\\Download C\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("launching chrome broswer");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://freecrm.com/");
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}

	@Test(priority=1)
	public void freeCrmTitleTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "#1 Free CRM customer relationship management software cloud");
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
	}

	@Test(priority=2)
	public void freeCRMLogoTest() {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
		Boolean b = driver.findElement(By.xpath("//img[@class='c4icons']")).isDisplayed();
		Assert.assertTrue(b);
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
	}

	@AfterSuite
	public void tear() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
