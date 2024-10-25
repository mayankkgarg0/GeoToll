package com.automate.driver;


import com.automate.customexceptions.DriverInitializationException;
import com.automate.enums.ConfigJson;
import com.automate.enums.MobileBrowserName;
import com.automate.reports.ExtentManager;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



import java.net.URL;

//import static com.automate.utils.configloader.JsonUtils.getConfig;


public class Drivers extends ExtentManager {

  public static  UiAutomator2Options getApiDemoApkOptionsCreateAndroidDriverForNativeApp() 
  { System.out.println("-------- Started: GeoToll  Apk ----------");
  UiAutomator2Options options = new UiAutomator2Options();
	options
		.setPlatformName("Android")
		.setPlatformVersion("14.0")

		.setAutomationName("UiAutomator2")
		.setDeviceName("ZD222JNNVH")
		
		//.setAppPackage("com.geotoll.egpsflex_android.dev")
		//.setAppActivity("com.geotoll.egpsflex_android.activities.SplashActivity");
	     .setAppPackage("com.geotoll.egpsflex_android.dev.uat")
	     .setAppActivity("com.geotoll.egpsflex_android.activities.SplashActivity");   
	
	options.setAutoGrantPermissions(true);
	return options;
  
	/*	UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("8.1")

			.setAutomationName("UiAutomator2")
			.setDeviceName("emulator-5554")
			
			.setAppPackage("io.appium.android.apis")
			.setAppActivity(".ApiDemos");

		return options; */
  
 /* UiAutomator2Options options = new UiAutomator2Options();
	options
		.setPlatformName("Android")
		.setPlatformVersion("11.0")

		.setAutomationName("UiAutomator2")
		.setDeviceName("emulator-5554")
		
		.setAppPackage("com.geotoll.egpsflex_android.dev")
		.setAppActivity("com.geotoll.egpsflex_android.activities.SplashActivity");

	return options; */
  
/* UiAutomator2Options options = new UiAutomator2Options();
 	options
 		.setPlatformName("Android")
 		.setPlatformVersion("11.0")

 		.setAutomationName("UiAutomator2")
 		.setDeviceName("emulator-5554")
 		
 		.setAppPackage("io.appium.android.apis")
		.setAppActivity(".ApiDemos");


 	return options;  */
  
		
	}

  }

 