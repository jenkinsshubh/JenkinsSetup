package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initialization();
		contactsPage = new	ContactsPage(); 
		testutil = new TestUtil();
		loginPage = new LoginPage();
	homePage =	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
/*	@Test(priority=1)
	public void verifyHomePageTitle() {
	String title =	homePage.verifyHomePageTitle();
	Assert.assertEquals(title, "CRMPRO","Home Page title not matched");
	}*/
	
/*	@Test(priority=1)
	public void verifyUserNameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	} */
	
	@Test(priority=1)
	public void verifyContactsLinkTest() {
		testutil.switchToFrame();
		contactsPage =	homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
	//	driver.quit();
	}
	
}
