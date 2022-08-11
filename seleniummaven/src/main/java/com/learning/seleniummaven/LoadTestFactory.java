package com.learning.seleniummaven;


import org.testng.annotations.Factory;

public class LoadTestFactory {
	
	@Factory
    public Object[] createInstances() {

        Object[] obj = new Object[10];

        for (int iter = 0; iter < 10; iter++) 
        {
           // obj[iter] = new LoadTestSelenium();
        }

        return obj;
    }

}
