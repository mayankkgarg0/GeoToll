package com.automate.utils.screenshot;


import com.automate.driver.manager.DriverManager;

import io.appium.java_client.AppiumDriver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import  com.automate.driver.manager.*;

public  class ScreenshotUtils  {
	//AppiumDriver driver	= DriverManager.getDriver();
	public static String takeScreenshot( AppiumDriver driver,String fileName) {
		if (driver == null) {
	        System.out.println("Driver is not initialized in screenshoot.");
	        return fileName;   }
		if(driver!= null) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File( fileName);
    
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved Successfully");
            return destFile.getAbsolutePath();
           
           // System.out.println("xyz   "+destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		return fileName;
    }
}
  // This class is to handle the change in third party library
/*  @SneakyThrows
  public static void captureScreenshotAsFile(String testName) {
    File source = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    File destination = new File(FrameworkConstants.SCREENSHOT_PATH + File.separator + testName + ".png");
    FileUtils.copyFile(source, destination);
  }

  public static String captureScreenshotAsBase64() {
    return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
  } */
	
	

