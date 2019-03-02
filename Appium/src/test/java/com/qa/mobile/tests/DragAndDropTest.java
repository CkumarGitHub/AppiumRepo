package com.qa.mobile.tests;


import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.mobile.testbase.TestBase;

import io.appium.java_client.android.AndroidTouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDropTest extends TestBase{

	@BeforeClass
	public void setUp() {
		initialization();
	}
	
	
	@Test
	public void dragAndDropTest() {
		
		StopWatch pageload = new StopWatch();
		pageload.start();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		
		AndroidTouchAction androidtouch = new AndroidTouchAction(driver);
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destin = driver.findElementsByClassName("android.view.View").get(1);
		
		androidtouch.longPress(element(source)).moveTo(element(destin)).release().perform();
		Assert.assertEquals(driver.findElementsByClassName("android.widget.TextView").get(0).getText(),"Views/Drag and Drop");
		
		pageload.stop();
		System.out.println(pageload.getTime());
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
