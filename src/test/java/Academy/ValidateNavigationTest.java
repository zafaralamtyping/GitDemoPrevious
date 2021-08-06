package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationTest extends Base{
	WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);

	}

	@Test
	public void validateNavigation() throws IOException {
		LandingPage landingPage = new LandingPage(driver);
		if(landingPage.getNavigation().isDisplayed()) {
			Assert.assertTrue(true);
			log.info("Navigation bar is present");
		} else {
			Assert.assertTrue(false);
			log.error("Navigation bar is not present");
		}
	}

	@AfterTest
	public void tearDown() {
		System.out.println("closing   validate navigation");
		driver.close();
	}

}
