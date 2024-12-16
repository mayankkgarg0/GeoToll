package com.tests.NegativeTestCases;

import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
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
import io.appium.java_client.MobileBy;
import org.testng.asserts.SoftAssert;

public class NegDisWifiCombinedHamburgerMenuOptions extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class)
	public void NegDisWifiCombinedHamburgerSideMenuOptions(String username, String password)
			throws InterruptedException, IOException {
		AppiumDriver driver = DriverManager.getDriver();
		Thread.sleep(3000);
		SoftAssert softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			InternetUP();
			InternetUP();

			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
					.click();

			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
					.sendKeys(username);
			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
					.click();

			driver.findElement(AppiumBy.xpath(
					"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
					.sendKeys(password);
			driver.navigate().back();

			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]"))
					.click();

			waitForTime(12000);

//----------------------------------------------------------------------Login Done-----------------------------------------------------------------------------------------------------------------		

//----------------------------------------------------------------------Change Password Start-------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------Change Password with Data Down ---------------------------------------------------------------------------------------------
			InternetDown();
			InternetDown();
			NativeswipeDown();
			NativeswipeDown();

			NativeswipeUp();
			NativeswipeUp();

			waitForTime(2000);

			try {
				/*
				 * Step Used for TestCase without MRO Screen Dashboard
				 * driver.findElement(AppiumBy.xpath(
				 * "//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"
				 * )).click(); Thread.sleep(5000);
				 */
				NativeswipeUp();
				test.info("Step 1: Open Left Pane");
				driver.findElement(AppiumBy.xpath(
						"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
						.click();
				Thread.sleep(1000);

				test.info("Step 2: Click on Change password Text");
				driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/layout_cng_pswd_tab")).click();
				waitForTime(2000);
				test.info("Step 3: Enter Old Passwod");
				WebElement OldPassword = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_old_password")));
				OldPassword.click();
				OldPassword.sendKeys(password);
				test.info("Step 4: Enter New Passwod");
				WebElement NewPassword = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_new_password")));
				NewPassword.click();
				NewPassword.sendKeys("New@12346");
				// swipe function call
				// scroll("DOWN", 0.5); Scroll with not work as no place to swipe
				test.info("Step 4: Re-Enter New Passwod");
				driver.navigate().back();
				WebElement ReNewPassword = wait.until(ExpectedConditions.elementToBeClickable(
						By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_confirm_new_password")));
				ReNewPassword.click();
				ReNewPassword.sendKeys("New@12346");
				driver.navigate().back();
				WebElement UpdatePassword = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_update_password")));
				UpdatePassword.click();

				// Next screen required xpath to break flow or OCR from screenshot
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Change Password"));
				waitForTime(8000);
				String CheckTittle = driver
						.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label")).getText();
				System.out.println(CheckTittle);

				test.fail("Failed as process was not interpted with Wifi");
				// Assert.fail("Test case Failed as Change Password worked after Wifi was
				// Disabled"); // if want to continue with next RT issue remove this as it
				// terminates here

			} catch (Exception e) {
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Change Password WiFi Disabled"));
				test.pass(e);
				test.info("ChangePassword failed as Wifi id Disabled");
			}
		} catch (Exception e) {

			test.info("Unable to Login");
			test.fail(e);
		}

//-----------------------------------------------------------------------------------------------Report Technical Issue Start------------------------------------------------------------------------
		waitForTime(2000);
		try {

			test.info("Press Back Button");
			WebElement BackButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
			BackButton.click();

			test.info("Step 1: Open Left Pane");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
					.click();
			Thread.sleep(1000);

			test.info("Step 2: Click on RTissue page");
			WebElement ReportTechnicalIssue = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_report_issue")));
			ReportTechnicalIssue.click();
			waitForTime(1000);
			// Short Desp
			test.info("Step 3: Create Short Description");
			WebElement ShortDesc = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_short_description")));
			ShortDesc.click();
			ShortDesc.sendKeys("ABCDE");
			// Details
			WebElement Details = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_details")));
			Details.click();
			Details.sendKeys("Hi " + " Complete Details Enclosed");

			// Submit -
			test.info("Step 4: Click on Submit");
			WebElement Submit = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_submit")));
			Submit.click();
			waitForTime(10000);
			test.addScreenCaptureFromPath(
					ScreenshotUtils.takeScreenshot(driver, "Chane Password Internet Not Connected"));
			WebElement SubmitttedTicketNo = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("android:id/message")));
			String TicketMessage = SubmitttedTicketNo.getText();

			waitForTime(3000);
			test.fail("Failed as process was not interpted with Wifi");
			// Assert.fail("Test case Failed as Repport Technical Issue worked after Wifi
			// was Disabled"); // if want to continue with next T&C issue remove this as it
			// terminates here

		} catch (Exception e) {
			test.addScreenCaptureFromPath(
					ScreenshotUtils.takeScreenshot(driver, "Repport Technical 'Issue  WiFi Disabled"));
			test.pass(e);
			test.info("Report Technical issue failed as Wifi id Disabled");
		}
//--------------------------------------------------------------------------------------Terms&Conditions Started---------------------------------------------------------------------------------------------	
		try {
			test.info("Press Back Button");
			WebElement BackButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
			BackButton.click();

			test.info("Step 4: Open Again Left Pane");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
					.click();
			Thread.sleep(1000);

			test.info("Step 5: Click on TermsnCondition");
			WebElement TermsnCondition = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_tc")));
			TermsnCondition.click();
			waitForTime(5000);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "TermsnCondition"));
			
			// OCR from Screenshot or Webpage some Element take out
			WebElement SignUp = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text=\"Sign Up\"]")));
			SignUp.click();
			waitForTime(3000);

			test.fail("Failed as process was not interpted with Wifi");
			// Assert.fail("Test case Failed as Terms&Conditions worked after Wifi was
			// Disabled"); // if want to continue with next PP issue remove this as it
			// terminates here

		}

		catch (Exception e) {
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Terms&Conditions  WiFi Disabled"));
			test.pass(e);
			test.info("Terms&Conditions failed as Wifi id Disabled");
		}
