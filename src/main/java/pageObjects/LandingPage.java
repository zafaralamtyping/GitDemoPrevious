package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By signin = By.xpath("//span[text()='Login']");
	By title = By.xpath("//h2[text()='Featured Courses']");
	By navigationBy = By.cssSelector(".navbar.navbar-default.navbar-static-top");
	By popUp = By.xpath("//button[text()='NO THANKS']");
	
	public List<WebElement> getPopUpPresent() {
		return driver.findElements(popUp);
	}
	public WebElement closePopUp() {
		return driver.findElement(popUp);
	}
	
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigation() {
		return driver.findElement(navigationBy);
	}

}
