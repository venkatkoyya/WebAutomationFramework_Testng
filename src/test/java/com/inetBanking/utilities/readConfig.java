package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	Properties pro;
	public readConfig()
	{
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	public String GetBaseURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String GetuserName()
	{
		String username1 = pro.getProperty("username");
		return username1;
	}
	
	public String GetPassword()
	{
		String password1 = pro.getProperty("password");
		return password1;
	}
	
	public String GetChromepath()
	{
		String chromepath1 = pro.getProperty("chromepath");
		return chromepath1;
	}
	
	public String GetIepath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
	public String GetFirefoxpath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}

