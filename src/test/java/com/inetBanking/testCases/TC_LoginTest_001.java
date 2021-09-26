package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseTest{

	@Test
	public void loginTest() throws InterruptedException
	{
		
		LoginPage loginPg = new LoginPage(driver);
		loginPg.setUsername(username);
		logger.info("sent user name");
		loginPg.setPassword(password);
		logger.info("set password");
		loginPg.clickLoginbtn();
		logger.info("Clicked on loggin button");
		
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else
		{
			try {
				captureScreen(driver, "LoginTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("Login test faileds");
		}
	}
}
