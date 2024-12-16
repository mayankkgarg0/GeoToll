package com.automate.entity;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.automate.readData.ReadFromExcel;

public class TesData {
   
	  @DataProvider(name = "loginData")
	 
	    public Object[][] loginDataProvider() throws IOException {
		
	    	ReadFromExcel excelUtil = new ReadFromExcel("C:\\Users\\dell\\eclipse-workspace\\GeoTollUAT\\GeoTollExcelLogin.xlsx"); 
	    	
	        String[][] data = excelUtil.getData("Sheet1");
	        
	        
	        excelUtil.close();
	        return data;
	    } 
   
	  @DataProvider(name = "MROData")
		 
	    public Object[][] MROProvider() throws IOException {
		
	    	ReadFromExcel excelUtil = new ReadFromExcel("C:\\Users\\dell\\eclipse-workspace\\GeoTollUAT\\GeoTollExcelMRO.xlsx"); 
	        String[][] data = excelUtil.getData("Sheet1");
	        
	        
	        excelUtil.close();
	        return data;
	    } 
   
	 
	 // Method to provide test data
 /*   @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][] {
        	 { "udupaakshaya+QATest@gmail.com", "New@1234"},
        	 { "udupaakshaya+QATest@gmail.com", "New@123"},
        	 { "udupaakshayaQATest@gmail.com", "New@1234"},
            
        }; 
    }*/ 
}