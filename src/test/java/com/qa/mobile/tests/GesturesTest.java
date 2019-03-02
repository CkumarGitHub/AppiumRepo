package com.qa.mobile.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.mobile.testbase.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;

public class GesturesTest extends TestBase{
	
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		initialization();
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void touchGesturesTest() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		WebElement element_Expandable_Lists = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		//TouchActions
		TouchAction touch = new TouchAction(driver);
		touch.tap(TapOptions.tapOptions().withElement(element(element_Expandable_Lists))).perform();
		
		//long Press
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		WebElement element_People_Names = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		touch.longPress(LongPressOptions.longPressOptions().withElement(element(element_People_Names)).withDuration(Duration.ofSeconds(2))).release().perform();
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed(), true, "NO SUCH ELEMENT");
		
	}

}
