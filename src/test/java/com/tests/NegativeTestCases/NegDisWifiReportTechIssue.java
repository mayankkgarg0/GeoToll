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

public class NegDisWifiReportTechIssue extends BaseTest {

	@Test(dataProvider = "MROData", dataProviderClass = TesData.class, priority = 2)
	public void NegDisWifiReportTechIssueHamburger(String username, String password) throws InterruptedException {
		AppiumDriver driver = DriverManager.getDriver();
		Thread.sleep(3000);

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

//--------------------------------------------------------------------------------Login Done--------------------------------------------------------------------------------------------------------//		
//-----------------------------------------------------------------------------Report Technical Issue----------------------------------------------------------------------------------------------//	

			InternetDown();
			InternetDown();
			// To Swipe down and up
			NativeswipeDown();
			NativeswipeDown();
			NativeswipeUp();
			NativeswipeUp();
			waitForTime(2000);

			try { // driver.findElement(AppiumBy
					// .xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"))
					// .click();
				// Thread.sleep(5000);

				test.info("Step 1: Open Left Pane");
				driver.findElement(AppiumBy.xpath(
						"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
						.click();
				Thread.sleep(1000);
				// Report techical issue -
				test.info("Step 2: Click on RTissue page");
				WebElement ReportTechnicalIssue = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_report_issue")));
				ReportTechnicalIssue.click();
				waitForTime(1000);
				// Short Desp -
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
				waitForTime(8000);
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "TicketMessage"));
				WebElement SubmitttedTicketNo = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("android:id/message")));
				String TicketMessage = SubmitttedTicketNo.getText();
				TicketMessage = TicketMessage.replaceAll("\\D+", "");
				System.out.println(TicketMessage);
				test.info("Step 5: Capture Ticket No.");

				driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"OK\"]")).click();
				waitForTime(3000);

				try {

					Runtime.getRuntime().exec("adb shell input keyevent 3");
					System.out.println("Home Button tapped");
					test.info("Pressed Home Icon");
				} catch (Exception e) {
					e.printStackTrace();
				}
				test.fail("Failed as process was not interpted with Wifi");

			} catch (Exception e) {
				test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "WiFi Disabled"));
				test.info("Reporting Technical Issue failed as Wifi id Didabled");
				test.pass(e);

			}
		} catch (Exception e) {

			test.info("Unable to Login");
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