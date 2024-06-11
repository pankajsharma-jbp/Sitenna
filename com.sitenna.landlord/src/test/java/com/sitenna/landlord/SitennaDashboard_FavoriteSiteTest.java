package com.sitenna.landlord;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xotiv.sitenna.genericUtility.BaseClass;
import com.xotiv.sitenna.pomrepo.SitennaDashboardPage;
import com.xotiv.sitenna.pomrepo.SitennaLoginPage;

public class SitennaDashboard_FavoriteSiteTest extends BaseClass {

	
	@Test(priority = 1, enabled = true)
	public void verifyTheVisibilityOfFavoritesIcon_Dashboard_TC_01() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		WebElement toast = loginpage.gettoastLoginSuccessful();
		Thread.sleep(10);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	     WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='login successful']")));
		if(toast.getText() != null) {
			System.out.println(toast.getText());
			System.out.println("Passed: toast message is verified and found correct");	
		}
		else {
			System.out.println("Failed: toast message is verified and found incorrect");
		}
		String actualToastMSG = toast.getText();
		String expectedToastMSG = "login successful";
		if(actualToastMSG.equals(expectedToastMSG)) {
			System.out.println("Passed: Toast Message Spelling Verified and found correct");
		}
		else {
			System.out.println("Failed: Toast Message Spelling Verified and found incorrect");
		}
		
		String expectedURL = "https://qa.sitenna.com/#/home/dashboard";
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(expectedURL)) {
			System.out.println("Passed: User Dashboard page is verified and found correct");
		}
		else {
			System.out.println("Failed: User Dashboard page is verified and found incorrect");
		}
		
		SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
		if (dashboard.getfavoriteIcon().isDisplayed()) {
			System.out.println("Passed: Favorites site icon is displaying on the dashboard");
		}
		else {
			System.out.println("Failed: Favorites site icon is not displaying on the dashboard");
		}
	}
	
	 @Test(priority = 2, enabled = true)
	public void verifyaUserCanOpenAndCloseTheFavoritesModal_Dashboard_TC_02() throws IOException, InterruptedException {
		 SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(100);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
		     dashboard.getfavoriteIcon().click();
		     Thread.sleep(1000);
		
			if(dashboard.getfavoriteModal().isDisplayed()) {
				System.out.println("Passed: Favorite modal is verified and displayed on UI");
			}
			else {
				System.out.println("Failed: Favorite modal is verified and not displaying on UI");
			}
			
			if(dashboard.getsearchBar().isDisplayed()) {
				System.out.println("Passed: Search Bar is verified and displayed in the UI");
			}
			else {
				System.out.println("Failed: Search Bar is neither verified and nor displayed in the UI");
			}
		     
			if(dashboard.getitemCount().isDisplayed()) {
				System.out.println("Passed: Item Count is verified and displayed in the UI");
			}
			else {
				System.out.println("Failed: Item Count is verified and not displaying in the UI");
			}
			if(dashboard.getyellowStar().isDisplayed() && dashboard.getyouCurrentlyHaveNoFavoritesSitesMSG().isDisplayed()) {
				System.out.println("Passed: Yellow star icon and no favorite msg are displayed on the UI");
			}
			else {
				System.out.println("Failed: Yellow star icon and no favorite msg are not displayed on the UI");
			}
			
			dashboard.getcloseSiteModal().click();
			if(dashboard.getfavoriteIcon().isDisplayed()) {
				
				System.out.println("Passed: After closing favorite sites modal is closed and favorite icon is  displayed on the UI");
			}
			else {
				System.out.println("Failed: After closing favorite site modal is not closed and favorite icon is not displayed on the UI");
			}     
	}
	 
	 @Test(priority = 3, enabled = true)
	 public void verifyTheSiteMarkedFavoriteFromDashboardShouldBeDisplayedInTheFavoriteList_Dashbord_TC_03() throws IOException, InterruptedException {
		 SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
			loginpage.getLoginButton().click();
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			act.click(dashboard.getmap()).build().perform();
			Thread.sleep(1000);
			if(dashboard.getsiteModal().isDisplayed()) {
				System.out.println("Passed: Site modal is verified found correct and displayed on the UI");
			}
			else {
				System.out.println("Failed: Site modal is verified found incorrect and not displaying on the UI");
			}
			if(dashboard.getfavoriteIconSiteModal().isDisplayed()) {
				System.out.println("Passed: Favorite Star icon is displaying on the UI");
			}
			else {
				System.out.println("Failed: Favorite Star icon is not displaying on the UI");
			}
		    
			dashboard.getfavoriteIconSiteModal().click();
			Thread.sleep(1000);
			
			
//			try {
//	            
//	            // Get the color property of the text element
//	            String color = dashboard.getfavoriteIconSiteModal().getCssValue("color");
//
//	            // Verify the color
//	            String expectedColor = "rgba(227, 227, 229, 1)"; 
//	            String expectedColorFireFox = "rgb(227, 227, 229)";
//	            if (color.equalsIgnoreCase(expectedColor)|| color.equalsIgnoreCase(expectedColorFireFox)) {
//	                System.out.println("Passed: Text color is verified and found as expected: " + color);
//	            } else {
//	                System.out.println("Failed: Text color is verified and found not as expected. Expected: " + expectedColor + ", Actual: " + color);
//	            }
//	        } catch (Exception e) {
//	            System.out.println("Failed to verify text color: " + e.getMessage());
//	            
//	        }
			
			String markedSiteName = dashboard.getmarkedFavoriteSiteModal().getText();
			System.out.println("Marked Site Name = " +markedSiteName );
			dashboard.getcloseSiteModal().click();
			
			dashboard.getfavoriteIcon().click();
			String favoriteSiteName = dashboard.getselectedFavoriteSite().getText();
			System.out.println("Favorite Site Name = " +favoriteSiteName);
			if(markedSiteName.equals(favoriteSiteName)) {
				System.out.println("Passed: Marked site board and favorite sites are verified and found same");
			}
			else {
				System.out.println("Failed: Marked site board and favorite sites are verified and found incorrect");
			}
			Thread.sleep(500);
			dashboard.getstarIconInFavoriteSite().click();
			Thread.sleep(500);
			dashboard.getcloseSiteModal().click();
	 }
	 
	 @Test(priority = 4, enabled = true)
	 public void verifyTheSiteMarkedFavoriteFromDashboardShouldBeDisplayedInManageSiteDetaiWithFavoriteYellowStarIcon_Dashboad_TC_04() throws IOException, InterruptedException {
		 SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
            SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
			loginpage.getLoginButton().click();
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			act.click(dashboard.getmap()).build().perform();
			Thread.sleep(500);
			dashboard.getfavoriteIconSiteModal().click();
//			 Actions actions = new Actions(driver);

		        // Click on the first element
		        dashboard.getmanageSiteFirstElement().click();

		        // Move to the second element
		        act.moveToElement(dashboard.getmanageSiteSecondElement()).perform();

		        // Click on the second element
		        dashboard.getmanageSiteSecondElement().click();
		        Thread.sleep(1000);
			    dashboard.getsearchTextFieldManageSite().sendKeys("demo site 01");
			    Thread.sleep(500);
			    dashboard.getdemoSiteName().click();
			Thread.sleep(1000);
			String expectedURL = "https://qa.sitenna.com/#/home/manage-site/site-detail";
			Thread.sleep(500);
			String actualURL = driver.getCurrentUrl();
			System.out.println(actualURL);
			if(actualURL.contains(expectedURL)) {
				System.out.println("Passed: Site detail modal page is verified and found correct");
			}
			else {
				System.out.println("Failed: Site detail modal page is verified and found incorrect");
			}
			Thread.sleep(2000);
			if(dashboard.getstarIconInFavoriteSite().isDisplayed()) {
				System.out.println("Passed: favorite icon is verified and found correct");
			}
			else {
				System.out.println("Failed: favorite icon is verified and found incorrect");
			}

			Thread.sleep(500);
			dashboard.getstarIconInFavoriteSite().click();
			Thread.sleep(500);
	 }
	@Test(priority = 5, enabled = true)
	 public void verifyTheFavoriteSiteCardList_Dashboard_TC_05() throws IOException, InterruptedException {
		 SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
         SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
         
         loginpage.getLoginButton().click();
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			act.click(dashboard.getmap()).build().perform();
            
			dashboard.getfavoriteIconSiteModal().click();
            Thread.sleep(500);
            dashboard.getcrosslink().click();
            dashboard.getfavoriteIcon().click();
            Thread.sleep(500);
            if(dashboard.getstarIconInFavoriteSite().isDisplayed() && dashboard.getrefID().isDisplayed()) {
            	System.out.println("Passed: Star icon and refID is verified and visible to the UI");
            }
            else {
            	System.out.println("Failed: Star icon and refID is verified and not visible to the UI");
            }
            if(dashboard.getsiteName_demoSite01().isDisplayed() && dashboard.getsiteType_Greenfield().isDisplayed() && dashboard.getsiteOwner_Automation_Landlord().isDisplayed()) {
            	System.out.println("Passed: All the elements are siteName, siteType, siteOwner verified and found correct");
            }
            else {
            	System.out.println("Failed: All the elements are siteName, siteType, siteOwner verified and found incorrect");
            }   
            dashboard.getstarIconInFavoriteSite().click();
            Thread.sleep(500);
	 }
	
	@Test(priority = 6, enabled = true)
	public void verifyIfUserClicksAgainOnFavoriteIconThenThatSiteShouldBeRemovedFromFavoriteList_Dashboard_TC_06() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
        SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
         
         loginpage.getLoginButton().click();
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			act.click(dashboard.getmap()).build().perform();
			dashboard.getfavoriteIconSiteModal().click();
            Thread.sleep(500);
            dashboard.getcrosslink().click();
            dashboard.getfavoriteIcon().click();
            Thread.sleep(500);
            String pageSource = driver.getPageSource();
            if(pageSource.contains("0123N6")) {
            	System.out.println("Passed: Before Removing site from favorite icon it is present and displayed counting to the UI");
            }
            else {
            	System.out.println("Failed: Before Removing site from favorite icon it is not present and not displayed counting to the UI");
            }   
            dashboard.getstarIconInFavoriteSite().click();                    
            Thread.sleep(1000);
            String siteCount = dashboard.getsiteCount().getText();
            System.out.println("After Removing the site count = " +siteCount);
	}
	@Test(priority = 7, enabled = true)
	public void verifyIfUserMakesAsiteUnfavoriteFromDashboardThenTheSameSiteIsShownAsUnfavoriteInManageSite_Dashboard_TC_07() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
        
            loginpage.getLoginButton().click();
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			act.click(dashboard.getmap()).build().perform();
			dashboard.getfavoriteIconSiteModal().click();
            Thread.sleep(500);
            dashboard.getcrosslink().click();
            dashboard.getfavoriteIcon().click();
            Thread.sleep(500);
            dashboard.getstarIconInFavoriteSite().click();
		    
		    Thread.sleep(500);
            String siteCount = dashboard.getsiteCount().getText();
            System.out.println("Passed: After Removing the site count = " +siteCount);
            
		    dashboard.getmanageSiteFirstElement().click();

	        // Move to the second element
	        act.moveToElement(dashboard.getmanageSiteSecondElement()).perform();

	        // Click on the second element
	        dashboard.getmanageSiteSecondElement().click();
	        Thread.sleep(1000);
		    dashboard.getsearchTextFieldManageSite().sendKeys("demo site 01");
		    dashboard.getdemoSiteName().click();
		    Thread.sleep(500);
		    if(dashboard.getfavoriteIconSiteModal().isDisplayed()) {
		    	System.out.println("Passed: Favorite Site is removed and visible to the UI");
		    }
		    else {
		    	System.out.println("Failed: Favorite Site is not removed and not visible to the UI");
		    }
		    Thread.sleep(500);    
		    
	} 
	@Test(priority = 8, enabled = true)
	public void verifyTheMarkedFavoriteSiteFromManageSiteIsAddedInTheFavoriteList_Dashboard_TC_08() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);

        loginpage.getLoginButton().click();
		Actions act = new Actions(driver);
		act.moveToElement(dashboard.getsearchIcon()).perform();
		dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
		Thread.sleep(2000);
		dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(4000);			 
		act.click(dashboard.getmap()).build().perform();
		dashboard.getfavoriteIconSiteModal().click();
        Thread.sleep(500);
        dashboard.getcrosslink().click();
        Thread.sleep(500);
        dashboard.getfavoriteIcon().click();
        Thread.sleep(500);
        dashboard.getstarIconInFavoriteSite().click();
	    Thread.sleep(500);
	   
        String siteCount = dashboard.getsiteCount().getText();
        System.out.println("Passed: After Removing the site count = " +siteCount);
        
	    dashboard.getmanageSiteFirstElement().click();

        // Move to the second element
        act.moveToElement(dashboard.getmanageSiteSecondElement()).perform();

        // Click on the second element
        dashboard.getmanageSiteSecondElement().click();
        Thread.sleep(500);
	    dashboard.getsearchTextFieldManageSite().sendKeys("demo site 01");
	    Thread.sleep(500);
	    dashboard.getdemoSiteName().click();
	    Thread.sleep(500);
		dashboard.getfavoriteIconSiteModal().click();
		dashboard.getdashboardIcon().click();	
		dashboard.getfavoriteIcon().click();
		if(dashboard.getsiteName_demoSite01().isDisplayed()) {
			System.out.println("Passed: Favorite marked site from manage site is visible to the favorite icon UI");
		}
		else {
			System.out.println("Failed: Favorite marked site from manage site is not visible to the favorite icon UI");
		}
		Thread.sleep(500);
		if(dashboard.getstarIconInFavoriteSite().isDisplayed()) {
			System.out.println("Passed: After clicking on favorite  marker favorite icon is displayed in the UI");
		}
		else {
			System.out.println("Failed: After clicking on favorite marker favorite icon is not displayed in the UI");
		}
		String pageSource = driver.getPageSource();
		if(!pageSource.contains("0 Sites")) {
			System.out.println("Passed: Site count is more than zero");
		}
		else {
			System.out.println("Failed: Site count is zero");
		}
		Thread.sleep(500);
		dashboard.getstarIconInFavoriteSite().click();
		Thread.sleep(500);
	}
	
	@Test(priority = 9, enabled = true)
	public void verifyIfUserMakesASiteUnfavoriteFromTheManageSiteThenTheSameSiteCardIsRemovedFromTheDashboard_Dashboard_TC_09() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
		 
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			act.click(dashboard.getmap()).build().perform();
			Thread.sleep(500);
			dashboard.getfavoriteIconSiteModal().click();         
	        Thread.sleep(1000);
	       dashboard.getstarIconInFavoriteSite().click();
	      
	       dashboard.getcloseSiteModal().click();
	       dashboard.getdashboardIcon().click();
	       Thread.sleep(1000);
	       dashboard.getfavoriteIcon().click();
	       String pagesource = driver.getPageSource();
	       if(!pagesource.contains("0123N6")) {
	    	   System.out.println("Passed: The marked site's card is verified and removed from the favorite card list on the Dashboard.");
	       }
	       else {
	    	   System.out.println("Failed: The marked site's card is verified and not removed from the favorite card list on the Dashboard.");
	       }
	    	   
	       Thread.sleep(500);
	        
	       if(pagesource.contains("0 Sites")) {
				System.out.println("Passed: Site count is zero");
			}
			else {
				System.out.println("Failed: Site count is not zero");
			}
	}
	
	@Test(priority = 10, enabled = true)
	public void verifyTheUserCanSearchTheFavoriteSiteNameFromTheFavoriteSiteCardList_Dashboard_TC_10() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
		 
		Actions act = new Actions(driver);
		act.moveToElement(dashboard.getsearchIcon()).perform();
		dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
		Thread.sleep(2000);
		dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(4000);			 
		act.click(dashboard.getmap()).build().perform();
		Thread.sleep(500);
		dashboard.getfavoriteIconSiteModal().click();   
		Thread.sleep(500);
        dashboard.getcloseSiteModal().click();
        Thread.sleep(500);
		dashboard.getfavoriteIcon().click();
		Thread.sleep(500);
		dashboard.getsearchTextFieldManageSite().sendKeys("demo site 01");
		Thread.sleep(500);
		if(dashboard.getfavoriteIconSiteName_demosite01().isDisplayed()) {
			System.out.println("Passed: Favorite site is displaying in card view");
		}
		else {
			System.out.println("Failed: Favorite site is not displaying in card view");
		}
		dashboard.getstarIconInFavoriteSite().click();
	}
	
	@Test(priority = 11, enabled = true)
	public void verifyTheVisibilityOfFilterIcon_Dashboard_TC_11() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		Thread.sleep(500);
		SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
		int favoriteIconLocation = dashboard.getfavoriteIcon().getLocation().getX();
        
        int filterIconLocation = dashboard.getfilterIcon().getLocation().getX();
        
        
        if (filterIconLocation > favoriteIconLocation) {
            System.out.println("Element filterIcon is present to the right of element favoriteIcon.");
        } else {
            System.out.println("Element filterIcon is not present to the right of element favoriteIcon.");
        }
        Thread.sleep(500);
        String oldColor = dashboard.getfilterIcon().getCssValue("background-color");
        System.out.println("Old Color: " + oldColor);
      
        
        // Move the mouse cursor to the element
        Actions actions = new Actions(driver);
        actions.moveToElement(dashboard.getfilterIcon()).perform();
      
        
        // Get the new color of the element
        String newColor = dashboard.getfilterIcon().getCssValue("background-color");
        System.out.println("New Color: " + newColor);
        if(!newColor.equals(oldColor)) {
        	System.out.println("Passed: After Moving cursor to filter icon color is changed");
        }
        else {
			System.out.println("Failed: After Moving cursor to filter icon color is same");
		}   
        
	}
	
	   @Test(priority = 12, enabled = true)
	    public void verifyIfUserClicksOnFilterIconThenFilterModalIsOpened_Dashboard_TC_12() throws IOException, InterruptedException {
		SitennaLoginPage loginpage = new SitennaLoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		Thread.sleep(500);
		SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
		dashboard.getfilterIcon().click();
		
		if(dashboard.getcrossIcon()!= null) {
			System.out.println("Passed: cross icon is present in the UI");
		}
		else {
			System.out.println("Failed: cross icon is not present in the UI");
		}
	    Thread.sleep(500);
//		 boolean e1 = dashboard.getgreenfieldCheckBox().isDisplayed();
//		 boolean e2 = dashboard.getgreenfieldSiteType().isDisplayed();
//		 boolean e3 = dashboard.getrooftopCheckBox().isDisplayed();
//		 boolean e4 = dashboard.getrooftopfieldSiteType().isDisplayed();
//		 boolean e5 = dashboard.getstreetassetCheckBox().isDisplayed();
//		 boolean e6 = dashboard.getstreetassetSiteType().isDisplayed();
//		 boolean e7 = dashboard.gettowerCheckBox().isDisplayed();
//		 boolean e8 = dashboard.gettowerSiteType().isDisplayed();
//		 boolean e9 = dashboard.getmobileCheckBox().isDisplayed();
//		 boolean e10 = dashboard.getmobileSiteType().isDisplayed();
//		 boolean e11 = dashboard.getsiteTypeLabel().isDisplayed();
		 
//		 if (dashboard.getgreenfieldCheckBox().isDisplayed()) {
//	            System.out.println("pass");
//	        } else {
//	            System.out.println("fail");
//	        }
	    
	    String pagesource = driver.getPageSource();
	    Thread.sleep(500);
	    if(pagesource.contains("Greenfield") && pagesource.contains("Rooftop") && pagesource.contains("StreetAsset") && pagesource.contains("Tower") && pagesource.contains("MobileAsset") && pagesource.contains("Site Type"))  {
	    	System.out.println("Passed: All the site type fields with check box are visible to the UI");
	    }
	    else {
	    	System.out.println("Failed: All the site type fields with check box are not visible to the UI");
	    	}
	    Thread.sleep(500);
	    if(pagesource.contains("Site Subtype") && pagesource.contains("Active") && pagesource.contains("Passive") && pagesource.contains("NewBuild")) {
	    	System.out.println("Passed: All the site sub type fields with check box are visible to the UI");
	    }
	    else {
	    	System.out.println("Failed: All the site sub type fields with check box are not visible to the UI");
	    }
	    Thread.sleep(500);
	    if(pagesource.contains("Owner") &&  pagesource.contains("self_organization") && pagesource.contains("other_organization")) {
	    	System.out.println("Passed: All section owner organisation your organisation and other organisation are present and visible to the UI");
	    }
	    else {
	    	System.out.println("Failed: All section owner organisation your organisation and other organisation are not present and not visible to the UI");
	    }
	    Thread.sleep(500);
	    if (pagesource.contains("Classification") && pagesource.contains("Select Classification")) {
			System.out.println("Passed: Classification label with dropdown is verified and visible to the UI");
		}
	    else {
	    	System.out.println("Failed: Classificaion label  with dropdown is verified and not visible to the UI");
	    }
	    Thread.sleep(500);
	    if(pagesource.contains("Height Range") && pagesource.contains("From (meters)") && pagesource.contains("To (meters)")) {
	    	System.out.println("Passed: All fields of height Range is verified and visible to the UI");
	    }
	    else {
	    	System.out.println("Failed: All fields of height Range is  verified and not visible to the UI");
	    }
	    Thread.sleep(500);
	    if(pagesource.contains("Facilities") && pagesource.contains("Power") && pagesource.contains("Fibre")) {
	    	System.out.println("Passed: All facilities fields power and fibre is verified and visible to the UI");
	    }
	    else {
	    	System.out.println("Failed: All facilities fields power and fibre is verified and not visible to the UI");
	    }
	    Thread.sleep(500);
	    if(dashboard.getclearAllFilterLink().isDisplayed()) {
	    	System.out.println("Passed: Clear all filter link is verified and visible to the UI");
	    }
	    else {
	    	System.out.println("Failed: Clear all filter link is verified and not visible to the UI");
	    }
	    Thread.sleep(500);
	    if(dashboard.getapplyButton().isDisplayed()) {
	    	System.out.println("Passed: Apply button is verified and visible to the UI");
	    }
	    else {
	    	System.out.println("Failed: Aplly button is verified and not visible to the UI");
	    }
	}
	   
	   @Test(priority = 13, enabled = true)
	   public void verifyAUserCanSeeTheGreenFieldTypeSitesOnTheMapIfGreengieldSiteTypeCheckBoxIsApplied_Dashboard_TC_13() throws IOException, InterruptedException {
		   SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			dashboard.getfilterIcon().click();
			dashboard.getgreenfieldCheckBox().click();
			dashboard.getapplyButton().click();
			Thread.sleep(1000);
			act.click(dashboard.getmap()).build().perform();
			if(dashboard.getgreenFieldSiteModal().isDisplayed()) {
				System.out.println("Passed: Green field site is verified and displayed to the UI");
			}
			else {
				System.out.println("Failed: Green field site is verified and not displayed to the UI");
			}
			dashboard.getcloseSiteModal().click();
			Thread.sleep(500);
			if(dashboard.getfilterIconWithRedDot().isDisplayed()) {
				System.out.println("Passed: Filter icon with red dot is verified and visible to the UI");
			}
			
			else {
				System.out.println("Failed: Filter icon with red dot is verified and not visible to the Ui");
			}
			
			if(dashboard.getgreenFieldAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed()) {
				System.out.println("Passed: Green Field applied parameter and cross icon symbols are verified and displaying to the UI");
			}
			else {
				System.out.println("Failed; Green Field applied parameter and cross icon symbols are verifed and not displaying to the UI");
			}
			
			String color = dashboard.getgreenFieldAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color);
	        if(color.equals("rgba(217, 74, 111, 1)") || color.equals("rgba(217, 74, 111)") ) {
	        	System.out.println("Passed: Applied parameter name colour is verified and found correct");
	        }
	        else {
				System.out.println("Failed: Applied parameter name colour is verified and found incorrect");
			}   
	        
	        if(dashboard.getclearAllFilters().isDisplayed() && dashboard.clearAllFiltersCloseIcon().isDisplayed()) {
	        	System.out.println("Passed: Clear all filter with close icon is visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Clear all filter with close icon is not visible to the UI");
	        }
	        if(dashboard.gethideFilterLink().isDisplayed() && dashboard.gethideFilterLinkWithUpsideArrow().isDisplayed()) {
	        	System.out.println("Passed: Hide Visible Link With Upside Arrows are visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Hide Visible Link With Upside Arrows are not visible to the UI");
	        }
	   }
	   
	   @Test(priority = 14, enabled = true)
	   public void verifyAUserCanSeeTheRoofTopTypeSitesOnTheMapIfRoofTopSiteTypeCheckBoxIsApplied_Dashboard_TC_14() throws IOException, InterruptedException {
		   SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02489 Lng: -84.49498");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			dashboard.getfilterIcon().click();
			dashboard.getrooftopCheckBox().click();
			dashboard.getapplyButton().click();
			Thread.sleep(1000);
			act.click(dashboard.getmap()).build().perform();
			if(dashboard.getroofTopSiteModal().isDisplayed()) {
				System.out.println("Passed: RoofTop site is verified and displayed to the UI");
			}
			else {
				System.out.println("Failed: RoofTop site is verified and not displayed to the UI");
			}
			dashboard.getcloseSiteModal().click();
			Thread.sleep(500);
			if(dashboard.getfilterIconWithRedDot().isDisplayed()) {
				System.out.println("Passed: Filter icon with red dot is verified and visible to the UI");
			}
			else {
				System.out.println("Failed: Filter icon with red dot is verified and not visible to the Ui");
			}
			Thread.sleep(500);
			
			if(dashboard.getroofTopAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed()) {
				System.out.println("Passed: Roof Top applied parameter and cross icon symbols are verified and displaying to the UI");
			}
			else {
				System.out.println("Failed; Roof Top applied parameter and cross icon symbols are verifed and not displaying to the UI");
			}
			
			String color = dashboard.getroofTopAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color);
	        if(color.equals("rgba(217, 74, 111, 1)") || color.equals("rgba(217, 74, 111)") ) {
	        	System.out.println("Passed: Applied parameter name colour is verified and found correct");
	        }
	        else {
				System.out.println("Failed: Applied parameter name colour is verified and found incorrect");
			}   
	        
	        if(dashboard.getclearAllFilters().isDisplayed() && dashboard.clearAllFiltersCloseIcon().isDisplayed()) {
	        	System.out.println("Passed: Clear all filter with close icon is visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Clear all filter with close icon is not visible to the UI");
	        }
	        if(dashboard.gethideFilterLink().isDisplayed() && dashboard.gethideFilterLinkWithUpsideArrow().isDisplayed()) {
	        	System.out.println("Passed: Hide Visible Link With Upside Arrows are visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Hide Visible Link With Upside Arrows are not visible to the UI");
	        }	
	   }
	   
	   @Test(priority = 15, enabled = true)
	   public void verifyAUserCanSeeTheStreetAssetTypeSitesOnTheMapIfStreetAssetSiteTypeCheckBoxIsApplied_Dashboard_TC_15() throws IOException, InterruptedException {
		   SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02652 Lng: -84.49413");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			dashboard.getfilterIcon().click();
			dashboard.getstreetassetCheckBox().click();
			dashboard.getapplyButton().click();
			Thread.sleep(1000);
			act.click(dashboard.getmap()).build().perform();
			Thread.sleep(501);
			if(dashboard.getstreetAssetSiteModal().isDisplayed()) {
				System.out.println("Passed: Street Asset site is verified and displayed to the UI");
			}
			else {
				System.out.println("Failed: Street Asset site is verified and not displayed to the UI");
			}
			dashboard.getcloseSiteModal().click();
			Thread.sleep(500);
			if(dashboard.getfilterIconWithRedDot().isDisplayed()) {
				System.out.println("Passed: Filter icon with red dot is verified and visible to the UI");
			}
			else {
				System.out.println("Failed: Filter icon with red dot is verified and not visible to the Ui");
			}
			Thread.sleep(501);
			if(dashboard.getstreetAssetAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed()) {
				System.out.println("Passed: Roof Top applied parameter and cross icon symbols are verified and displaying to the UI");
			}
			else {
				System.out.println("Failed; Roof Top applied parameter and cross icon symbols are verifed and not displaying to the UI");
			}
			
			String color = dashboard.getstreetAssetAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color);
	        if(color.equals("rgba(217, 74, 111, 1)") || color.equals("rgba(217, 74, 111)") ) {
	        	System.out.println("Passed: Applied parameter name colour is verified and found correct");
	        }
	        else {
				System.out.println("Failed: Applied parameter name colour is verified and found incorrect");
			}   
	        
	        if(dashboard.getclearAllFilters().isDisplayed() && dashboard.clearAllFiltersCloseIcon().isDisplayed()) {
	        	System.out.println("Passed: Clear all filter with close icon is visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Clear all filter with close icon is not visible to the UI");
	        }
	        if(dashboard.gethideFilterLink().isDisplayed() && dashboard.gethideFilterLinkWithUpsideArrow().isDisplayed()) {
	        	System.out.println("Passed: Hide Visible Link With Upside Arrows are visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Hide Visible Link With Upside Arrows are not visible to the UI");
	        }
			
	   }
	   @Test(priority = 18, enabled = true)
	   public void verifyAUserCanSeeTheGreenFieldAndRoofTopSitesByGreenFieldAndRoofTopParametersappliedTogether_Dashboard_TC_18() throws IOException, InterruptedException {
		   SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02606 Lng: -84.49468");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			dashboard.getfilterIcon().click();
			dashboard.getgreenfieldCheckBox().click();
			Thread.sleep(500);
			dashboard.getrooftopCheckBox().click();
			Thread.sleep(500);
			dashboard.getapplyButton().click();
			Thread.sleep(500);
			act.click(dashboard.getmap()).build().perform();
			
			if(dashboard.getgreenFieldSiteModal().isDisplayed() ) {
				System.out.println("Passed: Green Field site is verified and displaying to the UI");
			}
			else {
				System.out.println("Failed: Green Field site is verified and not displaying to the UI");
			}
			Thread.sleep(500);
			dashboard.getcloseSiteModal().click();
			Thread.sleep(1000);
			/* start */
			
			
			act.moveToElement(dashboard.getsearchTextField()).perform();
			dashboard.getsearchIconFieldCrossIcon().click();
//			Thread.sleep(3000);
//			dashboard.getsearchTextField().sendKeys("Lat: 38.02572 Lng: -84.49471");
			dashboard.getsearchTextField().sendKeys("Lat: 38.02572 Lng: -84.49471");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);
            act.click(dashboard.getmap()).build().perform();
			
			if(dashboard.getroofTopSiteModal().isDisplayed() ) {
				System.out.println("Passed: Roof Top site is verified and displaying to the UI");
			}
			else {
				System.out.println("Failed: Roof Top site is verified and not displaying to the UI");
			}
			dashboard.getcloseSiteModal().click();
			Thread.sleep(500);
			
			
			if(dashboard.getfilterIconWithRedDot().isDisplayed()) {
				System.out.println("Passed: Filter icon with red dot is verified and visible to the UI");
			}
			else {
				System.out.println("Failed: Filter icon with red dot is verified and not visible to the UI");
			}
			Thread.sleep(501);
			if(dashboard.getgreenFieldAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed() && dashboard.getroofTopAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed()) {
				System.out.println("Passed: Roof Top applied parameter and cross icon symbols are verified and displaying to the UI");
			}
			else {
				System.out.println("Failed; Roof Top applied parameter and cross icon symbols are verifed and not displaying to the UI");
			}
			
			String color1 = dashboard.getgreenFieldAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color1);
	        String color2 = dashboard.getroofTopAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color2);
	        if(color1.equals("rgba(217, 74, 111, 1)") || color1.equals("rgba(217, 74, 111)")   &&  color2.equals("rgba(217, 74, 111, 1)") || color2.equals("rgba(217, 74, 111)")) {
	        	System.out.println("Passed: Applied parameters name colour is verified and found correct");
	        }
	        else {
				System.out.println("Failed: Applied parameters name colour is verified and found incorrect");
			}   
