package com.gmail.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

public class WebDriverFactory {

	public static WebDriver getWebDriver(String browser) {

		WebDriver webDriver = null;
		switch (browser) {
		case "firefox":
			webDriver = new FirefoxDriver();
			break;
		case "ie":
			webDriver = new InternetExplorerDriver();
			break;
		case "chrome":
			webDriver = new ChromeDriver();
		case "opera":
			webDriver = new OperaDriver();

		default:
			webDriver = new FirefoxDriver();
			break;
		}
		return webDriver;
	}
}
