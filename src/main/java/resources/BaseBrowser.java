package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

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
	
	public String getScreenshots(String testcaseName, WebDriver driver) throws IOException 
	{
		// -----------  Updated Screenshot code with FileUtils ----------------
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destFilename = System.getProperty("user.dir")+ "\\screenshots\\" + testcaseName + ".png" ;
		FileUtils.copyFile(src, new File(destFilename));  // add commons-io dependency in POM for FileUtils class
		
		return destFilename;
		// -----------  Old Screenshot code with FileHandler----------------
		/* 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("F://ScreenshotsSelenium//"+result+"_Failed_Screenshot.png"));
		*/
		//FileUtils.copyFile(src,new File("F://ScreenshotsSelenium//"+result+"screenshot.png"));
	}
	
	public void navigateToLoginPage() throws IOException
	{
		driver = driverInitialization();
		driver.get(prop.getProperty("loginPageUrl"));
		
	}

}
