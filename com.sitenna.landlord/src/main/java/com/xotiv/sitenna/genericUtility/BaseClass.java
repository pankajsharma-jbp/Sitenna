package com.xotiv.sitenna.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {
	
   public static WebDriver driver;

   public static WebDriverUtility webDriverUtils = new WebDriverUtility();
   public static FileUtility fileUtils = new  FileUtility();
   public static ExcelUtility excelUtils = new ExcelUtility();

   
   
//   public static Actions actions;
//   public static void setUp() {
//       actions = new Actions(driver);
//   }
//
//
//   public void doubleClick(WebElement element) {
//       actions.doubleClick(element).perform();
//   }
//   
//   public void click(WebElement element) {
//	   actions.click(element).perform();
//   }
   

  @BeforeMethod
 
    public void preCondition() throws IOException {
	  
	   String browser = fileUtils.readThedataFromPropertyFile("browser");
	   if (browser.equals("chrome")) {
		driver = new ChromeDriver();
	}
	   else if(browser.equals("edge")){
		   driver = new EdgeDriver();
	   }
	   else if(browser.equals("firefox")) {
           driver = new FirefoxDriver();
           
       }
	   else if(browser.equals("safari")) {
		   driver = new SafariDriver();
	   }
	   
	   driver.manage().window().maximize();
	   webDriverUtils.implicitWait(driver);
	   driver.get(fileUtils.readThedataFromPropertyFile("url"));
   }
   
     @AfterMethod
   public void postCondition()  {
    	
	   driver.manage().window().minimize();
	   driver.quit();
   }
     

   

}
