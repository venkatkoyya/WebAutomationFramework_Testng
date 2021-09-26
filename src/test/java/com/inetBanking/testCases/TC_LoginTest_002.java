package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginTest_002 extends BaseTest{

	@Test(dataProvider = "LoginTestdata")
	public void loginDDTest(String user,String pwd)
	{
		
		LoginPage loginPg = new LoginPage(driver);
		loginPg.setUsername(user);
		logger.info("sent user name");
		loginPg.setPassword(pwd);
		logger.info("set password");
		loginPg.clickLoginbtn();
		logger.info("Clicked on loggin button");
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			
			Assert.assertTrue(true);
			logger.info("Login passed");
			loginPg.clickLogoutbtn();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	
		
	}
	
	@DataProvider(name="LoginTestdata")
	public String[][] Getlogindata() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rowNumber = XLUtils.getRowCount(path, "Sheet1");
		int columnNumber = XLUtils.getCellCount(path,"Sheet1", 1);
		
		String loginData[][]=new String[rowNumber][columnNumber];
		
		for(int i=1;i<=rowNumber;i++)
		{
			for(int j=0;j<columnNumber;j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
	}
	
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