//	        
	        if(dashboard.getclearAllFilters().isDisplayed() && dashboard.clearAllFiltersCloseIcon().isDisplayed()) {
	        	System.out.println("Passed: Clear all filter with close icon is visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Clear all filter with close icon is not visible to the UI");
	        }
	        if(dashboard.gethideFilterLink().isDisplayed() && dashboard.gethideFilterLinkWithUpsideArrow().isDisplayed()) {
	        	System.out.println("Passed: Hide Visible Link With Upside Arrows are visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Hide Visible Link With Upside Arrows are not visible to the UI");
	        }
			
	   }
	   
	   @Test(priority = 19, enabled = true)
	   public void verifyIfUserAppliesTheGreenfieldAndStreetAssetParameterTogether_Dashboard_TC_19() throws IOException,InterruptedException {
		   SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02606 Lng: -84.49468");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			dashboard.getfilterIcon().click();
			dashboard.getgreenfieldCheckBox().click();
			Thread.sleep(500);
			dashboard.getstreetassetCheckBox().click();
			Thread.sleep(500);
			dashboard.getapplyButton().click();
			Thread.sleep(500);
			act.click(dashboard.getmap()).build().perform();
			
			if(dashboard.getgreenFieldSiteModal().isDisplayed() ) {
				System.out.println("Passed: Green Field site is verified and displaying to the UI");
			}
			else {
				System.out.println("Failed: Green Field site is verified and not displaying to the UI");
			}
			Thread.sleep(500);
			dashboard.getcloseSiteModal().click();
			Thread.sleep(1000);
			/* start */
			
			
			act.moveToElement(dashboard.getsearchTextField()).perform();
			dashboard.getsearchIconFieldCrossIcon().click();
//			Thread.sleep(3000);
//			dashboard.getsearchTextField().sendKeys("Lat: 38.02572 Lng: -84.49471");
			dashboard.getsearchTextField().sendKeys("Lat: 38.02652 Lng: -84.49413");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);
           act.click(dashboard.getmap()).build().perform();
			
			if(dashboard.getstreetAssetSiteModal().isDisplayed() ) {
				System.out.println("Passed: Roof Top site is verified and displaying to the UI");
			}
			else {
				System.out.println("Failed: Roof Top site is verified and not displaying to the UI");
			}
			dashboard.getcloseSiteModal().click();
			Thread.sleep(500);
			
			
			if(dashboard.getfilterIconWithRedDot().isDisplayed()) {
				System.out.println("Passed: Filter icon with red dot is verified and visible to the UI");
			}
			else {
				System.out.println("Failed: Filter icon with red dot is verified and not visible to the UI");
			}
			Thread.sleep(501);
			if(dashboard.getgreenFieldAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed() && dashboard.getstreetAssetAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed()) {
				System.out.println("Passed: Roof Top applied parameter and cross icon symbols are verified and displaying to the UI");
			}
			else {
				System.out.println("Failed; Roof Top applied parameter and cross icon symbols are verifed and not displaying to the UI");
			}
			
			String color1 = dashboard.getgreenFieldAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color1);
	        String color2 = dashboard.getstreetAssetAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color2);
	        if(color1.equals("rgba(217, 74, 111, 1)") || color1.equals("rgba(217, 74, 111)")   &&  color2.equals("rgba(217, 74, 111, 1)") || color2.equals("rgba(217, 74, 111)")) {
	        	System.out.println("Passed: Applied parameters name colour is verified and found correct");
	        }
	        else {
				System.out.println("Failed: Applied parameters name colour is verified and found incorrect");
			}   
	        
	        if(dashboard.getclearAllFilters().isDisplayed() && dashboard.clearAllFiltersCloseIcon().isDisplayed()) {
	        	System.out.println("Passed: Clear all filter with close icon is visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Clear all filter with close icon is not visible to the UI");
	        }
	        if(dashboard.gethideFilterLink().isDisplayed() && dashboard.gethideFilterLinkWithUpsideArrow().isDisplayed()) {
	        	System.out.println("Passed: Hide Visible Link With Upside Arrows are visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Hide Visible Link With Upside Arrows are not visible to the UI");
	        }
	   }
	   
	   @Test(priority = 20, enabled = true)
	   public void verifyIfUserAppliesTheRoofTopAndStreetAssetParameterTogether_Dashboard_TC_20() throws IOException, InterruptedException {
		   
			   SitennaLoginPage loginpage = new SitennaLoginPage(driver);
				loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
				loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
				loginpage.getLoginButton().click();
				Thread.sleep(500);
				SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
				
				Actions act = new Actions(driver);
				act.moveToElement(dashboard.getsearchIcon()).perform();
				dashboard.getsearchTextField().sendKeys("Lat: 38.02489 Lng: -84.49498");
				Thread.sleep(2000);
				dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				Thread.sleep(4000);			 
				dashboard.getfilterIcon().click();
				dashboard.getrooftopCheckBox().click();
				Thread.sleep(500);
				dashboard.getstreetassetCheckBox().click();
				Thread.sleep(500);
				dashboard.getapplyButton().click();
				Thread.sleep(500);
				act.click(dashboard.getmap()).build().perform();
				
				if(dashboard.getroofTopSiteModal().isDisplayed() ) {
					System.out.println("Passed: Street Asset site is verified and displaying to the UI");
				}
				else {
					System.out.println("Failed: Street Asset site is verified and not displaying to the UI");
				}
				Thread.sleep(500);
				dashboard.getcloseSiteModal().click();
				Thread.sleep(1000);
				/* start */
				
				
				act.moveToElement(dashboard.getsearchTextField()).perform();
				dashboard.getsearchIconFieldCrossIcon().click();
//				Thread.sleep(3000);
//				dashboard.getsearchTextField().sendKeys("Lat: 38.02572 Lng: -84.49471");
				dashboard.getsearchTextField().sendKeys("Lat: 38.02652 Lng: -84.49413");
				Thread.sleep(2000);
				dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				Thread.sleep(4000);
	           act.click(dashboard.getmap()).build().perform();
				
				if(dashboard.getstreetAssetSiteModal().isDisplayed() ) {
					System.out.println("Passed: Roof Top site is verified and displaying to the UI");
				}
				else {
					System.out.println("Failed: Roof Top site is verified and not displaying to the UI");
				}
				dashboard.getcloseSiteModal().click();
				Thread.sleep(500);
				
				
				if(dashboard.getfilterIconWithRedDot().isDisplayed()) {
					System.out.println("Passed: Filter icon with red dot is verified and visible to the UI");
				}
				else {
					System.out.println("Failed: Filter icon with red dot is verified and not visible to the UI");
				}
				Thread.sleep(501);
				if(dashboard.getroofTopAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed() && dashboard.getstreetAssetAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed()) {
					System.out.println("Passed: Roof Top and street asset applied parameter and cross icon symbols are verified and displaying to the UI");
				}
				else {
					System.out.println("Failed: Roof Top and street asset  applied parameter and cross icon symbols are verifed and not displaying to the UI");
				}
				
				String color1 = dashboard.getroofTopAppliedParameter().getCssValue("background-color");
		        System.out.println(" Color: " + color1);
		        String color2 = dashboard.getstreetAssetAppliedParameter().getCssValue("background-color");
		        if(color1.equals("rgba(217, 74, 111, 1)") || color1.equals("rgba(217, 74, 111)")   &&  color2.equals("rgba(217, 74, 111, 1)") || color2.equals("rgba(217, 74, 111)")) {
		        	System.out.println("Passed: Applied parameters name colour is verified and found correct");
		        }
		        else {
					System.out.println("Failed: Applied parameters name colour is verified and found incorrect");
				}   
		        
		        if(dashboard.getclearAllFilters().isDisplayed() && dashboard.clearAllFiltersCloseIcon().isDisplayed()) {
		        	System.out.println("Passed: Clear all filter with close icon is visible to the UI");
		        }
		        else {
		        	System.out.println("Failed: Clear all filter with close icon is not visible to the UI");
		        }
		        if(dashboard.gethideFilterLink().isDisplayed() && dashboard.gethideFilterLinkWithUpsideArrow().isDisplayed()) {
		        	System.out.println("Passed: Hide Visible Link With Upside Arrows are visible to the UI");
		        }
		        else {
		        	System.out.println("Failed: Hide Visible Link With Upside Arrows are not visible to the UI");
		        }
	   }
	   
	   @Test(priority = 21, enabled = true)
	   public void verifyIfUserAppliesTheGreenFieldRoofTopAndStreetAssetParameterTogether_Dashboard_TC_21() throws IOException, InterruptedException {
		   SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			
			Actions act = new Actions(driver);
			act.moveToElement(dashboard.getsearchIcon()).perform();
			dashboard.getsearchTextField().sendKeys("Lat: 38.02489 Lng: -84.49498");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);			 
			dashboard.getfilterIcon().click();
			dashboard.getgreenfieldCheckBox().click();
			Thread.sleep(500);
			dashboard.getrooftopCheckBox().click();
			Thread.sleep(500);
			dashboard.getstreetassetCheckBox().click();
			Thread.sleep(500);
			dashboard.getapplyButton().click();
			Thread.sleep(500);
			act.click(dashboard.getmap()).build().perform();
			
			if(dashboard.getroofTopSiteModal().isDisplayed() ) {
				System.out.println("Passed: Street Asset site is verified and displaying to the UI");
			}
			else {
				System.out.println("Failed: Street Asset site is verified and not displaying to the UI");
			}
			Thread.sleep(500);
			dashboard.getcloseSiteModal().click();
			Thread.sleep(1000);
			/* start */
			
			
			act.moveToElement(dashboard.getsearchTextField()).perform();
			dashboard.getsearchIconFieldCrossIcon().click();
