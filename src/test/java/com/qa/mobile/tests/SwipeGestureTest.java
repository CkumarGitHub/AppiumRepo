package com.qa.mobile.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.mobile.testbase.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;

public class SwipeGestureTest extends TestBase{
	
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		initialization();
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void swipeGesturesTest() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		WebElement element_Date_Widgets = driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']");
		//TouchActions
		TouchAction touch = new TouchAction(driver);
		touch.tap(TapOptions.tapOptions().withElement(element(element_Date_Widgets))).perform();
		
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		//driver.findElementByAndroidUIAutomator("content-desc(\"9\")").click();
		
		WebElement src_element = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement dest_element = driver.findElementByXPath("//*[@content-desc='45']");
		
		touch.longPress(LongPressOptions.longPressOptions().
				withElement(element(src_element)).
				withDuration(Duration.ofSeconds(2))).
				moveTo(element(dest_element)).release().perform();
		
	}

}
