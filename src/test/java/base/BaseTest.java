package base;

import com.automate.driver.Drivers;
import com.automate.driver.factory.DriverFactory;

import com.automate.driver.manager.DriverManager;




import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

//import com.automate.utils.screenrecording.ScreenRecordingService;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.Objects;

public class BaseTest extends Drivers {

  public BaseTest() {
  }

  
  public AppiumDriverLocalService appiumService;
  public AppiumDriver driver;

  @BeforeSuite
  public void startAppiumServer() {
      // Start the Appium server
      appiumService = AppiumDriverLocalService.buildDefaultService();
      appiumService.start();
      System.out.println("Appium server started at: " + appiumService.getUrl());
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
  
  
  
  @AfterSuite
  public void stopAppiumServer() {
      
          appiumService.stop(); // Stop the Appium server
          System.out.println("Appium server stopped.");
   }
  

} 
