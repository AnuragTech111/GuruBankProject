package com.mygithublab;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.BaseBrowser;

public class LoginTest extends BaseBrowser{
	
	private static Logger log = LogManager.getLogger(LoginTest.class.getName());

	@Test
	public void loginByValidUserSS1() throws IOException
	{
		//driver = driverInitialization();
		//driver.get(prop.getProperty("loginPageUrl"));
		//log.info("Login page is displayed successfully");
		
		navigateToLoginPage();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		log.info("User login successfully");
		log.error("User login successfully error demo 1");
		log.fatal("User login successfully fatal demo 2");
		log.debug("User login successfully debug demo 3");
		String titleHome = driver.getTitle();
		System.out.println(titleHome);
		
		Assert.assertEquals(titleHome, "Guru99 Bank Manager HomePage");
	}
	
	@Test
	public void loginByInvalidUserSS2() throws IOException
	{
		navigateToLoginPage();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(prop.getProperty("invalidUsername"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		log.info("User login successfully");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
		
		Assert.assertEquals(alertMessage, "User or Password is not valid");
	}
	
	@Test
	public void loginByInvalidPassSS3() throws IOException
	{
		navigateToLoginPage();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		log.info("User login successfully");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
		
		Assert.assertEquals(alertMessage, "User or Password is not valid");
	}
	
	@Test
	public void loginByInvalidUserPassSS4() throws IOException
	{
		navigateToLoginPage();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(prop.getProperty("invalidUsername"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		log.info("User login successfully");
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
		
		Assert.assertEquals(alertMessage, "User or Password is not valid");
	}
	
}
