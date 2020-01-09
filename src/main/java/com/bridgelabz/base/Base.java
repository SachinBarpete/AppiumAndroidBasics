package com.bridgelabz.base;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Sachin Barpete
 * @purpose To set common DesiredCapabilities
 * @date 08/01/2020
 */
public class Base {

	public static DesiredCapabilities setDesiredCapabilities() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google pixel 2");
		return desiredCapabilities;
	}
}
