package com.instudies.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import com.instudies.utils.ConfigProperties;

public class UserActivityPage extends Page {

	public UserActivityPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//html/body/div[1]/div/ul[1]/li[4]/a/span")
	public WebElement allActivity;

	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("url")+"/");
	}
	
	public boolean isLoggedIn() {
		// Todo: if (exist(allActivity)) true; else false
		return true;
	}

}
