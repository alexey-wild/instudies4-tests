package com.instudies.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.data.UserData;
import com.instudies.utils.ConfigProperties;

public class LoginPage extends Page {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="auth_login_email")
	public WebElement fieldLoginEmail;
	
	@FindBy(id="auth_login_password")
	public WebElement fieldLoginPassword;
	
	@FindBy(xpath="//html/body/div/div/div/div/form/footer/button")
	public WebElement buttonLogin;
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("url")+"/#/preloadedpopup/popupLogin");
	}
	
	public UserActivityPage loginAs(UserData user) {
		buttonLogin.click();
		fill(fieldLoginEmail, user.email);
		fill(fieldLoginPassword, user.password);
		buttonLogin.click();
		return PageFactory.initElements(driver, UserActivityPage.class);
	}

}
