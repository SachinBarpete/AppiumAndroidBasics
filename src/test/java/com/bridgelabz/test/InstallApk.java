package com.bridgelabz.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.bridgelabz.base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Sachin Barpete
 * @purpose Install apk file in the mobile through automation script
 * @date 06/01/2020
 */
public class InstallApk extends Base {

	@Test
	public void installApkTest() {
		DesiredCapabilities desiredCapabilities = setDesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apk/Files.apk");
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);
		driver.quit();
	}
}
