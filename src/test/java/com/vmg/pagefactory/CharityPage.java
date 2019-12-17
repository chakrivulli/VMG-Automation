package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CharityPage 
{

	AbstractPage abs ;
	

	@FindBy(xpath="//img[contains(@src,'make-donation-btn')]")
	WebElement makeADonationButton;
	
	public CharityPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void clickMakeADonationButton() {
		abs.click(makeADonationButton);
	}
}


