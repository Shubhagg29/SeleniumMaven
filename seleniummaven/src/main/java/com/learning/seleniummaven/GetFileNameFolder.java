package com.learning.seleniummaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetFileNameFolder {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
	
		FileOutputStream fout =null;
		try {
			File folder = new File("C:\\Excel");
			File[] listOfFiles = folder.listFiles();
			// List<String> fileNames = new ArrayList<>();

			for(File fs:listOfFiles)	{
				   if (fs.isFile()) {
						System.out.println("File " +fs.getName());

					

					fis = new FileInputStream(fs);

					XSSFWorkbook wb = new XSSFWorkbook(fis);

					// Load sheet- Here we are loading first sheetonly
					XSSFSheet sh1 = wb.getSheetAt(0);

					System.out.println(sh1.getSheetName());
					wb.setSheetName(0, "The Vault");
					System.out.println(sh1.getSheetName());

					String newpath = sh1.getSheetName();
					

					// FileOutputStream fout =new
					// FileOutputStream(listOfFiles[i]);
					fout = new FileOutputStream(fs);
					// close the file
					wb.write(fout);

					
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
