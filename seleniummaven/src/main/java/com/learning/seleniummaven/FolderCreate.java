package com.learning.seleniummaven;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FolderCreate {

	public static void main(String[] args) {
		
		Date now = new Date();
		DesiredCapabilities capability = null;
		String path ="C:\\Data\\";
		//SimpleDateFormat dateFormat = new SimpleDateFormat("hh mm ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		String value = dateFormat.format(now);
		
		
		
		  Map<String, Object> preferences = new Hashtable<String, Object>();
		  preferences.put("download.default_directory", path);
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("prefs", preferences);
         
          capability.setCapability(ChromeOptions.CAPABILITY, options);
          capability = DesiredCapabilities.chrome();
          File file = new File(path + value );
  		
  		file.mkdir();
		
	}

}
