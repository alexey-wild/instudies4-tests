package com.instudies.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class Page {
	
	protected WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	protected void fill(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	protected void waithAndReloadFor(By elemBy) {
		int waitTime = 120000;
        Boolean condition = false;
        int waitStep = 3000;
        int startTime = (int) System.currentTimeMillis();
        int finishTime = startTime + waitTime;
        int currentTime = startTime + waitStep;
        while (currentTime <= finishTime) {
    		boolean exists = driver.findElements(elemBy).size() != 0;
        	if (exists) {
                condition = true;
                break;        		
        	} else {
            	try {
    				Thread.sleep(waitStep);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
        	}
        	/*
        	try {
        		driver.findElement(elemBy);
                condition = true;
                debug.message(0, "ok");
                break;
        	} catch (Exception e) {
        		debug.message(0, "no");
        		try {
					Thread.sleep(waitStep);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}*/
        	/*
            if (elem.isDisplayed()) {
                condition = true;
                break;
            } else {
                try {
					Thread.sleep(waitStep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            */
            currentTime = (int) System.currentTimeMillis() + waitStep;
            driver.navigate().refresh();
        }

        if (!condition) {
        	Assert.assertTrue(false, "Превышено время ожидания элемента");
        }
	}
	
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		
		Wait<WebDriver> wait = new WebDriverWait(driver, 120);
		try {
			wait.until(expectation);
		} catch(Throwable error) {
			error.printStackTrace();
		}
	 } 
	
	public abstract void open();

}