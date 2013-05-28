package com.instudies.pages;

import org.openqa.selenium.WebDriver;

import com.instudies.utils.ConfigProperties;

public class UserActivityPage extends Page {

	public UserActivityPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("url")+"/activity/list");
	}
	
	public boolean isLoggedIn() {
		return true;
	}

}
