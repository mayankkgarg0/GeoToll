package com.automate.driver.factory;
/*
import com.automate.customexceptions.DriverInitializationException;
import com.automate.driver.Drivers;
import com.automate.driver.Drivers1;
import com.automate.driver.manager.DriverManager;
import com.automate.enums.MobilePlatformName;

import io.appium.java_client.AppiumDriver;



public class DriverFactory1 {

	
public static void initializeDriver(MobilePlatformName mobilePlatformName, String deviceName, String udid, int port,
	                                      String emulator) {
	   AppiumDriver  driver = DriverManager.getDriver();
	    switch (mobilePlatformName) {
	      case ANDROID:
	        driver = Drivers1.createAndroidDriverForNativeApp(deviceName, udid, port, emulator);
	        break;
	      case ANDROID_WEB:
	        driver = Drivers1.createAndroidDriverForWeb(deviceName, udid, port, emulator);
	        break;
	      case IOS:
	        driver = Drivers1.createIOSDriverForNativeApp(deviceName, udid, port);
	        break;
	      case IOS_WEB:
	        driver = Drivers1.createIOSDriverForWeb(deviceName, udid, port);
	        break;
	      default:
	        throw new DriverInitializationException(
	          "Platform name " + mobilePlatformName + " is not found. Please check the platform name");
	    }
	    DriverManager.setAppiumDriver(driver);
	  }

	  public static void quitDriver() {
	    if (Objects.nonNull(DriverManager.getDriver())) {
	      DriverManager.getDriver().quit();
	      DriverManager.unload();
	    }
	  }
	} */

