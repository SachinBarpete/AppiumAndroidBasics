package com.bridgelabz.test;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bridgelabz.base.Base;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author Sachin Barpete
 * @purpose perform addition in the calculator
 * @date 06/01/2020
 */
public class Calculator extends Base {

	@Test
	public void addTest() throws InterruptedException {
		DesiredCapabilities desiredCapabilities = setDesiredCapabilities();
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (Exception exception) {
			System.out.println("Cause is : " + exception.getCause());
			System.out.println("Message is : " + exception.getMessage());
			exception.printStackTrace();
		}
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);
		Thread.sleep(1000);
		driver.findElementById("com.android.calculator2:id/digit_8").click();
		driver.findElementById("com.android.calculator2:id/op_add").click();
		driver.findElementById("com.android.calculator2:id/digit_5").click();
		driver.findElementById("com.android.calculator2:id/eq").click();
		Thread.sleep(500);
		String result = driver.findElementById("com.android.calculator2:id/result").getText();
		Assert.assertEquals(result, "13", "add test is failed...");
		Thread.sleep(2000);
		driver.quit();
	}
}
