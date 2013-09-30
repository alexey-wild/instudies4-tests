package com.instudies.autotests;

import static org.testng.Assert.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.popups.LoginPopup;
import com.instudies.pages.UserActivityPage;

public class LoginTwTest extends BasicTestCase {

private LoginPopup loginPopup = PageFactory.initElements(getWebDriver(), LoginPopup.class);

private UserActivityPage userActivityPage;

	@Test(description="Авторизация пользователя в системе через twitter.com")
	public void testLoginTw() throws Exception {
		loginPopup.open();
		userActivityPage = loginPopup.loginTw(BasicTestCase.twUser);
		assertTrue(userActivityPage.isLoggedIn(), "Ошибка авторизации через twitter.com");
	}

}