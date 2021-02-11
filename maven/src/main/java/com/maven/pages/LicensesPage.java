package com.maven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicensesPage {
	@FindBy(xpath="//nobr[text()='Product Edition:']/../../td[2]")
	private WebElement ProductEdition;
	
	@FindBy(xpath="//nobr[text()='Issue Date:']/../../td[2]")
	private WebElement IssuDate;
	
	public LicensesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProductEdition(String expectedproductedistion) {
	//	String expectedproductedistion = "actiTIME 2017.4";
		String actualproductedtion = ProductEdition.getText();
		if (actualproductedtion.equals(expectedproductedistion)) {
			System.out.println("The Expected product Edition is dispalyed: " + expectedproductedistion);
			System.out.println("TestCase is Passed");
		}
		else {
			System.out.println("The Expected product edition is not displayed: " + actualproductedtion);
		}
	}
	
	public void verifyIssudate(String expectedIssudate) {
	//	String expectedIssudate = "Jul 14, 2017";
		String actualissudate = IssuDate.getText();
		if (actualissudate.equals(expectedIssudate)) {
			System.out.println("Expected issue date is displayed: " + expectedIssudate);
			System.out.println("Test Case is Passed");
		}
		else {
			System.out.println("Expected Issue Date is not displayed:" + actualissudate);
			System.out.println("TestCase is failed");
		}
	}
}
