package com.qa.mobile.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.mobile.testbase.TestBase;

public class ScrollToViewTest extends TestBase{
	
	@BeforeClass
	public void setUp() {
		initialization();
	}
	
	@Test
	public void scrollIntoViewTest() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	}

}
