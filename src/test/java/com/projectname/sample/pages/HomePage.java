package com.projectname.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.projectname.sample.testbase.TestBase;

public class HomePage extends TestBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyHomePage(){
		driver.switchTo().frame("mainpanel");
		return driver.findElement(By.xpath(OR.getProperty("homeTabField"))).isDisplayed();
	}
	
}
