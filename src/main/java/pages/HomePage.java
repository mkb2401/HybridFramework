package pages;

import java.io.IOException;

import factory.ElementFactory;

public class HomePage {
	String locWelcomeAdmin="//a[text()='Welcome Admin']";
	String locLogout="//a[text()='Logout']";

	public void clickWelcomeAdmin() throws IOException
	{
		ElementFactory.clickElement(locWelcomeAdmin);
	}
	public void clickLogout() throws IOException
	{
		ElementFactory.clickElement(locLogout);
	}
}
