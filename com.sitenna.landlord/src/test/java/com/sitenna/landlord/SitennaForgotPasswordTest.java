package com.sitenna.landlord;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xotiv.sitenna.genericUtility.BaseClass;
import com.xotiv.sitenna.pomrepo.SitennaForgotPasswordPage;
import com.xotiv.sitenna.pomrepo.SitennaLoginPage;

public class SitennaForgotPasswordTest extends BaseClass{
	
	
 
	@Test(priority = 1, enabled = true)
	public void verifyTheForgotPasswordLinkOnTheLoginPage_ForgotPassword_TC_01() {
		
		SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
		try {
            
            // Get the color property of the text element
            String color = forgotpassword.getForgotPassword().getCssValue("color");

            // Verify the color
            String expectedColor = "rgba(217, 74, 111, 1)"; // Example: Red color
            String expectedColorFireFox = "rgb(217, 74, 111)";
            if (color.equalsIgnoreCase(expectedColor) || color.equalsIgnoreCase(expectedColorFireFox)) {
                System.out.println("Passed: Text color is verified and found as expected: " + color);
            } else {
                System.out.println("Failed: Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
            }
        } catch (Exception e) {
            System.out.println("Failed to verify text color: " + e.getMessage());
        }
		
		if (forgotpassword.getForgotPassword().isEnabled()) {
           
//            forgotpassword.getForgotPassword().click();
            
            System.out.println("Passed: Link is clickable.");
            // Optionally, you can click the link
            
        } else {
            System.out.println("Failed: Link is not clickable.");
        }
		forgotpassword.getForgotPassword().click();
		String expectedURL = "https://qa.sitenna.com/#/auth/forgot-password";
	    String actualUL	= driver.getCurrentUrl();
		if(actualUL.equals(expectedURL)) {
			System.out.println("Passed: After clicking of forgot password page link is verified and found correct");
		}
		
		else {
			System.out.println("Failed: After clicking of forgot password page link is verified and found incorrect");
		}
	
	}
	@Test(priority = 2, enabled = true)
	public void verifyTheResetNewPasswordPage_ForgotPassword_TC_02() throws InterruptedException {
        SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
        forgotpassword.getForgotPassword().click();
        String expectedURL = "https://qa.sitenna.com/#/auth/forgot-password";
        String actualURL= driver.getCurrentUrl();
        if(actualURL.equals(expectedURL)) {
        	System.out.println("Passed: Reset Your Password page URL is verified and found correct");
        }
        else {
        	System.out.println("Failed: Reset Your Password page URL is verified and found incorrect");
        }
        String pageSource = driver.getPageSource();

	     if(pageSource.contains("sitenna-asset/images/sitenna-logo.svg")) {   
		    	System.out.println("Passed: Sitenna Logo verified and found correct");
		    }
		    else {
		    	System.out.println("Failed: Sitenna Logo verified and found incorrect");
		    }
	     /////////////////////////////////////////////////////////////////////////////////
	     try {
	            // Locate the heading element

	            if (forgotpassword.getHeadingLabel().isDisplayed()) {
	                System.out.println("Passed: Heading is visible on the webpage.");
	            } else {
	                System.out.println("Failed: Heading is not visible on the webpage.");
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to verify heading visibility: " + e.getMessage());
	        }

	        // Check if the email text field is displayed
	        if (forgotpassword.getresetpasswordemail().isDisplayed()) {
	            System.out.println("Passed: Email text field is displayed on the reset password page");
	        } else {
	            System.out.println("Fsiled: Email text field is not displayed on the reset password page.");
	        }
	   
	        if (forgotpassword.getresetPasswordButton().isDisplayed()) {
	            System.out.println("Passed: Login button is displaying.");
	        } 
	        else {
	        	System.out.println("Failed: Login button is not displayingS");
	        }
	        try {
	             
	             // Get the color property of the text element
	             String color = forgotpassword.getresetPasswordButton().getCssValue("color");

	             // Verify the color
	             String expectedColor = "rgba(255, 255, 255, 1)"; // Example: Red color
	             String expectedColorFireFox = "rgb(255, 255, 255)";
	             if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
	                 System.out.println("Passed: Text color is verified and found as expected: " + color);
	             } else {
	                 System.out.println("Failed: Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
	             }
	         } catch (Exception e) {
	             System.out.println("Failed to verify text color: " + e.getMessage());
	         }
	        /* Sign in Link in red should be displayed */
	        if(forgotpassword.getsignInLink().isDisplayed()) {
	        	System.out.println("Passed: Sign In button is displaying");
	        }
	        else {
	        	System.out.println("Failed: Sign In is not displaying");
	        }
	        /* verify sign in color  */
	        try {
	             
	             // Get the color property of the text element
	             String color = forgotpassword.getsignInLink().getCssValue("color");

	             // Verify the color
	             String expectedColor = "rgba(234, 76, 120, 1)"; // Example: Red color
	             String expectedColorFireFox = "rgb(234, 76, 120)";
	             if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
	                 System.out.println("Passed: Sign In Text color is verified and found as expected: " + color);
	             } else {
	                 System.out.println("Failed: Sign In Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
	             }
	         } catch (Exception e) {
	             System.out.println("Failed to verify text color: " + e.getMessage());
	         }
	}
	@Test(priority = 3, enabled = true)
	public void verifyIfUserClicksOnTheResetPasswordButtonWithEmpthEmailTextField_ForgotPassword_TC_03() throws InterruptedException{
		SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
		forgotpassword.getForgotPassword().click();
		forgotpassword.getresetPasswordButton().click();
		WebElement toast = forgotpassword.gettoastInvalidMsg();
		Thread.sleep(10);
		if(toast.getText() != null) {
			System.out.println(toast.getText());
			if(toast.getText().equalsIgnoreCase("Correct email is mandatory.")) {
			System.out.println("Passed:Toast message and spellings are verified and found correct");
			}
			
		}
		else {
			System.out.println("Failed: Toast message is verified and found incorrect");
		}
		/*  verify colour     */
		try {
            
            // Get the color property of the text element
            String color = forgotpassword.getemailIsRequired().getCssValue("color");

            // Verify the color
            String expectedColor = "rgba(220, 53, 69, 1)"; // Example: Red color
            String expectedColorFireFox = "rgb(220, 53, 69)";
            if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
                System.out.println("Passed: Text color is verified and found as expected: " + color);
            } else {
                System.out.println("Failed: Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
            }
        } catch (Exception e) {
            System.out.println("Failed to verify text color: " + e.getMessage());
        }
		/*   spelling    */
		String actualText = forgotpassword.getemailIsRequired().getText();
		String expectedText = "Email is required";
		if(actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Passed: Reset Password email Text field is verified and found correct");
		}
		else { 
			System.out.println("Failed: Reset Password email Text field is verified and found incorrect");
		}
	}
	 @Test(priority = 4, enabled = true)
	public void verifyThataUserReceivesAEmailForResetPassword_ForgotPassword_TC_04() throws EncryptedDocumentException, IOException, InterruptedException {
		SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
		forgotpassword.getForgotPassword().click();
		forgotpassword.getresetpasswordemail().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		forgotpassword.getresetPasswordButton().click();
		WebElement toast = forgotpassword.gettoastMailForResetPassword();
		Thread.sleep(1000);
		if(toast.getText() != null) {
			System.out.println(toast.getText());
			if(toast.getText().equalsIgnoreCase("Please check mail for reset password")) {
			System.out.println("Passed:Toast message and spellings are verified and found correct");
			}
			
		}
		else {
			System.out.println("Failed: Toast message is verified and found incorrect");
		}
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get(excelUtils.readTheString("Forgot Password", 1, 1));
		Thread.sleep(10);
		forgotpassword.getmailinatorSearch().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		forgotpassword.getGoButton().click();
		Thread.sleep(1000);
		
		/* New login from here */
		WebElement search = forgotpassword.getmailinatorUserReTextField();
		 
		   String textFieldValue = search.getAttribute("value");
		   Thread.sleep(2000);
		   System.out.println(textFieldValue);
		   Thread.sleep(3000);
		   if(textFieldValue.isEmpty()) {
			   System.out.println("Mailinator Inbox not fetching so, putting again in input field");
			   Thread.sleep(3000);
			   search.clear();
		   search.sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		   search.sendKeys(Keys.ENTER);
		   forgotpassword.getmailinatorPublicInboxes().click();
			
		   String emailSenderExpected = "admin@sitenna.com";
		   String emailSenderActual = forgotpassword.getemailSender().getText();
	       String subjectExpected = "Reset Password.";
	       String subjectActual = forgotpassword.getemailSubject().getText();
	       System.out.println(subjectActual);
	       String justnowTimeExpected = "just now";
	       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
	       Thread.sleep(500);
	       if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
	    	   System.out.println("Passed: mail sender, mail subject and mail time are verified and found correct");
	    	   forgotpassword.getemailSubject().click();
	       }
	       else {
	    	   System.out.println("Failed: mail sender, mail subject and mail time are verified and found incorrect");
	       }
	       driver.switchTo().frame(0);
	      forgotpassword.getcreateNewPasswordButton().click();
	       Thread.sleep(500);
	       driver.switchTo().defaultContent();
		   
		   
		   }
		   
		   
		   
		   /* Reenter user details logic till here*/
		   else {
			   System.out.println("again adding user input then executedexecuted");
		   
		   Thread.sleep(3000);
		   
		   
		forgotpassword.getmailinatorPublicInboxes().click();
		
		   String emailSenderExpected = "admin@sitenna.com";
		   String emailSenderActual = forgotpassword.getemailSender().getText();
	       String subjectExpected = "Reset Password.";
	       String subjectActual = forgotpassword.getemailSubject().getText();
	       System.out.println(subjectActual);
	       String justnowTimeExpected = "just now";
	       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
	       Thread.sleep(500);
	       if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
	    	   System.out.println("Passed: mail sender, mail subject and mail time are verified and found correct");
	    	   forgotpassword.getemailSubject().click();
	       }
	       else {
	    	   System.out.println("Failed: mail sender, mail subject and mail time are verified and found incorrect");
	       }
	       driver.switchTo().frame(0);
	      forgotpassword.getcreateNewPasswordButton().click();
	       Thread.sleep(500);
	       driver.switchTo().defaultContent();
		   }
	}
	 
