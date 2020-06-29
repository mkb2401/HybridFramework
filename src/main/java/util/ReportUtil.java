package util;

import java.sql.Timestamp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

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
	
	public static void logFail(String strmessage)
	{
		testcasereport.log(Status.FAIL, strmessage);
	}
	
	public static void closereport()
	{
		getReporter().flush();
	}
}
