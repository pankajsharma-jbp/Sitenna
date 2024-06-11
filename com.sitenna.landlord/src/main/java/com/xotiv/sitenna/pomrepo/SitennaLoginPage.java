package com.xotiv.sitenna.pomrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SitennaLoginPage {
	WebDriver driver;
	public SitennaLoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
		
	}
	@FindBy(id = "login_email")
	private WebElement emailTextField;
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	
	
	@FindBy(id = "login_password")
	private WebElement passwordTextField;
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	@FindBy(id = "login_button")
	private WebElement loginButton;
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	@FindBy(xpath = "//img[@src = 'https://sitenna-public-downloads.s3.eu-west-2.amazonaws.com/sitenna-asset/images/sitenna-logo.svg']")
	private WebElement sitennaLogo;
	public WebElement getSitennaLogo() {
		return sitennaLogo;
	}
	
	@FindBy(xpath = "//i[@class = 'fa icon-eye fa-eye-slash']")
	private WebElement eyeIcon;
	public WebElement getEyeIcon() {
		return eyeIcon;
	}
	@FindBy(xpath = "//i[contains(@class, 'fa icon-eye fa-eye')]")
	private WebElement eyeIconVisible;
	public WebElement geteyeIconVisible() {
		return eyeIconVisible;
	}
	
	@FindBy(tagName = "h3")
	private WebElement headingLabel;
	public WebElement getHeadingLabel() {
		return headingLabel;
	}
	@FindBy(linkText = "Forgot Password?")
	private WebElement forgotPassword;
	public WebElement getForgotPassword() {
		return forgotPassword;
	}
	@FindBy(xpath = "//div[text() = 'Email is required']")
	private WebElement emailIsRequired;
	public WebElement getemailIsRequired() {
		return emailIsRequired;
	}
	@FindBy(xpath = "//div[text() = 'Password is required']")
	private WebElement passwordIsRequired;
	public WebElement getpasswordIsRequired() {
		return passwordIsRequired;
	}
	
	@FindBy(xpath = "//p[text()='Invalid user login attempt.']")   
	private WebElement toastInvalidMessage;
	public WebElement gettoastInvalidMessage() {
		return toastInvalidMessage;
	}
	@FindBy(xpath = "//div[text() = 'Email must be a valid email address']")
	private WebElement emailMustBeAValidEmailID;
	public WebElement getemailMustBeAValidEmailID() {
		return emailMustBeAValidEmailID;
	}
	@FindBy(xpath = "//p[text()='login successful']")
	private WebElement toastLoginSuccessful;
	public WebElement gettoastLoginSuccessful() {
		return toastLoginSuccessful;
	}
	@FindBy(xpath = "//p[text()='User is not active.']")
	private WebElement toastUserIsNotActive;
	public WebElement gettoastUserIsNotActive() {
		return toastUserIsNotActive;
	}
	@FindBy(xpath = "//p[text()='User has been removed']")
	private WebElement toastUserHasBeenRemoved;
	public WebElement gettoastUserHasBeenRemoved() {
		return toastUserHasBeenRemoved;
	}
	
	
	

	
}
