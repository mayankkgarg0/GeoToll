package com.tests;

import org.testng.annotations.Test;

import com.automate.driver.manager.DriverManager;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


public class InviteCodeRegistration {

	//@Test (priority =6)
	public void Registration() throws InterruptedException {
		
		DriverManager.getDriver();
		 // AppiumDriver  driver = DriverManager.getDriver();
		  Thread.sleep(3000);
		  DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.geotoll.egpsflex_android.dev:id/txt_label_have_invite_code\"]")).click();
		
	}
}
