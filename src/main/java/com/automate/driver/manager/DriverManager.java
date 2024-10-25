package com.automate.driver.manager;

import io.appium.java_client.AppiumDriver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;


public final class DriverManager {

  private static final ThreadLocal<AppiumDriver> threadLocalDriver = new ThreadLocal<>();

  public static AppiumDriver getDriver() {
    return threadLocalDriver.get();
  }

  public static void setAppiumDriver(AppiumDriver driver) {
    
      threadLocalDriver.set(driver);
    System.out.println("---------- Appium Driver has been set (Threadlocal) ----------");
  }

  public static void unload() {
    threadLocalDriver.remove();
  }
}
