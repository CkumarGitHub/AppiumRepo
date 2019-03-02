package com.qa.mobile.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.mobile.testbase.TestBase;


public class InvokeAppTest extends TestBase{
	
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		initialization();
	}
	
	@Test
	public void invokeAppTest() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		AssertJUnit.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").isEnabled(), false);
		driver.findElementById("android:id/checkbox").click();
		AssertJUnit.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").isEnabled(), true);
		driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
		driver.findElementById("android:id/edit").sendKeys("Hello Radhe");
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		
}
	
}
