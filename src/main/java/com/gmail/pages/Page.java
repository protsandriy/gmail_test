package com.gmail.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

	protected WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

	public boolean isElementPresent(WebElement webElement) {
		try {
			return webElement.isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
