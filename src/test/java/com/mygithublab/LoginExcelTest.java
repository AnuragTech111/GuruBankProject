package com.mygithublab;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.BaseBrowserExcelData;
import resources.ExcelDataDriven;


public class LoginExcelTest extends BaseBrowserExcelData {
	
	@Test
	public void loginValidFromExcelDataSS1() throws IOException
	{
		//ExcelDataDriven exc = new ExcelDataDriven();
		//ArrayList<String> dataList = exc.getData("Login Valid");
		
		/* 
		System.out.println(dataList.get(0));
		System.out.println(dataList.get(1));
		System.out.println(dataList.get(2));
		System.out.println(dataList.get(3));
		System.out.println(dataList.get(4));
		*/
		
		navigateToLoginPage();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(dataList.get(3));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataList.get(4));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String titleHome = driver.getTitle();
		System.out.println(titleHome);
		
		Assert.assertEquals(titleHome, "Guru99 Bank Manager HomePage");
		
		
	}

}
