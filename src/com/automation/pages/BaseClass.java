package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public Helper helper;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		helper = new Helper();
		System.out.println("Suite starts");
		System.out.println("Browser used : " + config.getBrowser());
		System.out.println("App Url : " + config.getAppURL());
//		report = new ExtentReports();
//		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/ANZLoanCalculator.html"));
//		report.attachReporter(extent);
	}
	
	
	
	@BeforeMethod
	public void setUp()
	{
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getAppURL());
	}
	
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		//ItestResult is an interface. As soon as test get completed the result variable will have the result
		if(result.getStatus() == ITestResult.FAILURE)
		{
			helper.captureScreenShot(driver);
		}
		BrowserFactory.closeBrowser(driver);
//		report.flush();    //After each method it will keep on adding the report in a single report file
	}

}
