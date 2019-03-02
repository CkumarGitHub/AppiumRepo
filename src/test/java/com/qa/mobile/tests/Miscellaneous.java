package com.qa.mobile.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.mobile.testbase.TestBase;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscellaneous extends TestBase{
	
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		initialization();
	}
	
	@Test
	public void miscellaneous() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		System.out.println(driver.getContext());
		System.out.println(driver.getOrientation());
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		
	}

}
