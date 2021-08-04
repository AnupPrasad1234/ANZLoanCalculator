package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	public Properties prop;
	
	public ConfigDataProvider()
	{
		File file = new File("./Config/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Unable to load properties file " + e.getMessage());
		}
	}
	
	
	/**
	 * With the help of this method we can search any key in the Config.properties
	 * @param keyToSearch
	 */
	public String getDataFromConfig(String keyToSearch)
	{
		// Its a generic key search method. Whatever key we'll pass, according to that result will be returned
		return prop.getProperty(keyToSearch);
	}
	
	/**
	 * This method will return the browser name
	 * @param getBrowser
	 */
	public String getBrowser()
	{
		return prop.getProperty("Broswer");
	}

	/**
	 * This method will return the URL
	 * @param getAppURL
	 */
	public String getAppURL()
	{
		return prop.getProperty("qaUrl");
	}
}




















