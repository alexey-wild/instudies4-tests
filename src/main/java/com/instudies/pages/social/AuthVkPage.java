package com.instudies.pages.social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.Page;

public class AuthVkPage extends Page {
	
	public AuthVkPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="email")
	public WebElement fieldEmail;
	
	@FindBy(name="pass")
	public WebElement fieldPassword;
	
	@FindBy(id="install_allow")
	public WebElement buttonSubmit;
	
	@Override
	public void open() {}
	
	public GrantAccessVkPage auth(String[] userVk) {
		fill(fieldEmail, userVk[0]);
		fill(fieldPassword, userVk[1]);
		buttonSubmit.click();
		return PageFactory.initElements(driver, GrantAccessVkPage.class);
	}

}
