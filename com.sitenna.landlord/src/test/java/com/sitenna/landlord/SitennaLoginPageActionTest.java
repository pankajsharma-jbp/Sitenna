 
package com.sitenna.landlord;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.xotiv.sitenna.genericUtility.ActionsClassUtility;
import com.xotiv.sitenna.genericUtility.BaseClass;
import com.xotiv.sitenna.pomrepo.SitennaLoginPage;

public class SitennaLoginPageActionTest extends BaseClass{
	@Test(priority = 1, enabled = true)
	public void verifyLoginPage_Login_TC_01() {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://qa.sitenna.com/#/auth/signin";
		if(actualURL.equals(expectedURL)) {
			System.out.println("Passed: Sitenna Login Page URL is verified and found correct");
		}
		else {
			System.out.println("Failed: Sitenna Login Page URL is verified and found incorrect");
		}
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Sitenna";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Passed: Sitenna Page Title is verified and found correct");
		}
		else {
			System.out.println("Failed: Sitenna Page Title is verified and found incorrect");
		}
//		/* sitenna logo address */
		String pageSource = driver.getPageSource();

	     if(pageSource.contains("sitenna-asset/images/sitenna-logo.svg")) {   
		    	System.out.println("Passed: Sitenna Logo verified and found correct");
		    }
		    else {
		    	System.out.println("Failed: Sitenna Logo verified and found incorrect");
		    }
	     try {
	            // Locate the heading element
//	            WebElement headingElement = driver.findElement(By.tagName("h3")); // Adjust the locator as per your heading element

	            // Check if the heading is displayed
	            if (loginpage.getHeadingLabel().isDisplayed()) {
	                System.out.println("Passed: Heading is visible on the webpage.");
	            } else {
	                System.out.println("Failed: Heading is not visible on the webpage.");
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to verify heading visibility: " + e.getMessage());
	        }
	     try {
	           

	            // Check if the email and password text fields are displayed
	            if (loginpage.getEmailTextField().isDisplayed() && loginpage.getPasswordTextField().isDisplayed()) {
	                System.out.println("Passed: Email and password text fields are visible on the webpage.");
	            } else {
	                System.out.println("Failed: Email and password text fields are not visible on the webpage.");
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to verify text field visibility: " + e.getMessage());
	        }
	     // verify forgot password text is a link
	     try {
	            
	            if (loginpage.getForgotPassword().getTagName().equalsIgnoreCase("a")) {
	                System.out.println("Passed: The text is a link.");
	            } else {
	                System.out.println("Failed: The text is not a link.");
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to verify text/link: " + e.getMessage());
	        } 
  //      verifying forgot password colour       
         try {
             
             // Get the color property of the text element
             String color = loginpage.getForgotPassword().getCssValue("color");

             // Verify the color
             String expectedColor = "rgba(217, 74, 111, 1)"; // Example: Red color
             String expectedColorFireFox = "rgb(217, 74, 111)";
             if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
                 System.out.println("Passed: Text color is verified and found as expected: " + color);
             } else {
                 System.out.println("Failed: Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
             }
         } catch (Exception e) {
             System.out.println("Failed to verify text color: " + e.getMessage());
         }
         
         // login button disable                  
         
         try {
             // Locate the login button element
             
             if (!loginpage.getLoginButton().isEnabled()) {
                 System.out.println("Passed: Login button is disabled.");
             } else {
                 System.out.println("Failed: Login button is enabled.");
             }
         } catch (Exception e) {
             System.out.println("Failed to verify login button: " + e.getMessage());
         }
          
	}
	 
	@Test(priority = 2, enabled = true)
	 public void verifyWithoutEnteringAnyCredentials_Login_TC_02 () {
		 SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		 try {
             // Locate the login button element
             
             if (!loginpage.getLoginButton().isEnabled()) {
                 System.out.println("Passed: Login button is disabled.");
             } else {
                 System.out.println("Failed: Login button is enabled.");
             }
         } catch (Exception e) {
             System.out.println("Failed to verify login button: " + e.getMessage());
         }
     }
	
	@Test(priority = 3, enabled = true)
	public void verifyEnteringEmailIDandPasswordandThenRemoveBoth_Login_TC_03() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		
		WebElement emailTextField = loginpage.getEmailTextField();
		emailTextField.sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		WebElement passwordTextField = loginpage.getPasswordTextField();
		passwordTextField.sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		Thread.sleep(100);
		while (true) {
			emailTextField.sendKeys(Keys.BACK_SPACE);
            
            if (emailTextField.getAttribute("value").isEmpty()) {
                break;
            }
        }
		String pageSource = driver.getPageSource();
		if(pageSource.contains("Email is required")) {
			System.out.println("Passed: Email Text Field is verified and found correct with statement Email is required");
		}
		else {
			System.out.println("Failed: Email Text Field is verified and found incorrect without statement Email is required");
		}
		try {
            
            // Get the color property of the text element
            String color = loginpage.getemailIsRequired().getCssValue("color");

            // Verify the color
            String expectedColor = "rgba(220, 53, 69, 1)"; 
            String expectedColorFireFox = "rgb(220, 53, 69)";
            if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
                System.out.println("Passed: Text color is verified and found as expected: " + color);
            } else {
                System.out.println("Failed: Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
            }
        } catch (Exception e) {
            System.out.println("Failed to verify text color: " + e.getMessage());
        }
		Thread.sleep(100);
		while(true) {
			passwordTextField.sendKeys(Keys.BACK_SPACE);
			if(passwordTextField.getAttribute("value").isEmpty()){
				break;
			}
		}
		Thread.sleep(100);
		String pageSource1 = driver.getPageSource();
		if(pageSource1.contains("Password is required")) {
			System.out.println("Passed: Password Text Field is verified and found correct with statement Password is required");
		}
		else {
			System.out.println("Failed: Password Text Field is verified and found incorrect without statement Password is required");
		}
		
		try {
            
            // Get the color property of the text element
            String color = loginpage.getpasswordIsRequired().getCssValue("color");

            // Verify the color
            String expectedColor = "rgba(220, 53, 69, 1)"; 
            String expectedColorFireFox = "rgb(220, 53, 69)";
            if (color.equalsIgnoreCase(expectedColor)||color.equalsIgnoreCase(expectedColorFireFox)) {
                System.out.println("Passed: Text color is verified and found as expected: " + color);
            } else {
                System.out.println("Failed: Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
            }
        } catch (Exception e) {
            System.out.println("Failed to verify text color: " + e.getMessage());
        }
		try {
            // Locate the login button element
            
            if (!loginpage.getLoginButton().isEnabled()) {
                System.out.println("Passed: Login button is disabled.");
            } else {
                System.out.println("Failed: Login button is enabled.");
            }
        } catch (Exception e) {
            System.out.println("Failed to verify login button: " + e.getMessage());
        }
  }
	@Test(priority = 4, enabled = true)
	public void verifyEnteringRandomEmailIdWhichIsNotRegistered_Login_TC_04() throws EncryptedDocumentException, IOException, InterruptedException{
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(excelUtils.readTheString("Login", 1, 1));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		WebElement toast = loginpage.gettoastInvalidMessage();
		Thread.sleep(10);
		if(toast.getText() != null) {
			System.out.println(toast.getText());
			System.out.println("Passed: toast message is verified and found correct");
			
		}
		else {
			System.out.println("Failed: toast message is verified and found incorrect");
		}
	}
	@Test(priority = 5, enabled = true)
	public void verifyEnteringInvalidEmailIDnotInProperFormat_Login_TC_05() throws EncryptedDocumentException, IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(excelUtils.readTheString("Login", 2, 1));
		Thread.sleep(2000);
		String pageSource = driver.getPageSource();
		if(pageSource.contains("Email must be a valid email address")) {
			System.out.println("Passed: Email Text Field is verified with invalid email Address ");
		}
		else {
			System.out.println("Failed: Email Text Field is verified and found incorrect ");
		}
		// colour
        try {
            
            // Get the color property of the text element
            String color = loginpage.getemailMustBeAValidEmailID().getCssValue("color");

            // Verify the color
            String expectedColor = "rgba(220, 53, 69, 1)"; 
            String expectedColorFireFox = "rgb(220, 53, 69)";
            if (color.equalsIgnoreCase(expectedColor)||color.equalsIgnoreCase(expectedColorFireFox)) {
                System.out.println("Passed: Text color is verified and found as expected: " + color);
            } else {
                System.out.println("Failed: Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
            }
        } catch (Exception e) {
            System.out.println("Failed to verify text color: " + e.getMessage());
        }
		
	}
	@Test(priority = 6, enabled = true)
	public void verifyEnteringInvalidPasswordWherePasswordSatisfyingpasswordPolicyButIncorrect_Login_TC_06() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(excelUtils.readTheString("Login", 3, 1));
		loginpage.getLoginButton().click();
		WebElement toast = loginpage.gettoastInvalidMessage();
		Thread.sleep(10);
		
		if(toast.getText() != null) {
			
			System.out.println(toast.getText());
			System.out.println("Passed: toast message is verified and found correct");
			
		}
		else {
			System.out.println("Failed: toast message is verified and found incorrect");
		}
	}
	@Test(priority = 7, enabled = true)
	public void verifyEnteringInvalidPasswordNotSafisfyingPasswordPolicy_Login_TC_07() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(excelUtils.readTheString("Login", 4, 1));
		try {
            // Locate the login button element
            
            if (!loginpage.getLoginButton().isEnabled()) {
                System.out.println("Passed: Login button is disabled.");
            } else {
                System.out.println("Failed: Login button is enabled.");
            }
        } catch (Exception e) {
            System.out.println("Failed to verify login button: " + e.getMessage());
        }
		
	}
	@Test(priority = 8, enabled = true)
	public void verifyIfUserTypesTheValidEmailIdInTheEmailTextField_Login_TC_08() throws IOException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		String pageSource = driver.getPageSource();
		if(pageSource.contains("Email must be a valid email address")) {
			System.out.println("Failed: Email Text Field contains error message with valid email id");
		}
		else {
			System.out.println("Passed: Email Text Field contains no any error message with valid email id");
			
		}
	}
	
	@Test(priority = 9, enabled = true)
	public void verifyIfUserTypesTheValidEmailIdAndPasswordInBothEmailAndPasswordTextFields_Login_TC_09() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		String pageSource = driver.getPageSource();
		if(pageSource.contains("Email must be a valid email address")) {
			System.out.println("Failed: Email Text Field contains error message with valid email id");
		}
		else {
			System.out.println("Passed: Email Text Field contains no any error message with valid email id");
			
		}
		if(loginpage.getLoginButton().isEnabled()) {
			System.out.println("Passed: Login button is Enabled after entering both email and password");
		}
		else {
			System.out.println("Failed: Login button is disabled after entering both email and password");
		}
		
		loginpage.getLoginButton().click();
		Thread.sleep(3000);
		
		WebElement toast = loginpage.gettoastLoginSuccessful();
		Thread.sleep(10);
		
		if(toast.getText() != null) {
			
			System.out.println(toast.getText());
			System.out.println("Passed: toast message is verified and found correct");
			
		}
		else {
			System.out.println("Failed: toast message is verified and found incorrect");
		}
		String expectedURL = "https://qa.sitenna.com/#/home/dashboard";
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equalsIgnoreCase(expectedURL)) {
			System.out.println("Passed: Sitenna Dashboard Page is verified and found correct");
		}
		else {
			System.out.println("Failed: Sitenna Dashboard Page is verified and found incorrect");
		}
		
	}
	
	@Test(priority = 10, enabled = true)
	public void verifyIfUserTypesInThePasswordThenEyeIconIsVisible_Login_TC_10() throws EncryptedDocumentException, IOException, InterruptedException {
	    SitennaLoginPage loginpage = new SitennaLoginPage(driver);
	    loginpage.getPasswordTextField().sendKeys(excelUtils.readTheString("Login", 5, 1));
	    if(loginpage.getEyeIcon().isDisplayed()) {
	    	System.out.println("Passed: eye icon is displaying in password text field");
	    }
	    else {
	    	System.out.println("Failed: eye icon is not displaying in password text field");
	    }
	    String fieldType = loginpage.getPasswordTextField().getAttribute("type");

        // Check if the type attribute is "password"
        if (fieldType.equals("password")) {
            System.out.println("Passed: Password is hidden in the password text field.");
        } else {
            System.out.println("Failed: Password is not hidden in the password text field.");
        }
	}
	@Test(priority = 11, enabled = true)
	public void verifyIfUserClicksOnTheEyeIconInThePasswordInputField_Login_TC_11() throws IOException, InterruptedException {
		 SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		 loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		 loginpage.getEyeIcon().click();
		 String passwordValue = loginpage.getPasswordTextField().getAttribute("value");
	        if (!passwordValue.isEmpty()) {
	            System.out.println("Passed: Password is visible in the password text field.");
	        } else {
	            System.out.println("Failed: Password is not visible in the password text field.");
	        }
	}
	@Test(priority=12, enabled = true)
	public void verifyIfUserClicksOnTheEyeIconTwice_Login_TC_12 () throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