	 @Test(priority = 5, enabled = true)
	 public void verifyIfaUserClicksOnTheCreateNewPasswordButtonThenUserNavigatesToCreateNewPasswordPage_ForgotPassword_TC_05() throws InterruptedException, EncryptedDocumentException, IOException {
		 SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
		 forgotpassword.getForgotPassword().click();
			forgotpassword.getresetpasswordemail().sendKeys(excelUtils.readTheString("Forgot Password", 3, 1));
			forgotpassword.getresetPasswordButton().click();
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get(excelUtils.readTheString("Forgot Password", 1, 1));
			Thread.sleep(10);
			forgotpassword.getmailinatorSearch().sendKeys(excelUtils.readTheString("Forgot Password", 3, 1));
			Thread.sleep(1000);
			forgotpassword.getGoButton().click();
			Thread.sleep(1000);
			
			/*New login code from here*/
			
			WebElement search = forgotpassword.getmailinatorUserReTextField();
			   String textFieldValue = search.getAttribute("value");
			   Thread.sleep(2000);
			   System.out.println(textFieldValue);
			   Thread.sleep(3000);
			   if(textFieldValue.isEmpty()) {
				   System.out.println("Mailinator Inbox not fetching so, putting again in input field");
				   Thread.sleep(4000);
				   search.clear();
			   search.sendKeys(excelUtils.readTheString("Forgot Password", 3, 1));
			   search.sendKeys(Keys.ENTER);
			   forgotpassword.getmailinatorPublicInboxes().click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				Thread.sleep(1000);
				
				
				String emailSenderExpected = "admin@sitenna.com";
				   String emailSenderActual = forgotpassword.getemailSender().getText();
				   System.out.println(emailSenderActual);
			       String subjectExpected = "Reset Password.";
			       String subjectActual = forgotpassword.getemailSubject().getText();
			       System.out.println(subjectActual);
			       String justnowTimeExpected = "just now";
			       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
			       System.out.println(justnowTimeActual);
			       Thread.sleep(500);
				if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
			    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");
			    	   forgotpassword.getemailSubject().click();
			       }
				
				
				 else {
			    	   System.out.println("Fail just now time");
			       }
			       
			       driver.switchTo().frame(0);
			       
			       Thread.sleep(500);
			      forgotpassword.getcreateNewPasswordButton().click();
				Thread.sleep(500);
				driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
			       System.out.println(driver.getCurrentUrl());
			       String pageSource = driver.getPageSource();
				     if(pageSource.contains("sitenna-asset/images/sitenna-logo.svg")) {   
					    	System.out.println("Passed: Sitenna Logo verified and found correct");
					    }
					    else {
					    	System.out.println("Failed: Sitenna Logo verified and found incorrect");
					    }
				Thread.sleep(500);
				
				 try {

			            if (forgotpassword.getlabelCreateNewPassword().isDisplayed()) {
			                System.out.println("Passed: Heading is visible on the webpage.");
			            } else {
			                System.out.println("Failed: Heading is not visible on the webpage.");
			            }
			        } catch (Exception e) {
			            System.out.println("Failed to verify heading visibility: " + e.getMessage());
			        }
				 try {
			            if (forgotpassword.getcreateNewPassword().isDisplayed()) {
			                System.out.println("Passed: Create New Password text field is visible on the web page");
			            } else {
			                System.out.println("Failed: Create New Password text field is visible on the web page");
			            }
			        } catch (Exception e) {
			            System.out.println("Failed to verify Create New Password visibility: " + e.getMessage());
			        }
				 
				 try {
			            if (forgotpassword.getrepeatNewPassword().isDisplayed()) {
			                System.out.println("Passed: Repeat New Password text field is visible on the web page");
			            } else {
			                System.out.println("Failed: Repeat New Password text field is not visible on the web page");
			            }
			        } catch (Exception e) {
			            System.out.println("Failed to verify Repeat New Password visibility: " + e.getMessage());
			        }
				 
				 try {
			            if (forgotpassword.getpasswordPolicy().isDisplayed()) {
			                System.out.println("Passed: Password policy is visible on the web page");
			            } else {
			                System.out.println("Failed: Password policy is not visible on the web page");
			            }
			        } catch (Exception e) {
			            System.out.println("Failed to verify Password Policy  visibility: " + e.getMessage());
			        }
				 try {
			            if (forgotpassword.getcontinueButton().isDisplayed()) {
			                System.out.println("Passed: Continue Button is visible on the web page");
			            } else {
			                System.out.println("Failed: Continue Button is not visible on the web page");
			            }
			        } catch (Exception e) {
			            System.out.println("Failed to verify Continue Button visibility: " + e.getMessage());
			        }
				 
	              try {
		             
		             // Get the color property of the text element
		             String color = forgotpassword.getcontinueButton().getCssValue("color");

		             
		             String expectedColor = "rgba(227, 227, 229, 1)"; 
		             String expectedColorFireFox = "rgb(227, 227, 229)";
		             if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
		                 System.out.println("Passed: Continue button color is verified and found as expected: " + color);
		             } else {
		                 System.out.println("Failed: Continue button color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
		             }
		         } catch (Exception e) {
		             System.out.println("Failed to verify text color: " + e.getMessage());
		         }
	              
	              if(forgotpassword.getsignInLink().isDisplayed()) {
	  	        	System.out.println("Passed: Sign In button is displaying");
	  	        }
	  	        else {
	  	        	System.out.println("Failed: Sign In is not displaying");
	  	        }
	  	        /* verify sign in color  */
	  	        try {
	  	             
	  	             // Get the color property of the text element
	  	             String color = forgotpassword.getsignInLink().getCssValue("color");

	  	             // Verify the color
	  	             String expectedColor = "rgba(234, 76, 120, 1)"; // Example: Red color
	  	             String expectedColorFireFox = "rgb(234, 76, 120)";
	  	             if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
	  	                 System.out.println("Passed: Sign In Text color is verified and found as expected: " + color);
	  	             } else {
	  	                 System.out.println("Failed: Sign In Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
	  	             }
	  	         } catch (Exception e) {
	  	             System.out.println("Failed to verify text color: " + e.getMessage());
	  	         }
			   
			   }
			   /* Till here */
			   else {
				   System.out.println("again adding user input then executedexecuted");
			   
			   Thread.sleep(3000);
			
			forgotpassword.getmailinatorPublicInboxes().click();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			
			
			String emailSenderExpected = "admin@sitenna.com";
			   String emailSenderActual = forgotpassword.getemailSender().getText();
			   System.out.println(emailSenderActual);
		       String subjectExpected = "Reset Password.";
		       String subjectActual = forgotpassword.getemailSubject().getText();
		       System.out.println(subjectActual);
		       String justnowTimeExpected = "just now";
		       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
		       System.out.println(justnowTimeActual);
		       Thread.sleep(500);
			if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
		    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");
		    	   forgotpassword.getemailSubject().click();
		       }
			
			
			 else {
		    	   System.out.println("Fail just now time");
		       }
		       
