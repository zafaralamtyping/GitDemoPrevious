package Academy;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
import resources.ExcelArrayList;
import resources.ExcelUtilData;

public class HomePageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password, String comment) throws IOException {
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("opened url from HomePageTest");

		LandingPage lPage = new LandingPage(driver);
		lPage.getLogin().click();
		log.info("clicked Login from HomePageTest"); 
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(userName);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLogin().click();
		log.info("userName, Password and login click from HomePageTest");
	}
/*
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "restricted_user";
		data[0][1] = "restrictpassword";
		data[0][2] = "restricted user";

		data[1][0] = "unrestricted_user";
		data[1][1] = "unrestrictpassword";
		data[1][2] = "un-restricted user";
		
//		data[2][0] = "special_user";
//		data[2][1] = "specialpassword";
//		data[2][2] = "special user";
		
		return data;
	}
*/
	@DataProvider
	public Object[][] getData() throws IOException {
		ArrayList<ExcelArrayList> arrayList = new ArrayList<ExcelArrayList>();
		ExcelUtilData excelUtilData = new ExcelUtilData();
		arrayList = excelUtilData.getExcelData();
//		for(int i=0; i<arrayList.size(); i++) {
//			System.out.print(arrayList.get(i).getUserName()
//					+ "     " + arrayList.get(i).getPassword()
//					+ "     " + arrayList.get(i).getComment());
//			System.out.println();
//		}
	
//		System.out.println(arrayList.size());
		
		Object[][] dataObjects = new Object[3][3];
		
		for(int i=0; i<arrayList.size(); i++) {
			int j=0;
			dataObjects[i][j] =  arrayList.get(i).getUserName();
			j++;
			dataObjects[i][j] =  arrayList.get(i).getPassword();
			j++;
			dataObjects[i][j] =  arrayList.get(i).getComment();
			
		}
//		System.out.println("2D array object");
//		for(int i=0; i<3; i++) {
//			for(int j=0; j<3; j++) {
//				System.out.print(dataObjects[i][j] + "     ");
//			}
//			System.out.println();
//		}
		return dataObjects;
}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}
}
