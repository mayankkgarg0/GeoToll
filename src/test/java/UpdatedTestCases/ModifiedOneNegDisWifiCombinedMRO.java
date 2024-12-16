package UpdatedTestCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
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
import java.util.Base64;

import javax.imageio.ImageIO;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

public class ModifiedOneNegDisWifiCombinedMRO extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class)
	public void ModifiedOneNegDisWifiCombinedMROMethod(String username, String password)
			throws InterruptedException, IOException {

		AppiumDriver driver = DriverManager.getDriver();
		waitForTime(2000);

		test.info("Step 1: Open the login page");
		test.info("Step 2: Enable Bluetooth and connect ");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
			
			// To Include what ever element comes next
		/*	String ExpectedTittle = "Welcome, Akshay QATest ";
			String ActualTittle = driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label"))
					.getText();
			System.out.println(ActualTittle);
			Assert.assertEquals(ActualTittle, ExpectedTittle, "ActualTittle is passed"); */

			WebElement NewBluetoothFindStart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"1\"]")));
			NewBluetoothFindStart.click();
			waitForTime(5000);
			Back();
			test.pass("Login Test Passed");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "LoginPass"));
		
		}

		catch (Exception e) {

			test.fail(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Login"));
	/*		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
	            // Convert screenshot to BufferedImage for OCR processing
	            BufferedImage bufferedImage = ImageIO.read(srcFile);
 
	            // Initialize Tesseract OCR
	            ITesseract tesseract = new Tesseract();
	            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Set path to tessdata

	            // Perform OCR on the image
	            String extractedText = tesseract.doOCR(bufferedImage);
	            System.out.println("Extracted Text: " + extractedText); */
                String Checkingtext = "Pending Agency Approval";
                
		/*		Tesseract("extractedText");
                if(extractedText.contains(Checkingtext)) {
                	System.out.println("Working");
                }
                else {
                	System.out.println("Not Working");
                } */
                
	        
			
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

//-----------------------------------------------------------------------------------------Login Done -----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------MRO Screen - Bluetooth Connection Tests-------------------------------------------------------------------		
		
/*		// For Bluetooth Tab
		waitForTime(1000);
		scroll("UP", 0.5);
		try {
			
			InternetUP();
		//	NativeswipeDown(); NativeswipeDown();
		//	NativeswipeUp();NativeswipeUp();
			waitForTime(1000);
			
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

			 try {		
			WebElement BluetoothSelectPopupYes = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
			BluetoothSelectPopupYes.click();
			test.info(" Accepted Popup");
			waitForTime(9000);
			WebElement CaptureVINNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"2\"]")));
			CaptureVINNumber.click();
			Back();
			waitForTime(5000);
			
            test.pass("Bluetooth Configuration Completed");
			
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Bluetooth Configured"));
	         }     
			  catch(Exception e) {
	        	 test.fail("Unable to Configure Bluetooth as bluetooth internal icons not clickble" + e);
	 			test.info("Unable to Configure Bluetooth as bluetooth internal icons not clickble");
	 			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,"Unable to Configure Bluetooth as bluetooth internal icons not clickble"));
	 			Back();
	             }
	}    catch (Exception e) {

			test.fail("Unable to Configure Bluetooth" + e);
			test.info("Unable to Configure Bluetooth");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,"Unable to Configure Bluetooth"));
	
		}

	


//----------------------------------------------------------------------------------------MRO Screen - VIN Check Tests-------------------------------------------------------------------		

	//	waitForTime(2000);
	//	Back();
		try {
			
			InternetUP();
			
			waitForTime(2000);
			scroll("UP", 0.5);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Checking State of Vin while Bluetooth is On"));
			test.info("Dasboard Screen - Bluetooth Connected | Enabled state of Vin   ");
			
			
			bluetoothOff();
			scroll("UP", 0.8); //not able to work
			waitForTime(1000);
			//scroll("UP", 0.5);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Checking Dashboard Screen while Bluetooth is Off"));
			test.info("Dasboard Screen - Bluetooth Disconnected Error ");
			scroll("DOWN",0.5);
			
			
			test.info("Scroll-Down");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Checking Dashboard Screen Vin State while Bluetooth is Off"));
			test.info("Dasboard Screen - Bluetooth Disconnected | Disabled state of Vin ");
			test.info("Vin Disabled as Bluetooth not connected");
			scroll("UP",0.5);
			
			test.info("Scroll-Up");
			
			// To Check to take out text from dashboard screen and display in report and equate in if else for pass and fail(Bluetooth On and off Scenario)
			// To Check Ble on and off with exception for that include multiple try catch inside try catch
			bluetoothOn();
			scroll("UP",0.8);
			waitForTime(2000);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Checking Dashboard Screen Vin State while Bluetooth is On"));
			test.pass("Vin Enabled after bluetooth is On");
		} catch (Exception e) {

			test.fail("Bluetooth| VIN Check Tests Error");
	
		} 

		

	


		bluetoothOn();
   	
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
	
				waitForTime(10000);
				test.info(" Confirm Pic");
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
						"Passed As Vin Configuration completed"));				
				NativeswipeUp();
				WebElement CaptureOdometerReadingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"3\"]")));
				CaptureOdometerReadingClick.click();
				Back();
				test.pass("Passed as Vin Configuration completed");
				
			} 
                catch (Exception e) {
                	test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver,
    						"Failed As Vin Wasn't Configured  while Data is On"));
                	test.fail("Failed As Vin Wasn't Configured  while Data is On & Bluetooth is Up");
    				
				
				
				
			} */

		// Till here Done
       

//----------------------------------------------------------------------------------------MRO Screen - Odometer Reading Tests---------------------------------------------------------------------
	
			InternetDown();
			bluetoothOff();
	        // waitForTime(1000);
	       //  NativeswipeUp(); */
	 
	         try {
	 			
	 			waitForTime(2000);
	 			scroll("UP",0.8);
	 			scroll("DOWN", 0.5);
	 			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Checking State of Dashboard while bluetooth is off"));
	 			test.info("Dasboard Screen - Bluetooth Disconnect Error ");
	 			scroll("UP",0.8);
	 			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Checking State of Odometer while BluetoothNInternet is off"));
	 			test.info("Dasboard Screen -  Disabled state of Odometer ");
	 			
	 			waitForTime(1000);
	 			bluetoothOn();
	 			InternetUP();
	 			waitForTime(2000);
	 			
	 			scroll("UP", 0.8);
	 			waitForTime(1000);
	 			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Status of MRO Odometer"));
	 			test.info("Dasboard Screen - Status of MRO Odometer ");
	 			
	 			
	 			
	 			
	 			// To Check to take out text from dashboard screen and display in report and equate in if else for pass and fail(Bluetooth On and off Scenario)
	 			// To Check Ble on and off with exception for that include multiple try catch inside try catch
	 			
	 			
	 			waitForTime(2000);
	 			
	 			test.pass("Odometer Enabled after bluetooth is On");
	 		} catch (Exception e) {

	 			test.fail("Bluetooth/Internet - Odometer Reading Test Error");
	 	
	 		} 

	  
	         
	         
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
					waitForTime(25000);
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
	
/*	public String Tesseract( String extractedText) throws IOException, TesseractException {
		
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
	            // Convert screenshot to BufferedImage for OCR processing
	            BufferedImage bufferedImage = ImageIO.read(srcFile);
 
	            // Initialize Tesseract OCR
	            ITesseract tesseract = new Tesseract();
	            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Set path to tessdata

	            // Perform OCR on the image
	            String extractedText = tesseract.doOCR(bufferedImage);
	            System.out.println("Extracted Text: " + extractedText);
	            
		
		return extractedText;
    }*/
	
	
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
