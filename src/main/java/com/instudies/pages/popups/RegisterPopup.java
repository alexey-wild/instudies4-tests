package com.instudies.pages.popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.data.UserData;
import com.instudies.pages.Page;
import com.instudies.pages.UserActivityPage;
import com.instudies.pages.social.AuthFbPage;
import com.instudies.pages.social.AuthMrPage;
import com.instudies.pages.social.AuthTwPage;
import com.instudies.pages.social.AuthVkPage;
import com.instudies.pages.social.ConfirmGrantAccessFbPage;
import com.instudies.pages.social.GrantAccessFbPage;
import com.instudies.pages.social.GrantAccessTwPage;
import com.instudies.pages.social.GrantAccessVkPage;
import com.instudies.utils.ConfigProperties;

public class RegisterPopup extends Page {
	
	public RegisterPopup(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="type_teacher")
	public WebElement fieldRegisterTypeTeacher;
	
	@FindBy(id="type_student")
	public WebElement fieldRegisterTypeStudent;
	
	@FindBy(name="register[fullname]")
	public WebElement fieldRegisterFullname;

	@FindBy(name="register[email]")
	public WebElement fieldRegisterEmail;
	
	@FindBy(name="register[password]")
	public WebElement fieldRegisterPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement buttonRegister;
	
	@FindBy(css="a[data-test-authvk]")
	public WebElement linkRegisterVk;
	
	@FindBy(css="a[data-test-authfb]")
	public WebElement linkRegisterFb;
	
	@FindBy(css="a[data-test-authmr]")
	public WebElement linkRegisterMr;
	
	@FindBy(css="a[data-test-authtw]")
	public WebElement linkRegisterTw;
	
	private AuthVkPage authVkPage = PageFactory.initElements(driver, AuthVkPage.class);
	private GrantAccessVkPage grantAccessVkPage;
	
	private AuthFbPage authFbPage = PageFactory.initElements(driver, AuthFbPage.class);
	private GrantAccessFbPage grantAccessFbPage;
	private ConfirmGrantAccessFbPage confirmGrantAccessFbPage;
	
	private AuthMrPage authMrPage = PageFactory.initElements(driver, AuthMrPage.class);
	
	private AuthTwPage authTwPage = PageFactory.initElements(driver, AuthTwPage.class);
	private GrantAccessTwPage grantAccessTwPage;
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("url")+"/security/register");
	}
	
	public UserActivityPage registerAs(UserData user) {
		fill(fieldRegisterFullname, user.email);
		fill(fieldRegisterEmail, user.email);
		fill(fieldRegisterPassword, user.password);
		// Todo: сделать выбор типа пользователя: Студент или Преподаватель
		/*
		if (user.typeUser == "teacher") {
			fill(fieldRegisterTypeStudent, "teacher");
		} else if (user.typeUser == "student") {
			fill(fieldRegisterTypeTeacher, "student");
		}
		*/
		buttonRegister.click();
		return PageFactory.initElements(driver, UserActivityPage.class);
	}
	
	public UserActivityPage registerVk(String[] user) {
		linkRegisterVk.click();
		grantAccessVkPage = authVkPage.auth(user);
		return grantAccessVkPage.grantAccess();
	}
	
	public UserActivityPage registerFb(String[] user) {
		linkRegisterFb.click();
		grantAccessFbPage = authFbPage.auth(user);
		confirmGrantAccessFbPage = grantAccessFbPage.grantAccess();
		return confirmGrantAccessFbPage.confirmGrantAccess();
	}
	
	public UserActivityPage registerMr(String[] user) {
		linkRegisterMr.click();
		return authMrPage.auth(user);
	}
	
	public UserActivityPage registerTw(String[] user) {
		linkRegisterTw.click();
		grantAccessTwPage = authTwPage.auth(user);
		return grantAccessTwPage.grantAccess();
	}

}