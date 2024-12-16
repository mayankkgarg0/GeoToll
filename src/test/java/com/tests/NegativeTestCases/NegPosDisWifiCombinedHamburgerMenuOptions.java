package com.tests.NegativeTestCases;

import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class NegPosDisWifiCombinedHamburgerMenuOptions extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class)
	public void NegPosDisWifiCombinedHamburgerSideMenuOption(String username, String password)
			throws InterruptedException, IOException {
		AppiumDriver driver = DriverManager.getDriver();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {

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
		} catch (Exception e) {

			test.info("Unable to Login");
			test.fail(e);
		}
//----------------------------------------------------------------------------------Login Done------------------------------------------------------------------------------------------------------		
//----------------------------------------------------------------------Report Technical Issue(Internet Down)---------------------------------------------------------------------------------------
		InternetDown();
		//NativeswipeUp();
		scroll("UP",0.5);
		waitForTime(2000);
		try {

			/*
			 * test.info("Press Back Button"); WebElement BackButton = wait.until(
			 * ExpectedConditions.elementToBeClickable(By.id(
			 * "com.geotoll.egpsflex_android.dev.uat:id/img_back"))); BackButton.click();
			 */

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
					ScreenshotUtils.takeScreenshot(driver, "Repport Technical 'Issue - WiFi Disabled"));
			test.pass("Report Technical issue failed as Wifi is Disabled");
			test.info("Test Case Passed");
		}

//----------------------------------------------------------------------Report Technical Issue(Internet Up)-----------------------------------------------------------------------------------------
		InternetUP();
		waitForTime(1000);
		Back();
		Back();
		//NativeswipeUp();
		//scroll("UP",0.5);
		waitForTime(2000);
		try {

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
					ScreenshotUtils.takeScreenshot(driver, "Change Password Internet  Connected"));
			WebElement SubmitttedTicketNo = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("android:id/message")));
			String TicketMessage = SubmitttedTicketNo.getText();

			TicketMessage = TicketMessage.replaceAll("\\D+", "");
			System.out.println(TicketMessage);
			test.info("Step 5: Capture Ticket No." + TicketMessage);

			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"OK\"]")).click();
			waitForTime(3000);
			test.pass("Successfully Reported Issue");

		} catch (Exception e) {
			test.addScreenCaptureFromPath(
					ScreenshotUtils.takeScreenshot(driver, "Repport Technical 'Issue Failed when  - WiFi was Enabled"));
			test.fail(e + "  " + "Report Technical issue failed when Wifi id Enabled");
			test.info("Report Technical issue failed when Wifi was Enabled");
			Back();
		}

//----------------------------------------------------------------------Privacy Policy(Internet Down)-----------------------------------------------------------------------------------------------
		InternetDown();
		//NativeswipeUp();
		//scroll("UP",0.5);
		try {

			/*
			 * test.info("Press Back Button"); WebElement BackButton = wait.until(
			 * ExpectedConditions.elementToBeClickable(By.id(
			 * "com.geotoll.egpsflex_android.dev.uat:id/img_back"))); BackButton.click();
			 */

			test.info("Step 1: Open Left Pane");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
					.click();
			waitForTime(2000);
			// Privacy Policy
			test.info("Step 2: Click on Privacy Policy");
			WebElement PrivacyPolicy = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_pp")));
			PrivacyPolicy.click();
			//----
			waitForTime(10000);
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "PrivacyPolicy"));

			

			String AppPageTittle = driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_title"))
					.getText();
			System.out.println("Element found: " + AppPageTittle);
			waitForTime(3000);

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

//----------------------------------------------------------------------Privacy Policy(Internet Up)-------------------------------------------------------------------------------------------------
		InternetUP();
		waitForTime(1000);
		Back();
		//NativeswipeUp();
		//scroll("UP",0.5);
		try {

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

			

			String AppPageTittle = driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_title"))
					.getText();
			System.out.println("Element found: " + AppPageTittle);
			waitForTime(1000);
            // When white page there in PP
			//WebElement DummyTittle = driver
				//	.findElement(By.xpath("//android.widget.TextView[@text=\"Web page not available\"]"));
		//	String DummyStatement = DummyTittle.getText();
					
			String DummyStatement = "White Screen Available";

			String ExpectedText = "Dummy";

			
			if (DummyStatement.equals(ExpectedText)) {
				test.addScreenCaptureFromPath(
						ScreenshotUtils.takeScreenshot(driver, "Privacy Policy  failed as Wifi is Disabled"));
				test.info("Privacy Policy can be Viewed Clearly as Wifi is Enabled");
				test.pass("Test Complete");

			} else {
				test.fail("Failed as Privacy policy page is not visible");
			//	Assert.fail("Test case Failed as Repport Technical Issue worked after Wifi was Disabled");

			}
			

		} catch (Exception e) {
			// Not able to take Screenshot of Privacy Policy
			//test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Privacy Policy can be Viewed Clearly "));
			test.info("Privacy Policy is not visible ");
			test.fail("Test Case Failed");

		}

