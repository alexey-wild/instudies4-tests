package com.instudies.autotests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.instudies.data.UserData;
import com.instudies.utils.ConfigProperties;

public class BasicTestCase {
	
	protected static WebDriver driver;
	
	public UserData firstUser = new UserData("autotestuser@mailinator.com", "1234567", "Autotest User");
	
	protected WebDriver getWebDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("wait")), TimeUnit.SECONDS);
		}
		return driver;
	}

	@BeforeTest
	public void setUp() throws Exception {
		driver = this.getWebDriver();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
	  driver.quit();
	  }

}
