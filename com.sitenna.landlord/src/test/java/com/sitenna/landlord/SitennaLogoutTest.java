package com.sitenna.landlord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.xotiv.sitenna.genericUtility.BaseClass;
import com.xotiv.sitenna.pomrepo.SitennaLoginPage;
import com.xotiv.sitenna.pomrepo.SitennaLogoutPage;

public class SitennaLogoutTest extends BaseClass{			
                 
	@Test(priority = 1, enabled = true)
	public void verifyTheUserCanSuccessfullyLogOutFromTheApplicationByClickingTheLogoutLink_Logout_TC_01() throws IOException, InterruptedException {

		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		SitennaLogoutPage logoutpage = new SitennaLogoutPage(driver);
		logoutpage.getexpandButton().click();
		logoutpage.getprofileAvatar().click();
		logoutpage.getlogoutLink().click();
		String expectedURL = "https://qa.sitenna.com/#/auth/signin";
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(expectedURL)) {
			System.out.println("Passed: Logout feature is verified and found correct after logout redirecting to login page");
		}
		else {
			System.out.println("Failed: Logout feature is verified and found incorrect after logout not redirectig to login page");
		}
		
	}
	
	@Test(priority = 2, enabled = true)
	public void verifyTheUserCanNotPerformAnyActionFromFirstTabIfUserHasLoggedOutFromTheSecondTabOrOtherTab_Logout_TC_02() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		Thread.sleep(2000);
		
		
		  
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://qa.sitenna.com/#/auth/signin");
		SitennaLogoutPage logoutpage = new SitennaLogoutPage(driver);
		Thread.sleep(2000);
		logoutpage.getexpandButton().click();
		logoutpage.getprofileAvatar().click();
		logoutpage.getlogoutLink().click();
		Thread.sleep(2000);
		String expectedURL = "https://qa.sitenna.com/#/auth/signin";
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(expectedURL)) {
			System.out.println("Passed: After logout driver is redirected to login page");
		}
		else {
			System.out.println("Failed: After logout driver is  not redirected to login page");
		}
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(1000);
		logoutpage.getinboxIcon().click();
		Thread.sleep(1000);
		String expectedURL1 = "https://qa.sitenna.com/#/auth/signin";
		String actualURL1 = driver.getCurrentUrl();
		if(actualURL1.equals(expectedURL1)) {
			System.out.println("Passed: After logout driver is redirected to login page");
		}
		else {
			System.out.println("Failed: After logout driver is  not redirected to login page");
		}
		Thread.sleep(1000);
		WebElement toast = logoutpage.gettoastUnauthorizedMSG();
		Thread.sleep(10);
		if(toast.getText() != null) {
			System.out.println(toast.getText());
			System.out.println("Passed: toast message is verified and found correct");
			
		}
		else {
			System.out.println("Failed: toast message is verified and found incorrect");
		}
	}
	
	
	@Test(priority = 3, enabled = true)
	public void  verifyOneUsersLogoutDoesNotAffectsTheSecondUser_Logout_TC_03() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		{
		String browser = fileUtils.readThedataFromPropertyFile("browser");
		 if (browser.equals("chrome")) {
			 driver = new FirefoxDriver();
		 }
		 else if (browser.equals("firefox")) {
			 driver = new EdgeDriver();
		}
		 else if (browser.equals("edge")) {
			 driver = new ChromeDriver();
		} driver.manage().window().maximize();
		   webDriverUtils.implicitWait(driver);
		   driver.get(fileUtils.readThedataFromPropertyFile("url"));
		 
		   driver.findElement(By.id("login_email")).sendKeys("joebloggs@mailinator.com");
			 driver.findElement(By.id("login_password")).sendKeys("Password@123");
			 driver.findElement(By.id("login_button")).click();
			 driver.findElement(By.xpath("//button[@mattooltipclass = 'tooltip-bgcolor']")).click();
			 driver.findElement(By.xpath("//li[@class = 'mat-mdc-tooltip-trigger menu-li d-flex flex-row justify-content-between align-items-center']")).click();
			 driver.findElement(By.xpath("//span[text() = 'Logout']")).click();
			 String expectedURL = "https://qa.sitenna.com/#/auth/signin";
			 String actualURL = driver.getCurrentUrl();
			 if(actualURL.equals(expectedURL)) {
				 System.out.println("Passed: different browser user is successfully logged out and land on login page");
			 }
			 else {
				 System.out.println("Failed: different browser user is unable to logged out");
			 }
			 
		}
			 
	}
	
	@Test(priority = 4, enabled = true)
	public void verifyUserCantLogInAgainFromBackArrowAfterLogginOut_Logout_TC_04() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		SitennaLogoutPage logoutpage = new SitennaLogoutPage(driver);
		logoutpage.getexpandButton().click();
		logoutpage.getprofileAvatar().click();
		logoutpage.getlogoutLink().click();
		Thread.sleep(1000);
		String expectedURL = "https://qa.sitenna.com/#/auth/signin";
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		if(actualURL.equals(expectedURL)) {
			System.out.println("Passed: Logout feature is verified and found correct after logout redirecting to login page");
		}
		else {
			System.out.println("Failed: Logout feature is verified and found incorrect after logout not redirectig to login page");
		}
		driver.navigate().back();
		String expectedURL1 = "https://qa.sitenna.com/#/auth/signin";
		String actualURL1 = driver.getCurrentUrl();
		System.out.println(actualURL);
		Thread.sleep(1000);
		if(actualURL1.equalsIgnoreCase(expectedURL1)) {
			System.out.println("Passed: After clicking on back page driver present on login page");
		}
		else {
			System.out.println("Failed: After clicking on back page driver is not present on login page");
		}
		
		

	}
}
