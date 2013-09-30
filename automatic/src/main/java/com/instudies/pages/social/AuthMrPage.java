package com.instudies.pages.social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.Page;
import com.instudies.pages.UserActivityPage;

public class AuthMrPage extends Page {
	
	public AuthMrPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="Login")
	public WebElement fieldEmail;
	
	@FindBy(name="Password")
	public WebElement fieldPassword;
	
	@FindBy(css="button[type='submit']")
	public WebElement buttonSubmit;
	
	@Override
	public void open() {}
	
	public UserActivityPage auth(String[] userMr) {
		fill(fieldEmail, userMr[0]);
		fill(fieldPassword, userMr[1]);
		buttonSubmit.click();
		return PageFactory.initElements(driver, UserActivityPage.class);
	}

}
