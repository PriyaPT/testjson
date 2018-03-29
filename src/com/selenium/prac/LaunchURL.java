package com.selenium.prac;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class LaunchURL {
	WebDriver driver;
	 WebDriverWait wait;
	@BeforeTest
  
	public LoginPage1 LaunchURLMethod()
	{
	
		
			String URL = "https://10.44.234.229:9443";
			
			 String PROXY = "hjproxy.persistent.co.in:8080";
			 Proxy proxy = new Proxy();
			 proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY) .setSocksProxy(PROXY); 
			 DesiredCapabilities cap = new DesiredCapabilities(); 
			 cap.setCapability(CapabilityType.PROXY, proxy);
			 driver = new FirefoxDriver(cap);
			driver = new FirefoxDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.navigate().to(URL);
             return new LoginPage1(driver);
			 
	}

   @AfterTest
   public void TearDown()
   {
   	driver.close();
   	driver.quit();
   }

}
