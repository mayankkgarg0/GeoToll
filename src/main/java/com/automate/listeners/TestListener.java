/*package com.automate.listeners;

import com.automate.customannotations.FrameworkAnnotation;
import com.automate.driver.manager.DriverManager;
import com.automate.utils.screenshot.ScreenshotUtils;

import io.appium.java_client.AppiumDriver;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
public class TestListener extends ScreenshotUtils implements ITestListener, ISuiteListener {
	 
	
  @Override
  public void onStart(ISuite suite) {
	 //DriverManager.getDriver();
  }

  @Override
  public void onTestStart(ITestResult result) {
  }

  @Override
  public void onTestSuccess(ITestResult result) {
	  AppiumDriver driver	= DriverManager.getDriver();
	  if (driver == null) {
	        System.out.println("Driver is not initialized. Cannot take screenshot.");
	        return; }
	  ScreenshotUtils.takeScreenshot(driver, result.getName() + "_PASS");
	  
  }

  @Override
  public void onTestFailure(ITestResult result) {
	  AppiumDriver driver	= DriverManager.getDriver();
	  ScreenshotUtils.takeScreenshot(driver, result.getName() + "_FAIL");
  }

  @Override
  public void onTestSkipped(ITestResult result) {
  }

  @Override
  public void onFinish(ISuite suite) {
   
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // No implementation
  }

  @Override
  public void onStart(ITestContext iTestContext) {
    // No implementation
  }

  @Override
  public void onFinish(ITestContext iTestContext) {
    // No implementation
  }
  
} */
