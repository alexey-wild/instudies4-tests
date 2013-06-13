package com.instudies.pages.popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.data.UserData;
import com.instudies.pages.ConfirmRestorePasswordPage;
import com.instudies.pages.Page;
import com.instudies.pages.UserActivityPage;
import com.instudies.pages.mail.InboxListMailinatorPage;
import com.instudies.pages.social.AuthFbPage;
import com.instudies.pages.social.AuthMrPage;
import com.instudies.pages.social.AuthTwPage;
import com.instudies.pages.social.AuthVkPage;
import com.instudies.pages.social.ConfirmGrantAccessFbPage;
import com.instudies.pages.social.GrantAccessFbPage;
import com.instudies.pages.social.GrantAccessTwPage;
import com.instudies.pages.social.GrantAccessVkPage;
import com.instudies.utils.ConfigProperties;

public class LoginPopup extends Page {
	
	public LoginPopup(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="login[email]")
	public WebElement fieldLoginEmail;
	
	@FindBy(name="login[password]")
	public WebElement fieldLoginPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement buttonLogin;
	
	@FindBy(css="a[data-test-authvk]")
	public WebElement linkLoginVk;
	
	@FindBy(css="a[data-test-authfb]")
	public WebElement linkLoginFb;
	
	@FindBy(css="a[data-test-authmr]")
	public WebElement linkLoginMr;
	
	@FindBy(css="a[data-test-authtw]")
	public WebElement linkLoginTw;
	
	@FindBy(css="a[data-test-restorepassword]")
	public WebElement linkRestorePassword;
	
	private AuthVkPage authVkPage = PageFactory.initElements(driver, AuthVkPage.class);
	private GrantAccessVkPage grantAccessVkPage;
	
	private AuthFbPage authFbPage = PageFactory.initElements(driver, AuthFbPage.class);
	private GrantAccessFbPage grantAccessFbPage;
	private ConfirmGrantAccessFbPage confirmGrantAccessFbPage;
	
	private AuthMrPage authMrPage = PageFactory.initElements(driver, AuthMrPage.class);
	
	private AuthTwPage authTwPage = PageFactory.initElements(driver, AuthTwPage.class);
	private GrantAccessTwPage grantAccessTwPage;
	
	private RestorePasswordPopup restorePasswordPopup = PageFactory.initElements(driver, RestorePasswordPopup.class);
	private InboxListMailinatorPage inboxListMailinatorPage;
	
	private ConfirmRestorePasswordPage confirmRestorePasswordPage;
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("url")+"/security/login");
	}
	
	public UserActivityPage loginAs(UserData user) {
		fill(fieldLoginEmail, user.email);
		fill(fieldLoginPassword, user.password);
		buttonLogin.click();
		return PageFactory.initElements(driver, UserActivityPage.class);
	}
	
	public UserActivityPage loginVk(String[] user) {
		linkLoginVk.click();
		grantAccessVkPage = authVkPage.auth(user);
		return grantAccessVkPage.grantAccess();
	}
	
	public UserActivityPage loginFb(String[] user) {
		linkLoginFb.click();
		grantAccessFbPage = authFbPage.auth(user);
		confirmGrantAccessFbPage = grantAccessFbPage.grantAccess();
		return confirmGrantAccessFbPage.confirmGrantAccess();
	}
	
	public UserActivityPage loginMr(String[] user) {
		linkLoginMr.click();
		return authMrPage.auth(user);
	}
	
	public UserActivityPage loginTw(String[] user) {
		linkLoginTw.click();
		grantAccessTwPage = authTwPage.auth(user);
		return grantAccessTwPage.grantAccess();
	}
	
	public UserActivityPage restorePassword(UserData user) {
		linkRestorePassword.click();
		restorePasswordPopup.restore(user);
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inboxListMailinatorPage = PageFactory.initElements(driver, InboxListMailinatorPage.class);
		inboxListMailinatorPage.open(user.emailUrl);
		confirmRestorePasswordPage = inboxListMailinatorPage.confirmChangeForgotPassword();
		return confirmRestorePasswordPage.confirm(user, "12345678");
	}

}
