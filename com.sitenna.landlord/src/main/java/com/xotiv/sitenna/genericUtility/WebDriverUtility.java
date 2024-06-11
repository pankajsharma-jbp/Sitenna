package com.xotiv.sitenna.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
