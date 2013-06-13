package com.instudies.pages.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.Page;
import com.instudies.pages.UserActivityPage;

public class MessageActivateEmailPageMailinator extends Page {
	
	public MessageActivateEmailPageMailinator(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='message']/p[3]/a")
	public WebElement linkActivate;
	
	@Override
	public void open() {}
		
	public UserActivityPage activate() {
		linkActivate.click();
		return PageFactory.initElements(driver, UserActivityPage.class);
	}
	
}
