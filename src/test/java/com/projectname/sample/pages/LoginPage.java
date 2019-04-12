package com.projectname.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectname.sample.testbase.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterCredentials(){
		driver.findElement(By.xpath(OR.getProperty("usernameField"))).sendKeys(ENV.getProperty("username"));
		driver.findElement(By.xpath(OR.getProperty("passwordField"))).sendKeys(ENV.getProperty("password"));
		
	}
	
	public HomePage clickLogin(){
		driver.findElement(By.xpath(OR.getProperty("loginButton"))).click();
		return new HomePage(driver);
	}

}
