package com.selenium.prac;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {

	WebDriver driver;
	String channelName="No_Value", connectionName = "No_Value", nodeName="No_Value", vhost="No_Value",mode="No_Value";
	String messagesUnacknowledged = null, messagesUnconfirmed = null, acknowledgementsUncommited = null;
	String messagesUncommited = null, state = null,  consumerCount=null;
	int requestID = 0;
	LinkedHashMap<Integer, String[]> lnkmap = null;
	
	
	public DashBoardPage(WebDriver driver) 
	{
   this.driver = driver;
	 }

	

	public void component() {
		driver.switchTo().frame("contentframe");

		driver.findElement(
				By.cssSelector("div[class='truncation_ellipsis'][title='Test']"))
				.click();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("//*[@id='GroupNav']/div[3]/div[2]/div/table/tbody/tr/td[1]/div/div[1]"))
				.click();

		WebElement element = driver
				.findElement(By
						.xpath("//*[@id='GroupNav']/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/div/div[2]/div"));
		element.click();

		driver.findElement(
				By.cssSelector("div[class='truncation_ellipsis'][title='Rabbitmqwin2012R2:ESX4-RMQ-T-1:Z']"))
				.click();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(
				By.xpath("//*[@id='idx_layout_MoveableTabContainer_0_tablist_dijit_layout_ContentPane_31'][@class='tabLabel']")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idx_layout_MoveableTabContainer_0_tablist_dijit_layout_ContentPane_31"))).click();
				
		driver.findElement(
				By.xpath(".//*[@id='gridx_Grid_0']/div[3]/div[4]/div[1]/table/tbody/tr/td/span"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='gridx_Grid_1']/div[2]/div[2]/div[2]/table/tbody/tr/td/span"))
				.click();
		driver.findElement(By.xpath("//span[@id='dijit_form_Button_12_label']"))
				.click();
		CollectChannelData();

	}
  
	
	public void CollectChannelData() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j < 11; j++) {
				
			//colid="MSGSUNCOMM"
				String attribute = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]")).getAttribute("colid");
								
			
			
		//1
				if(attribute.equalsIgnoreCase("MSGSUNCOMM"))
				            {
				WebElement element = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));				
				WebElement element2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));	
				
				je.executeScript("arguments[0].scrollIntoView(true);",element);
				messagesUncommited = element2.getText();
				               
				         System.out.println("uncommited messages are" +messagesUncommited  );
				         System.out.println("Priya");
				          
				            }
			//2
			if(attribute.equalsIgnoreCase("STATE"))
			{
                WebElement element = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));				
				WebElement  element2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",element);
			     
				state = element2.getText();
			   System.out.println("The state of the application is " + state);
			
			}
				//3
			if(attribute.equalsIgnoreCase("CHANNELNAM"))
			{
				WebElement channaelname = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement channaelname2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",channaelname);
				channelName = channaelname2.getText();
			  System.out.println(" the channel name of the application is " + channelName);
			}
			//4
			if(attribute.equalsIgnoreCase("VHOST"))
			{
				WebElement vhostname = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement vhostname2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",vhostname);
				vhost = vhostname2.getText();
				System.out.println(" The host name is" + vhost );
			}
			//5
			if(attribute.equalsIgnoreCase("CONSUMERCO"))
			{
				WebElement cunsumercount = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement cunsumercount2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",cunsumercount);
				consumerCount = cunsumercount2.getText();
				System.out.println("The consumer count is " +consumerCount );
			
			}
			//6
			if(attribute.equalsIgnoreCase("MSGSUNACKN"))
			{
				WebElement messageunack = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement messageunack2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",messageunack);
				messagesUnacknowledged = messageunack2.getText();
				System.out.println("The no of message unacknowledged" + messagesUnacknowledged);
				
			}//7
			if(attribute.equalsIgnoreCase("MODE"))
			{
				WebElement mode1 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement mode2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",mode1);
				mode = mode2.getText();
				System.out.println("The no of message unacknowledged" + mode);
			}
			//8
			
			
			if(attribute.equalsIgnoreCase("ACKSUNCOMM"))
			{
				WebElement ack = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement ack2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",ack);
				acknowledgementsUncommited = ack2.getText();
				System.out.println("The no of message unacknowledged" + acknowledgementsUncommited);
			}
			//9
			if(attribute.equalsIgnoreCase("NODENAME"))
			{
				WebElement NODENAME = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement NODENAME2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",NODENAME);
				nodeName = NODENAME2.getText();
				System.out.println("The no of message unacknowledged" + nodeName);
			}
			//10
			if(attribute.equalsIgnoreCase("CONNECTION"))
			{
				WebElement CONNECTION = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement CONNECTION2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",CONNECTION);
				connectionName = CONNECTION2.getText();
				System.out.println("The no of message unacknowledged" + connectionName);
			}
			//11
			if(attribute.equalsIgnoreCase("MSGSUNCONF"))
			{
				WebElement MSGSUNCONF = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				WebElement MSGSUNCONF2 = driver.findElement(By.xpath("//*[@id='gridx_Grid_2']/div[3]/div[2]/div["+i+"]/table/tbody/tr/td["+j+"]"));
				je.executeScript("arguments[0].scrollIntoView(true);",MSGSUNCONF);
				messagesUnconfirmed = MSGSUNCONF2.getText();
				System.out.println("The no of message unacknowledged" + messagesUnconfirmed);
			}
			}
			requestID = requestID+1;
          String[] FJsonArray2 = new String[11];
		
			
			FJsonArray2[0] = channelName;
			FJsonArray2[1] = connectionName;
			FJsonArray2[2] = nodeName;
			FJsonArray2[3] = vhost;
			FJsonArray2[4] = state;
			FJsonArray2[5] = mode;
			FJsonArray2[6] = consumerCount;
			FJsonArray2[7] = messagesUnacknowledged;
			FJsonArray2[8] = messagesUncommited;
			FJsonArray2[9] = messagesUnconfirmed;
			FJsonArray2[10] = acknowledgementsUncommited;
			System.out.println("\n");
			LiknedhashmapCollection( FJsonArray2 , requestID);
		
		}

	}



	private void LiknedhashmapCollection(String[] FJsonArray2, int requestID) {
		// TODO Auto-generated method stub
		 lnkmap = new LinkedHashMap<Integer, String[]>();
		   lnkmap.put(requestID, FJsonArray2);
	}
}
