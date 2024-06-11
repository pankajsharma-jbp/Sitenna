package com.xotiv.sitenna.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SitennaForgotPasswordPage {
	WebDriver driver;
	public SitennaForgotPasswordPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);	
		}
	
	@FindBy(xpath = "//a[text()='Forgot Password?']")
	private WebElement forgotPasswordLink;
	public WebElement getForgotPassword() {
		return forgotPasswordLink;
	}
	
	@FindBy(tagName = "h2")
	private WebElement headingLabel;
	public WebElement getHeadingLabel() {
		return headingLabel;
	}
	
	@FindBy(id = "reset_password_email")
	private WebElement resetpasswordemail;
	public WebElement getresetpasswordemail() {
		return resetpasswordemail;
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Reset Password ')]")
	private WebElement resetPasswordButton;
	public WebElement getresetPasswordButton() {
		return resetPasswordButton;
	}
	
	@FindBy(xpath = "//a[text() = 'Sign in']")
	private WebElement signInLink;
	public WebElement getsignInLink() {
		return signInLink;
	}
	
	@FindBy(xpath = "//p[text()='Correct email is mandatory.']")
	private WebElement toastInvalidMsg;
	public WebElement gettoastInvalidMsg() {
		return toastInvalidMsg;
	}
	
	@FindBy(xpath = "//div[text() = 'Email is required']")
	private WebElement emailIsRequired;
	public WebElement getemailIsRequired() {
		return emailIsRequired;
	}
	
	@FindBy(xpath = "//p[text()='Please check mail for reset password']")   
	private WebElement toastMailForResetPassword;
	public WebElement gettoastMailForResetPassword() {
		return toastMailForResetPassword;
	}
	
	@FindBy(id = "search")
	private WebElement mailinatorSearch;
	public WebElement getmailinatorSearch() {
		return mailinatorSearch;
	}
	
	@FindBy(xpath = "//button[text() = 'GO']")
	private WebElement goButton;
	public WebElement getGoButton() {
		return goButton;
	}
	
	@FindBy(xpath = "//a[@href = 'inboxes.jsp']")                   
	private WebElement mailinatorPublicInboxes;
	public WebElement getmailinatorPublicInboxes() {
		return mailinatorPublicInboxes;
	}
	
	@FindBy(xpath = "//td[contains(text(), 'admin@sitenna.com')]")
	private WebElement emailSender;
	public WebElement getemailSender() {
		return emailSender;
	}
	
	@FindBy(xpath = "//td[contains(text(), 'Reset Password.')]")
	private WebElement emailSubject;
	public WebElement getemailSubject() {
		return emailSubject;
	}
	
	@FindBy(xpath = "//td[contains(text(), 'just now')]")
	private WebElement emailJustNowTime;
	public WebElement getemailJustNowTime() {
		return emailJustNowTime;
	}
	
	@FindBy(xpath = "//a[contains(text(), 'Create New Password')]")    
	private WebElement createNewPasswordButton;
	public WebElement getcreateNewPasswordButton() {
		return createNewPasswordButton;
	}
	
	@FindBy(xpath = "//h3[text() = 'Create New Password']")
	private WebElement labelCreateNewPassword;
	public WebElement getlabelCreateNewPassword() {
		return labelCreateNewPassword;
	}
	
	@FindBy(id = "new_password")   
	private WebElement createNewPassword;
	public WebElement getcreateNewPassword() {
		return createNewPassword;
	}
	
	@FindBy(id = "repeat_new_password")
	private WebElement repeatNewPassword;
	public WebElement getrepeatNewPassword() {
		return repeatNewPassword;
	}
	
	@FindBy(xpath = "//label[text() = 'Minimum of 12 characters, with upper and lowercase, number and a symbol']")
	private WebElement passwordPolicy;
	public WebElement getpasswordPolicy() {
		return passwordPolicy;
	}
	@FindBy(xpath = "//span[@class = 'mat-mdc-button-persistent-ripple mdc-button__ripple']")
	private WebElement continueButton;
	public WebElement getcontinueButton() {
		return continueButton;
	}
	@FindBy(xpath = "//p[text()='Check all data is correct and the passwords match the minimum requirements for a strong password']")   
	private WebElement toastmsgforCorrectDataAndPasswordPolicy;
	public WebElement gettoastmsgforCorrectDataAndPasswordPolicy() {
		return toastmsgforCorrectDataAndPasswordPolicy;
	}
	
	@FindBy(xpath = "//span[text() = ' Continue ']")
	private WebElement continuebutton1;
	public WebElement getcontinuebutton1() {
		return continuebutton1;
	}
	
	@FindBy(xpath = "//p[text()='Check all data is correct and the passwords match the minimum requirements for a strong password']")
	private WebElement toastmsgforResetPasswordMismatch;
	public WebElement gettoastmsgforResetPasswordMismatch() {
		return toastmsgforResetPasswordMismatch;
	}
	@FindBy(xpath = "//p[text()='Password reset successfully.']")
	private WebElement toastmsgforPasswordResetSuccessfully;
	public WebElement gettoastmsgforPasswordResetSuccessfully() {
		return toastmsgforPasswordResetSuccessfully;
	}
	@FindBy(id = "login_email")
	private WebElement loginEmailTextField;
	public WebElement getloginEmailTextField() {
		return loginEmailTextField;
	}
	@FindBy(id = "login_password")
	private WebElement loginPasswordTextField;
	public WebElement getloginPasswordTextField() {
		return loginPasswordTextField;
	}
	@FindBy(xpath = "//span[contains(text(), 'Log In ')]")
	private WebElement loginButton;
	public WebElement getloginButton() {
		return loginButton;
	}
	
	@FindBy(xpath = "//p[text()='login successful']")
	private WebElement toastmsgforLoginSuccessful;
	public WebElement gettoastmsgforLoginSuccessful() {
		return toastmsgforLoginSuccessful;
	}
	@FindBy(id = "inbox_specified")
	private WebElement mailinatorEmptyInbox;
	public WebElement getmailinatorEmptyInbox() {
		return mailinatorEmptyInbox;
	}
	@FindBy(id = "inbox_field")
	private WebElement mailinatorUserReTextField;
	public WebElement getmailinatorUserReTextField() {
		return mailinatorUserReTextField;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}