package com.inetbankingv1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
WebDriver Idriver;
public Loginpage(WebDriver rdriver)
{
	Idriver=rdriver;
	PageFactory.initElements(rdriver, this);
	
}
	@FindBy(name="uid")
	
	WebElement txtUserName;
	
	@FindBy(name="password")
	
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	
	WebElement btnLogin;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtUserName.sendKeys(pwd);
	}
	public void clicksubmit()
	{
		btnLogin.click();
	}
	public void clickLogout() {
		// TODO Auto-generated method stub
		
	}
	
}
