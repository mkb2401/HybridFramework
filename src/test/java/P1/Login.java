package P1;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import pages.HomePage;
import pages.LoginPage;
import util.ReportUtil;

public class Login {

	@BeforeMethod
	public void startofTestCase(Method m)
	{
		ReportUtil.initiateReport(m.getName());
	}

	@Test(dataProvider="myData")
	public void tc01(String strUid,String strPass,String strMessage) throws IOException {
		LoginPage lp=new LoginPage();
		lp.setUsername(strUid);
		lp.setPassword(strPass);
	lp.clickLogin();

		if(!strMessage.equals(""))
		{
			Assert.assertEquals(lp.getMessage(), strMessage);
		
		}
		else
		{
			HomePage hp=new HomePage();
			hp.clickWelcomeAdmin();
			hp.clickLogout();
		}
	}

	@DataProvider
	public Object[][] myData() throws IOException
	{
		String file="testData//TestData.xlsx";
		XSSFWorkbook objworkbook=new XSSFWorkbook(file);
		XSSFSheet objsheet=objworkbook.getSheet("Login");
		XSSFRow objrow;
		XSSFCell objcell;
		int rowCount=objsheet.getLastRowNum(); //n-1
		int colCount=objsheet.getRow(0).getLastCellNum(); //n
		Object[][] arrData=new Object[rowCount][colCount];

		for(int irow=1;irow<=rowCount;irow++)
		{
			objrow=objsheet.getRow(irow);
			for(int jcol=0;jcol<colCount;jcol++)
			{
				objcell=objrow.getCell(jcol);
				if(objcell==null)
				{
					arrData[irow-1][jcol]="";
				}
				else
				{
					objcell.setCellType(CellType.STRING);
					arrData[irow-1][jcol]=objcell.getStringCellValue();
				}
			}

		}
		return arrData;

	}


	@AfterMethod
	public void endoftestcase(ITestResult oReport) throws WebDriverException, IOException
	{
		if(!oReport.isSuccess())
		{
			ReportUtil.logFail("Exception occurs. Message is " +oReport.getThrowable().getMessage());

		}
		ReportUtil.closereport();
	}
}
