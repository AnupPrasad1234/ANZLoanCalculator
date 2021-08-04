package com.automation.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	/**
	 * This method will capture screenshot and save it in locationScreenshots folder
	 * @param getCurrentDatetime
	 */
	public void captureScreenShot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileHandler.copy(src, new File("./ScreenShots/LoanCalculator_" + getCurrentDatetime()));
		}
		catch(Exception e)
		{
			System.out.println("Unable to capture screen shot" + e.getMessage());
		}
				
	}
	
	/**
	 * This method will return date in MM_dd_yyyy_HH_mm_ss format
	 * @param getCurrentDatetime
	 */
	public String getCurrentDatetime()
	{
		DateFormat customDateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customDateFormat.format(currentDate);
	}
}
