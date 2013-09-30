package com.instudies.autotests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.UserActivityPage;
import com.instudies.pages.popups.RegisterPopup;

public class RegisterMrTest extends BasicTestCase {
	
	private RegisterPopup registerPopup = PageFactory.initElements(getWebDriver(), RegisterPopup.class);

	private UserActivityPage userActivityPage;

	@Test(description="Регистрация пользователя 'Студент' в системе через mail.ru")
	public void testRegisterMr() throws Exception {
		registerPopup.open();
		userActivityPage = registerPopup.registerMr(BasicTestCase.mrUser);
		assertTrue(userActivityPage.isLoggedIn(), "Ошибка регистрации через mail.ru");
	}

}