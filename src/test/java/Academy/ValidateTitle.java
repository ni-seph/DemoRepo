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

public class ValidateTitle extends base {
	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intialize() throws IOException {
		driver=intializeDriver();
		log.info("driver is intialized");
		driver.get(prop.getProperty("url"));	
		log.info("navigated to home page");
	}
	
	@Test
	public void validateApp() throws IOException {
	
		//one is inheritance
		//another creating object to that class and invoke method of it.
		LandingPage l= new LandingPage(driver);
		AssertJUnit.assertEquals("FEATURED COURSES123", l.getTitle().getText());
		log.info("successfully validated text message");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	public void logOut() {
		System.out.println("login out");
	}
}
