package com.instudies.autotests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.instudies.data.UserData;
import com.instudies.utils.ConfigProperties;

public class BasicTestCase {
	
	protected static WebDriver driver;
	
	protected static Reporter reporter;
	
	public static UserData firstUser = new UserData("autotestuser@mailinator.com", "1234567", "Autotest User", "student", "http://autotestuser.mailinator.com");
	public static String[] vkUser = {"380938423649", "123456Instudies"};
	public static String[] fbUser = {"autotestinstudies@gmail.com", "123456Instudies"};
	public static String[] mrUser = {"autotestinstudies@mail.ru", "123456Instudies"};
	public static String[] twUser = {"autotestinstudies@gmail.com", "123456Instudies"};
	
	protected Reporter getReporter() {
		if (reporter == null) {
			reporter = new Reporter();
		}
		return reporter;
	}
	
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
		reporter = new Reporter();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
	  driver.quit();
	}

}
