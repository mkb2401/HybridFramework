package P1;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	
  @Test
  public void tc01() throws IOException {
   	  LoginPage lp=new LoginPage();
	  lp.setUsername("admin");
	  lp.setPassword("admin1234");
	  lp.clickLogin();
	  
	  HomePage hp=new HomePage();
	  hp.clickWelcomeAdmin();
	  hp.clickLogout();
	 	  
  }
  
    
  
  @AfterMethod
  public void endoftestcase()
  {
	  ReportUtil.closereport();
  }
}
