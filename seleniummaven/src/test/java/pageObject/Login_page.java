package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class Login_page {
	
	static WebElement element = null;
	 
    public static WebElement txtbx_UserName(WebDriver driver){

        element = driver.findElement(By.id("username"));

  Log.info("Username text box found");

        return element;

        }

    public static WebElement txtbx_Password(WebDriver driver){

        element = driver.findElement(By.id("password"));

   Log.info("Password text box found");

        return element;

        }

    public static WebElement btn_LogIn(WebDriver driver){

        element = driver.findElement(By.id("btnLogin"));

Log.info("Submit button found");

        return element;

        }

}
