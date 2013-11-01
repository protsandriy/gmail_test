package com.gmail.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.gmail.pages.impl.InitPage;
import com.gmail.util.PropertyLoader;
import com.gmail.webdriver.WebDriverFactory;

public class BaseTest {

	protected WebDriver webDriver;
	protected String testUrl;
	protected InitPage initPage;

	@Parameters({ "browserName" })
	@BeforeTest
	public void setUp(String browserName) {
		webDriver = WebDriverFactory.getWebDriver(browserName);
		testUrl = PropertyLoader.loadProperty("test.url");
		webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Reporter.log("Opening " + testUrl + " web page");
		webDriver.manage().deleteAllCookies();
		webDriver.get(testUrl);
		initPage = PageFactory.initElements(webDriver, InitPage.class);
	}

	@AfterTest
	public void tearDown() {
		Reporter.log("Closing the browser");
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}
