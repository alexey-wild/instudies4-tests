package com.instudies.autotests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.instudies.pages.UserActivityPage;
import com.instudies.pages.mail.InboxListMailinatorPage;

public class ActivateEmailTest extends BasicTestCase {

private InboxListMailinatorPage inboxListPage = PageFactory.initElements(getWebDriver(), InboxListMailinatorPage.class);

private UserActivityPage userActivityPage;

	@Test(description="Активация email пользователя")
	public void testActivateEmail() throws Exception {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inboxListPage.open(BasicTestCase.firstUser.emailUrl);
		userActivityPage = inboxListPage.activateEmail();
		assertTrue(userActivityPage.isLoggedIn(), "Ошибка активации email пользователя");
	}

}