		       driver.switchTo().frame(0);
		       
		       Thread.sleep(500);
		      forgotpassword.getcreateNewPasswordButton().click();
			Thread.sleep(500);
			driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		       System.out.println(driver.getCurrentUrl());
		       String pageSource = driver.getPageSource();
			     if(pageSource.contains("sitenna-asset/images/sitenna-logo.svg")) {   
				    	System.out.println("Passed: Sitenna Logo verified and found correct");
				    }
				    else {
				    	System.out.println("Failed: Sitenna Logo verified and found incorrect");
				    }
			Thread.sleep(500);
			
			 try {

		            if (forgotpassword.getlabelCreateNewPassword().isDisplayed()) {
		                System.out.println("Passed: Heading is visible on the webpage.");
		            } else {
		                System.out.println("Failed: Heading is not visible on the webpage.");
		            }
		        } catch (Exception e) {
		            System.out.println("Failed to verify heading visibility: " + e.getMessage());
		        }
			 try {
		            if (forgotpassword.getcreateNewPassword().isDisplayed()) {
		                System.out.println("Passed: Create New Password text field is visible on the web page");
		            } else {
		                System.out.println("Failed: Create New Password text field is visible on the web page");
		            }
		        } catch (Exception e) {
		            System.out.println("Failed to verify Create New Password visibility: " + e.getMessage());
		        }
			 
