package com.learning.seleniummaven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.collections.CollectionUtils;

public class VaultTableheader {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		try {
			String Path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", Path + "\\utility\\chromedriver.exe");
			driver = new ChromeDriver();
			// String Url =
			// "http://10.221.203.184:8080/beco";http://thevault-wdev.aws.wiley.com/beco

			String Url = "http://thevault-wqa.aws.wiley.com/beco";
			driver.get(Url);
			driver.manage().window().maximize();
			/*
			 * WebElement username = driver.findElement(By.id("uname"));
			 * 
			 * username.sendKeys("shugupta");
			 * 
			 * driver.findElement(By.id("pwd")).sendKeys("Asdf12345");
			 * driver.findElement(By.id("signInIcon")).click();
			 */
			System.out.println("Login Successfully");

			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement wl = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Activity Log')]")));
			Thread.sleep(1000);
			wl.click();
			Thread.sleep(2000);
			List<WebElement> colHeader = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
					.xpath("//table[@class='pq-grid-header-table pq-wrap ']/tbody/tr[@class='pq-grid-title-row']/td")));

			List<String> A1 = new ArrayList<String>();
			for (WebElement col : colHeader) {

				A1.add(col.getText());

			}
			System.out.println("The ArraySize of list " + A1);

			String arr[] = { "ISBN", "Object Type","Change", "Transaction Type", "Title/Component/File", "Transaction Time",
					"User Name", "Status", "Error Code"};

			List<String> al = Arrays.asList(arr);

			System.out.println("The Size of list " + al);
			Thread.sleep(3000);

			//Collections.sort(A1);
		//	Collections.sort(al);

			//sA1.replaceAll(String::trim);
			//System.out.println("the list is correct"+ Collections.disjoint(A1, al));
			
			//int counter = 0;
			
			for (String expectedList : al) {
				boolean found = false;
				for (String actualList : A1) {
					if (expectedList.contains(actualList)) {

						found = true;
						
						//System.out.println("the list is correct-->" + actualList);
						break;
					}

					
					
				}
				if(!found)
				{
					System.out.println("The mismatched Element-->" + expectedList );
				}
			}

			driver.close();

		} catch (StaleElementReferenceException elementHasDisappeared) {
			elementHasDisappeared.printStackTrace();
			/*
			 * if(A1.equals(al)){ System.out.println("the list is correct"); }
			 * else{ System.out.println("the list is not  correct"); }
			 */
		}
	}

}
