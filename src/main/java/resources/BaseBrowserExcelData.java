package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseBrowserExcelData {

	public static WebDriver driver;
	public ExcelDataDriven exc;
	public ArrayList<String> dataList;
	
	public WebDriver driverInitialization() throws IOException {
		
		exc = new ExcelDataDriven();
		dataList = exc.getData("Login Valid");
		
		String browserName = dataList.get(1);
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Mindscript sir\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
			// firefox code
		}
		else if(browserName.equals("IE"))
		{
			// Internet code
		}
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public void navigateToLoginPage() throws IOException
	{
		driver = driverInitialization();
		driver.get(dataList.get(2));
		
	}

}
