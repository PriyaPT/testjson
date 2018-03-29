package com.selenium.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class practestOED {

	//public static ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "http://10.80.39.217:1010/dashboardTool/html/dashboard.jsp";
		// To check login sucessfull
		
		WebDriver driver ;
		 String PROXY = "ptproxy.persistent.co.in:8080";
		Proxy proxy = new Proxy();
		 proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY) .setSocksProxy(PROXY); 
		 DesiredCapabilities cap = new DesiredCapabilities(); 
		 cap.setCapability(CapabilityType.PROXY, proxy);
		 
		 driver = new FirefoxDriver(cap);
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(URL);
		 driver.findElement( By.xpath(".//*[@id='username']")).sendKeys("smadmin");
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("smadmin");
			driver.findElement(By.xpath(".//*[@id='frm-login']/button")).click();
		 
		 //To check verify Title page
		 String title = "Dashboard";
		 
		String ActulaTitle = driver.getTitle();
		System.out.println(" The actual tile is" +  "\t" +ActulaTitle );
	   
	   // To check page heading
	   
	   /*String Heading = "Dashboard Designer";
	   
	    String ActualHeading = driver.findElement(By.xpath(".//*[@id='header']/div/nav/div[1]/a/span")).getText();
	
	   Assert.assertEquals(ActualHeading,Heading);
	   System.out.println(" Assertion pass");*/
	   
	   //Verify all the menu item of the dashboard page
	List<String> MenuItemlist = Arrays.asList("Templates","Charts","Custom Widgets","Filters","Data Definitions","Dashboards","Menu Access","Roles & Users");
	List<WebElement> ActulMenuList =  new ArrayList<WebElement>();
	
	 for(int i=1;i<=8;i++)
	 {
	
		WebElement element =  driver.findElement(By.xpath("//*[@id='toolbar-menu']/li["+i+"]/a/span"));
		
		System.out.println(element.getText());
		ActulMenuList.add(element);
		//System.out.println(ActulMenuList.size());
	}
	  
	 /*if(ActulMenuList.containsAll(MenuItemlist))
	 {
		 System.out.println(" All the lements are present");
		 
	 }
	 else
	 {
	 System.out.println(" All menu item element are not present");
	 }
 */
	 
	 
		//To verify submenu items

	/* for(int i=1;i<=8;i++)
	 {
	
		WebElement element =  driver.findElement(By.xpath("//*[@id='toolbar-menu']/li["+i+"]/a/span"));
		if(element.equals("Templates"))
		{
			element.click();
			for(int j=1;j<=2;j++)
			{
			driver.findElement(By.xpath("//*[@id='dropdown-templates']/li["+j+"]/div[1]/a"));
			
			}*/
		
	
	 
		
		driver.close();
		driver.quit();
	
	 
	 }
	

	

}
