package com.maven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EnterTimeTrackPage {
	
	@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
	private WebElement Settings;
	
	@FindBy(xpath="//a[text()='Licenses']")
	private WebElement Licenses;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement Logout;
	
	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement tasks;
	
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnSettings() {
		Settings.click();
	}
	
	public void ClickOnLicenses() {
		Licenses.click();
	}
	
	public void ClickOnLogOut() {
		Logout.click();
	}
	
	public void ClickOntasks() {
		tasks.click();
	}

}
