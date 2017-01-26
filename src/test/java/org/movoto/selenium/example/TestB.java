package org.movoto.selenium.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestB {
		
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		
		System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver");
		//System.setProperty("webdriver.chrome.driver","D:\\codebase\\SourceCode-Examples\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInChrome() {
		/*
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
		*/
		driver.navigate().to("http://172.18.51.88:8080/devcapsule-spring-1.0/");
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
