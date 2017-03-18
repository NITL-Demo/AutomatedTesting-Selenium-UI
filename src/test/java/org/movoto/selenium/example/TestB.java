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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



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
		Assert.assertFalse(strPageTitle.equalsIgnoreCase("Pizzas1"), "");
	}
	
	
	@Test
	public void service() throws Exception{
		
		ExtentTest test= extentreport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		driver.get("http://172.18.51.87:80/devcapsule-spring-1.0/");
		getscreenshot("Homepage");
		flushReport(test,LogStatus.PASS, "Website URL", url, "<div align='right' style='float:right' class='imagesrc'><a href=" + "./../Images/Homepage.png" + ">Screenshot</a></div>");
		// Add Base
		driver.findElement(By.cssSelector("button.btn-primary:nth-child(1)")).click();
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		driver.findElement(By.id("base-name")).sendKeys(prop.getProperty("basename"));
		getscreenshot("Base_Added");
		flushReport(test, LogStatus.PASS, "Base Name ", prop.getProperty("basename"), "<div align='right' style='float:right' class='imagesrc'><a href=" + "./../Images/Base_Added.png" + ">Screenshot</a></div>");
		Thread.sleep(1000);
		driver.findElement(By.id("savebutton")).click();
		
		// Add Topings
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".nav > li:nth-child(2) > a:nth-child(1)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn-primary:nth-child(1)")).click();
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		driver.findElement(By.id("topping-name")).sendKeys(prop.getProperty("toppingname"));
		getscreenshot("Toppings_Added");
		flushReport(test,LogStatus.PASS, "Topping Name ", prop.getProperty("toppingname"), "<div align='right' style='float:right' class='imagesrc'><a href=" + "./../Images/Toppings_Added.png" + ">Screenshot</a></div>");
		Thread.sleep(1000);
		driver.findElement(By.id("savebutton")).click();
		
		//Add Pizza
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".nav > li:nth-child(3) > a:nth-child(1)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn-primary:nth-child(1)")).click();
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#pizza-name")).sendKeys(prop.getProperty("PName"));
		Select oSelect = new Select(driver.findElement(By.cssSelector("#base-name")));
		oSelect.selectByVisibleText(prop.getProperty("basename"));
		driver.findElement(By.xpath("//*[@id='pizzaModal']/div/div/div[3]/form/div[3]/div[4]/label/input")).click();
		driver.findElement(By.id("pizza-price")).sendKeys(prop.getProperty("price"));
		getscreenshot("Pizza_Added");
		flushReport(test,LogStatus.PASS, "Pizza Price ", prop.getProperty("price"), "<div align='right' style='float:right' class='imagesrc'><a href=" + "./../Images/Pizza_Added.png" + ">Screenshot</a></div>");
		Thread.sleep(1000);
		driver.findElement(By.id("savebutton")).click();
		
		//Add Order
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".nav > li:nth-child(4) > a:nth-child(1)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".col-md-6")).click();
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='orderModal']/div/div/div[3]/form/div/div/div[2]/div/div/label/input")).click();
		getscreenshot("Order_Added");
		flushReport(test, LogStatus.PASS, "Order ", "Done" , "<div align='right' style='float:right' class='imagesrc'><a href=" + "./../Images/Order_Added.png" + ">Screenshot</a></div>");
		Thread.sleep(1000);
		driver.findElement(By.id("savebutton")).click();
		extentreport.endTest(test);
		
	}
	
	
	
	
	
	

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			driver.quit();
		}
	}
}
