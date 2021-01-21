package com.mygithublab;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.BaseBrowser;

public class LoginTest extends BaseBrowser{
	
	private static Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	LoginPage loginPage;
	WebDriver driver;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver = driverInitialization();
		driver.get(prop.getProperty("loginPageUrl"));
		loginPage = new LoginPage(driver);
		
	}
	
	@Test
	public void loginByValidUserSS1() throws IOException
	{
		//driver = driverInitialization();
		//driver.get(prop.getProperty("loginPageUrl"));
		//log.info("Login page is displayed successfully");
		
		//navigateToLoginPage();
		
		loginPage.getUsername().sendKeys(prop.getProperty("username"));
		loginPage.getPassword().sendKeys(prop.getProperty("password"));
		loginPage.getLoginSubmit().click();
		log.info("User login successfully");
		
		String titleHome = driver.getTitle();
		System.out.println(titleHome);
		
		Assert.assertEquals(titleHome, "Guru99 Bank Manager HomePage");
	}
	
	@Test
	public void loginByInvalidUserSS2() throws IOException
	{
		//navigateToLoginPage();
		
		loginPage.getUsername().sendKeys(prop.getProperty("invalidUsername"));
		loginPage.getPassword().sendKeys(prop.getProperty("password"));
		loginPage.getLoginSubmit().click();
		log.info("Username or Password is not correct");
		
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
		
		Assert.assertEquals(alertMessage, "User or Password is not valid");
	}
	
	@Test
	public void loginByInvalidPassSS3() throws IOException
	{
		//navigateToLoginPage();
		
		loginPage.getUsername().sendKeys(prop.getProperty("username"));
		loginPage.getPassword().sendKeys(prop.getProperty("invalidPassword"));
		loginPage.getLoginSubmit().click();
		log.info("Username or Password is not correct");
		
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
		
		Assert.assertEquals(alertMessage, "User or Password is not valid");
	}
	
	@Test
	public void loginByInvalidUserPassSS4() throws IOException
	{
		//navigateToLoginPage();
		
		loginPage.getUsername().sendKeys(prop.getProperty("invalidUsername"));
		loginPage.getPassword().sendKeys(prop.getProperty("invalidPassword"));
		loginPage.getLoginSubmit().click();
		log.info("Username or Password is not correct");
		
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
		
		Assert.assertEquals(alertMessage, "User or Password is not valid");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	}
}
