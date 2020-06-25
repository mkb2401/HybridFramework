package factory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.CommonFunctions;
public class BrowserFactory {
	private static WebDriver driver;
	public static WebDriver getBrowser() throws IOException
	{
		if(driver==null)
		{
			System.setProperty("webdriver.chrome.driver", CommonFunctions.getValue("chromepath"));

			driver=new ChromeDriver();

			driver.get(CommonFunctions.getValue("url"));
		}
		return driver;

	}
	
	public static String getBrowserTitle() throws IOException
	{  
		return getBrowser().getTitle();
				
	}
	
	
}
