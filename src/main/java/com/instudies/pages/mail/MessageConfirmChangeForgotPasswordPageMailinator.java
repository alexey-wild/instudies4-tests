package com.instudies.pages.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.ConfirmRestorePasswordPage;
import com.instudies.pages.Page;

public class MessageConfirmChangeForgotPasswordPageMailinator extends Page {
	
	public MessageConfirmChangeForgotPasswordPageMailinator(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='message']/p[3]/a")
	public WebElement linkConfirm;
	
	@Override
	public void open() {}
		
	public ConfirmRestorePasswordPage confirm() {
		linkConfirm.click();
		return PageFactory.initElements(driver, ConfirmRestorePasswordPage.class);
	}

}
