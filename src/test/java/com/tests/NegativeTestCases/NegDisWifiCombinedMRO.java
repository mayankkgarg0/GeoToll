package com.tests.NegativeTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automate.driver.manager.DriverManager;
import com.automate.entity.TesData;
import com.automate.utils.screenshot.ScreenshotUtils;
import com.google.common.collect.ImmutableList;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class NegDisWifiCombinedMRO extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class)
	public void NegDisWifiCombinedMROMethod(String username, String password)
			throws InterruptedException, IOException {

		AppiumDriver driver = DriverManager.getDriver();
		waitForTime(2000);

		test.info("Step 1: Open the login page");
		test.info("Step 2: Enable Bluetooth and connect ");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		bluetoothOn(); InternetUP();
		
		try {
			test.info("Step 3: Enter username and password");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
					.click();
			test.info("Step 4: Enter username ");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
					.sendKeys(username);
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
					.click();
			test.info("Step 5: Enter Password");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
					.sendKeys(password);
			driver.navigate().back();

			test.info("Step 6: Click on Login");

			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]"))
					.click();
			// longPress(driver.findElement(AppiumBy.xpath(
			// "//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]")));
			waitForTime(10000);
			String ExpectedTittle = "Welcome, Akshay QATest ";
			String ActualTittle = driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label"))
					.getText();
			System.out.println(ActualTittle);
			Assert.assertEquals(ActualTittle, ExpectedTittle, "ActualTittle is passed");
			test.pass("Login Test Passed");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "LoginPass"));
		}

		catch (Exception e) {

			test.fail(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Login"));
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

//-----------------------------------------------------------------------------------------Login Done -----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------MRO Bluetooth Config with Internet Down-------------------------------------------------------------------		
		
		
		waitForTime(2000);
		scroll("UP", 0.5);
		try {
			
			InternetDown();
			NativeswipeDown(); NativeswipeDown();
			NativeswipeUp();NativeswipeUp();
			waitForTime(2000);
			
			WebElement NewBluetoothFindStart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"1\"]")));
			NewBluetoothFindStart.click();
			waitForTime(2000);
			test.info(" Clicked on Find Bluetooth");
			WebElement BluetoothSelectConnect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_connect\"]")));
			BluetoothSelectConnect.click();
			test.info(" Selected Bluetooth");
			waitForTime(1000);

			WebElement BluetoothSelectPopupYes = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
			BluetoothSelectPopupYes.click();
			test.info(" Accepted Popup");
			waitForTime(9000);
			WebElement CaptureVINNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"2\"]")));
			CaptureVINNumber.click();
			waitForTime(5000);

			test.fail("Bluetooth Configuration Completed");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Bluetooth Configured"));
			Assert.fail("Test failed as Internet was down and Bluetooth Configuration Completed" );
		} catch (Exception e) {

			test.pass(e);
			test.info("Unable to Configure Bluetooth as  WiFi/Mobile Data is Disabled");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
					"Unable to Configure Bluetooth as  WiFi/Mobile Data is Disabled"));
			

		}

	


//----------------------------------------------------------------------------------------MRO Bluetooth Config with Internet Up-------------------------------------------------------------------		

		waitForTime(2000);
		Back();
		try {
			
			InternetUP();
			
			waitForTime(2000);
			
			WebElement NewBluetoothFindStart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"1\"]")));
			NewBluetoothFindStart.click();
			waitForTime(2000);
			test.info(" Clicked on Find Bluetooth");
			WebElement BluetoothSelectConnect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_connect\"]")));
			BluetoothSelectConnect.click();
			test.info(" Selected Bluetooth");
			waitForTime(1000);

			WebElement BluetoothSelectPopupYes = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
			BluetoothSelectPopupYes.click();
			test.info(" Accepted Popup");
			waitForTime(10000);
			NativeswipeUp();
			
			
			WebElement CaptureVINNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"2\"]")));
			CaptureVINNumber.click();
			Back();
			test.pass("Bluetooth Configuration Completed");
			
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Bluetooth Configured"));
		} catch (Exception e) {

			test.fail("Unable to Configure Bluetooth");
			test.info("Unable to Configure Bluetooth");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,"Unable to Configure Bluetooth"));
			Assert.fail("Test failed as Internet was Up and Bluetooth Didn't Configured " );
			

		} 

		
//----------------------------------------------------------------------------------------MRO Check Vin with Bluetooth Off(Catch Error)--------------------------------------------------------------
	try {	bluetoothOff();
		scroll("UP", 0.5);
		waitForTime(2000);
		scroll("UP", 0.5);
		test.info("Scroll-Up");
		test.info("Dasboard Screen Notification - Bluettooth Not Connected ");
		test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,"Dasboard Screen Bluettooth Error"));
		scroll("DOWN",0.5);
		
		test.info("Scroll-Down");
		test.info("VIN Disabled as Bluetooth not connected");
		waitForTime(2000);
		test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,"VIN Disabled as Bluetooth not connectedOne"));
		bluetoothOn();
		waitForTime(3000);
		scroll("UP", 0.5);
		scroll("UP", 0.5);
		waitForTime(2000);
		scroll("UP", 0.5);
		scroll("DOWN",0.5);
		test.info("VIN Enabled as Bluetooth is connected");
		waitForTime(3000);
		test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,"VIN Enabled as Bluetooth is connectedOne"));
		test.pass("Test Passed");
	} 
	catch(Exception e) {
		test.fail("Some Error Occured");
		Assert.fail("Some Error Occured");
	}
	