//		Thread.sleep(2000);
		loginpage.getEyeIcon().click();
//		Thread.sleep(2000);
//		String enteredEmailData = loginpage.getPasswordTextField().getAttribute("value");

        if (loginpage.getPasswordTextField().getAttribute("value").equals(fileUtils.readThedataFromPropertyFile("password"))) {
            System.out.println("Passed: Password data entered successfully and visible to UI ----- " + loginpage.getPasswordTextField().getAttribute("value"));
        } else {
            System.out.println("Failed: Password is not visible to UI");
        }
        loginpage.geteyeIconVisible().click();
//        Thread.sleep(2000);       
        if (loginpage.getPasswordTextField().getAttribute("type").equals("password")) {
            System.out.println("Passed: Entered password is hidden.");
        } else {
            System.out.println("Failed: entered is not hidden.");
        }
	}
	@Test(priority = 13, enabled = true)
	public void verifyIfUserTriesToLogInWithTheEmailID_Username_forThatInviteUserProcessHasNotBeenCompleted_Login_TC_13() throws EncryptedDocumentException, IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(excelUtils.readTheString("Login", 6, 1));
		loginpage.getPasswordTextField().sendKeys(excelUtils.readTheString("Login", 7, 1));
		loginpage.getLoginButton().click();
		
