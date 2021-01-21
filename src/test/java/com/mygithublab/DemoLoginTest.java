package com.mygithublab;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.BaseBrowser;

public class DemoLoginTest extends BaseBrowser{
	
	private static Logger log = LogManager.getLogger(DemoLoginTest.class.getName());

	LoginPage loginPage;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver = driverInitialization();
		driver.get(prop.getProperty("loginPageUrl"));
		loginPage = new LoginPage(driver);
	} 
	
	
	@Test
	public void loginByValidUserDemo() throws IOException
	{
		//driver = driverInitialization();
		//driver.get(prop.getProperty("loginPageUrl"));
		//log.info("Login page is displayed successfully");
		
		//navigateToLoginPage();
		
		loginPage.getUsername().sendKeys(prop.getProperty("username"));
		loginPage.getPassword().sendKeys(prop.getProperty("invalidPassword"));
		loginPage.getLoginSubmit().click(); 
		/* 
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		*/
        log.error("Username or Password is not correct");
		
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage, "Username or Password is not correct");
		/*log.info("User login successfully");
		String titleHome = driver.getTitle();
		System.out.println(titleHome); */
		
		//Assert.assertEquals(titleHome, "Guru99 Bank Manager HomePage");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	} 
	
}
