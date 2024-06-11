package com.sitenna.landlord;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SourceCodeTesting {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://qa.sitenna.com"); 

       
        driver.findElement(By.id("login_email")).sendKeys("pankajoperator@mailinator.com");
		driver.findElement(By.id("login_password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//span[contains(text(), 'Log In')]")).click();
		
	String 	ab=driver.getPageSource();
		
	System.out.println(ab);
	}

}
