package factory;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.ReportUtil;

public class ElementFactory {
private static WebElement getElement(String locatorValue) throws IOException
{
	return BrowserFactory.getBrowser().findElement(By.xpath(locatorValue));
}

public static void setData(String strLoc,String strdata) throws IOException
{
	getElement(strLoc).sendKeys(strdata);
	ReportUtil.logPass("Setting data:  "+strdata+" on element : "+strLoc);
}
	
public static void clickElement(String strLoc) throws IOException
{
	getElement(strLoc).click();
	ReportUtil.logPass("Clicking element : "+strLoc);
	}
}
