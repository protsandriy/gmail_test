package com.gmail.test.pages;

import static org.testng.Assert.*;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmail.pages.impl.LoginPage;
import com.gmail.tests.BaseTest;

public class LoginPageTest extends BaseTest {
	
	protected LoginPage loginPage;
	
	@BeforeClass
	public void setLoginPage() {
		loginPage = initPage.clickLinkSignIn();	
	}
	
	@Test
	public void testLoginPageIsLoaded(){
		Reporter.log("LoginPageIsLoaded()");
		assertTrue(loginPage.isElementPresent(loginPage.buttonSignIn));
		assertTrue(loginPage.isElementPresent(loginPage.imageLogo));
		assertTrue(loginPage.isElementPresent(loginPage.inputEmail));
		assertTrue(loginPage.isElementPresent(loginPage.inputPassword));
	}

}
