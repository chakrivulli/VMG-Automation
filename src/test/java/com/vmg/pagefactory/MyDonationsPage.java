package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDonationsPage 
{

	AbstractPage abs ;
	
	@FindBy(xpath="//h3[text()='My donation history']")
	WebElement myDonationHistoryHeading;
	
	@FindBy(xpath="//h3[text()='Total donations']")
	WebElement totalDonationsHeading;
	
	@FindBy(xpath="//h3[text()='Regular giving']")
	WebElement regularGivingHeading;
	
	@FindBy(xpath="//body/descendant::button[@id='showDonationDetails'][1]")
	WebElement firstViewDetailsButton;

	
	public MyDonationsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public boolean isMyDonationHistoryHeadingPresent() {
		return abs.isWebElementPresent(myDonationHistoryHeading);
	}
	
	
	public boolean isTotalDonationsHeadingPresent() {
		return abs.isWebElementPresent(totalDonationsHeading);
	}
	
	public boolean isRegularGivingHeadingPresent() {
		return abs.isWebElementPresent(regularGivingHeading);
	}
	
	public void clickViewDetails() {
		abs.click(firstViewDetailsButton);
	}
}

