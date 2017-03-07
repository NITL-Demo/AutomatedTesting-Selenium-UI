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
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxBinary; 

public class TestB {
		
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching firefox browser");
		
		/*
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
                chromeOptions.put("binary", "/var/lib/jenkins/chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		capabilities.setPlatform(Platform.LINUX);
		capabilities.setCapability("browser_version", "54.0.2840.87");
		capabilities.setBrowserName("chrome");
		*/
		try{
		   System.setProperty("webdriver.gecko.driver","/root/artifacts/resources/geckodriver");		
		   driver = new FirefoxDriver();
		    System.out.println("*******************Browser Started*****Start*************"); 
                     //driver = new RemoteWebDriver(new URL("http://172.18.51.88:4444/wd/hub"), capabilities);
		}catch(Exception e){
		  System.out.println("*******************"+e.getMessage());
		}
                
		
		
		/*
		try{
		    System.setProperty("webdriver.gecko.driver","/root/artifacts/resources/geckodriver");	
		     DesiredCapabilities capability = DesiredCapabilities.firefox();
		      capability.setBrowserName("firefox");//AGAIN, use the right browser name that you can get from the hub's config page
                      capability.setPlatform(Platform.ANY);//	
                     driver = new RemoteWebDriver(new URL("http://172.18.51.88:4444/wd/hub"), capability);
		}catch(Exception e){
		  System.out.println("*******************"+e.getMessage());
		}
                */
	
		// driver = new RemoteWebDriver(new URL("http://172.18.51.88:4444/wd/hub"), capabilities);
		/*System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver");*/
		//System.setProperty("webdriver.chrome.driver","D:\\codebase\\SourceCode-Examples\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","/usr/local/share/chromedriver");
		//driver = new ChromeDriver();
		//driver = new ChromeDriver(capabilities);
		/*try{
		//driver = new RemoteWebDriver( new URL("http://172.18.51.88:4444/wd/hub"), capabilities);
	        //System.setProperty("webdriver.gecko.driver","/root/artifacts/resources/geckodriver");
	        		
		FirefoxBinary binary = new FirefoxBinary(new File("/usr/lib/firefox/firefox"));
                binary.setEnvironmentProperty("DISPLAY",System.getProperty("lmportal.xvfb.id",":1"));
                driver = new FirefoxDriver(binary,null);	
			
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}catch(Exception ex){
			 ex.printStackTrace();
		 }
		 */
		/*
		try{
		DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://172.18.51.88:4444/wd/hub"), capability);
		}catch(Exception e){}
             */
		System.out.println("*******************Browser Started*****Final*************");
	}
	
	@Test
	public void testGooglePageTitleInChrome() {
		/*
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
		*/
		driver.navigate().to("http://172.18.51.87:80/devcapsule-spring-1.0/");
		//driver.get("http://172.18.51.88:8080/devcapsule-spring-1.0/");
		String strPageTitle = driver.getTitle();
		Assert.assertFalse(strPageTitle.equalsIgnoreCase("Pizzas"), "");
	}
	
	
	@Test
	public void testGooglePageTitleInChrome1() {
		/*
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
		*/
		driver.navigate().to("http://172.18.51.87:80/devcapsule-spring-1.0/");
		//driver.get("http://172.18.51.88:8080/devcapsule-spring-1.0/");
		String strPageTitle = driver.getTitle();
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Pizzas1"), "");
	}
	
	
	
	

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			driver.quit();
		}
	}
}
