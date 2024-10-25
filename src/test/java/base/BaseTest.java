package base;

import com.automate.driver.Drivers;
import com.automate.driver.factory.DriverFactory;
import com.automate.driver.manager.DeviceManager;
import com.automate.driver.manager.DriverManager;
import com.automate.driver.manager.PlatformManager;
import com.automate.enums.MobilePlatformName;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.Objects;
import org.testng.annotations.AfterSuite;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends Drivers {

	
  public BaseTest() {
  }


  @BeforeMethod
  public void setUp() throws MalformedURLException, InterruptedException {
 
	  UiAutomator2Options  options = Drivers.getApiDemoApkOptionsCreateAndroidDriverForNativeApp();
	  
	  DriverFactory.initializeDriverandroidLaunchApp(options);
	  
  }

  @AfterMethod
  public void tearDown(ITestResult result) {
  DriverFactory.quitDriver();

  }

 
} 
