package UpdatedTestCases;

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

public class ModifiedNegDisWifiCombinedHamburgerMenuOptions extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class)
	public void ModifiedNegDisWifiCombinedHamburgerMenuOptionsMethod(String username, String password)
			throws InterruptedException, IOException {
		AppiumDriver driver = DriverManager.getDriver();
		Thread.sleep(3000);
		SoftAssert softAssert = new SoftAssert();
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
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Unable to Login"));
			test.info("Unable to Login");
			test.fail(e);
			
		}

//----------------------------------------------------------------------Login Done-----------------------------------------------------------------------------------------------------------------		

//-----------------------------------------------------------------------------------------------Report Technical Issue Start(Internet UP)------------------------------------------------------------------------
		bluetoothOn();
		InternetUP();
			
		
		waitForTime(2000);
		try {

		/*	test.info("Press Back Button");
			WebElement BackButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
			BackButton.click(); */

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
					ScreenshotUtils.takeScreenshot(driver, "Reported Technical issue completed"));
			WebElement SubmitttedTicketNo = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("android:id/message")));
			String TicketMessage = SubmitttedTicketNo.getText();

			TicketMessage = TicketMessage.replaceAll("\\D+", "");
			System.out.println(TicketMessage);
			test.info("Step 5: Capture Ticket No. " + TicketMessage);

			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"OK\"]")).click();
			waitForTime(3000);
			test.pass("Successfully Reported Issue");

		} catch (Exception e) {
			test.addScreenCaptureFromPath(
					ScreenshotUtils.takeScreenshot(driver, "Repport Technical Issue did not completed successfully"));
			test.fail(e + "  " + "Report Technical issue failed");
			test.info("Report Technical issue failed ");
			Back();
		}
		
		
		

	//--------------------------------------------------------------------------------------Terms&Conditions (Internet Up)---------------------------------------------------------------------------------------------	
		waitForTime(1000);
		try {
			/*test.info("Press Back Button");
			WebElement BackButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
			BackButton.click(); */

			test.info("Step 4: Open Again Left Pane");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
					.click();
			Thread.sleep(1000);

			test.info("Step 5: Click on TermsnCondition");
			WebElement TermsnCondition = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_tc")));
			TermsnCondition.click();
			waitForTime(15000);
			
			
			WebElement SignUp = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text=\"Sign Up\"]")));
			SignUp.click();
			waitForTime(3000);

			test.pass("Terms and Conditions can be Viewed Correctly");
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "TermsnCondition can be viewed"));
		}

		catch (Exception e) {
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Terms&Conditions  can not be viewed"));
			test.fail(e);
			test.info("Terms&Conditions failed to view");
		}
//-------------------------------------------------------------------------------------------------Privacy Policy Started (Internet Up)------------------------------------------------------------------------------------
		
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
			test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "PrivacyPolicy Page"));

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
			test.info("Privacy Policy is not visible ");
			test.fail("Test Case Failed");

		}
	

	
	
	
	//----------------------------------------------------------------------Change Password(Internet Up) ---------------------------------------------------------------------------------------------
			
				waitForTime(2000);
          Back();
				try {
					/*
					 * Step Used for TestCase without MRO Screen Dashboard
					 * driver.findElement(AppiumBy.xpath(
					 * "//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"
					 * )).click(); Thread.sleep(5000);
					 */
					//NativeswipeUp();
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

					
					
					waitForTime(8000);
					test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Change Password Completed"));
					String CheckTittle = driver
							.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_welcome_label")).getText();
					System.out.println(CheckTittle); 
                    // Check for welcome xpath take it out only welcome or Notification bell , In Login also can verify dashboard with bell or welcome text
			
					
					test.pass("Test Case Passed ");
					test.info("Change Password Done Successfully");
					
				} catch (Exception e) {
					test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Change Password Failed"));
					test.fail(e);
					test.info("Change Password failed");
					waitForTime(3000);
					String CPErrorMessage = driver
							.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_error")).getText();
					String IncorrectOldPass = "* Incorrect old password";
					String OldnNewNotSame= "* Old and New password cannot be same";
					if((CPErrorMessage).equals(IncorrectOldPass)) {
						System.out.println(CPErrorMessage);
						test.info(CPErrorMessage);  
						test.info("Please Enter correct old password");					
	
                      }
					else if((CPErrorMessage).equals(OldnNewNotSame)) {
						System.out.println(OldnNewNotSame);
						test.info(OldnNewNotSame);  
						test.info("Please Enter Different New password");	
					}
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
	
	public void Back() {
		try {

			Runtime.getRuntime().exec("adb shell input keyevent 4");
			waitForTime(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}