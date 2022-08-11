package com.learning.seleniummaven;



import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteContentVault {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
	
		String Path = System.getProperty("user.dir");
		WebElement component = null ;
		boolean isp =true;
	// boolean isPresent =true;
		

		System.setProperty("webdriver.chrome.driver", Path + "\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver();
		// String Url = "http://jqagatewayqa.wiley.com/login";
		String Url = "http://10.221.203.228:8080/beco";
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
		//WebElement ch1 =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='selectAllComponentCheckbox']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();",ch1);
		
		
		 //component =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='ese0001']")));
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='ese0001']")));
		
		js.executeScript("arguments[0].click();",component);
		
	 
		 System.out.println("dg Successfully");
		// boolean isContent=verify_content();
		 isp= driver.findElements(By.xpath("//input[@class='editor-active']")).size() >0;
		//isp= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@class='editor-active']"))).size()>0;
		Thread.sleep(20000);
			
		 if(isp){
			 
			 System.out.println("Kt gya tera jaa phle Content delete Kar");
		 }
		 else{
			 System.out.println("Kr do Delete");
			 
		 }
		 
		 
		/* if(isContent){
			 
			 System.out.println("Kt gya tera jaa phle Content delete Kar");
		 }
		 else{
			 System.out.println("Kr do Delete");
		 }
		 */
		// driver.quit();
		 
		
	}
	
	/*public static boolean verify_content(){
		try{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='editor-active']"));
			return true;	
		}
	
		catch(Exception e)
		
		{
			return false;
			}
		
		}*/
	
}




