package com.gmail.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.gmail.pages.Page;

public class LoginPage extends Page {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.CSS, using=".logo" )
	public WebElement imageLogo;
	
	@FindBy (how = How.CSS, using="#Email" )
	public WebElement inputEmail;
	
	@FindBy (how = How.CSS, using="#Passwd" )
	public WebElement inputPassword;
	
	@FindBy (how = How.CSS, using="#signIn" )
	public WebElement buttonSignIn;
	
	public GmailPage logingToGmail (String userName, String password){
		inputEmail.clear();
		inputEmail.sendKeys(userName);
		inputPassword.clear();
		inputPassword.sendKeys(password);
		buttonSignIn.click();
		Reporter.log("Logging to Gmail, username: "+userName+", password: "+password);
		return PageFactory.initElements(webDriver, GmailPage.class);
	}
	
	

}
