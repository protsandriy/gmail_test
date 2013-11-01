package com.gmail.test.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmail.pages.impl.GmailPage;
import com.gmail.pages.impl.LoginPage;
import com.gmail.tests.BaseTest;
import com.gmail.util.PropertyLoader;

public class GmailPageTest extends BaseTest {
	protected GmailPage gmailPage;
	protected String userName;
	protected String password;
	protected String address;
	protected String subject;
	protected String text;
	
	
	@BeforeClass
	public void setGmailPage(){
		userName = PropertyLoader.loadProperty("user.username");
		password = PropertyLoader.loadProperty("user.password");
		address = PropertyLoader.loadProperty("mail.to");
		subject = PropertyLoader.loadProperty("mail.subject");
		text = PropertyLoader.loadProperty("mail.text");
		LoginPage loginPage = initPage.clickLinkSignIn();
		gmailPage = loginPage.logingToGmail(userName, password);
	}
	
	@Test
	public void testGmailPageIsLoaded(){
		assertTrue(gmailPage.isElementPresent(gmailPage.buttonCompose));
		assertTrue(gmailPage.isElementPresent(gmailPage.imageLogo));
	}
	
	@Test(dependsOnMethods={"testGmailPageIsLoaded"})
	public void testNewMailForm(){
		gmailPage.clickComposeButton();
		assertTrue(gmailPage.isElementPresent(gmailPage.newMessageBox));
		assertTrue(gmailPage.isElementPresent(gmailPage.textAreaTo));
		assertTrue(gmailPage.isElementPresent(gmailPage.inputSubject));
		assertTrue(gmailPage.isElementPresent(gmailPage.frameText));
		assertTrue(gmailPage.isElementPresent(gmailPage.buttonSend));
	}
	
	@Test(dependsOnMethods={"testGmailPageIsLoaded"})
	public void testSendingMail(){
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertFalse(gmailPage.isElementPresent(gmailPage.mailSendText));
		gmailPage.writeLetter(address, subject, text);
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			Reporter.log(e.getMessage());
		}
		assertTrue(gmailPage.isElementPresent(gmailPage.mailSendText));
		assertFalse(gmailPage.isElementPresent(gmailPage.newMessageBox));
		assertFalse(gmailPage.isElementPresent(gmailPage.textAreaTo));
		assertFalse(gmailPage.isElementPresent(gmailPage.inputSubject));
		assertFalse(gmailPage.isElementPresent(gmailPage.frameText));
		assertFalse(gmailPage.isElementPresent(gmailPage.buttonSend));
		assertFalse(gmailPage.isElementPresent(gmailPage.mailSendText));
		webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}

}