//		Thread.sleep(10);
		
		WebElement toast = loginpage.gettoastUserIsNotActive();
//		Thread.sleep(10);
		
		if(toast.getText() != null) {
			System.out.println(toast.getText());
			System.out.println("Passed: toast message is verified and found correct");
		}
		else {
			System.out.println("Failed: toast message is verified and found incorrect");
		}
	} 
	
	@Test(priority = 14, enabled = true)
	public void verifyIfUserTryToLogInWithTheDeletedOrArchivedEmailId_username_ThenUserShouldNotBeAbleLogIN_Login_TC_14() throws EncryptedDocumentException, IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(excelUtils.readTheString("Login", 8, 1));
		loginpage.getPasswordTextField().sendKeys(excelUtils.readTheString("Login", 9, 1));
		loginpage.getLoginButton().click();
//		actions.doubleClick(loginpage.getLoginButton());
		
		WebElement toast = loginpage.gettoastUserHasBeenRemoved();
//		Thread.sleep(10);
		
		if(toast.getText() != null) {
			System.out.println(toast.getText());
			System.out.println("Passed: toast message is verified and found correct");
		}
		else {
			System.out.println("Failed: toast message is verified and found incorrect");
		}
		Thread.sleep(3000);
		
	}
	
	
	
//	@Test(priority = 1, enabled = true)   
//	public void verifyTheSitennaLogoPresentOnLoginPage_TC_0001() {
//		
//		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
//		
//	     String pageSource = driver.getPageSource();
//	     
//	     if(pageSource.contains("sitenna-asset/images/sitenna-logo.svg")) {
//		    	System.out.println("Passed: Sitenna Logo verified and found correct");
//		    }
//		    else {
//		    	System.out.println("Failed: Sitenna Logo verified and found incorrect");
//		    }
//	     if(loginpage.getSitennaLogo().isDisplayed()) {
//	    	 System.out.println("Passed: Image is present on the webpage.");
//	     }
//	      else {
//	            System.out.println("Failed: Image is not present on the webpage.");
//	        }
//	     
//	     String expectedURL = "https://qa.sitenna.com/#/auth/signin";
//	     String actualURL = driver.getCurrentUrl();
//	     if(expectedURL.equals(actualURL)) {
//	    	 System.out.println("Passed :Sitenn currenct url is verified and found correct");
//	     }
//	     else {
//	    	 System.out.println("Failed :Sitenna current url is verified and found incorrect");
//	    	 
//	     }
//	     
//	     
//	}
//	@Test(priority = 2, enabled = true)
//	public void verifyPageTitleShouldBeSitenna_TC_0002() {
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		String expectedTitle = "Sitenna";
//		String actualTitle = driver.getTitle();
//		if(expectedTitle.equals(actualTitle)) {
//			System.out.println("Passed: Sitenna Page Title Verified and found Correct");
//		}
//		else {
//			System.out.println("Failed: Sitenna Page Title Verified and found Incorrect");
//		}
//	}
//	
//	@Test(priority = 3, enabled = true)
//	public void verifyTheLogInButtonShouldNotBeEnableIfBothTextFieldsAreEmpty_TC_0003 () throws InterruptedException, IOException {
//		
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		
//		loginPage.getEmailTextField().clear();
//		
//		loginPage.getPasswordTextField().clear();
//		
//		if(loginPage.getLoginButton().isEnabled()) {
//			
//			System.out.println("Failed : Login button is enabled");
//		}
//	     
//		else {
//	            System.out.println("Passed : Login button is disabled");
//	        }	
//	}
//	
//	@Test(priority = 4, enabled = true)
//	 public void verifyIfUserFillsOnlyEmailID_onlyThenLogInButtonShouldNotEnable_TC_0004() throws IOException {
//		
//		 SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		 
//		 loginPage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
//
//		 
//		 if(loginPage.getLoginButton().isEnabled()) {
//				System.out.println("Failed : Login button is enabled");
//			}
//		     
//			else {
//		            System.out.println("Passed : Login button is disabled");
//		        }
//		 
//	 }
//	
//	@Test (priority = 5, enabled = true)
//	public void verifyIfUserTypesPasswordOnlyThenLogINButtonShouldNotBeEnabled_Login_TC_0005() throws IOException {
//		
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		
//		loginPage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
//		
//		if(loginPage.getLoginButton().isEnabled()) {
//			System.out.println("Failed : Login button is enabled");
//		}
//	     
//		else {
//	            System.out.println("Passed : Login button is disabled");
//	        }
//		
//	}
//	
//	@Test(priority = 6, enabled = true)
//	public void verifyIfUserTypesTheValidEmailIDinTheEmailTextField_TC_0006() throws IOException {
//		
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		
//		loginPage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
//		String pageSource = driver.getPageSource();
//		if(pageSource.contains("Email must be a valid email address")) {
//			System.out.println("Failed: Email Text Field is accepting Invalid email id");
//		}
//		else{
//			System.out.println("Passed: Email Text Field is accepting valid email id");
//			
//		}	
//	}
//	
//	@Test(priority = 7, enabled = true)
//	public void verifyIfUserTypesTheValidPasswordInThePasswordTextField_TC_0007() throws IOException {
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		loginPage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
//		String pageSource = driver.getPageSource();
//		if(pageSource.contains("Password must be a valid password")) {
//			System.out.println("Failed: Password Text Field is accepting Invalid password");
//		}
//		else {
//			System.out.println("Passed: Password Text Field is accepting valid password only");
//		}
//				
//	}
//	@Test(priority = 8, enabled = true)
//	public void verifyIfUserTypesTheValidEmailIdAndPasswordInBothTextField() throws IOException {
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		loginPage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
//		loginPage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
//		loginPage.getLoginButton().click();
//	}
//	
//	
//	
//	@Test(priority = 8, enabled = true)   // start to check from here
//	public void verifyIfUserTypesTheValidEmailIdAndPasswordInBothTextFiel() throws IOException, InterruptedException {
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		WebElement emailTextField = loginPage.getEmailTextField();
//		emailTextField.sendKeys(fileUtils.readThedataFromPropertyFile("username"));
//		Thread.sleep(100);
//		while (true) {
//			emailTextField.sendKeys(Keys.BACK_SPACE);
//            
//            if (emailTextField.getAttribute("value").isEmpty()) {
//                break;
//            }
//        }
//		String pageSource = driver.getPageSource();
//		if(pageSource.contains("Email is required")) {
//			System.out.println("Passed: Email Text Field is verified and found correct");
//		}
//		else {
//			System.out.println("Failed: Email Text Field is verified and found incorrect");
//		}
//	}
//	@Test(priority = 9, enabled = true)
//	public void verifyIfUserTypesInThePasswordTextFieldThenEyeIconIsEnabled() throws IOException, InterruptedException {
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		loginPage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
//		System.out.println("Passed: Is Eye Icon Displayed: " + loginPage.getEyeIcon().isDisplayed());
//        System.out.println("Passed: Is Eye Icon Clickable: " + loginPage.getEyeIcon().isEnabled());
//        
//	}
//	
//	@Test(priority = 10, enabled = true)
//	public void verifyTheEyeIconShouldBeEnabledAndPasswordShouldBeHidden() throws IOException, InterruptedException {
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		WebElement passwordTextField = loginPage.getPasswordTextField();
//		passwordTextField.sendKeys(fileUtils.readThedataFromPropertyFile("password"));
//		String typeAttributeValue = passwordTextField.getAttribute("type");
//
//        
//        if (typeAttributeValue != null && typeAttributeValue.equalsIgnoreCase("password")) {
//            System.out.println("Passed: Password Text field contains password attribute.");
//        } else {
//            System.out.println("Failed: Password Text field does not contain password attribute.");
//        }
//       
//	}
//	
//	@Test(priority = 11, enabled = true)
//	public void verifyIfUserClicksOnTheEyeIconToSeeThePasswordThenUserShouldBeAbleToSeeTheWrittenPassword() throws IOException, InterruptedException {
//		SitennaLoginPage loginPage = new SitennaLoginPage(driver);
//		WebElement passwordTextField = loginPage.getPasswordTextField();
//		passwordTextField.sendKeys(fileUtils.readThedataFromPropertyFile("password"));
//		Thread.sleep(1000);
//		String enteredPassword = passwordTextField.getAttribute("value");
//        if (!enteredPassword.isEmpty()) {
//            System.out.println("Passed: Entered password is visible in the user interface " + enteredPassword);
//        } else {
//            System.out.println("Failed: Entered password is not visible in the user interface");
//        }
//		
//	}
	
	
	
//	@Test(priority = 13, enabled = false)
//	public void verifyIfUserClicksOnTheEyeIconAgainToHideThePasswordThenUserShouldBeABleToHideTheWrittenPassword() throws IOException, InterruptedException {
//	SitennaLoginPage loginPage	= new SitennaLoginPage(driver);
//	loginPage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
//	   
//	WebElement ab = loginPage.getEyeIcon();
//	
//	
//	Thread.sleep(2000);
//	Actions actions = new Actions(driver);
//	actions.doubleClick(ab);
//	Thread.sleep(2000);
//	}
	
	

}
