package com.vmg.pagefactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{

	AbstractPage abs ;
	
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Make a donation']")
	WebElement makeADonationLink;
	
	@FindBy(xpath="//*[@id='btn-dismiss-cookies']")
	WebElement dismissCookiesButton;
	
	@FindBy(xpath="//span[text()='Account settings']")
	WebElement accountSettingsLink;
	
	//span[text()='Account settings']
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public boolean isMyAccountPresent() {
		return abs.isWebElementPresent(myAccount);
	}
	
	public void clickMakeADonationLink() {
		abs.click(makeADonationLink);
	}
	
	public void clickDismissCookies() {
		abs.click(dismissCookiesButton);
	}
	
	public void validateLoginCookiee(String val1, String val2)
	{
		boolean result=isMyAccountPresent();
		String actualResult="";
		if(result) {
			actualResult="Success";
			Assert.assertTrue(abs.isCookieeContainsVal(val1, val2));
		}else {
			actualResult="Failure";
			}
		/*System.out.println("Expected result is "+expectedResult);
		System.out.println("Got actual result as "+actualResult);*/
		
		/*if(!expectedResult.equals(actualResult))
		{
	       //reportFailure("Scenario Failure");
			Assert.assertTrue(false);
			
		}*/	
	}
	public void clickMyAccount() {
		abs.click(myAccount);
	}
	public void clickAccountSettingsLink() {
		abs.click(accountSettingsLink);
	}

}


