package com.instudies.autotests;

import static org.testng.Assert.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.LoginPage;
import com.instudies.pages.UserActivityPage;

public class LoginTest extends BasicTestCase {

private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);

private UserActivityPage userActivityPage;

@Test
  public void testLogin() throws Exception {
	  loginPage.open();
	  userActivityPage = loginPage.loginAs(firstUser); 
	  assertTrue(userActivityPage.isLoggedIn());
  }

}