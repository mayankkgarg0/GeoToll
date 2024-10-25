package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automate.driver.manager.DriverManager;
import com.google.common.collect.ImmutableList;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class InitialVerification extends BaseTest {
	@Test (priority = 5)
	public void OdometerReading() {
		
	//Login --1)Open camera , 2)Take Pic , 3 Send it  and store it 4) verify with order history for reading 	
		  AppiumDriver  driver = DriverManager.getDriver();
		  waitForTime(2000);
		 // test = extent.createTest("InitialVerification Test");
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]")).click();
		
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_email\"]")).sendKeys("udupaakshaya+QATest@gmail.com");
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]")).click();
		 
		  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/edt_login_password\"]")).sendKeys("New@1234");
		 driver.navigate().back();
		
		 
		  driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]")).click();
		  longPress(driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/btn_login\"]")));
		  waitForTime(9000);
		 driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev.uat:id/img_close\"]")).click();
		 waitForTime(4000);
		 
		 WebElement OdometerEle = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_odometer_title")));
		 OdometerEle.click();
		 waitForTime(1000);
		// test.info("Step 1: Clicked Odometer Icon");
		 //test.info("Step 2: Capture/Store Latest Odometer Reading");
		 WebElement MilageNum = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/txt_odometer_mileage")));
		 MilageNum.click();
		 //String Status = MilageNum.getText();
		 String Status = "Under Review";
		System.out.println( MilageNum.getText());
		waitForTime(1000);
	//	Response response = ApiUtil.approveValue("12350");
		if(  !MilageNum.getText().equals(Status)) {
		//	test.info("Step 3 : Captured Odometer Reading as it is not Under Review");
			//test.info("Click Capture Odometer Reading Icon");
		WebElement CaptureOdometerReading = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_capture_odometer_reading")));
		CaptureOdometerReading.click();
		waitForTime(2000);
		//WebElement OdometerCaptureBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev:id/boundaryBox")));
		//OdometerCaptureBox.click();
		//OdometerCaptureBox.sendKeys("12350");
		//test.info("Scan a picture Through Camera");
		WebElement ClickImage = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/capture")));
		ClickImage.click();
		waitForTime(4000);
		//test.info("Click Re-Capture Odometer Reading Icon");
		WebElement CaptureRetake = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.geotoll.egpsflex_android.dev.uat:id/btn_retake")));
		CaptureRetake.click();
		waitForTime(2000);
		//test.info("Re-Scan a picture Through Camera");
		ClickImage.click();
		waitForTime(2000);
	//	test.info("Click Re-Capture  Odometer Reading Icon Again");
		CaptureRetake.click();
		
	//	test.info("Re-Scan a picture Through Camera Again");
		waitForTime(2000);
		ClickImage.click(); 
		waitForTime(10000);
	//	test.pass("Odometer Reading Captured");
		}
		
		else if ( MilageNum.getText().equals(Status)) {
			 try {
				 test.info("Step 3 : Captured Odometer Reading as it is Under Review"); 
		           Runtime.getRuntime().exec("adb shell input keyevent 3"); 
		           System.out.println("Home Button tapped");
		           test.info("Pressed Home Icon");      
			 }
			 catch (Exception e) {
		           e.printStackTrace(); 
		       } 
		}
		waitForTime(2000);	
		 
	}
	
	 public static void longPress(WebElement ele) {
	      Point location = ele.getLocation();
	      PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	      Sequence sequence = new Sequence(input, 0);
	      sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
	      sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	      sequence.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
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
	 
	 public static class ApiUtil {
		    private static final String BASE_URL = "com.geotoll.egpsflex_android.activities.VehicleOdometerHistoryActivity"; // Update with your API base URL
		    
		    public static Response approveValue(String valueId) {
		        return RestAssured
		            .given()
		            .contentType("application/json")
		            .when()
		            .post(BASE_URL + "/approve/" + valueId); // Adjust endpoint as necessary
		    }
		}
	 
	/* public void testApproveValue() {
	        // Call the API to approve a value
	      //  Response response = ApiUtil.approveValue("12350"); // Example value ID

	        // Validate the API response
	        if (response.getStatusCode() == 200) {
	            System.out.println("Value approved successfully.");
	        } else {
	            System.err.println("Failed to approve value: " + response.getStatusLine());
	        } 
}*/
}