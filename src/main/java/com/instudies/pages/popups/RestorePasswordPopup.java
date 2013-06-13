package com.instudies.pages.popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.instudies.data.UserData;
import com.instudies.pages.Page;
import com.instudies.utils.ConfigProperties;

public class RestorePasswordPopup extends Page {
	
	public RestorePasswordPopup(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="request_password[email]")
	public WebElement fieldRequestPasswordEmail;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement buttonForgotPassword;
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("url")+"/security/request_password");
	}
	
	public void restore(UserData user) {
		fill(fieldRequestPasswordEmail, user.email);
		buttonForgotPassword.click();
	}

}
