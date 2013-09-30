package com.instudies.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.blocks.LeftSidebarBlockNavigationUserBlock;
import com.instudies.utils.ConfigProperties;


public class UserActivityPage extends Page {
	
	private LeftSidebarBlockNavigationUserBlock leftSidebarBlockNavigationBlockUser = PageFactory.initElements(driver, LeftSidebarBlockNavigationUserBlock.class);

	public UserActivityPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("url")+"/");
	}

	public boolean isLoggedIn() {
		// TODO if (exist(allActivity)) true; else false
		return true;
	}

	public boolean isLogout() {
		// TODO if (exist(allActivity)) false; else true
		return true;
	}
	
	public MainPage logout() {
		return leftSidebarBlockNavigationBlockUser.logout();
	}	

}