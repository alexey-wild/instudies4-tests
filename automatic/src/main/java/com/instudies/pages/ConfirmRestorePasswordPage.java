package com.instudies.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.data.UserData;

public class ConfirmRestorePasswordPage extends Page {
	
	public ConfirmRestorePasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="password_repeat")
	public WebElement passwordRepeat;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement buttonSubmit;
	
	@Override
	public void open() {}

	public UserActivityPage confirm(UserData user, String newPassword) {
		fill(password, newPassword);
		fill(passwordRepeat, newPassword);
		user.password = newPassword;
		buttonSubmit.click();
		return PageFactory.initElements(driver, UserActivityPage.class);
	}

}
