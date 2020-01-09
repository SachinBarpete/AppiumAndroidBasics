package com.bridgelabz.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bridgelabz.base.Base;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author Sachin Barpete
 * @purpose Launch Dialer
 * @date 06/01/2020
 */
public class DailNumber extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities desiredCapabilities = setDesiredCapabilities();
		desiredCapabilities.setCapability("appPackage", "com.android.dialer");
		desiredCapabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);
		Thread.sleep(2000);
		driver.quit();
	}
}
