package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'shujoshi')]")
    WebElement userNameCheck;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;	
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;	
	
	@FindBy(xpath=" //a[@title='New Contact']")
	WebElement NewContactLink;
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
	return	driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOndealssLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOntaskssLink() {
		dealsLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName() {
	return	userNameCheck.isDisplayed();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		NewContactLink.click();
	}
}
