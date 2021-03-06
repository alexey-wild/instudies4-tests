package com.instudies.autotests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.UserActivityPage;
import com.instudies.pages.popups.RegisterPopup;

public class RegisterVkTest extends BasicTestCase {
	
	private RegisterPopup registerPopup = PageFactory.initElements(getWebDriver(), RegisterPopup.class);

	private UserActivityPage userActivityPage;

	@Test(description="Регистрация пользователя 'Студент' в системе через vk.com")
	public void testRegisterVk() throws Exception {
		registerPopup.open();
		userActivityPage = registerPopup.registerVk(BasicTestCase.vkUser);
		assertTrue(userActivityPage.isLoggedIn(), "Ошибка регистрации через vk.com");
	}

}