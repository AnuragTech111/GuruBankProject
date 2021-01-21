package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By username = By.xpath("//input[@name='uid']");
	By password = By.xpath("//input[@name='password']");
	By loginSubmit = By.xpath("//input[@type='submit']");
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLoginSubmit()
	{
		return driver.findElement(loginSubmit);
	}

}
