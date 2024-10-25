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
import org.testng.annotations.Test;

import com.automate.driver.manager.DriverManager;
import com.google.common.collect.ImmutableList;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

	public final class LoginTestN extends BaseTest {
		
		@SuppressWarnings("deprecation")
		@Test
		public void WrongUserIdLoginN() throws InterruptedException, IOException {
			
			  AppiumDriver  driver = DriverManager.getDriver();
			  waitForTime(2000);
			  
		       
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).click();
		                                    
		     
			  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).sendKeys("udupaakshaya@gmail.com");
			  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).click();
			 
			  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).sendKeys("New@1234");
			 driver.navigate().back();
			
			
			  driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_login\"]")).click();
			  longPress(driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_login\"]")));
			
			  waitForTime(9000);
			
}
		@Test (priority =8) 
		public void WrongPasswordLoginN() throws InterruptedException, IOException {
			
			  AppiumDriver  driver = DriverManager.getDriver();
			  waitForTime(2000);
			  test = extent.createTest("WrongPasswordLoginN Test");
			 test.info("Step 1: Open the login page");
			  test.info("Step 2: Enter username and password");
			 
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).click();
		   test.info("Step 2: Enter username");
			  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).sendKeys("udupaakshaya+QATest@gmail.com");
			  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).click();
			  test.info("Step 3: Enter Wrong Password");
			  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).sendKeys("New@12826");
			 driver.navigate().back();
			
			 test.info("Step 4: Click on the login button");
			  driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_login\"]")).click();
			  longPress(driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.geotoll.egpsflex_android.dev:id/btn_login\"]")));
			  test.pass("Login test passed.");
			  waitForTime(9000);
             
		}	
	//	@Test
		public void IncompleteUserIdLoginN() throws InterruptedException, IOException {
			
			  AppiumDriver  driver = DriverManager.getDriver();
			  waitForTime(2000);
		
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		     WebElement UserId= wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")));
		      UserId.click();
			  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_email\"]")).sendKeys("udupaak");
			  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.geotoll.egpsflex_android.dev:id/edt_login_password\"]")).click();
			  
			 
			 driver.navigate().back();
			// String color = UserId.getCssValue("background-color");
			 String color = UserId.getAttribute("contentDescription"); // or "textColor"
			 System.out.println("The background color is: " + color);
			 
			   waitForTime(9000);
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

}