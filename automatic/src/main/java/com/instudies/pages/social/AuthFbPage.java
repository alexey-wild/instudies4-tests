package com.instudies.pages.social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.Page;

public class AuthFbPage extends Page {
	
	public AuthFbPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="email")
	public WebElement fieldEmail;
	
	@FindBy(id="pass")
	public WebElement fieldPassword;
	
	@FindBy(id="u_0_1")
	public WebElement buttonSubmit;
	
	@Override
	public void open() {}
	
	public GrantAccessFbPage auth(String[] userFb) {
		fill(fieldEmail, userFb[0]);
		fill(fieldPassword, userFb[1]);
		buttonSubmit.click();
		return PageFactory.initElements(driver, GrantAccessFbPage.class);
	}
}
