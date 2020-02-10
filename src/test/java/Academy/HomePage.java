package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger log =(Logger) LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void intialize() throws IOException {
		driver=intializeDriver();
	}
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password) throws IOException {
			

		//one is inheritance
		//another creating object to that class and invoke method of it.
		driver.get(prop.getProperty("url"));
		LandingPage l= new LandingPage(driver);
		l.getlogin().click();
		LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.clickLogin().click();
		log.info("login is clicked");
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data= new Object[2][2];
		//oth row 
		data[0][0]="nonrestricted@qa.com";
		data[0][1]="12345";
		
		//1th row
		data[1][0]="restricted@qa.com";
		data[1][1]="4445";
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}

}
