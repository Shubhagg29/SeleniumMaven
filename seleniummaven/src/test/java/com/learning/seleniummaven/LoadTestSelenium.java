package com.learning.seleniummaven;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class LoadTestSelenium {
  
	static WebDriver driver;

	 
  @Test
  public void VaultLoad() {
	  String Path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", Path + "\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver();

		// String Url =
		// "http://10.221.203.184:8080/beco";http://thevault-wdev.aws.wiley.com/beco

		String Url = "http://thevault-wqa.aws.wiley.com/beco";
		driver.get(Url);
		driver.manage().window().maximize();
	  
	  
  }
  @AfterTest
  public void teardown(){
	  
	  driver.quit();
	  
  }
}
