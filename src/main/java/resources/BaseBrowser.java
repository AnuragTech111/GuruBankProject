package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseBrowser {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver driverInitialization() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Anurag\\Github Projects\\GuruBankProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
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
		driver.get(prop.getProperty("loginPageUrl"));
		
	}

}
