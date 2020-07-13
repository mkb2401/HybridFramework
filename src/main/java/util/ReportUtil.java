package util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import factory.BrowserFactory;

public class ReportUtil {

	private static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest testcasereport;

	private static ExtentReports getReporter()
	{
		if (extent==null)
		{
			String currentTime= "Report_"+new Timestamp(System.currentTimeMillis());
			currentTime=currentTime.replace(" ","_").replace("-", "_").replace(":","_").replace(".","_");
			String reportpath="reports\\"+ currentTime+".html";
			extent=new ExtentReports();
			reporter=new ExtentHtmlReporter(reportpath);
			extent.attachReporter(reporter);
		}
		return extent;
	}

	public static void initiateReport(String testCaseName)
	{
		testcasereport= getReporter().createTest(testCaseName);
			}
	
	public static void logPass(String strmessage)
	{
		testcasereport.log(Status.PASS, strmessage);
	}
	
	public static void logFail(String strmessage) throws WebDriverException, IOException
	{
		testcasereport.log(Status.FAIL, strmessage);
		String scrFilename="Screenshot_"+new Timestamp(System.currentTimeMillis());
		scrFilename=scrFilename.replace(" ","_").replace("-", "_").replace(":","_").replace(".","_");
		scrFilename=System.getProperty("user.dir")+"\\reports\\Screenshots\\"+ scrFilename+".jpeg";
		
		
		getScreenshot(scrFilename);
		testcasereport.addScreenCaptureFromPath(scrFilename);
	}
	
	private static void getScreenshot(String strPath) throws WebDriverException, IOException
	{
		File file=((TakesScreenshot)BrowserFactory.getBrowser()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(strPath));
	}
	
	public static void closereport()
	{
		getReporter().flush();
	}
}
