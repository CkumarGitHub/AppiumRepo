package saucelabs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabTest {
	private static WebDriver driver;

	public static void main(String[] args) {
		
		String sauceUserName = "ChandanKumar";
        String sauceAccessKey = "150e5b90-2061-4adf-baf3-c8057b5d7f2f";
        
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("username", sauceUserName);
		caps.setCapability("accessKey", sauceAccessKey);
		caps.setCapability("browserName", "chrome");
		caps.setCapability("version", "72.0");
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("name", "SauceLabtest");
		
		try {
			driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("https://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("Sapna");
		driver.findElement(By.name("btnK")).click();
		driver.quit();
	}

}
