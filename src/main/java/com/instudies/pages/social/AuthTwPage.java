package com.instudies.pages.social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.Page;

public class AuthTwPage extends Page {
	
	public AuthTwPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="username_or_email")
	public WebElement fieldEmail;
	
	@FindBy(id="password")
	public WebElement fieldPassword;
	
	@FindBy(id="allow")
	public WebElement buttonSubmit;
	
	@Override
	public void open() {}
	
	public GrantAccessTwPage auth(String[] userTw) {
		fill(fieldEmail, userTw[0]);
		fill(fieldPassword, userTw[1]);
		buttonSubmit.click();
		return PageFactory.initElements(driver, GrantAccessTwPage.class);
	}

}
