package com.tests.NegativeTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
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

public class MROIndivisualTabCheckN extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class, priority = 1)
	public void MROIndivisualCheck(String username, String password) throws InterruptedException, IOException {

		AppiumDriver driver = DriverManager.getDriver();
		waitForTime(2000);

		test.info("Step 1: Open the login page");
		test.info("Step 2: Enable Bluetooth and connect ");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {

			Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus enable");
			System.out.println("Bluetooth has been enabled.");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		//	longPress(driver.findElement(AppiumBy.xpath(
			//		"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]")));
			waitForTime(15000);
			String ExpectedTittle = "Welcome, Akshay QATest ";
			String ActualTittle = driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label"))
					.getText();
			System.out.println(ActualTittle);
			Assert.assertEquals(ActualTittle, ExpectedTittle, "ActualTittle is passed");
			test.pass("Login Test Passed");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "LoginPass"));
		}

		catch (Exception e) {
			// e.printStackTrace();
			test.fail(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Login"));
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

//---------------------------------Login Done -----------------------------------------------------------------------------------------------------------------------------------------------------//		
		try {

			
			WebElement NewBluetoothFindStart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"1\"]")));
			NewBluetoothFindStart.click();
			waitForTime(2000);
			test.info(" Clicked on Find Bluetooth");
			
			WebElement BackButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
			BackButton.click();
			test.info(" Pressed Back Button");
			waitForTime(4000);
			test.info(" Bluetooth button is Clickable");
			
			waitForTime(2000);
			test.pass("Bluetooth Test Passed");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Bluetooth Button Clickable"));
		} catch (Exception e) {
			// e.printStackTrace();
			test.fail(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Bluetooth icon is not Enable/Clickable"));
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

//----------------Bluetooth Checked--------------------------------------------------------------------------------------------------------------------------------------------------------------//		 

		waitForTime(3000);
		
		try {
			test.info(" Clicked on Find VIM");
			WebElement CaptureVINNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"2\"]")));
			CaptureVINNumber.click();
			WebElement ShutterClick = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/capture")));
			ShutterClick.click();
			waitForTime(1000);
	
				test.fail("VIN Clicked");
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "VIM CLicked"));
				Assert.fail("Test failed due to exception: VIN ");
				
			}

		catch (Exception e) {

			test.pass(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "VIN is Not Clickable"));
			waitForTime(2000);
		}
		
	

//---------------------VIN Is Disabled--------------------------------------------------------------------------------------------------------------------------------------------------------//

	


//-----------------------------------------------Odometer Reading Started---------------------------------------------------------------------------------------------------------------------------//	
		
		try {
			WebElement CaptureOdometerReadingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/txt_position\" and @text=\"3\"]")));
			CaptureOdometerReadingClick.click();
			waitForTime(2000);
			test.info(" Clicked on CaptureOdometerReading");
			
			WebElement ShutterClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/capture")));
			ShutterClick.click();
			test.fail("Odometer  Clicked");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Odometer Clicked"));
			Assert.fail("Test failed due to exception: Odometer ");
		} catch (Exception e) {

			test.pass(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, " Odometer  Not Clickable"));
			
		}

	}

//-----------------------------Odometer Reading Done(3rd step)----------------------------------------------------------------------------------------------------------------------------------------//

//------------------------TestComplete--------------------------------------------------------------------------------------------------------------------------------------------------------------//	

//-------------------------------------OtherFunction------------------------------------------------------------------------------------------------------------------------------------------------//

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
}