//----------------------------------------------------------------------------------------MRO Vin Config with Internet Down and Bluetooth On---------------------------------------------------------
	
	
		          bluetoothOn();
		          waitForTime(2000);
		          InternetDown();  NativeswipeUp();
		         
		     
			
       try {
				WebElement CaptureVINNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"2\"]")));
				CaptureVINNumber.click();
				waitForTime(5000);
				test.info(" Clicked on Find VIM");

				WebElement ShutterClick = wait.until(
						ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/capture")));
				ShutterClick.click();
				test.info(" Taken Pic");
				Thread.sleep(6000);
				// waited unusually and did not move

				WebElement ConfirmVIN = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_confirm")));
				ConfirmVIN.click();
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
						"Failed As Vin Configured while Data is Off"));
				waitForTime(20000);
				test.info(" Confirm Pic");
				NativeswipeUp();
				
				WebElement CaptureOdometerReadingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"3\"]")));
				CaptureOdometerReadingClick.click();
				
				test.fail("Failed As Vin Configured while Data is Off");
				Assert.fail("Failed As Vin Configured while Internet is down" );
			} 
                catch (Exception e) {

				test.pass("Passed as Vin Configuration Failed as WiFi is Disabled");
				test.info("Unable to Configure VIN as  WiFi/Mobile Data is Disabled");
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
						"Unable to Configure VIN as  WiFi/Mobile Data is Disabled"));
				
			}

		

 //----------------------------------------------------------------------------------------MRO Vin Config with Internet UP ---------------------------------------------------------
   		
       Back(); InternetUP();
       waitForTime(3000);
       NativeswipeUp();
       
   	
       try {
				WebElement CaptureVINNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"2\"]")));
				CaptureVINNumber.click();
				waitForTime(5000);
				test.info(" Clicked on Find VIM");

				WebElement ShutterClick = wait.until(
						ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/capture")));
				ShutterClick.click();
				test.info(" Taken Pic");
				Thread.sleep(6000);
				// waited unusually and did not move

				WebElement ConfirmVIN = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_confirm")));
				ConfirmVIN.click();
	
				waitForTime(27000);
				test.info(" Confirm Pic");
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
						"Passed As Vin Configuration ompleted"));
				NativeswipeUp();
				WebElement CaptureOdometerReadingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"3\"]")));
				CaptureOdometerReadingClick.click();
				test.pass("Passed as Vin Configuration completed");
				
			} 
                catch (Exception e) {
                	test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
    						"Failed As Vin Wasn't Configured  while Data is On"));
                	test.fail("Failed As Vin Wasn't Configured  while Data is On");
    				Assert.fail("Failed As Vin Wasn't Configured  while Data is On" );
				
				
				
			}

		
       
//----------------------------------------------------------------------------------------MRO Odometer Config With Internet Down---------------------------------------------------------------------
	
	
      
         Back();
         InternetDown();
         waitForTime(1000);
         NativeswipeUp();
         waitForTime(1000);	
			try {
				WebElement CaptureOdometerReadingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"3\"]")));
				CaptureOdometerReadingClick.click();
				waitForTime(3000);
				test.info(" Clicked on CaptureOdometerReading");
				WebElement ShutterClick = wait.until(
						ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/capture")));
				ShutterClick.click();
				test.info("  Captured Pic");
				waitForTime(7000);

				WebElement Retake = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_retake")));
				Retake.click();
				waitForTime(4000);
				test.info("  Retake");
				ShutterClick.click();
				waitForTime(10000);
				test.info("  Captured Pic");
				WebElement Retake1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_retake\"]")));

				Retake1.click();
				waitForTime(4000);
				test.info("  Retake");
				ShutterClick.click();
				waitForTime(27000);
				test.info("  Captured Pic");

				test.fail("Failed As Vin Configured while Data is Off");
				Assert.fail("Failed As Vin Configured while Internet is down" );
			} catch (Exception e) {

				test.pass("Passed as Odometer Configuration Failed as WiFi is Disabled");
				test.info("Unable to Configure Odometer as  WiFi/Mobile Data is Disabled");
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,"Unable to Configure Odometer as  WiFi/Mobile Data is Disabled"));
				
			}
