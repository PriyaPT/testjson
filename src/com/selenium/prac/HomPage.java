package com.selenium.prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomPage {

	
WebDriver driver;
	String str;
	
 public HomPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	 this.driver = driver;
	}

public DashBoardPage HomPageClickDashBoard() 
 { 
  
    try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='perfFolderId']/span")));
	
	
	WebElement element = driver.findElement(By.xpath("//div[@id='perfFolderId']/span"));
	 
	element.click();
	
	WebElement element2 = driver.findElement(By.linkText("Application Performance Dashboard"));
	 element2.click();

  return new DashBoardPage(driver);
    	

}
}