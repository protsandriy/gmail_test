package com.gmail.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.gmail.pages.Page;

public class GmailPage extends Page {

	public GmailPage(WebDriver webDriver) {
		super(webDriver);
	}
	

	@FindBy (how = How.CSS, using = ".gb_ia")
	public WebElement imageLogo;
	
	@FindBy (how = How.XPATH, using = "//div[contains(text(),'COMPOSE')]")
	public WebElement buttonCompose;
	

	@FindBy (how = How.CSS, using = ".aYF")
	public WebElement newMessageBox;
	
	@FindBy (how = How.XPATH, using = "//textarea[@aria-label='Address' and @name='to']")
	public WebElement textAreaTo;
	
	@FindBy (how = How.XPATH, using = "//input[contains(@placeholder,'Subject')]")
	public WebElement inputSubject;
	
	@FindBy (how = How.XPATH, using = "//div[contains(text(),'Send')]")
	public WebElement buttonSend;
	
	@FindBy (how = How.XPATH, using = "//div[attribute::class='Am Al editable']/child::iframe")
	public WebElement frameText;
	
	@FindBy (how = How.XPATH, using = "//div[contains(text(),'Your message has been sent.')]")
	public WebElement mailSendText;
	
	public void writeLetter(String address, String subject, String text ){
		textAreaTo.sendKeys(address);
		inputSubject.sendKeys(subject);
		frameText.sendKeys(text);
		buttonSend.click();
	}
	
	public void clickComposeButton(){
		buttonCompose.click();
	}

}
