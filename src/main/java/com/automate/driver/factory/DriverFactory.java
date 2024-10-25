package com.automate.driver.factory;

import com.automate.customexceptions.DriverInitializationException;
import com.automate.driver.Drivers;
import com.automate.driver.manager.DriverManager;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


public  class DriverFactory extends Drivers {
  
	 static AppiumDriver driver;
	
 
  
  public static void initializeDriverandroidLaunchApp(UiAutomator2Options options) throws MalformedURLException, InterruptedException {
	  
	  driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
	  DriverManager.setAppiumDriver(driver);
	 System.out.println("---------- Android Driver has been set in ThreadLocal ----------");
		
	}
  
  public static void initializeDriveriosLaunchApp(XCUITestOptions options) throws MalformedURLException {
		driver =new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
		DriverManager.setAppiumDriver(driver);
		System.out.println("---------- iOS Driver has been set ----------");
	}

  public static void quitDriver() 
     {
      DriverManager.getDriver().quit();
      DriverManager.unload();
    }
  





}
