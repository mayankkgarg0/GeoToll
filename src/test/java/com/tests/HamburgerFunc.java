package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automate.driver.manager.DriverManager;
import com.automate.entity.TesData;
import com.automate.utils.screenshot.ScreenshotUtils;
import com.google.common.collect.ImmutableList;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HamburgerFunc extends BaseTest {

	
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class , priority = 2)
	public void ReportTecniicalIssue(String username, String password) throws InterruptedException {
		AppiumDriver driver = DriverManager.getDriver();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]")).sendKeys(username);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
				.click();

		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
				.sendKeys(password);
		driver.navigate().back();

		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]"))
				.click();
		
		waitForTime(10000);
		
		
//--------------------------------------------------------------------------------Login Done--------------------------------------------------------------------------------------------------------//		
//-----------------------------------------------------------------------------Report Technical Issue----------------------------------------------------------------------------------------------//	

		
	try {	//	driver.findElement(AppiumBy
			//	.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"))
			//	.click();
	//	Thread.sleep(5000);

		test.info("Step 1: Open Left Pane");
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
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
		WebElement Details = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_details")));
		Details.click();
		Details.sendKeys("Hi " + " Complete Details Enclosed");

		// Submit -
		test.info("Step 4: Click on Submit");
		WebElement Submit = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_submit")));
		Submit.click();
		waitForTime(8000);
		test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "TicketMessage"));
		WebElement SubmitttedTicketNo = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("android:id/message")));
		String TicketMessage = SubmitttedTicketNo.getText();
		TicketMessage = TicketMessage.replaceAll("\\D+", "");
		System.out.println(TicketMessage);
		test.info("Step 5: Capture Ticket No.");

		// Assert.assertEquals(1716, TicketMessage, "Both values are equal");

		// WebElement AfterSubmitPopup =
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("//android:id/button1")));
		// WebElement AfterSubmitPopup =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text=\"OK\"]")));
		// AfterSubmitPopup.click();

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"OK\"]")).click();
		waitForTime(3000);
		test.pass("Successfully Reported Issue");
		// WebElement BackButton =
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev:id/img_back")));
		// BackButton.click();
		// waitForTime(3000);
		try {

			Runtime.getRuntime().exec("adb shell input keyevent 3");
			System.out.println("Home Button tapped");
			test.info("Pressed Home Icon");
		} catch (Exception e) {
			e.printStackTrace();
		}
} catch(Exception e) {
	test.info(e);
	Assert.fail("Reporting Technical Issue Failed" + e);
	
}
	}

	@Test(dataProvider = "MROData", dataProviderClass = TesData.class , priority = 3)
	public void PrivacyPolicynTermsAndConditions(String username, String password) throws InterruptedException {

		AppiumDriver driver = DriverManager.getDriver();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
try {		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
				.click();

		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
				.sendKeys(username);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
				.click();

		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
				.sendKeys(password);
		driver.navigate().back();

		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]"))
				.click();
		
		Thread.sleep(9000);
		
//-----------------------------------------------------Login Done----------------------------------------------------------------------------------------------------------------------------------//
//--------------------------------------------------------PP&TC------------------------------------------------------------------------------------------------------------------------------------//		
try {	//	driver.findElement(AppiumBy
		//		.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"))
		//		.click();
	//	Thread.sleep(5000);

		test.info("Step 1: Open Left Pane");
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
				.click();
		Thread.sleep(1000);
		// Privacy Policy
		test.info("Step 2: Click on Privacy Policy");
		WebElement PrivacyPolicy = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_pp")));
		PrivacyPolicy.click();
		waitForTime(10000);
		test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "PrivacyPolicy"));
		
		
		test.info("Step 3: Back");
		WebElement BackButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
		BackButton.click();

		waitForTime(1000);
		// After privacy back button takes back click hamburger icon
		test.info("Step 4: Open Again Left Pane");
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
				.click();
		Thread.sleep(1000);
		// Terms and Conditions -
		test.info("Step 5: Click on TermsnCondition");
		WebElement TermsnCondition = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_label_tc")));
		TermsnCondition.click();
		waitForTime(10000);
		test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "TermsnCondition"));
		test.info("Step 6: Back");
		WebElement BackButton1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/img_back")));
		BackButton1.click();
		waitForTime(2000);
}
catch(Exception e) {
	test.info(e);
	Assert.fail("PP & T&C Failed" + e);
	
}
}catch(Exception e) {
	test.info("Login Failed");
	Assert.fail("Login Failed" + e);
}
	}
	
	@Test(dataProvider = "MROData", dataProviderClass = TesData.class , priority = 4)
	public void ChangePassword(String username, String password) throws InterruptedException {
     
		AppiumDriver driver = DriverManager.getDriver();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
				.click();

		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]"))
				.sendKeys(username);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
				.click();

		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]"))
				.sendKeys(password);
		driver.navigate().back();

		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]"))
				.click();
		//longPress(driver.findElement(AppiumBy
			//	.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]")));
		Thread.sleep(9000);
		
