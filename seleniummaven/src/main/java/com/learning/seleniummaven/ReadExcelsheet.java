package com.learning.seleniummaven;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReadExcelsheet {
	
	
	
	public static void main(String[] args) throws IOException {
	
	
		List<List<String>> externalIdList = new ArrayList<List<String>>();
		String downloadFilepath = ("C:\\Vault_Wrkspace\\data\\downloaded_data\\");
		File dir = new File(downloadFilepath);
		String fileName = "9780470077955" + "_QAReport_";
		String Value = "";
		String va2 = "";
		File[] files = dir.listFiles((FileFilter) new PrefixFileFilter(fileName, IOCase.SENSITIVE));
		Workbook Workbook = null;
		if (files != null && files.length > 0) {
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			String filename = files[0].getAbsolutePath();
			File f = new File(filename);
			FileInputStream inputStream = new FileInputStream(f);
			String fileExtensionName = filename.substring(filename.indexOf("."));
			if (fileExtensionName.equals(".xlsx")) {
				Workbook = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				Workbook = new HSSFWorkbook(inputStream);

			}
			Sheet Sheet = Workbook.getSheet("QA Report");
			int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
			for (int i = 1; i < 5; i++) {
				List<String> prefLabelList = new ArrayList<String>();
				Row row = Sheet.getRow(i);
				// prefLabelList.clear();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					va2 = cell.getStringCellValue();

					prefLabelList.add(va2);

				}

				externalIdList.add(prefLabelList);

				// prefLabelList.clear();

			}
			System.out.println("The Value off list is " + externalIdList);

			// System.out.print("The Valuemaker " + externalIdList);

			// System.out.println("The Value off list is " + externalIdList);

		}
	}

}
	/*@Test
	public  void listtbook(){
		
           		WebDriver driver = null ;
		WebElement table = driver.findElement(By.xpath("//table[@class='pq-grid-table pq-td-border-right pq-td-border-bottom pq-wrap ']/tbody"));

		// List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		int listOfRows = table.findElements(By.tagName("tr")).size();

		int count = 2;
		for (int i = 1; i < listOfRows; i++) {
			int locator1 = driver.findElements(By.xpath("//table[@class='pq-grid-table pq-td-border-right pq-td-border-bottom pq-wrap ']/tbody" + "/tr[" + count + "]/td")).size();

			for (int j = 1; j <= locator1; j++) {

				WebElement c2 = driver.findElement(By.xpath("//table[@class='pq-grid-table pq-td-border-right pq-td-border-bottom pq-wrap ']/tbody" + "/tr[" + count + "]" + "/td[" + j + "]"));

				
					actualList.add(c2.getText());
		
		
	
	
			System.out.print("The Valuemaker " + actualList);	
}
	

		}}*/

