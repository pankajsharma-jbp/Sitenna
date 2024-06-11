package com.xotiv.sitenna.pomrepo;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SitennaLogoutPage {
	WebDriver driver;
	public SitennaLogoutPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);	
		}
	
   @FindBy(xpath = "//li[@class = 'mat-mdc-tooltip-trigger menu-li d-flex flex-row justify-content-between align-items-center']")
   private WebElement profileAvatar;
   public WebElement getprofileAvatar() {
	   return profileAvatar;
   }
   
   @FindBy(xpath = "//button[@mattooltipclass = 'tooltip-bgcolor']")
   private WebElement expandButton;
   public WebElement getexpandButton() {
	   return expandButton;
   }
   @FindBy(xpath = "//span[text() = 'Logout']")
   private WebElement logoutLink;
   public WebElement getlogoutLink() {
	   return logoutLink;
   }
   @FindBy(xpath = "//p[text()='Unauthorized access. Please login to continue']")
	private WebElement toastUnauthorizedMSG;
	public WebElement gettoastUnauthorizedMSG() {
		return toastUnauthorizedMSG;
	}
	@FindBy(id = "inbox_menu_item")
	private WebElement inboxIcon;
	public WebElement getinboxIcon() {
		return inboxIcon;
	}
	@FindBy(xpath = "//p[text()='Cannot read properties of null (reading 'user')']")  
	private WebElement toastBackAfterLogout;
	public WebElement gettoastBackAfterLogout() {
		return toastBackAfterLogout;
	}
   
}
