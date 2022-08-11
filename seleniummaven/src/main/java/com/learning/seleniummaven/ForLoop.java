package com.learning.seleniummaven;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ForLoop {

	public static void main(String[] args) {
		File folder = new File("C:\\RPS");
		File[] listOfFolders = folder.listFiles();
		// List<String> fileNames = new ArrayList<>();

		
		   for(File fs:listOfFolders)	{
			   if (fs.isFile()) {
					System.out.println("File " +fs.getParentFile().getName());
		   }
			   else if(fs.isDirectory()){
				   System.out.println("Component " +fs.getName());
				  
			   }
	}
	}
}
