package com.maven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage implements com.manevn.generics.AutoConstant{
	
	@FindBy(id="username")
	private WebElement Username;
	
	@FindBy(name="pwd")
	private WebElement Password;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement CheckBox;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//span[contains(text(),'invalid.')]")
	private WebElement ErrorMessage;
	
	@FindBy(xpath="//a[text()='actiTIME Inc.']")
	private WebElement actiTimeInc;
	
	@FindBy(xpath="//a[text()='View License']")
	private WebElement ViewLicense;

	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SetUsername(String un) {
		Username.sendKeys(un);
	}
	
	public void SetPassword(String pw) {
		Password.sendKeys(pw);
	}
	
	public void ClickOnKeepMeLoggedButton() {
		CheckBox.click();
	}
	
	public void ClickOnLogInButton() {
		LoginButton.click();
	}
	
	public void ClickOnViewLicense() {
		ViewLicense.click();
	}
	
	public void ClickOnactiTimeLink() {
		actiTimeInc.click();
	}
	
	public void VerifyErrorMessgae(WebDriver driver) {
	//	PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ErrorMessage));
		if (ErrorMessage.isDisplayed()) {
			System.out.println("Error Message is dispalyed :" + ErrorMessage.getText());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
