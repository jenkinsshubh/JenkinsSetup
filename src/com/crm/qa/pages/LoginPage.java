package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="username")
	WebElement UserName;
	

	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//div[@class='input-group-btn']")
	WebElement Login;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
public	LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
	return	crmLogo.isDisplayed();
		}
	public HomePage login(String un, String pwd) {
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		System.out.println("login mehtond executed");
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", Login);
	//	Login.click();
		return new HomePage();
	}
 }
