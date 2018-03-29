package com.selenium.prac;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Channel {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://10.44.234.229:9443/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testChannel() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("j_username")).clear();
    driver.findElement(By.id("j_username")).sendKeys("apmadmin");
    driver.findElement(By.id("j_password")).clear();
    driver.findElement(By.id("j_password")).sendKeys("apmpass");
    driver.findElement(By.name("action")).click();
    System.out.println(driver.getTitle());
  
    
   
   
  assertEquals(driver.getTitle().toString(), "IBM Performance Management");  
  driver.switchTo().frame(driver.findElement(By.id("contentframe")));
  
  driver.findElement(By.xpath("//span[contains(@class,'navFolderIcon perfFolderIcon')]")).click();
    driver.findElement(By.linkText("Application Performance Dashboard")).click();
    driver.findElement(By.xpath("//div[@id='ApplicationNav']/div[3]/div[2]/div[3]/table/tbody/tr/td/div/div[2]/div")).click();
    driver.findElement(By.xpath("//div[@id='GroupNav']/div[3]/div[2]/div/table/tbody/tr/td/div/div")).click();
    driver.findElement(By.xpath("//div[@id='GroupNav']/div[3]/div[2]/div[9]/table/tbody/tr/td/div/div[2]/div")).click();
    driver.findElement(By.id("idx_layout_MoveableTabContainer_0_tablist_dijit_layout_ContentPane_31")).click();
    driver.findElement(By.xpath("(//input[@value=''])[29]")).click();
  }

}

