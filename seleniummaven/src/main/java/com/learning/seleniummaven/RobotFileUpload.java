package com.learning.seleniummaven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotFileUpload {

	static WebDriver driver;

	public static void main(String[] args) throws AWTException, InterruptedException {
		String Path = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", Path + "\\utilities\\chromedriver.exe");
		driver = new ChromeDriver();
		String Url = "http://jqagatewayqa.wiley.com/login";

		driver.get(Url);

		WebElement username = driver.findElement(By.id("username"));

		username.sendKeys("shugupta");

		driver.findElement(By.id("password")).sendKeys("Winter@2019");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Login Successfully");
		
driver.findElement(By.id("uploadPackageLi")).click();

driver .findElement(By.id("uploadedFile")).click();

   uploadFile("C:\\ER_EV_ER4459");
   

	}
public static void setClipboardData(String string) {
	//StringSelection is a class that can be used for copy and paste operations.
	   StringSelection stringSelection = new StringSelection(string);
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

public static  void uploadFile(String fileLocation) {
    try {
    	//Setting clipboard with file location
        setClipboardData(fileLocation);
        //native key strokes for CTRL, V and ENTER keys
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    } catch (Exception exp) {
    	exp.printStackTrace();
    }
}

		
		


}
