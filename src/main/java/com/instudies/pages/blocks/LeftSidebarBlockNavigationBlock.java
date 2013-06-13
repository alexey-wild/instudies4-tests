package com.instudies.pages.blocks;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.instudies.pages.Page;

public class LeftSidebarBlockNavigationBlock extends Page {

	public LeftSidebarBlockNavigationBlock(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void open() {}
	
	@FindBy(css="li")
	public List<WebElement> elementsNavigationBlock;

}