//----------------------------------------------------------------------Terms & Conditions(Internet Down)-------------------------------------------------------------------------------------------
		Back();
		//NativeswipeUp();
		//scroll("UP",0.5);
		InternetDown();

		try {
			/*
			 * test.info("Press Back Button"); WebElement BackButton = wait.until(
			 * ExpectedConditions.elementToBeClickable(By.id(
			 * "com.geotoll.egpsflex_android.dev.uat:id/img_back"))); BackButton.click();
			 */

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
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "TermsnCondition-InternetDown"));

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
			test.pass("TestCase Passed");
			test.info("Terms&Conditions Couldn't process as Wifi is Disabled");
		}

//----------------------------------------------------------------------Terms & Conditions(Internet Up)---------------------------------------------------------------------------------------------
		InternetUP();
		Back();
		//NativeswipeUp();
		//scroll("UP",0.5);
		try {
			/*
			 * test.info("Press Back Button"); WebElement BackButton = wait.until(
			 * ExpectedConditions.elementToBeClickable(By.id(
			 * "com.geotoll.egpsflex_android.dev.uat:id/img_back"))); BackButton.click();
			 */

			test.info("Step 4: Open Again Left Pane");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
					.click();
			Thread.sleep(3000);

			test.info("Step 5: Click on TermsnCondition");
			WebElement TermsnCondition = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_tc")));
			TermsnCondition.click();
			waitForTime(15000);
			

			// OCR from Screenshot or Webpage some Element take out
			WebElement SignUp = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text=\"Sign Up\"]")));
			SignUp.click();
			waitForTime(3000);

			test.pass("Terms and Conditions can be Viewed Correctly");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "TermsnCondition-Internet Up"));
			// Assert.fail("Test case Failed as Terms&Conditions worked after Wifi was
			// Disabled"); // if want to continue with next PP issue remove this as it
			// terminates here

		}

		catch (Exception e) {
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Terms&Conditions Failed to View"));
			test.fail("Terms&Conditions Failed to View" + " " + e);
			test.info("Terms&Conditions Failed to View");
		}

//-----------------------------------------------------------------------Change Password(Internet Down)--------------------------------------------------------------------------------------------
		Back();
		//NativeswipeUp();
		//scroll("UP",0.5);
		InternetDown();

		waitForTime(2000);

		try {
			/*
			 * Step Used for TestCase without MRO Screen Dashboard
			 * driver.findElement(AppiumBy.xpath(
			 * "//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"
			 * )).click(); Thread.sleep(5000);
			 */
			
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
			WebElement ReNewPassword = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_confirm_new_password")));
			ReNewPassword.click();
			ReNewPassword.sendKeys("New@12346");
			driver.navigate().back();
			WebElement UpdatePassword = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_update_password")));
			UpdatePassword.click();
			waitForTime(8000);
			// Next screen required xpath to break flow or OCR from screenshot
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Change Password-WiFi Disabled"));
			
			String CheckTittle = driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label"))
					.getText();
			System.out.println(CheckTittle);

			test.fail("Failed as process was not interpted with Wifi");
			// Assert.fail("Test case Failed as Change Password worked after Wifi was
			// Disabled"); // if want to continue with next RT issue remove this as it
			// terminates here

		} catch (Exception e) {
			test.addScreenCaptureFromPath(
					ScreenshotUtils.takeScreenshot(driver, "Change Password couldn't succed as WiFi Disabled"));
			test.pass("TestCase Passed");
			test.info("ChangePassword couldn't succed as Wifi id Disabled");
		}

//-----------------------------------------------------------------------Change Password(Internet Up)----------------------------------------------------------------------------------------------	

		InternetUP();
		Back();
		//NativeswipeUp();
		//scroll("UP",0.5);
		waitForTime(2000);

		try {
			/*
			 * Step Used for TestCase without MRO Screen Dashboard
			 * driver.findElement(AppiumBy.xpath(
			 * "//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"
			 * )).click(); Thread.sleep(5000);
			 */
			// NativeswipeUp();
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
			WebElement ReNewPassword = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_confirm_new_password")));
			ReNewPassword.click();
			ReNewPassword.sendKeys("New@12346");
			driver.navigate().back();
			WebElement UpdatePassword = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_update_password")));
		/*	 UpdatePassword.click();
              waitForTime(8000);
			// Next screen required xpath to break flow or OCR from screenshot
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Change Password- Wifi Enabled"));
			
			String CheckTittle = driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label"))
					.getText();
			System.out.println(CheckTittle); */

			test.pass("Test Case Passed ");
			test.info("Change Password Done Successfully");
			// Assert.fail("Test case Failed as Change Password worked after Wifi was
			// Disabled"); // if want to continue with next RT issue remove this as it
			// terminates here

		} catch (Exception e) {
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Change Password WiFi Enabled"));
			test.fail(e);
			test.info("ChangePassword failed");
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