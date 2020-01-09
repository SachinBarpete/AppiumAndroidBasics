package com.bridgelabz.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.bridgelabz.base.Base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Sachin Barpete
 * @purpose handle scrolling till the element is visible
 * @date 08/01/2020
 */
public class VerticalScrolling extends Base {

	@Test
	public void scrollingTest() throws InterruptedException {
		DesiredCapabilities desiredCapabilities = setDesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "/apk/ApiDemo.apk");
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);
		Thread.sleep(500);
		driver.findElementsById("android:id/text1").get(10).click();
		Thread.sleep(500);
		// scrolling down till we get the element
		MobileElement listItem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"Switches\"));"));
		System.out.println(listItem.getLocation());
		listItem.click();
		Thread.sleep(2000);
		driver.quit();
	}
}
