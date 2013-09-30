package com.instudies.autotests;

import static org.testng.Assert.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.popups.LoginPopup;
import com.instudies.pages.UserActivityPage;

public class LoginTest extends BasicTestCase {

private LoginPopup loginPopup = PageFactory.initElements(getWebDriver(), LoginPopup.class);

private UserActivityPage userActivityPage;

	@Test(description="Авторизация пользователя в системе")
	public void testLogin() throws Exception {
		loginPopup.open();
		userActivityPage = loginPopup.loginAs(BasicTestCase.firstUser);
		assertTrue(userActivityPage.isLoggedIn(), "Ошибка авторизации");
	}

}