			 try {
		            if (forgotpassword.getrepeatNewPassword().isDisplayed()) {
		                System.out.println("Passed: Repeat New Password text field is visible on the web page");
		            } else {
		                System.out.println("Failed: Repeat New Password text field is not visible on the web page");
		            }
		        } catch (Exception e) {
		            System.out.println("Failed to verify Repeat New Password visibility: " + e.getMessage());
		        }
			 
			 try {
		            if (forgotpassword.getpasswordPolicy().isDisplayed()) {
		                System.out.println("Passed: Password policy is visible on the web page");
		            } else {
		                System.out.println("Failed: Password policy is not visible on the web page");
		            }
		        } catch (Exception e) {
		            System.out.println("Failed to verify Password Policy  visibility: " + e.getMessage());
		        }
			 try {
		            if (forgotpassword.getcontinueButton().isDisplayed()) {
		                System.out.println("Passed: Continue Button is visible on the web page");
		            } else {
		                System.out.println("Failed: Continue Button is not visible on the web page");
		            }
		        } catch (Exception e) {
		            System.out.println("Failed to verify Continue Button visibility: " + e.getMessage());
		        }
			 
              try {
	             
	             // Get the color property of the text element
	             String color = forgotpassword.getcontinueButton().getCssValue("color");

	             
	             String expectedColor = "rgba(227, 227, 229, 1)"; 
	             String expectedColorFireFox = "rgb(227, 227, 229)";
	             if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
	                 System.out.println("Passed: Continue button color is verified and found as expected: " + color);
	             } else {
	                 System.out.println("Failed: Continue button color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
	             }
	         } catch (Exception e) {
	             System.out.println("Failed to verify text color: " + e.getMessage());
	         }
              
              if(forgotpassword.getsignInLink().isDisplayed()) {
  	        	System.out.println("Passed: Sign In button is displaying");
  	        }
  	        else {
  	        	System.out.println("Failed: Sign In is not displaying");
  	        }
  	        /* verify sign in color  */
  	        try {
  	             
  	             // Get the color property of the text element
  	             String color = forgotpassword.getsignInLink().getCssValue("color");

  	             // Verify the color
  	             String expectedColor = "rgba(234, 76, 120, 1)"; // Example: Red color
  	             String expectedColorFireFox = "rgb(234, 76, 120)";
  	             if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
  	                 System.out.println("Passed: Sign In Text color is verified and found as expected: " + color);
  	             } else {
  	                 System.out.println("Failed: Sign In Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
  	             }
  	         } catch (Exception e) {
  	             System.out.println("Failed to verify text color: " + e.getMessage());
  	         }
  	        
	 }//else ends from logic
	 }
	 @Test(priority = 6, enabled = true)
	 public void verifyClickingOnContinueButtonLeavingTextFieldsBlank_ForgotPassword_TC_06() throws EncryptedDocumentException, IOException, InterruptedException {
		 SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
		    forgotpassword.getForgotPassword().click();
			forgotpassword.getresetpasswordemail().sendKeys(excelUtils.readTheString("Forgot Password", 4, 1));
			forgotpassword.getresetPasswordButton().click();
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get(excelUtils.readTheString("Forgot Password", 1, 1));
			Thread.sleep(10);
			forgotpassword.getmailinatorSearch().sendKeys(excelUtils.readTheString("Forgot Password", 4, 1));
			Thread.sleep(1000);
			forgotpassword.getGoButton().click();
			
			Thread.sleep(1000);
			/*New Logic from here*/
			 WebElement search = driver.findElement(By.id("inbox_field"));
			   String textFieldValue = search.getAttribute("value");
			   Thread.sleep(2000);
			   System.out.println(textFieldValue);
			   Thread.sleep(3000);
			   if(textFieldValue.isEmpty()) {
				   System.out.println("Mailinator Inbox not fetching so, putting again in input field");
				   Thread.sleep(4000);
				   search.clear();
			   search.sendKeys(excelUtils.readTheString("Forgot Password", 4, 1));
			   search.sendKeys(Keys.ENTER);
			   forgotpassword.getmailinatorPublicInboxes().click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				Thread.sleep(1000);		
				
				
				
				String emailSenderExpected = "admin@sitenna.com";
				   String emailSenderActual = forgotpassword.getemailSender().getText();
				   System.out.println(emailSenderActual);
			       String subjectExpected = "Reset Password.";
			       String subjectActual = forgotpassword.getemailSubject().getText();
			       System.out.println(subjectActual);
			       String justnowTimeExpected = "just now";
			       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
			       System.out.println(justnowTimeActual);
			       Thread.sleep(500);
				if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
			    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");
			    	   forgotpassword.getemailSubject().click();
			       }
				
				
				 else {
			    	   System.out.println("Fail just now time");
			       }
				driver.switchTo().frame(0);
			       
			       Thread.sleep(500);
			      forgotpassword.getcreateNewPasswordButton().click();
				Thread.sleep(500);
				driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
			    forgotpassword.getcontinuebutton1().click();
				WebElement toast = forgotpassword.gettoastmsgforCorrectDataAndPasswordPolicy();
				Thread.sleep(10);
				if(toast.getText() != null) {
					System.out.println("Passed: Toast Message field is not empty");
					System.out.println(toast.getText());
					
				}
				else {
					System.out.println("Failed: Toast Message field is empty");
				}
				if(toast.getText().equalsIgnoreCase("Check all data is correct and the passwords match the minimum requirements for a strong password")) {
					System.out.println("Passed:Toast message and spellings are verified and found correct");
					}
				else {
					System.out.println("Failed: Toast message is verified and found incorrect");
				}
			   
			   
			   }
			   /*Till here*/
			   else {
				   System.out.println("again adding user input then executedexecuted");
			   
			   Thread.sleep(3000);
			
			forgotpassword.getmailinatorPublicInboxes().click();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(1000);		
			
			
			
			String emailSenderExpected = "admin@sitenna.com";
			   String emailSenderActual = forgotpassword.getemailSender().getText();
			   System.out.println(emailSenderActual);
		       String subjectExpected = "Reset Password.";
		       String subjectActual = forgotpassword.getemailSubject().getText();
		       System.out.println(subjectActual);
		       String justnowTimeExpected = "just now";
		       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
		       System.out.println(justnowTimeActual);
		       Thread.sleep(500);
			if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
		    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");
		    	   forgotpassword.getemailSubject().click();
		       }
			
			
			 else {
		    	   System.out.println("Fail just now time");
		       }
			driver.switchTo().frame(0);
		       
		       Thread.sleep(500);
		      forgotpassword.getcreateNewPasswordButton().click();
			Thread.sleep(500);
			driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		    forgotpassword.getcontinuebutton1().click();
			WebElement toast = forgotpassword.gettoastmsgforCorrectDataAndPasswordPolicy();
			Thread.sleep(10);
			if(toast.getText() != null) {
				System.out.println("Passed: Toast Message field is not empty");
				System.out.println(toast.getText());
				
			}
			else {
				System.out.println("Failed: Toast Message field is empty");
			}
			if(toast.getText().equalsIgnoreCase("Check all data is correct and the passwords match the minimum requirements for a strong password")) {
				System.out.println("Passed:Toast message and spellings are verified and found correct");
				}
			else {
				System.out.println("Failed: Toast message is verified and found incorrect");
			}
			
	 } //else ends from logic
		 
	 }
