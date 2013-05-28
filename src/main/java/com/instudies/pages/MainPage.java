package com.instudies.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.instudies.utils.ConfigProperties;

public class MainPage extends Page {
	
	@FindBy(linkText="Войти")
	public WebElement buttonLogin;
	
	@FindBy(linkText="Регистрация")
	public WebElement buttonRegistration;
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("url"));
	}

}
