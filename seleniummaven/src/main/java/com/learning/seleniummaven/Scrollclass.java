package com.learning.seleniummaven;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scrollclass {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		String Path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", Path + "\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver();
		String Url = "http://thevault-wqa.aws.wiley.com/beco";
		driver.get(Url);
		driver.manage().window().maximize();
		
		WebElement serv=driver.findElement(By.xpath("//a[@title='Service Desk']"));
		
		serv.click();
		
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(driver.getWindowHandle());
		String Title= driver.getTitle();
		System.out.println("Title: ==" + Title);
		// String Url =
		// "http://10.221.203.184:8080/beco";http://thevault-wdev.aws.wiley.com/beco

	/*	String Url = "https://formy-project.herokuapp.com/radiobutton";
		driver.get(Url);
		driver.manage().window().maximize();
		
		
		
		driver.findElement(By.cssSelector("input[value='option2']")).click();;
		Thread.sleep(4000);*/
		driver.quit();
		

	}

}
