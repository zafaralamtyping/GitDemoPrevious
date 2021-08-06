package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class StepDefination extends Base {
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	    
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		driver.get(arg1);
	    
	}

	@Given("^click on login link in home page to land on secure sign in page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	    LandingPage landingPage = new LandingPage(driver);
	    if(landingPage.getPopUpPresent().size()>0) {
	    	landingPage.closePopUp().click();
	    }
	    landingPage.getLogin().click();
	    
	    
	}
	@When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.getEmail().sendKeys(username);
	    loginPage.getPassword().sendKeys(password);
	    loginPage.getLogin().click();
	}
//	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
//	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
//	    LoginPage loginPage = new LoginPage(driver);
//	    loginPage.getEmail().sendKeys(arg1);
//	    loginPage.getPassword().sendKeys(arg2);
//	    loginPage.getLogin().click();
//	    
//	    
//	}

	@Then("^close browser$")
    public void close_browser() throws Throwable {
       driver.close();
    }


}
