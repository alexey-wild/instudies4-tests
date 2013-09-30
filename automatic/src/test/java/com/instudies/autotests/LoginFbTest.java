package com.instudies.autotests;

import static org.testng.Assert.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.popups.LoginPopup;
import com.instudies.pages.UserActivityPage;

public class LoginFbTest extends BasicTestCase {

private LoginPopup loginPopup = PageFactory.initElements(getWebDriver(), LoginPopup.class);

private UserActivityPage userActivityPage;

	@Test(description="Авторизация пользователя в системе через facebook.com")
	public void testLoginFb() throws Exception {
		loginPopup.open();
		userActivityPage = loginPopup.loginFb(BasicTestCase.fbUser);
		assertTrue(userActivityPage.isLoggedIn(), "Ошибка авторизации через facebook.com");
	}

}