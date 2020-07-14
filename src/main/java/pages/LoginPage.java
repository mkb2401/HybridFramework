package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import factory.BrowserFactory;
import factory.ElementFactory;
import util.ReportUtil;

public class LoginPage {
	String usernameLoc="//input[@id='txtUsername']";
	String passLoc="//input[@id='txtPassword']";
	String loginLoc="//*[@value='LOGIN']";
	String locMessage="//*[@id='spanMessage']";

	public void setUsername(String strdata) throws IOException
	{
		ElementFactory.setData(usernameLoc,strdata);

	}

	public void setPassword(String strdata) throws IOException
	{
		ElementFactory.setData(passLoc,strdata);

	}
	public void clickLogin() throws IOException
	{
		ElementFactory.clickElement(loginLoc);
		
		
	}
	public String getMessage() throws IOException
	{
		String message=ElementFactory.getMessage(locMessage);
		return message;
	}
	
}
