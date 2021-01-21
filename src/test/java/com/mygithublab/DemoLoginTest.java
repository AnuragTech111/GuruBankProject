package com.mygithublab;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.BaseBrowser;

public class DemoLoginTest extends BaseBrowser{
	
	private static Logger log = LogManager.getLogger(DemoLoginTest.class.getName());

	@Test
	public void loginByValidUserDemo() throws IOException
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
	
}
