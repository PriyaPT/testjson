import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LaunchURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = null ;
		String PROXY = "hjproxy.persistent.co.in:8080";
		 Proxy proxy = new Proxy();
		 proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY) .setSocksProxy(PROXY); 
		 DesiredCapabilities cap = new DesiredCapabilities(); 
		 cap.setCapability(CapabilityType.PROXY, proxy);
		 driver = new FirefoxDriver(cap);
		 
		 driver.get("https://10.44.234.229:9443");
		 WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("action"))).click();
		
	System.out.println(" i am in launch page");
		 driver.close();
		 //driver.quit();
	}

}
