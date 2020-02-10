package Academy;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavBar extends base {
	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void intialize() throws IOException {
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));	
		
	}
	
	@Test
	public void validateNav() throws IOException {
		
		//one is inheritance
		//another creating object to that class and invoke method of it.
		LandingPage l= new LandingPage(driver);
		AssertJUnit.assertTrue(l.getNavBar().isDisplayed());
		log.info("navigation bar is successfully displayed");
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}

}