//-------------------------------------------------------------------------------------------------Privacy Policy Started------------------------------------------------------------------------------------
		try {

			test.info("Press Back Button");
			WebElement BackButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
			BackButton.click();

			test.info("Step 1: Open Left Pane");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
					.click();
			Thread.sleep(1000);
			// Privacy Policy
			test.info("Step 2: Click on Privacy Policy");
			WebElement PrivacyPolicy = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_pp")));
			PrivacyPolicy.click();
			waitForTime(10000);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "PrivacyPolicy"));

			waitForTime(4000);

			String AppPageTittle = driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_title"))
					.getText();
			System.out.println("Element found: " + AppPageTittle);
			waitForTime(1000);

			WebElement ActualErrorTittle = driver
					.findElement(By.xpath("//android.widget.TextView[@text=\"Web page not available\"]"));
			String ActuaErrorOccured = ActualErrorTittle.getText();
			System.out.println(ActuaErrorOccured);

			String ExpectedText = "Web page not available";

			if (ActuaErrorOccured.equals(ExpectedText)) {
				test.addScreenCaptureFromPath(
						ScreenshotUtils.takeScreenshot(driver, "Privacy Policy  failed as Wifi is Disabled"));
				test.info("Privacy Policy  failed as Wifi is Disabled");
				test.pass("Test Complete");

			} else {
				test.fail("Failed as process was not interpted with Wifi");
				Assert.fail("Test case Failed as Repport Technical Issue worked after Wifi was Disabled");

			}

		} catch (Exception e) {
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Privacy Policy  failed"));
			test.info("Privacy Policy  failed ");
			test.fail(e);

		}
	}

//---------------------------------------------------------------------------------------------------Other Method-----------------------------------------------------------------------------------//	
	public void NativeswipeDown() {
		try {

			Runtime.getRuntime().exec("adb shell input swipe 500 0 500 1000");
			waitForTime(1000);
		} catch (Exception e) {
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
			test.info(e);
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
			e.printStackTrace();
			test.info(e);
		}

	}

	public void waitForTime(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}