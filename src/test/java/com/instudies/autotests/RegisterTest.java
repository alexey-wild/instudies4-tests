package com.instudies.autotests;

import static org.testng.Assert.*;

import java.util.Random;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.popups.RegisterPopup;
import com.instudies.pages.UserActivityPage;

public class RegisterTest extends BasicTestCase {

	private RegisterPopup registerPopup = PageFactory.initElements(getWebDriver(), RegisterPopup.class);
	
	private UserActivityPage userActivityPage;

	@Test(description="Регистрация пользователя 'Студент' в системе")
	public void testRegister() throws Exception {		
		Random r = new Random();
		int rand = r.nextInt();
		String randString = String.valueOf(rand);
		BasicTestCase.firstUser.email = "autotestuser"+randString+"@mailinator.com";
		BasicTestCase.firstUser.fullname = "Autotest User"+randString;
		BasicTestCase.firstUser.password = "1234567";
		BasicTestCase.firstUser.emailUrl = "http://autotestuser"+randString+".mailinator.com";
		registerPopup.open();
		userActivityPage = registerPopup.registerAs(firstUser);
		assertTrue(userActivityPage.isLoggedIn(), "Ошибка регистрации");
	}

}