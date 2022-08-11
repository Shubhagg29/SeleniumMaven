package dataDriven_framework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.Home_page;
import automationFramework.SignIn_Action;

import com.learning.seleniummaven.Constant;

import Utility.ExcelUtils;
import Utility.Log;

public class Apache_POI_TC {
	
	private static Logger Log = Logger.getLogger(Apache_POI_TC.class.getName());
	
	private static WebDriver driver = null;
	 
	public static void main(String[] args) throws Exception {
	 
	        //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
	 
	        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
	 
	        driver = new FirefoxDriver();
	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	        driver.get(Constant.URL);
	 
	        SignIn_Action.Execute(driver);
	 
	        System.out.println("Login Successfully, now it is the time to Log Off buddy.");
	 
	        //Home_page.lnk_LogOut(driver).click();
	 
	        driver.quit();
	 
	        //This is to send the PASS value to the Excel sheet in the result column.
	 
	        ExcelUtils.setCellData("Pass", 1, 3);
	 
	}

}
