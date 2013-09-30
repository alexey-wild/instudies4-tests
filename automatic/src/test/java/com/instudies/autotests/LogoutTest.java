package com.instudies.autotests;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

	public class LogoutTest extends BasicTestCase {
	
	@Test(description="Выход пользователя из системы")
	public void testLogout() throws Exception {
		WebElement logout = driver.findElement(By.cssSelector("a[data-test-linklogout]"));
		logout.click();
		// TODO добавить проверку
		assertTrue(true, "Ошибка выхода из системы");
	}

}