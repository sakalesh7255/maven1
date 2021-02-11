package com.maven.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement AddNew;
	
	@FindBy(xpath="//div[@class='item createNewCustomer ellipsis']")
	private WebElement plusNewCustomer;
	
	@FindBy(xpath="//div[@class='item createNewProject ellipsis']")
	private WebElement PlusNewProject;
	
	@FindBy(id="customerLightBox_nameField")
	private WebElement Customername;
	
	@FindBy(id="customerLightBox_commitBtn")
	private WebElement PluscreateCustomer;
	
	@FindBy(xpath="//div[contains(@class,'node customerNode')]")
	private List<WebElement> AllCustomername;
	
	@FindBy(xpath = "//div[@class='editButton available']")
	private WebElement editButton;
	
	@FindBy(xpath="(//div[@class='actionButton'])[1]/../../../div[4]/div/div/div[2]")
	private WebElement ActionButton;
	
	@FindBy(xpath="(//div[text()='Delete'])[1]")
	private WebElement DeleteButton;
	
	@FindBy(id="customerPanel_deleteConfirm_submitTitle")
	private WebElement Deletepermentally;	
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void ClickOnAddNew() {
		AddNew.click();
	}
	public void ClickOnNewCustomer() {
		plusNewCustomer.click();
	}
	public void SetNewCustomerName(String name) {
		Customername.sendKeys(name);
	}
	public void ClickOnPlusCreateCustomer() {
		PluscreateCustomer.click();	
	}
	public void listOfCustomer() {
		int count = AllCustomername.size();
		System.out.println(count);
		for (WebElement Cn : AllCustomername) {
			String s = Cn.getText();
			System.out.println(s);
		/*	if (s.equals("Bsp")) {
				System.out.println("Customer Created succefully");
			}
			*/
		}
	}
	public void DeleteCustomer(WebDriver driver, String name) throws InterruptedException {
		int count = AllCustomername.size();
		System.out.println(count);
		for (WebElement Ele : AllCustomername) {
			String s = Ele.getText();
			System.out.println(s);
			if (s.equals(name)) {
				editButton.click();
				Actions act = new Actions(driver);
				act.moveToElement(ActionButton).click().build().perform();
			//	ActionButton.click();
				Thread.sleep(1000);
				DeleteButton.click();
				Deletepermentally.click();			
			}
		}
	}
}
