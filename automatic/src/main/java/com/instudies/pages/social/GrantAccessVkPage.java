package com.instudies.pages.social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.Page;
import com.instudies.pages.UserActivityPage;

public class GrantAccessVkPage extends Page {
	
	public GrantAccessVkPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="install_allow")
	public WebElement buttonSumit;
	
	@Override
	public void open() {}
	
	public UserActivityPage grantAccess() {
		buttonSumit.click();
		// Todo: добавить проверку правильной авторизации в vk
		return PageFactory.initElements(driver, UserActivityPage.class);
	}
}
