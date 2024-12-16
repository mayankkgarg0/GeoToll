package com.automate.listeners;


import com.automate.driver.manager.DriverManager;
import com.automate.reports.ExtentManager;
import com.automate.utils.screenshot.ScreenshotUtils;

import io.appium.java_client.AppiumDriver;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class CustomExtentListener implements ITestListener {
	 
	
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
       ExtentManager.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        // Capture screenshot on success
        captureScreenshot(result, "Test passed");
      
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        // Capture screenshot on failure
        captureScreenshot(result, "Test failed");
    }

 /*   public void onTestFinish(ITestResult result) {
        System.out.println("Test finished: " + result.getName());
    } */

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("All tests finished.");
        ExtentManager.flush(); // Save the report
    }



  public void captureScreenshot(ITestResult result, String status) {
      AppiumDriver driver = DriverManager.getDriver(); // Get the driver instance
      if (driver != null) {
          String screenshotPath = "screenshots/" + result.getName() + ".png";
          ScreenshotUtils.takeScreenshot(driver, screenshotPath); // Capture screenshot
     /*     try {
        
              
             ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath, status);
             System.out.println("qwe     " +screenshotPath);
          } catch (IOException e) {
              e.printStackTrace();
          } */
      } else {
          System.out.println("Driver is not initialized. Cannot take screenshot.");
      }
  }} 
