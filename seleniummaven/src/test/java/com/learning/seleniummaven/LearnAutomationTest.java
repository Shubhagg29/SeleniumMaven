package com.learning.seleniummaven;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LearnAutomationTest {
	
	static WebDriver driver;
	@Test
	public void test () {
		String baseUrl,nodeUrl,baseUrl1, nodeUrl1;
		
		baseUrl="https://www.google.co.in";
		
		nodeUrl ="http://10.201.165.119:5567/wd/hub";
		baseUrl1 ="http://www.redbus.in";
		nodeUrl1= "http://10.201.166.189:5566/wd/hub";
		//10.201.168.25
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.VISTA);
		
		
		DesiredCapabilities capability1 = DesiredCapabilities.chrome();
		capability1.setBrowserName("chrome");
		capability1.setPlatform(Platform.VISTA);
		
		try {
			
			driver = new RemoteWebDriver(new URL(nodeUrl),capability);
			driver.get(baseUrl);
			
			
			driver = new RemoteWebDriver(new URL(nodeUrl1),capability);
			driver.get(baseUrl1);
			
		} catch (MalformedURLException e)
		{
			
			e.printStackTrace();
		}
		
	}	
		
	
	
	
@Test
	public void test1 () {
		System.out.println("testing1"  + Thread.currentThread().getId());
		
		 String Path=	System.getProperty("user.dir");
		  System.setProperty("webdriver.chrome.driver", Path +"\\Utilities\\chromedriver.exe");
		  driver=new ChromeDriver();
		
	
			String baseUrl,nodeUrl;
			
			baseUrl="https://www.google.co.in";
			
			nodeUrl ="http://10.201.166.189:6666/wd/hub";
			//10.201.168.25
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.VISTA);
			WebDriver driver ;
			try {
				
				driver = new RemoteWebDriver(new URL(nodeUrl),capability);
				driver.get(baseUrl);
				
				
			} catch (MalformedURLException e)
			{
				
				e.printStackTrace();
			}
			
			
			
		}

		
	}


