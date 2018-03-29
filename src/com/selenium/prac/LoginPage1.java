package com.selenium.prac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class LoginPage1 {
	WebDriver driver;
	
	
	public LoginPage1(WebDriver driver) {
		
	this.driver = driver;

   
	}
    
	
	public HomPage TakeUSERPWD() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("j_username")).sendKeys("apmadmin");
		
	    driver.findElement(By.id("j_password")).sendKeys("apmpass");
	 
	    WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("action"))).click();
	System.out.println( driver.getTitle());
	
	return new HomPage(driver);

}
}
