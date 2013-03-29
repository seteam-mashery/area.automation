package mashery.com._day_trial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

public class PortalSetup extends App {

	
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  public void setUp() throws Exception {
		    driver = new FirefoxDriver();
		    baseUrl = "https://trial1004.admin.mashery.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
	  
	  
	
	public void createService(String portalName, String userName, String password)
	{
		
		try {
			setUp();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    
	    
	    driver.get("https://secure.mashery.com/login/" + portalName + ".mashery.com/");
	    driver.findElement(By.id("handle")).clear();
	    driver.findElement(By.id("handle")).sendKeys(userName);
	    driver.findElement(By.id("passwd")).clear();
	    driver.findElement(By.id("passwd")).sendKeys(password);
	    driver.findElement(By.id("process-login")).click();
	    driver.findElement(By.linkText("Dashboard")).click();
	    
	    driver.get("http://" + portalName + ".admin.mashery.com/#tabAPIs");
	    
	    
	    	
	    //driver.findElement(By.cssSelector("a.add-service.button")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | mif-comp-1185 | ]]
	   //driver.findElement(By.cssSelector("#ext-gen38 > em.x-tab-left > span.x-tab-strip-inner > span.x-tab-strip-text.")).click();
	    
	   
	    driver.switchTo().frame("ext-gen111"); 
	   // driver.click("//id('main')/x:ul/x:li[1]/x:a");

	    driver.findElement(By.linkText("Create Service")).click();
	    
	    driver.findElement(By.id("ext-gen24")).click();
	    driver.findElement(By.id("service-endpoints-0-general-moniker")).clear();
	    driver.findElement(By.id("service-endpoints-0-general-moniker")).sendKeys("products");
	    driver.findElement(By.id("service-endpoints-0-general-hostalias")).clear();
	    driver.findElement(By.id("service-endpoints-0-general-hostalias")).sendKeys(portalName + ".trial.mashery.com");
	    driver.findElement(By.id("service-endpoints-0-general-hostname")).clear();
	    driver.findElement(By.id("service-endpoints-0-general-hostname")).sendKeys(portalName + ".trial.mashery.com");
	    driver.findElement(By.id("service-endpoints-0-general-targets")).clear();
	    driver.findElement(By.id("service-endpoints-0-general-targets")).sendKeys(portalName + ".trial.mashery.com");
	    driver.findElement(By.id("service-endpoints-0-general-in_path")).clear();
	    driver.findElement(By.id("service-endpoints-0-general-in_path")).sendKeys("/product/");
	    driver.findElement(By.id("service-endpoints-0-general-targets")).clear();
	    driver.findElement(By.id("service-endpoints-0-general-targets")).sendKeys("services.wideworldofacme.com");
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    driver.findElement(By.id("process")).click();
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
	    //Add orders
	    driver.findElement(By.id("addEndpoint")).click();
	    driver.findElement(By.cssSelector("li.standard")).click();
	    		
	    driver.findElement(By.id("service-endpoints-1-general-moniker")).clear();
	    driver.findElement(By.id("service-endpoints-1-general-moniker")).sendKeys("orders");
	    driver.findElement(By.id("service-endpoints-1-general-hostalias")).clear();
	    driver.findElement(By.id("service-endpoints-1-general-hostalias")).sendKeys(portalName + ".trial.mashery.com");
	    driver.findElement(By.id("service-endpoints-1-general-hostname")).clear();
	    driver.findElement(By.id("service-endpoints-1-general-hostname")).sendKeys(portalName + ".trial.mashery.com");
	    driver.findElement(By.id("service-endpoints-1-general-targets")).clear();
	    driver.findElement(By.id("service-endpoints-1-general-targets")).sendKeys(portalName + ".trial.mashery.com");
	    driver.findElement(By.id("service-endpoints-1-general-in_path")).clear();
	    driver.findElement(By.id("service-endpoints-1-general-in_path")).sendKeys("/order/");
	    driver.findElement(By.id("service-endpoints-1-general-targets")).clear();
	    driver.findElement(By.id("service-endpoints-1-general-targets")).sendKeys("services.wideworldofacme.com");
	    driver.findElement(By.id("process")).click();
	    
	   // driver.findElement(By.id("ext-gen104")).click();
	    driver.findElement(By.linkText("Overview"));
	    //driver.findElement(By.id("ext-gen98")).click();
	    driver.findElement(By.id("ext-gen12")).click();
	    driver.findElement(By.id("service-moniker")).clear();
	    driver.findElement(By.id("service-moniker")).sendKeys("Retail Service API");
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    driver.findElement(By.id("process")).click();
        
        try {
			tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  public void tearDown() throws Exception {
		    driver.quit();
		    
		  }
	  
	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alert.getText();
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
}
