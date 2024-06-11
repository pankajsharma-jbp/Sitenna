package com.sitenna.landlord;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SitennaProjectModule {
   public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://qa.sitenna.com/#/auth/signin");
	
	// login to the page 
	driver.findElement(By.id("login_email")).sendKeys("vyas.aneesh@gmail.com");
	driver.findElement(By.id("login_password")).sendKeys("Password@1234");
	driver.findElement(By.xpath("//span[contains(text(),  ' Log In ')]")).click();
	
	//click on a project 
	driver.findElement(By.xpath("//img[@src = './assets/images/icon-forward.svg']")).click();
	driver.findElement(By.xpath("//span[contains(text(),' Projects ')]")).click();
	
	// click on create project 
	driver.findElement(By.xpath("//span[contains(text() , 'Create Project ')]")).click();
	
	
}
}
