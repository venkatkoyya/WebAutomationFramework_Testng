package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver iDriver ;
	public LoginPage(WebDriver rDriver)
	{
		iDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(name ="uid")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name ="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name ="btnLogin")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(linkText = "Log out")
	@CacheLookup
	WebElement logoutBtn;
	
	public void setUsername(String user)
	{
		userName.sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLoginbtn()
	{
		loginBtn.click();
	}
	
	public void clickLogoutbtn()
	{
		logoutBtn.click();
	}
}

