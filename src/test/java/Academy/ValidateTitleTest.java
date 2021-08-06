package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitleTest extends Base {
	WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);

	}

	
	@Test
	public void validateTtile() throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		String actual = landingPage.getTitle().getText();
		String expected = "FEATURED123 COURSES";
		Assert.assertEquals(actual, expected);
		log.info("Title validated successfully");
		
		
	}

	@AfterTest
	public void tearDown() {
		
		driver.close();
	}

}
