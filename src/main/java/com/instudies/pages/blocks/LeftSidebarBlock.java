package com.instudies.pages.blocks;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.instudies.pages.Page;

public class LeftSidebarBlock extends Page {
	
	public LeftSidebarBlock(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void open() {}

	@FindBy(css="side-navigation")
	public WebElement sideNavigation;
	
	@FindBy(css="side-navigation__block")
	public List<WebElement> sideNavigationBlock;
	
}
