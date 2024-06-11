package com.xotiv.sitenna.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassUtility {
	
	 private WebDriver driver;
	    private Actions actions;

	    public ActionsClassUtility(WebDriver driver) {
	        this.driver = driver;
	        this.actions = new Actions(driver);
	    }

	    // Method for mouse hover action
	    public void hoverOverElement(WebElement element) {
	        actions.moveToElement(element).perform();
	    }

	    // Method for double click action
	    public void doubleClickElement(WebElement element) {
	        actions.doubleClick(element).perform();
	    }

	    // Method for drag and drop action
	    public void dragAndDrop(WebElement source, WebElement target) {
	        actions.dragAndDrop(source, target).perform();
	    }
	    
	    public void scrollByAmount(WebElement source) {
	    	
			actions.scrollByAmount(100 , 0).perform();
	    }
	    public void clickElement(WebElement element) {
	    	actions.click(element);
	    }
	    
/*------------------------------------------------------------------------------------*/
          
	    

}