//	 @Test(priority = 7, enabled = true)
//	 public void verifyTheNewPasswordStrengthBar() throws EncryptedDocumentException, IOException, InterruptedException {
//		 SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
//		 forgotpassword.getForgotPassword().click();
//			forgotpassword.getresetpasswordemail().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
//			forgotpassword.getresetPasswordButton().click();
//			driver.switchTo().newWindow(WindowType.WINDOW);
//			driver.get(excelUtils.readTheString("Forgot Password", 1, 1));
//			Thread.sleep(10);
//			forgotpassword.getmailinatorSearch().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
//			Thread.sleep(1000);
//			forgotpassword.getGoButton().click();
//			Thread.sleep(1000);
//			forgotpassword.getmailinatorPublicInboxes().click();
//			Thread.sleep(3000);
//			String emailSenderExpected = "admin@sitenna.com";
//			   String emailSenderActual = forgotpassword.getemailSender().getText();
//			   System.out.println(emailSenderActual);
//		       String subjectExpected = "Reset Password.";
//		       String subjectActual = forgotpassword.getemailSubject().getText();
//		       System.out.println(subjectActual);
//		       String justnowTimeExpected = "just now";
//		       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
//		       System.out.println(justnowTimeActual);
//		       Thread.sleep(1000);
//			if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
//		    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");		    	   
//		    	   Thread.sleep(1000);
//		    	   forgotpassword.getemailSubject().click();
//		       }
//			
//			
//			 else {
//		    	   System.out.println("Fail: just now time");
//		       }
//			driver.switchTo().frame(0);
//		       
//		       Thread.sleep(1000);
//		      forgotpassword.getcreateNewPasswordButton().click();
//			Thread.sleep(10000);
//			driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
//			WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        explicitWait.until(ExpectedConditions.titleIs("Sitenna"));
      
