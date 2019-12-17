package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CharitySignInPage 
{

	AbstractPage abs;
	
	@FindBy(xpath="//span[text()='Your account']")
	WebElement yourAccount;
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="next-btn")
	WebElement signInButton;
	
	public CharitySignInPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void typeUserName(String userName) {
		abs.type(usernameField, userName);
	}
	
	public boolean isMyCharityAccountPresent() {
		return abs.isWebElementPresent(yourAccount);
	}
	
	public void typePassword(String pass) {
		abs.type(passwordField, pass);
	}
	
	public void clickSignInButton() {
		abs.click(signInButton);
	}

  	public void validateCharityLoginCookiee(String val1, String val2)
  	{
  		boolean result=isMyCharityAccountPresent();
  		if(result) {
  			Assert.assertTrue(abs.isCookieeContainsVal(val1, val2));
  		}
	}
}


