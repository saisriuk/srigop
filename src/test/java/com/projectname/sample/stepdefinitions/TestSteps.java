package com.projectname.sample.stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.projectname.sample.pages.HomePage;
import com.projectname.sample.pages.LoginPage;
import com.projectname.sample.testbase.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	
	WebDriver driver;
	TestBase testBase;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@Given("Launch application")
	public void launch_application() {
		testBase = new TestBase(driver);
		loginPage = testBase.initialization();
	}

	@When("enter username and password")
	public void enter_username_and_password() {
		loginPage.enterCredentials();
	}

	@When("click on login button")
	public void click_on_login_button() {
		homePage = loginPage.clickLogin();
	}

	@Then("home page should be displayed")
	public void home_page_should_be_displayed() {
		Assert.assertTrue("Homepage NOT displayed", homePage.verifyHomePage());
	}
	
	@After(order = 1)
	 public void afterScenario(Scenario scenario) {
	 if (scenario.isFailed()) {
	 String screenshotName = scenario.getName().replaceAll(" ", "_");
	 try {
	 //This takes a screenshot from the driver at save it to the specified location
	 File sourcePath = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
	 
	 //Building up the destination path for the screenshot to save
	 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
	 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
	 
	 //Copy taken screenshot from source location to destination location
	 Files.copy(sourcePath, destinationPath);   
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(destinationPath.toString());
	 } catch (IOException e) {
	 } 
	 }
	 
	 }
	
	@After(order = 0)
	public void tearDown(){		
		if(testBase.driver!=null)
			testBase.driver.quit();
	}
	
	
	
}