//			forgotpassword.getnewPasswordTextField().sendKeys(excelUtils.readTheString("Forgot Password", 6, 1));
//			Thread.sleep(7000);
//		    String actualURL = driver.getCurrentUrl();		    
//		    if(actualURL.contains("https://qa.sitenna.com/#/auth/forgot-password?t=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.ey")) {
//		    	System.out.println("Passed: actualURL and expectedURL for Sitenna Create new Password page verified and found correct");
//		    }
//		    else {
//		    	System.out.println("Failed: actualURL and expectedURL for Sitenna Create new Password page verified and found incorrect");
//		    }
//		 forgotpassword.getnewPasswordTextField().sendKeys();   //create different utility for decimal and number for reading
//		 Thread.sleep(10000);
//		 
//	 }
	 
	 @Test(priority = 8, enabled = true)
	 public void verifyErrorMessageOnPasswordMismatch_ForgotPassword_TC_08() throws EncryptedDocumentException, IOException, InterruptedException {
		 
			 SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
			 forgotpassword.getForgotPassword().click();
				forgotpassword.getresetpasswordemail().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
				forgotpassword.getresetPasswordButton().click();
				driver.switchTo().newWindow(WindowType.WINDOW);
				driver.get(excelUtils.readTheString("Forgot Password", 1, 1));
				Thread.sleep(10);
				forgotpassword.getmailinatorSearch().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
				Thread.sleep(1000);
				forgotpassword.getGoButton().click();
				
				Thread.sleep(1000);
				/*New logic from here*/
				 WebElement search = forgotpassword.getmailinatorUserReTextField();
				   String textFieldValue = search.getAttribute("value");
				   Thread.sleep(2000);
				   System.out.println(textFieldValue);
				   Thread.sleep(3000);
				   if(textFieldValue.isEmpty()) {
					   System.out.println("Mailinator Inbox not fetching so, putting again in input field");
					   Thread.sleep(4000);
					   search.clear();
				   search.sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
				   search.sendKeys(Keys.ENTER);
				   
				   forgotpassword.getmailinatorPublicInboxes().click();
					Thread.sleep(3000);
					driver.navigate().refresh();
					Thread.sleep(1000);
						
					
					
					String emailSenderExpected = "admin@sitenna.com";
					   String emailSenderActual = forgotpassword.getemailSender().getText();
					   System.out.println(emailSenderActual);
				       String subjectExpected = "Reset Password.";
				       String subjectActual = forgotpassword.getemailSubject().getText();
				       System.out.println(subjectActual);
				       String justnowTimeExpected = "just now";
				       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
				       System.out.println(justnowTimeActual);
				       Thread.sleep(2000);
					if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
				    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");		    	   
				    	   Thread.sleep(1000);
				    	   forgotpassword.getemailSubject().click();
				       }
					
					
					 else {
				    	   System.out.println("Fail: just now time");
				       }
					driver.switchTo().frame(0);
				       
				       Thread.sleep(1000);
				      forgotpassword.getcreateNewPasswordButton().click();
					Thread.sleep(5000);
					driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

				 forgotpassword.getcreateNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 7, 1));   //create different utility for decimal and number for reading
				 Thread.sleep(1000);
				 forgotpassword.getrepeatNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 8, 1));
				 Thread.sleep(1000);
				 
				 forgotpassword.getcontinuebutton1().click();
				 WebElement toast = forgotpassword.gettoastmsgforResetPasswordMismatch();
					Thread.sleep(1000);
					if(toast.getText() != null) {
						System.out.println("Passed: Toast Message field is not empty");
						System.out.println(toast.getText());
						
					}
					else {
						System.out.println("Failed: Toast Message field is empty");
					}
					Thread.sleep(1000);
					if(toast.getText().equalsIgnoreCase("Check all data is correct and the passwords match the minimum requirements for a strong password")) {
						System.out.println("Passed:Toast message and spellings are verified and found correct");
						}
					else {
						System.out.println("Failed: Toast message is verified and found incorrect");
					}
				   
				   
				   }
				   /*till here*/
				   else {
					   System.out.println("again adding user input then executedexecuted");
				   
				   Thread.sleep(3000);
				
				
				forgotpassword.getmailinatorPublicInboxes().click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				Thread.sleep(1000);
					
				
				
				String emailSenderExpected = "admin@sitenna.com";
				   String emailSenderActual = forgotpassword.getemailSender().getText();
				   System.out.println(emailSenderActual);
			       String subjectExpected = "Reset Password.";
			       String subjectActual = forgotpassword.getemailSubject().getText();
			       System.out.println(subjectActual);
			       String justnowTimeExpected = "just now";
			       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
			       System.out.println(justnowTimeActual);
			       Thread.sleep(2000);
				if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
			    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");		    	   
			    	   Thread.sleep(1000);
			    	   forgotpassword.getemailSubject().click();
			       }
				
				
				 else {
			    	   System.out.println("Fail: just now time");
			       }
				driver.switchTo().frame(0);
			       
			       Thread.sleep(1000);
			      forgotpassword.getcreateNewPasswordButton().click();
				Thread.sleep(5000);
				driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

			 forgotpassword.getcreateNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 7, 1));   //create different utility for decimal and number for reading
			 Thread.sleep(1000);
			 forgotpassword.getrepeatNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 8, 1));
			 Thread.sleep(1000);
			 
			 forgotpassword.getcontinuebutton1().click();
			 WebElement toast = forgotpassword.gettoastmsgforResetPasswordMismatch();
				Thread.sleep(1000);
				if(toast.getText() != null) {
					System.out.println("Passed: Toast Message field is not empty");
					System.out.println(toast.getText());
					
				}
				else {
					System.out.println("Failed: Toast Message field is empty");
				}
				Thread.sleep(1000);
				if(toast.getText().equalsIgnoreCase("Check all data is correct and the passwords match the minimum requirements for a strong password")) {
					System.out.println("Passed:Toast message and spellings are verified and found correct");
					}
				else {
					System.out.println("Failed: Toast message is verified and found incorrect");
				}
				
				   } //else ends here
		 
	 }
	 @Test(priority = 9, enabled = true)
	 public void verifyAUserCanResetThePassword_ForgotPassword_TC_09() throws EncryptedDocumentException, IOException, InterruptedException {
		 SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
		 forgotpassword.getForgotPassword().click();
			forgotpassword.getresetpasswordemail().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
			forgotpassword.getresetPasswordButton().click();
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get(excelUtils.readTheString("Forgot Password", 1, 1));
			Thread.sleep(10);
			forgotpassword.getmailinatorSearch().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
			Thread.sleep(1000);
			forgotpassword.getGoButton().click();
			
			Thread.sleep(1000);
			/*New Logic from here*/
			 WebElement search = forgotpassword.getmailinatorUserReTextField();
			   String textFieldValue = search.getAttribute("value");
			   Thread.sleep(2000);
			   System.out.println(textFieldValue);
			   Thread.sleep(3000);
			   if(textFieldValue.isEmpty()) {
				   System.out.println("Mailinator Inbox not fetching so, putting again in input field");
				   Thread.sleep(4000);
				   search.clear();
			   search.sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
			   search.sendKeys(Keys.ENTER);
			   
			   Thread.sleep(1000);
				forgotpassword.getmailinatorPublicInboxes().click();
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(1000);
		
				String emailSenderExpected = "admin@sitenna.com";
				   String emailSenderActual = forgotpassword.getemailSender().getText();
				   System.out.println(emailSenderActual);
			       String subjectExpected = "Reset Password.";
			       String subjectActual = forgotpassword.getemailSubject().getText();
			       System.out.println(subjectActual);
			       String justnowTimeExpected = "just now";
			       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
			       System.out.println(justnowTimeActual);
			       Thread.sleep(1000);
				if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
			    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");		    	   
			    	   Thread.sleep(1000);
			    	   forgotpassword.getemailSubject().click();
			       }
				
				
				 else {
			    	   System.out.println("Fail: just now time");
			       }
				driver.switchTo().frame(0);
			       
			       Thread.sleep(1000);
			      forgotpassword.getcreateNewPasswordButton().click();
				Thread.sleep(1000);
				driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

			 forgotpassword.getcreateNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));   //create different utility for decimal and number for reading
			 Thread.sleep(1000);
			 forgotpassword.getrepeatNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));
			 Thread.sleep(1000);
			
			 forgotpassword.getcontinuebutton1().click();
			 WebElement toast = forgotpassword.gettoastmsgforPasswordResetSuccessfully();
				Thread.sleep(10);
				if(toast.getText() != null) {
					System.out.println("Passed: Toast Message field is not empty");
					System.out.println(toast.getText());
					
				}
				else {
					System.out.println("Failed: Toast Message field is empty");
				}
				Thread.sleep(1000);
				Set<String> allWindowHandles = driver.getWindowHandles();

		        // Switch to the new window
				driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		        String actualNewURL = driver.getCurrentUrl();
		        System.out.println("URL of the new window: " + actualNewURL);
		        String expectedNewURL = "https://qa.sitenna.com/#/auth/signin";
		        if(actualNewURL.equals(expectedNewURL)) {
		        	System.out.println("Passed: Redirected login page link is verified and found correct");
		        }
		        else {
		        	System.out.println("Failed: Redirected login page link is verified and found incorrect");
		        }
			   
			   
			   }
			   /*Logic till here*/
			   else {
				   System.out.println("again adding user input then executedexecuted");
			   
			   Thread.sleep(3000);
			forgotpassword.getmailinatorPublicInboxes().click();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(1000);
	
			
			
			
			String emailSenderExpected = "admin@sitenna.com";
			   String emailSenderActual = forgotpassword.getemailSender().getText();
			   System.out.println(emailSenderActual);
		       String subjectExpected = "Reset Password.";
		       String subjectActual = forgotpassword.getemailSubject().getText();
		       System.out.println(subjectActual);
		       String justnowTimeExpected = "just now";
		       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
		       System.out.println(justnowTimeActual);
		       Thread.sleep(1000);
			if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
		    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");		    	   
		    	   Thread.sleep(1000);
		    	   forgotpassword.getemailSubject().click();
		       }
			
			
			 else {
		    	   System.out.println("Fail: just now time");
		       }
			driver.switchTo().frame(0);
		       
		       Thread.sleep(1000);
		      forgotpassword.getcreateNewPasswordButton().click();
			Thread.sleep(1000);
			driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

		 forgotpassword.getcreateNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));   //create different utility for decimal and number for reading
		 Thread.sleep(1000);
		 forgotpassword.getrepeatNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));
		 Thread.sleep(1000);
		
		 forgotpassword.getcontinuebutton1().click();
		 WebElement toast = forgotpassword.gettoastmsgforPasswordResetSuccessfully();
			Thread.sleep(10);
			if(toast.getText() != null) {
				System.out.println("Passed: Toast Message field is not empty");
				System.out.println(toast.getText());
				
			}
			else {
				System.out.println("Failed: Toast Message field is empty");
			}
			Thread.sleep(1000);
			Set<String> allWindowHandles = driver.getWindowHandles();

	        // Switch to the new window
			driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	        String actualNewURL = driver.getCurrentUrl();
	        System.out.println("URL of the new window: " + actualNewURL);
	        String expectedNewURL = "https://qa.sitenna.com/#/auth/signin";
	        if(actualNewURL.equals(expectedNewURL)) {
	        	System.out.println("Passed: Redirected login page link is verified and found correct");
	        }
	        else {
	        	System.out.println("Failed: Redirected login page link is verified and found incorrect");
	        }
	        
	        
			   }// else logic closed here
	 }
	 
	 @Test(priority = 10, enabled = true)
	 public void verifyAUserCanLoginWithTheNewPassword_ForgotPassword_TC_10() throws InterruptedException, EncryptedDocumentException, IOException {
		 SitennaForgotPasswordPage forgotpassword = new SitennaForgotPasswordPage(driver);
		 forgotpassword.getForgotPassword().click();
			forgotpassword.getresetpasswordemail().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
			forgotpassword.getresetPasswordButton().click();
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get(excelUtils.readTheString("Forgot Password", 1, 1));
			Thread.sleep(10);
			forgotpassword.getmailinatorSearch().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
			Thread.sleep(1000);
			forgotpassword.getGoButton().click();
			Thread.sleep(1000);
			
			WebElement search = forgotpassword.getmailinatorUserReTextField();
			   String textFieldValue = search.getAttribute("value");
			   Thread.sleep(1000);
			   System.out.println(textFieldValue);
			   Thread.sleep(3000);
			   if(textFieldValue.isEmpty()) {
				   System.out.println("Mailinator Inbox not fetching so, putting again in input field");
				   Thread.sleep(2000);
				   search.clear();
			   search.sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
			   search.sendKeys(Keys.ENTER);
			   
	/*  added new from here   */
			   
			   Thread.sleep(3000);
				forgotpassword.getmailinatorPublicInboxes().click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				Thread.sleep(1000);
				String emailSenderExpected = "admin@sitenna.com";
				   String emailSenderActual = forgotpassword.getemailSender().getText();
				   System.out.println(emailSenderActual);
			       String subjectExpected = "Reset Password.";
			       String subjectActual = forgotpassword.getemailSubject().getText();
			       System.out.println(subjectActual);
			       String justnowTimeExpected = "just now";
			       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
			       System.out.println(justnowTimeActual);
			       Thread.sleep(1000);
				if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
			    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");		    	   
			    	   Thread.sleep(1000);
			    	   forgotpassword.getemailSubject().click();
			       }
				
				
				 else {
			    	   System.out.println("Fail: just now time");
			       }
				driver.switchTo().frame(0);
			       
			       Thread.sleep(1000);
			      forgotpassword.getcreateNewPasswordButton().click();
				Thread.sleep(1000);
				driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

			 forgotpassword.getcreateNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));   //create different utility for decimal and number for reading
			 Thread.sleep(1000);
			 forgotpassword.getrepeatNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));
			 Thread.sleep(1000);
			
			 forgotpassword.getcontinuebutton1().click();
			 WebElement toast = forgotpassword.gettoastmsgforPasswordResetSuccessfully();
				Thread.sleep(10);
				
				if(toast.getText() != null) {
					System.out.println("Passed: Toast Message field is not empty");
					System.out.println(toast.getText());
					
				}
				else {
					System.out.println("Failed: Toast Message field is empty");
				}
				Thread.sleep(1000);
				Set<String> allWindowHandles = driver.getWindowHandles();

		        // Switch to the new window
				driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		        String actualNewURL = driver.getCurrentUrl();
		        System.out.println("URL of the new window: " + actualNewURL);
		        String expectedNewURL = "https://qa.sitenna.com/#/auth/signin";
		        if(actualNewURL.equals(expectedNewURL)) {
		        	System.out.println("Passed: Redirected login page link is verified and found correct");
		        }
		        else {
		        	System.out.println("Failed: Redirected login page link is verified and found incorrect");
		        }
		        forgotpassword.getloginEmailTextField().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
		        Thread.sleep(1000);
		        forgotpassword.getloginPasswordTextField().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));
		        Thread.sleep(1000);
		        forgotpassword.getloginButton().click();
		        Thread.sleep(1000);
		        WebElement toast1 = forgotpassword.gettoastmsgforLoginSuccessful();
				Thread.sleep(1000);
				System.out.println(toast1.getText());
				if(toast1.getText() != null) {
					System.out.println("Passed: Toast Message field is not empty");
					System.out.println(toast1.getText());
					
				}
				else {
					System.out.println("Failed: Toast Message field is empty");
				}
				if(toast1.getText().equalsIgnoreCase("login successful")) {
					System.out.println("Passed:Toast message and spellings are verified and found correct");
					}
				else {
					System.out.println("Failed: Toast message is verified and found incorrect");
				}
				Thread.sleep(1000);
				String actualURL = driver.getCurrentUrl();
				System.out.println(actualURL);
				String expectedURL = "https://qa.sitenna.com/#/home/dashboard";
				if(actualURL.equals(expectedURL)) {
					System.out.println("Passed: dashboard home page URL is verified and found correct");
				}
				else {
					System.out.println("Failed: dashboard home page URL is verified and found incorrect");
				}
			   }
			   
			   
			   /* till here */
			   
			   
			   
			   else {
				   System.out.println("again adding user input then executedexecuted");
			   
				   
				   
			   Thread.sleep(3000);
			forgotpassword.getmailinatorPublicInboxes().click();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			String emailSenderExpected = "admin@sitenna.com";
			   String emailSenderActual = forgotpassword.getemailSender().getText();
			   System.out.println(emailSenderActual);
		       String subjectExpected = "Reset Password.";
		       String subjectActual = forgotpassword.getemailSubject().getText();
		       System.out.println(subjectActual);
		       String justnowTimeExpected = "just now";
		       String justnowTimeActual = forgotpassword.getemailJustNowTime().getText();
		       System.out.println(justnowTimeActual);
		       Thread.sleep(1000);
			if(emailSenderExpected.equalsIgnoreCase(emailSenderActual)&& subjectExpected.equalsIgnoreCase(subjectActual) &&  justnowTimeActual.equalsIgnoreCase(justnowTimeExpected)) {                           
		    	   System.out.println("Passed: mail sender, mail subject and mail times are verified and found correct");		    	   
		    	   Thread.sleep(1000);
		    	   forgotpassword.getemailSubject().click();
		       }
			
			
			 else {
		    	   System.out.println("Fail: just now time");
		       }
			driver.switchTo().frame(0);
		       
		       Thread.sleep(1000);
		      forgotpassword.getcreateNewPasswordButton().click();
			Thread.sleep(1000);
			driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

		 forgotpassword.getcreateNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));   //create different utility for decimal and number for reading
		 Thread.sleep(1000);
		 forgotpassword.getrepeatNewPassword().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));
		 Thread.sleep(1000);
		
		 forgotpassword.getcontinuebutton1().click();
		 WebElement toast = forgotpassword.gettoastmsgforPasswordResetSuccessfully();
			Thread.sleep(10);
			
			if(toast.getText() != null) {
				System.out.println("Passed: Toast Message field is not empty");
				System.out.println(toast.getText());
				
			}
			else {
				System.out.println("Failed: Toast Message field is empty");
			}
			Thread.sleep(1000);
			Set<String> allWindowHandles = driver.getWindowHandles();

	        // Switch to the new window
			driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	        String actualNewURL = driver.getCurrentUrl();
	        System.out.println("URL of the new window: " + actualNewURL);
	        String expectedNewURL = "https://qa.sitenna.com/#/auth/signin";
	        if(actualNewURL.equals(expectedNewURL)) {
	        	System.out.println("Passed: Redirected login page link is verified and found correct");
	        }
	        else {
	        	System.out.println("Failed: Redirected login page link is verified and found incorrect");
	        }
	        forgotpassword.getloginEmailTextField().sendKeys(excelUtils.readTheString("Forgot Password", 5, 1));
	        Thread.sleep(1000);
	        forgotpassword.getloginPasswordTextField().sendKeys(excelUtils.readTheString("Forgot Password", 9, 1));
	        Thread.sleep(1000);
	        forgotpassword.getloginButton().click();
	        Thread.sleep(1000);
	        WebElement toast1 = forgotpassword.gettoastmsgforLoginSuccessful();
			Thread.sleep(1000);
			System.out.println(toast1.getText());
			if(toast1.getText() != null) {
				System.out.println("Passed: Toast Message field is not empty");
				System.out.println(toast1.getText());
				
			}
			else {
				System.out.println("Failed: Toast Message field is empty");
			}
			if(toast1.getText().equalsIgnoreCase("login successful")) {
				System.out.println("Passed:Toast message and spellings are verified and found correct");
				}
			else {
				System.out.println("Failed: Toast message is verified and found incorrect");
			}
			Thread.sleep(1000);
			String actualURL = driver.getCurrentUrl();
			System.out.println(actualURL);
			String expectedURL = "https://qa.sitenna.com/#/home/dashboard";
			if(actualURL.equals(expectedURL)) {
				System.out.println("Passed: dashboard home page URL is verified and found correct");
			}
			else {
				System.out.println("Failed: dashboard home page URL is verified and found incorrect");
			}
			
			
			
	 }    /* this one closing for else from condition in mailinator */
	        
	        
	 }
	 
	 
	 
	 
}
