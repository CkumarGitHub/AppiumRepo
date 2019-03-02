package com.qa.mobile.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class CustomizeLocatorByImageSrc extends By{
	private String ImageBySrc=null;
	
	public CustomizeLocatorByImageSrc(String ImageBySrc) {

		this.ImageBySrc=ImageBySrc;
	}

	@Override
	public List<WebElement> findElements(SearchContext context) {
		
		List<WebElement> mockElements = context.findElements(By.xpath("//img[@src='"+ImageBySrc+"']"));
		return mockElements;
	}
	
	

}
