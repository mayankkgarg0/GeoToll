package com.automate.reports;

import com.automate.driver.manager.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public  class ExtentManager {
	  public static ExtentReports extent;
	    public static ExtentTest test;
	    AppiumDriver driver = DriverManager.getDriver();	   
	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
	            extent = new ExtentReports();
	            extent.attachReporter(htmlReporter);
	        }
	        return extent;
	    }

	    public static ExtentTest createTest(String testName) {
	        test = getInstance().createTest(testName);
	        return test;
	    } 
        
	    public static void flush() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }

	    public static ExtentTest getTest() {
	        return test;
	    }
} 
