package com.instudies.pages.social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instudies.pages.Page;

public class GrantAccessFbPage extends Page {
	
	public GrantAccessFbPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="u_0_0")
	public WebElement buttonSumit;
	
	@Override
	public void open() {}
	
	public ConfirmGrantAccessFbPage grantAccess() {
		buttonSumit.click();
		// Todo: добавить проверку правильной авторизации в fb
		return PageFactory.initElements(driver, ConfirmGrantAccessFbPage.class);
	}

}
