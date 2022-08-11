package com.learning.seleniummaven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OutLookLogin {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		

		String Path = System.getProperty("user.dir");
		WebElement component = null ;
	 boolean isPresent =true;
		String oktaUrl="https://wiley.okta.com";

		System.setProperty("webdriver.chrome.driver", Path + "\\utility\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		String Url = "http://jqagatewayqa.wiley.com/login";
		//String Url = "http://10.221.203.184:8080/beco";
		driver.get(Url);
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.id("uname"));

		username.sendKeys("shugupta");

		driver.findElement(By.id("pwd")).sendKeys("Asdf12345");
		driver.findElement(By.id("signInIcon")).click();
		System.out.println("Login Successfully");
		Thread.sleep(2000);
		driver.findElement(By.id("logoutButton")).click();
		
		
		
		
	Thread.sleep(5000);
	WebDriverWait wait=new WebDriverWait(driver, 20);
WebElement C1=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='option-selected-text' and text()='Shubham']")));
	
C1.click();
		
			
		
			 component =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='option-title' and text()='Sign out']")));
		
			 component.click();
			 
			// waitForPageLoaded();
			 Thread.sleep(3000);
			 
			// driver.get("http://10.221.139.230:8080/beco");
			// driver.get("http://10.221.139.230:8080/beco");
				//driver.manage().window().maximize();
			// driver.navigate().refresh();
			
			
			  
				   WebElement username1 = driver.findElement(By.id("uname"));
				 //  username1.getAttribute("readonly")
					username.sendKeys("shugupta");

					driver.findElement(By.id("pwd")).sendKeys("Asdf12345");
					driver.findElement(By.id("signInIcon")).click();
					System.out.println("Login Successfully");
				 
			  
	}

	
	
	
	
		}

