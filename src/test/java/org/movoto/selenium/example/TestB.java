package org.movoto.selenium.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities; 
import java.net.*;
import java.io.*;
import org.openqa.selenium.remote.RemoteWebDriver; 
import org.openqa.selenium.remote.RemoteWebElement; 
import java.util.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class TestB {
		
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
                chromeOptions.put("binary", "/var/lib/jenkins/chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver");
		//System.setProperty("webdriver.chrome.driver","D:\\codebase\\SourceCode-Examples\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","/usr/local/share/chromedriver");
		//driver = new ChromeDriver();
		driver = new ChromeDriver(capabilities);
		//driver.manage().window().maximize();
		driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		/*
		try{
		DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://172.18.51.88:4444/wd/hub"), capability);
		}catch(Exception e){}
             */
		System.out.println("*******************Browser Started******************");
	}
	
	@Test
	public void testGooglePageTitleInChrome() {
		/*
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
		*/
		driver.navigate().to("http://172.18.51.87:81/devcapsule-spring-1.0/");
		//driver.get("http://172.18.51.88:8080/devcapsule-spring-1.0/");
		String strPageTitle = driver.getTitle();
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Pizzas"), "Page title doesn't match");
	}
	
	
	
	

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			driver.quit();
		}
	}
}
