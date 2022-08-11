package com.learning.seleniummaven;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class getNewFileName {

	public static void main(String[] args) {
		
		String filename = "12";
		  File newfile = getTheNewestFile("C://Vault_Wrkspace//data//downloaded_data");
		  if(newfile.exists()) {
			 // newfile.renameTo(new File("C://Vault_Wrkspace//data//downloaded_data//shubham.zip"));
			   filename= newfile.getName();
		  }


		  System.out.println("latest file is="+filename);

		
		//  File updated = getTheNewestFile("C://Vault_Wrkspace//data//downloaded_data", "zip");
		//  System.out.println("Changed file name is ="+updated);


	}

	public static File getTheNewestFile(String filePath) {
	    File theNewestFile = null;
	    File dir = new File(filePath);
	    FileFilter fileFilter = new WildcardFileFilter("*.zip" );
	    File[] files = dir.listFiles(fileFilter);

	    if (files != null && files.length > 0) {
	        /** The newest file comes first **/
	        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
	        theNewestFile = files[0];
	    }

	    return theNewestFile;
	}

	}