//----------------------------------------------------------------------------------------MRO Odometer Config With Internet Up---------------------------------------------------------------------
	
			 Back();
	         InternetUP();
	         waitForTime(1000);
	         NativeswipeUp();
				
				try {
					WebElement CaptureOdometerReadingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"3\"]")));
					CaptureOdometerReadingClick.click();
					waitForTime(3000);
					test.info(" Clicked on CaptureOdometerReading");
					WebElement ShutterClick = wait.until(
							ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/capture")));
					ShutterClick.click();
					test.info("  Captured Pic");
					waitForTime(7000);

					WebElement Retake = wait.until(ExpectedConditions
							.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_retake")));
					Retake.click();
					waitForTime(4000);
					test.info("  Retake");
					ShutterClick.click();
					waitForTime(10000);
					test.info("  Captured Pic");
					WebElement Retake1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_retake\"]")));

					Retake1.click();
					waitForTime(4000);
					test.info("  Retake");
					ShutterClick.click();
					waitForTime(27000);
					test.info("  Captured Pic");
					test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,"Passed As Odometer Configuration completed"));
					test.pass("Passed as Odometer Configuration completed");
				} catch (Exception e) {

					test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
    						"Failed As Odometer Wasn't Configured  while Data is On"));
                	test.fail("Failed As Odometer Wasn't Configured  while Data is On");
    				Assert.fail("Failed As Odometer Wasn't Configured  while Data is On" );
				
				} 

}
	
// --------------------------------------------- ------------------------------------------Test Complete---------------------------------------------------------------------------------------------	

//-----------------------------------------------------------------------------------------Other Function---------------------------------------------------------------------------------------------

	// Swipe Required to create
	public static void longPress(WebElement ele) {
		Point location = ele.getLocation();
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(input, 0);
		sequence.addAction(
				input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
		sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(
				input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
		sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		DriverManager.getDriver().perform(ImmutableList.of(sequence));
	}

	private void waitForTime(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void bluetoothOn() {
		try {

			Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus enable");
			test.info("BluetoothOn");
			waitForTime(1000);
			System.out.println("BluetoothOn");
		} catch (Exception e) {
			e.printStackTrace();
			test.info(e);
			test.info("Bluetooth Not Working");
		}
	}
	
	public void bluetoothOff() {
		try {

			Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus disable");
			test.info("BluetoothOff");
			waitForTime(1000);
			System.out.println("BluetoothOff");
		} catch (Exception e) {
			e.printStackTrace();
			test.info(e);
			test.info("Bluetooth Not Working");
		}
	}
	
	public void InternetUP() {
		try {

			Runtime.getRuntime().exec("adb shell svc wifi enable");
			Runtime.getRuntime().exec("adb shell svc data enable");
			test.info("Data/WiFi Enabled");
			waitForTime(1000);
			System.out.println("Mobile Data & WiFI has been Enabled");
		} catch (Exception e) {
			System.out.println("Issue exit in WiFi /Mobile Data");
			e.printStackTrace();
			test.info(e);
		}
	}

	public void InternetDown() {
		try {

			Runtime.getRuntime().exec("adb shell svc data disable");
			Runtime.getRuntime().exec("adb shell svc wifi disable");
			test.info("Data/WiFi Disabled");
			waitForTime(1000);
			System.out.println("Mobile Data & WiFI has been Disabled");
		} catch (Exception e) {
			System.out.println("Issue exit in WiFi /Mobile Data");
			e.printStackTrace();
			test.info(e);
		}

	}

	
	public void NativeswipeUp() {
		try {

			Runtime.getRuntime().exec("adb shell input swipe 500 1000 500 0");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void NativeswipeDown() {
		try {

			Runtime.getRuntime().exec("adb shell input swipe 500 0 500 1000");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void Back() {
		try {

			Runtime.getRuntime().exec("adb shell input keyevent 4");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	
	
	public static void swipe(Point start, Point end, Duration duration) {
		AppiumDriver driver = DriverManager.getDriver();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(swipe));
    }
	
	  public static void scroll(String pageDirection, double scrollRatio){
		AppiumDriver driver = DriverManager.getDriver();
		Duration SCROLL_DUR = Duration.ofMillis(300);
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        
        Dimension size = driver.manage().window().getSize();
        System.out.println("Screen Size = "+size);
        System.out.println("");

        Point midPoint = new Point((int)(size.width * 0.5),(int)(size.height * 0.5));
        
        int a = (int)(midPoint.x * scrollRatio);
        int b = (int)(midPoint.y * scrollRatio);
        
        int bottom = midPoint.y + (int)(midPoint.y * scrollRatio); // 50 + 25        B
        int top = midPoint.y - (int)(midPoint.y * scrollRatio); // 50 - 25           A
        int left = midPoint.x - (int)(midPoint.x * scrollRatio); // 25 - 12.5         M
        int right = midPoint.x + (int)(midPoint.x * scrollRatio); // 25 + 12.5        N

        System.out.println("Midpoint: "+ midPoint);
        
        System.out.println("Midpoint x: "+ midPoint.x);   
        System.out.println("a: "+ a);  
        
        System.out.println("Midpoint y: "+ midPoint.y);
        System.out.println("b: "+ b);        

        System.out.println("");
        System.out.println("Bottom: "+ bottom);
        System.out.println("Top: "+ top);
        System.out.println("Right: "+ right);
        System.out.println("Left: "+ left);
        System.out.println("--------------------");
        
        if (pageDirection == "UP") {
        	//Swipe Top to bottom, Page will go UP
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (pageDirection == "DOWN") {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (pageDirection == "LEFT") {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
        	//RIGHT
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }
	
	
}
