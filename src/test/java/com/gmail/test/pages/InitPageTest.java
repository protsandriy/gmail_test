package com.gmail.test.pages;

import static org.testng.Assert.*;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.gmail.tests.BaseTest;

public class InitPageTest extends BaseTest {
	
	@Test
	public void testPageIsLoaded(){
		Reporter.log("testPageIsLoaded()");
		assertTrue(initPage.isElementPresent(initPage.imageLogo));
		assertTrue(initPage.isElementPresent(initPage.linkSignIn));
	}

}
