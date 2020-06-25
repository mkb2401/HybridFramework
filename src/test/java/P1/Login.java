package P1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import pages.HomePage;
import pages.LoginPage;

public class Login {
  @Test
  public void f() throws IOException {
//	  BrowserFactory.getBrowser();
//	  BrowserFactory.getBrowser();
//	  BrowserFactory.getBrowser();
//	  System.out.println(BrowserFactory.getBrowserTitle());
	  
	  LoginPage lp=new LoginPage();
	  lp.setUsername("admin");
	  lp.setPassword("admin123");
	  lp.clickLogin();
	  
	  HomePage hp=new HomePage();
	  hp.clickWelcomeAdmin();
	  hp.clickLogout();
	  
  }
}
