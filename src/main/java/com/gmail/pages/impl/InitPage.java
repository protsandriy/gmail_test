package com.gmail.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.gmail.pages.Page;

public class InitPage extends Page {

	public InitPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.CSS, using = "img[src *='//www.google.com/images/logos/']")
	public WebElement imageLogo;
	
	@FindBy (how = How.CSS, using = "#gmail-sign-in")
	public WebElement linkSignIn;
	
	public LoginPage clickLinkSignIn(){
		linkSignIn.click();
		Reporter.log("Clicking SingIn link");
		return PageFactory.initElements(webDriver, LoginPage.class);
	}

}
