package com.tests;
/*
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;


public class UsefulFunction {

	 
	 Map<String, Object> command = new HashMap<>();
       command.put("command", "input keyevent 3"); // 3 is the keycode for Home
       driver.executeScript("mobile: shell", command); 
       
       Map<String, Object> params = new HashMap<>();
       params.put("action", "home");
       driver.executeScript("mobile: pressButton", params); 
       
     
    //   driver.executeScript("mobile: pressButton", Map.of("buttonName", "home"));

	  
	  
	  
       // Click Home Button
	// Step 1: Open the camera and take a picture

   try {
           
           Runtime.getRuntime().exec("adb shell input keyevent 3"); 
           System.out.println("Home Button tapped");
           Thread.sleep(1000); 
          Runtime.getRuntime().exec("adb shell am start -a android.media.action.IMAGE_CAPTURE"); 
           System.out.println("Camera has been enabled.");
           Thread.sleep(1000); 
	           
            Runtime.getRuntime().exec("adb shell input keyevent 27"); 
	         System.out.println("Camera Shutter Clicked.");
	         Thread.sleep(5000); 
       } catch (Exception e) {
           e.printStackTrace(); 
       } 
   // Step 2: Pull the latest image to local machine
   File latestImage = new File(IMAGE_PATH + "latest_image.jpg"); // Update with your logic to find the latest image
   if (latestImage.exists()) {
       // Copy the image to a local directory for processing
       Files.copy(latestImage.toPath(), new File(LOCAL_IMAGE_PATH).toPath(), StandardCopyOption.REPLACE_EXISTING);
   }

   
   // Step 3: Process the image (using Tesseract or any other method)
   String scannedText = processImageWithTesseract(LOCAL_IMAGE_PATH);
   System.out.println("Scanned Text: " + scannedText);
   
   Thread.sleep(1000); 

	 Thread.sleep(3000);
	 
}
private String processImageWithTesseract(String imagePath) {
       // Use Tesseract OCR to process the image
       // Example implementation using Tesseract
       // Make sure Tesseract is properly set up in your project
       // Refer to Tesseract documentation for setup and usage
       return "Processed text from image"; // Placeholder for actual OCR processing
   }

   
   
   
	 try {
           // Enable Bluetooth using adb command
           Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus enable"); // For enabling Bluetooth
           System.out.println("Bluetooth has been enabled.");
       } catch (Exception e) {
           e.printStackTrace(); 
       } 
	 
	//  Location location = new Location(48.8584, 2.2945, 10); // Example: Paris (Eiffel Tower) coordinates
	  // driver.setLocation(location);
	   

Android UI Automator 

// String selector = "new UiSelector().text(“1”)).className(“android.widget.TextView”))";
		
				 WebElement element = driver.findElement(AppiumBy.androidUIAutomator(selector));
				    element.click();
} */