//			Thread.sleep(3000);
//			dashboard.getsearchTextField().sendKeys("Lat: 38.02572 Lng: -84.49471");
			dashboard.getsearchTextField().sendKeys("Lat: 38.02652 Lng: -84.49413");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);
          act.click(dashboard.getmap()).build().perform();
			
			if(dashboard.getstreetAssetSiteModal().isDisplayed() ) {
				System.out.println("Passed: Roof Top site is verified and displaying to the UI");
			}
			else {
				System.out.println("Failed: Roof Top site is verified and not displaying to the UI");
			}
			dashboard.getcloseSiteModal().click();
			Thread.sleep(1000);
			
			/*start here 3rd*/
			
			act.moveToElement(dashboard.getsearchTextField()).perform();
			dashboard.getsearchIconFieldCrossIcon().click();
//			Thread.sleep(3000);
//			dashboard.getsearchTextField().sendKeys("Lat: 38.02572 Lng: -84.49471");
			dashboard.getsearchTextField().sendKeys("Lat: 38.02805 Lng: -84.49438");
			Thread.sleep(2000);
			dashboard.getsearchTextField().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(4000);
            act.click(dashboard.getmap()).build().perform();
			
			if(dashboard.getgreenFieldSiteModal().isDisplayed() ) {
				System.out.println("Passed: Green Field site is verified and displaying to the UI");
			}
			else {
				System.out.println("Failed: Green Field site is verified and not displaying to the UI");
			}
			dashboard.getcloseSiteModal().click();
			Thread.sleep(500);
			
		   /* ends here*/
			
			if(dashboard.getfilterIconWithRedDot().isDisplayed()) {
				System.out.println("Passed: Filter icon with red dot is verified and visible to the UI");
			}
			else {
				System.out.println("Failed: Filter icon with red dot is verified and not visible to the Ui");
			}
			Thread.sleep(501);
			if(dashboard.getroofTopAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed() && dashboard.getstreetAssetAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed() &&
					dashboard.getgreenFieldAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed()) {
				System.out.println("Passed: Roof Top and street asset applied parameter and cross icon symbols are verified and displaying to the UI");
			}
			else {
				System.out.println("Failed: Roof Top and street asset  applied parameter and cross icon symbols are verifed and not displaying to the UI");
			}
			
			String color1 = dashboard.getroofTopAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color1);
	        String color2 = dashboard.getstreetAssetAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color2);
	        String color3 = dashboard.getgreenFieldAppliedParameter().getCssValue("background-color");
	        System.out.println(" Color: " + color3);
	        
	        if(color1.equals("rgba(217, 74, 111, 1)") || color1.equals("rgba(217, 74, 111)")   &&  color2.equals("rgba(217, 74, 111, 1)") || color2.equals("rgba(217, 74, 111)") &&
	        		color3.equals("rgba(217, 74, 111, 1)") || color3.equals("rgba(217, 74, 111)")) {
	        	System.out.println("Passed: Applied parameters name colour is verified and found correct");
	        }
	        else {
				System.out.println("Failed: Applied parameters name colour is verified and found incorrect");
			}   
	        
	        if(dashboard.getclearAllFilters().isDisplayed() && dashboard.clearAllFiltersCloseIcon().isDisplayed()) {
	        	System.out.println("Passed: Clear all filter with close icon is visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Clear all filter with close icon is not visible to the UI");
	        }
	        if(dashboard.gethideFilterLink().isDisplayed() && dashboard.gethideFilterLinkWithUpsideArrow().isDisplayed()) {
	        	System.out.println("Passed: Hide Visible Link With Upside Arrows are visible to the UI");
	        }
	        else {
	        	System.out.println("Failed: Hide Visible Link With Upside Arrows are not visible to the UI");
	        }
			
	   }
	   
	   @Test(priority = 22, enabled = true)
	   public void verifyAUserCanCloseThefilterModalByCrossIcon() throws IOException, InterruptedException {
		   SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			dashboard.getfilterIcon().click();
			Thread.sleep(500);
			String filterText = dashboard.getfilterHeading().getText();
			System.out.println("After clicking on filter icon filter modal heading is " +filterText);
			boolean filterHeading = dashboard.getfilterHeading().isDisplayed();
			System.out.println("After clicking on the Filter icon Filter Heading is visible: " +filterHeading);
			dashboard.getcrossIcon().click();
			
            if(dashboard.getfilterIcon().isDisplayed()) {
            	System.out.println("Passed: After clilcking cross icon in Filter modal back filter icon is displaying to the UI");
            }
            else {
            	System.out.println("Failed: After clicking cross icon in Filter modal back filter icon is not displaying to the UI");
            }
	  }
	   
      @Test(priority = 23, enabled = true) 
	  public void verifyAUserCanCloseTheFilterModalByCrossIconWithoutRemovingTheCheckBoxes() throws IOException, InterruptedException {
    	  SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			dashboard.getfilterIcon().click();
			Thread.sleep(500);
			dashboard.getgreenfieldCheckBox().click();
			
			dashboard.getrooftopCheckBox().click();
			dashboard.getapplyButton().click();
			Thread.sleep(500);
			dashboard.getfilterIconWithRedDot().click();
			
			dashboard.getcrossIcon().click();
			Thread.sleep(500);
			if(dashboard.getfilterIcon().isDisplayed()) {
            	System.out.println("Passed: After clilcking cross icon in Filter modal back filter icon is displaying to the UI");
            }
            else {
            	System.out.println("Failed: After clicking cross icon in Filter modal back filter icon is not displaying to the UI");
            }
			
			if(dashboard.getgreenFieldAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed() && dashboard.getroofTopAppliedParameter().isDisplayed() && dashboard.getcrossIconAppliedParameter().isDisplayed()) {
				System.out.println("Passed: Roof Top applied parameter and cross icon symbols are verified and displaying to the UI");
			}
			else {
				System.out.println("Failed; Roof Top applied parameter and cross icon symbols are verifed and not displaying to the UI");
			}
	   }
      
      @Test(priority = 24, enabled = true)
      public void verifyAUserCanClearTheFilterFromMapByParameterCrossIcon() throws IOException, InterruptedException {
    	    SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			dashboard.getfilterIcon().click();
			Thread.sleep(500);
			dashboard.getgreenfieldCheckBox().click();
			
			
			dashboard.getapplyButton().click();
			Thread.sleep(5000);
			dashboard.getcrossIconAppliedParameter().click();
			Thread.sleep(500);
			
			
      }
      
      @Test(priority = 25, enabled = true)
      public void verifyAUserCanClearTheFilterFromMapByClearAllFilterLinkOnFilterModal() throws IOException, InterruptedException {
    	  SitennaLoginPage loginpage = new SitennaLoginPage(driver);
			loginpage.getEmailTextField().sendKeys(fileUtils.readThedataFromPropertyFile("username"));
			loginpage.getPasswordTextField().sendKeys(fileUtils.readThedataFromPropertyFile("password"));
			loginpage.getLoginButton().click();
			Thread.sleep(500);
			SitennaDashboardPage dashboard = new SitennaDashboardPage(driver);
			dashboard.getfilterIcon().click();
			Thread.sleep(500);
			dashboard.getrooftopCheckBox().click();
			dashboard.getapplyButton().click();
			Thread.sleep(3000);
			dashboard.getcrossIconAppliedParameter().click();
			Thread.sleep(3000);
			dashboard.getfilterIcon().click();
			Thread.sleep(3000);
			if(!dashboard.getrooftopCheckBox().isSelected()) {
				System.out.println("Passed: After click on crossed applied parameter Rooftop field check box is not selected");
			}
			else {
				System.out.println("Failed: After click on crossed applied parameter Rooftop field check box is selected");
			}
			Thread.sleep(3000);
			dashboard.getcrossIcon().click();
//			String pageSource = driver.getPageSource();
//			if(!pageSource.contains("Rooftop")) {
//				System.out.println("pass");
//			}
//			else {
//				System.out.println("Fail");
//			}
//			if(dashboard.getroofTopAppliedParameter().isEnabled()) {
//				System.out.println("pass");
//			}
//			else {
//				System.out.println("Fail");
//			}
			
					
			
      }

	
	
	
}
