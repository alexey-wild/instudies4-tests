package com.instudies.autotests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.UserActivityPage;
import com.instudies.pages.popups.LoginPopup;

public class RestorePassword extends BasicTestCase {

	private LoginPopup loginPopup = PageFactory.initElements(getWebDriver(), LoginPopup.class);

	private UserActivityPage userActivityPage;
	
	@Test(description="Восстановление пароля")
	public void testRestorePassword() throws Exception {
		loginPopup.open();
		userActivityPage = loginPopup.restorePassword(BasicTestCase.firstUser);
		assertTrue(userActivityPage.isLoggedIn(), "Ошибка восстановления пароля");
	}
	
}
