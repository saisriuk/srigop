package com.projectname.sample.testscripts;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.projectname.sample.testbase.TestBase;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/projectname/sample/features",
glue="com.projectname.sample.stepdefinitions",
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
monochrome = true
)
public class TestRunner {
	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(TestBase.ENV.getProperty("reportConfigPath")));
	/* Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));*/
	 }
}
