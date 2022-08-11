package com.learning.seleniummaven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		

		String Path = System.getProperty("user.dir");
		WebElement component = null ;
	 boolean isPresent =true;
		

		System.setProperty("webdriver.chrome.driver", Path + "\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver();
		// String Url = "http://jqagatewayqa.wiley.com/login";
		String Url = "http://10.221.203.164:8080/beco";
		driver.get(Url);

		WebElement username = driver.findElement(By.id("uname"));

		username.sendKeys("shugupta");

		driver.findElement(By.id("pwd")).sendKeys("Asdf12345");
		driver.findElement(By.id("signInIcon")).click();
		System.out.println("Login Successfully");
		Thread.sleep(2000);

		driver.findElement(By.id("keywordSearchInput")).sendKeys("9781118660584");
		driver.findElement(By.id("removeId")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='viewProdDtls' and @title='9781118660584']")).click();
		Thread.sleep(2000);
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
	try{
		
	
		// component =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Support']")));
		 
		 System.out.println("dg Successfully");
	}
	catch(TimeoutException e){
		isPresent=false;
		
	}
	
		if (component.isDisplayed() && isPresent) {

			//WebElement ch1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='selectAllComponentCheckbox']")));
			WebElement ch1 = driver.findElement(By.xpath("//input[@id='selectAllComponentCheckbox']"));
		//	ch1.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",ch1);
			System.out.println("Check box checked");
			
		} else {
			System.out.println("Jai  Ram");
		}

	
	
	}
	

	
	
}
