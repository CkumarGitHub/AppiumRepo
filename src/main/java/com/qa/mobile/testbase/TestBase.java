package com.qa.mobile.testbase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	public AndroidDriver<AndroidElement> driver;
	
	private AndroidDriver<AndroidElement> getDriver(URL url,DesiredCapabilities caps) {
		return new AndroidDriver<AndroidElement>(url, caps);
	}
	
	private String getAppPath(String appname) {
		File file = new File(System.getProperty("user.dir")+"/Apps/"+appname);
		return file.getAbsolutePath();
		
	}
	
	private DesiredCapabilities setDesiredCapabilities(String deviceName,String appName) {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		caps.setCapability(MobileCapabilityType.APP, getAppPath(appName));
		return caps;
	}
	
	public void initialization() {
		try {		
		driver = getDriver(new URL("http://127.0.0.1:4723/wd/hub"),setDesiredCapabilities("Nexus6P", "ApiDemos-debug.apk"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}catch(MalformedURLException e) {
		e.printStackTrace();
		
	}
	}
	

}
