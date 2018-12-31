package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//Helper class - configurate and return driver
public class BrowserFactory {
	
	static WebDriver driver;
	public static WebDriverWait waitForElement;
			
	public static WebDriver startBrowser(String browserName,String url)
	{		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\WebDriverExeFiles\\chromedriver.exe");
			driver=new ChromeDriver();
			waitForElement=new WebDriverWait(driver, 30);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{				
			System.setProperty("webdriver.gecko.driver", ".\\WebDriverExeFiles\\geckodriver.exe");
			driver = new MarionetteDriver();
			waitForElement=new WebDriverWait(driver, 30);
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", ".\\WebDriverExeFiles\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			waitForElement=new WebDriverWait(driver, 30);
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}

}
