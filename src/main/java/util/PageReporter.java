package util;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class PageReporter {

	public static void main(String[] args) throws IOException
	{
		
		String reportpath="reports/demoreport.html";
		ExtentReports extent=new ExtentReports();
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(reportpath);
		extent.attachReporter(reporter);
				
		ExtentTest testcaseReport=extent.createTest("TC01");
		testcaseReport.log(Status.PASS, "Enter user id");
		testcaseReport.log(Status.PASS, "Enter user password");
		testcaseReport.log(Status.PASS, "click login");
		testcaseReport.log(Status.PASS, "click logout");
		
		testcaseReport=extent.createTest("TC02");
		testcaseReport.log(Status.FAIL, "Enter user id");
		testcaseReport.log(Status.PASS, "Enter user password");
		testcaseReport.log(Status.PASS, "click login");
		testcaseReport.log(Status.PASS, "click logout");
		testcaseReport.addScreenCaptureFromPath("C:\\Users\\total solutions\\Desktop\\Capture.png");
		
		extent.flush();
	}
}
