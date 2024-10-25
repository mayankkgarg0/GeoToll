package com.tests;

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

public class MRO extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "loginData", dataProviderClass = TesData.class)
	public void LoginAcceptCredBVO(String username, String password) throws InterruptedException, IOException {

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
			longPress(driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]")));
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

//---------------------------------Login Done -----------------------------------------------------------------------------------------------------------------------------------------------//		
		try {

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
			waitForTime(7000);
			test.pass("Bluetooth Configuration Completed");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Bluetooth Configured"));
		} catch (Exception e) {

			test.fail(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Configure Bluetooth"));
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
//----------------Bluetooth Add Done(1st step)---------------------------------------------------------------------------------------------------------------------------------------------//		 

		// VIN number
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

			try {
				String ActualTittle = driver
						.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label")).getText();
				System.out.println(ActualTittle);
				test.pass("Vim  Configuration Completed");
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "VIM Configured"));
			} catch (Exception e) {
				WebElement BackButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
				BackButton.click();
				test.info(" Pressed Back Button");
				waitForTime(5000);
				test.pass("Vim  Configuration Completed");
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "VIM Configured"));

			}

		} catch (Exception e) {

			test.fail(e);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Configure VIN"));
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

//-------------------------------VIN Add Done(2st step)--------------------------------------------------------------------------------------------------------------------------------------------//	

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
			test.pass("Odometer  Configuration Completed");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Odometer Configured"));
		} catch (Exception e) {

			test.fail(e);
			test.addScreenCaptureFromPath(
					ScreenshotUtils.takeScreenshot(driver, "Unable to Configure Odometer Reading"));
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}


	}
//------------------------------Odometer Reading Done(3rd step)------------------------------------------------------------------------------------------------------------------------------------//
	
// ---------------------------------------------Test Complete-----------------------------------------------------------------------------------------------------------------------------------//	

//-------------------------------------Other Function------------------------------------------------------------------------------------------------------------------------------------------//

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
