package com.learning.seleniummaven;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	
	ExtentReports report;
 ExtentTest test;
	
	
	
	WebDriver driver;
	
	
	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	@BeforeTest
	public void generateReport()
	
	{
		
		String Path= System.getProperty("user.dir");
		String extentReportPath = Path + "/report/healthCheck_results.html";
		//report= new ExtentReports(extentReportPath, false);
		report = new ExtentReports(extentReportPath,true);
		
	}


	@Test
	public void testReport() throws Exception
	{
		//report=new ExtentReports("C:\\Report\\LearnAutomation.html", true);
		
		//logger=report.startTest("GenerateReport");
		test=report.startTest("GenerateReport");

		
		FirefoxProfile firefoxProfile = new FirefoxProfile();    
		//firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
		/*String Path=	System.getProperty("user.dir");
		  System.setProperty("webdriver.chrome.driver", Path +"\\Utilities\\chromedriver.exe");
		
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--incognito");
		  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);*/
	driver=new FirefoxDriver();
	
		driver.manage().window().maximize();

		//logger.log(LogStatus.INFO, "Browser started ");

		driver.get("http://www.learn-automation.com");

		//logger.log(LogStatus.INFO, "Application is up and running");
		
		String title=driver.getTitle();

		Assert.assertTrue(title.contains("Selenium")); 

		//logger.log(LogStatus.PASS, "Checosjd");
   //  test.log(LogStatus.PASS, "Visible");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
     String screenShotPath =  getScreenhot(driver,"auto");
    test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
 	}
	
	@AfterTest

	public void testReporEnd()
	
	{
		report.endTest(test);
		report.flush();

		//driver.get("C:\\Report\\LearnAutomation.html");
		
	} 
	
	
}
