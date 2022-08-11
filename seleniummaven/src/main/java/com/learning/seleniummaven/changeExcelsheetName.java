package com.learning.seleniummaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class changeExcelsheetName {

	public static void main(String[] args) throws Exception {
	File src=new File("C:\\Excel");
	
		 File directory=new File("C:\\Excel");
		    int fileCount=directory.list().length;
		    System.out.println("File Count:"+fileCount);
		   // load file
		   FileInputStream fis=new FileInputStream(src);
		 
		   // Load workbook
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		   
		   // Load sheet- Here we are loading first sheetonly
		      XSSFSheet sh1= wb.getSheetAt(0);
		      
		      System.out.println(sh1.getSheetName());
		wb.setSheetName(0, "The Vault");
		FileOutputStream fout=new FileOutputStream(new File("C:\\Regression Suite_Modules.xlsx"));
		wb.write(fout);
		 
		// close the file
		 
		 fout.close();
		  

	}

}
