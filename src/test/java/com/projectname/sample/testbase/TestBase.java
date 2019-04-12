package com.projectname.sample.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.projectname.sample.pages.LoginPage;

import cucumber.api.java.After;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties ENV,OR;
	public static Logger log;
	public TestBase(WebDriver driver){
		this.driver = driver;
		
		ENV = new Properties();
		OR = new Properties();
		log = Logger.getLogger("devpinoyLogger");
		
		try {
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//projectname//sample//config//environment.properties");
			ENV.load(fi);
			fi = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//projectname//sample//config//OR.properties");
			OR.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public LoginPage initialization(){
		
		String browser = ENV.getProperty("browser");
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"//Drivers//chromedriver_win32//chromedriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(ENV.getProperty("url"));
		log.info("Browser launched");
		return new LoginPage(driver);
		
	}
	
	
}
