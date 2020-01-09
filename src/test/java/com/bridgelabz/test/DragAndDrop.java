package com.bridgelabz.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.bridgelabz.base.Base;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

/**
 * @author Sachin Barpete
 * @purpose handle drag and drop
 * @Date 08/01/2020
 */
public class DragAndDrop extends Base {

	@Test
	public void dragAndDropTest() throws InterruptedException {
		DesiredCapabilities desiredCapabilities = setDesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "/apk/draganddrop.apk");
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);
		Thread.sleep(500);
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[2]")
				.click();
		Thread.sleep(500);
		// Chick corea
		WebElement source = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2);
		WebElement target = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(5);
		TouchAction action = new TouchAction((MobileDriver<WebElement>) driver);
		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
		System.out.println("Element is droped at dastination successfully...");
		driver.quit();
	}
}
