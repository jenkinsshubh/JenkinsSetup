package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	String sheetName = "sheet1";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		contactsPage = new	ContactsPage(); 
		testutil = new TestUtil();
		loginPage = new LoginPage();
	homePage =	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testutil.switchToFrame();
	//contactsPage = homePage.clickOnContactsLink();
	}
	
	@DataProvider
	public Object[][] getTextData() throws IOException, EncryptedDocumentException, InvalidFormatException {
	Object data[][] =	TestUtil.getTestData(sheetName);
	System.out.println("data is: " + data);
	return data;
	}
	
	@Test(priority=1, dataProvider="getTextData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}


}