//-------------------------------------------------------------------------------Login Done---------------------------------------------------------------------------------------------------------//		
//------------------------------------------------------------------------------Change Password-----------------------------------------------------------------------------------------------------//		
try {		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]"))
				.click();
		Thread.sleep(5000);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.info("Step 1: Open Left Pane");
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_hamburger\"]"))
				.click();
		Thread.sleep(1000);

		// change password
		test.info("Step 2: Click on Change password Text");
		driver.findElement(By.id("com.geotoll.egpsflex_android.dev.uat:id/layout_cng_pswd_tab")).click();
		waitForTime(2000);
		test.info("Step 3: Enter Old Password");
		WebElement OldPassword = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_old_password")));
		OldPassword.click();
		OldPassword.sendKeys(password);
		test.info("Step 4: Enter New Passwod");
		WebElement NewPassword = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/edt_new_password")));
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
	//	UpdatePassword.click();
		// longPress(UpdatePassword);
		test.pass("Successfully Change Password");
		test.addScreenCaptureFromPath(ScreenshotUtils.takeScreenshot(driver, "Change Password"));
		waitForTime(4000);
}
catch(Exception e) {
	test.info(e);
	Assert.fail("Change Password Failed" + e);
	
}
	}
//---------------------------------------------------------------------------------------Other Function-----------------------------------------------------------------------------------------------//
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

	protected static void swipe(Point start, Point end, Duration duration) {
		AppiumDriver driver = DriverManager.getDriver();
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(ImmutableList.of(swipe));

	}

	/*
	 * 
	 * If scrollRatio = 0.8 then page will scroll fast If scrollRatio = 0.2 then
	 * page will scroll very less
	 * 
	 * If user want to scroll page in DOWN direction Then scroll mobile screen
	 * starting from Bottom to Top (B to A)
	 * 
	 * If user want to scroll page in RIGHT direction Then scroll mobile screen
	 * starting from Right to Left (N to M)
	 * 
	 * Assume Screen size = 50(x value) by 100(y value) midpoint of screen will be
	 * 50*0.5 & 100*0.5 i.e. (25,50)
	 * 
	 */
	public static void scroll(String pageDirection, double scrollRatio) {
		Duration SCROLL_DUR = Duration.ofMillis(300);
		if (scrollRatio < 0 || scrollRatio > 1) {
			throw new Error("Scroll distance must be between 0 and 1");
		}
		AppiumDriver driver = DriverManager.getDriver();
		Dimension size = driver.manage().window().getSize();
		System.out.println("Screen Size = " + size);
		System.out.println("");

		Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));

		int a = (int) (midPoint.x * scrollRatio);
		int b = (int) (midPoint.y * scrollRatio);

		int bottom = midPoint.y + (int) (midPoint.y * scrollRatio); // 50 + 25 B
		int top = midPoint.y - (int) (midPoint.y * scrollRatio); // 50 - 25 A
		int left = midPoint.x - (int) (midPoint.x * scrollRatio); // 25 - 12.5 M
		int right = midPoint.x + (int) (midPoint.x * scrollRatio); // 25 + 12.5 N

		System.out.println("Midpoint: " + midPoint);

		System.out.println("Midpoint x: " + midPoint.x);
		System.out.println("a: " + a);

		System.out.println("Midpoint y: " + midPoint.y);
		System.out.println("b: " + b);

		System.out.println("");
		System.out.println("Bottom: " + bottom);
		System.out.println("Top: " + top);
		System.out.println("Right: " + right);
		System.out.println("Left: " + left);
		System.out.println("--------------------");

		if (pageDirection == "UP") {
			// Swipe Top to bottom, Page will go UP
			swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
		} else if (pageDirection == "DOWN") {
			swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
		} else if (pageDirection == "LEFT") {
			swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
		} else {
			// RIGHT
			swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
		}
	}

	public void swipeMe() throws InterruptedException {
		AppiumDriver driver = DriverManager.getDriver();
		driver.findElement(AppiumBy.accessibilityId("Swipe")).click();
		Thread.sleep(4000);
		// Move page towards Right
		scroll("RIGHT", 0.5);
		Thread.sleep(2000);
		scroll("RIGHT", 0.5);
		Thread.sleep(2000);
		scroll("LEFT", 0.5);
		Thread.sleep(2000);
		scroll("DOWN", 0.8);
		Thread.sleep(2000);
		scroll("UP", 0.8);
	}

}
