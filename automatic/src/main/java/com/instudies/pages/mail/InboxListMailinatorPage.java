package com.instudies.pages.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.ConfirmRestorePasswordPage;
import com.instudies.pages.Page;
import com.instudies.pages.UserActivityPage;

public class InboxListMailinatorPage extends Page {
	
	public InboxListMailinatorPage(WebDriver driver) {
		super(driver);
	}
	// TODO определить селекторы по заголовкам писем
	@FindBy(css="html body div#container div#content div#mainCol table#inboxList tbody tr td a")
	public WebElement linkActivateEmailMessage;
	
	@FindBy(css="html body div#container div#content div#mainCol table#inboxList tbody tr td a")
	public WebElement linkConfirmForgotPasswordMessage;
	
	private MessageActivateEmailPageMailinator messageActivateEmailPageMailinator = PageFactory.initElements(driver, MessageActivateEmailPageMailinator.class);
	private MessageConfirmChangeForgotPasswordPageMailinator messageConfirmChangeForgotPasswordPageMailinator = PageFactory.initElements(driver, MessageConfirmChangeForgotPasswordPageMailinator.class);
	
	@Override
	public void open() {}
	
	public void open(String url) {
		driver.get(url);
	}
	
	public UserActivityPage activateEmail() {
		linkActivateEmailMessage.click();
		return messageActivateEmailPageMailinator.activate();
	}
	
	public ConfirmRestorePasswordPage confirmChangeForgotPassword() {
		linkConfirmForgotPasswordMessage.click();
		return messageConfirmChangeForgotPasswordPageMailinator.confirm();
	}

}
