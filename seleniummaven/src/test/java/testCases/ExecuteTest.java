package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ExecuteTest  {
	WebDriver driver;
	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.google.com");
	}
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case for  Selenium")
	public void searchTest1() throws InterruptedException {
		
		//driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium Training");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}	
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case for  Java")
	public void searchTest2() throws InterruptedException {		
		//driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Java Training");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);		
	}
	

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case for Search UFT")
	public void searchTest3() throws InterruptedException {		
		//driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("UFT Training");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);		
	}
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case for Search Jenkins")
	public void searchTest4() throws InterruptedException {	
		//driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Jenkins Training");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);	
	}


	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();
	}
}
