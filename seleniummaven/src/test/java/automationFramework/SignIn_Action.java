package automationFramework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.learning.seleniummaven.Constant;

import dataDriven_framework.Apache_POI_TC;
import pageObject.Home_page;
import pageObject.Login_page;
import Utility.ExcelUtils;
import Utility.Log;

public class SignIn_Action {
	
	private static Logger Log = Logger.getLogger(SignIn_Action.class.getName());
	
	public static void Execute(WebDriver driver) throws Exception{
		 
		String sUserName = ExcelUtils.getCellData(1,1);
		driver.get(Constant.URL);
		 
	Log.debug("Username picked from Excel is "+ sUserName );
		 
		String sPassword = ExcelUtils.getCellData(1, 2);
		 
	Log.info("Password picked from Excel is "+ sPassword );
		 
		//Home_page.lnk_MyAccount(driver).click();
		 
		//Log.info("Click action performed on My Account link");
		 
		Login_page.txtbx_UserName(driver).sendKeys(sUserName);
		 
		Log.debug("Username entered in the Username text box");
		 
		Login_page.txtbx_Password(driver).sendKeys(sPassword);
		 
		//Log.info("Password entered in the Password text box");
		 
		Login_page.btn_LogIn(driver).click();
		 
		//Log.info("Click action performed on Submit button");
		 
		        }

}
