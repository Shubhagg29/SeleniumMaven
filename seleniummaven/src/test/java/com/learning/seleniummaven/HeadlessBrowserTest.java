package com.learning.seleniummaven;




import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class HeadlessBrowserTest{
	
	
		@Test
	public static void testClass() {
		//System.out.println("testing"  + Thread.currentThread().getId());
		
		WebDriver driver = new FirefoxDriver();
		
		
		
		driver.get("http://www.Redbus.in");
		System.out.println("Application up and Running  ");		
		
		String title=driver.getTitle();

		Assert.assertTrue(title.contains("Selenium")); 
		


		System.out.println("Title Verified  ");	
		
		driver.close();
		driver.quit();
		
	}
}
