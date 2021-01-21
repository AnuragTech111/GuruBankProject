package com.mygithublab;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.BaseBrowserExcelData;
import resources.ExcelDataDriven;


public class LoginExcelTest extends BaseBrowserExcelData {
	
	private static Logger log = LogManager.getLogger(DemoLoginTest.class.getName());

	WebDriver driver =null;
	LoginPage loginPage;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver = driverInitialization();
		driver.get(dataList.get(2));
		loginPage = new LoginPage(driver);
	} 
	
	@Test
	public void loginValidFromExcelDataSS1() throws IOException
	{
		//ExcelDataDriven exc = new ExcelDataDriven();
		//ArrayList<String> dataList = exc.getData("Login Valid");
		
		
		loginPage.getUsername().sendKeys(dataList.get(3));
		loginPage.getPassword().sendKeys(dataList.get(4));
		loginPage.getLoginSubmit().click();
		log.info("User login successfully");
		
		String titleHome = driver.getTitle();
		System.out.println(titleHome);
		
		Assert.assertEquals(titleHome, "Guru99 Bank Manager HomePage");
		// --------- Old code --------
		/*
		navigateToLoginPage();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(dataList.get(3));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataList.get(4));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String titleHome = driver.getTitle();
		System.out.println(titleHome);
		
		Assert.assertEquals(titleHome, "Guru99 Bank Manager HomePage");
		*/
		
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	} 

}
