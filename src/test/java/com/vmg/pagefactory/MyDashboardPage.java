package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage 
{

	AbstractPage abs ;
	
	@FindBy(xpath="//a[@href='#fundraiser-pages']")
	WebElement fundraiserLink;
	
	@FindBy(xpath="//a[@href='#menu--signin']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[@href='#charities-pages']")
	WebElement charitiesPages;
	
	@FindBy(xpath="//span[text()='Charity Sign in']")
	WebElement charitySignInLink;

	@FindBy(xpath="//a[@href='/fundraiser-portal/handleFundraisingAction/inMemPage']")
	WebElement raiseFundInMemoryLink;
	
	@FindBy(xpath="//a[@href='/fundraiser-portal/showFundraiserActivities']")
	WebElement myFundraisingLink;
	
	@FindBy(xpath="//a[@href='/fundraiser-portal/myDonations']")
	WebElement myDonationsLink;
	
	@FindBy(xpath="//a[@href='/fundraiser-portal/handleFundraisingAction/teamPage']")
	WebElement fundraiseAsATeam;
	
	@FindBy(linkText="Account settings")
	WebElement accountSettings;
	
	@FindBy(xpath="//h1[text()='Account settings']")
	WebElement accountSettingsHeading;
	
	@FindBy(linkText="Create a page")
	WebElement CreateAPageLink;
	
	public MyDashboardPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void navigateToFundraiseAsATeam() {
		abs.click(fundraiserLink);
		abs.click(fundraiseAsATeam);
	}
	
	
	public void navigateToRaiseFundInMem() {
		abs.click(fundraiserLink);
		abs.click(raiseFundInMemoryLink);
	}
	
	public boolean isMyAccountPresent() {
		return abs.isWebElementPresent(myAccount);
	}
	
	public void clickMyAccount() {
		abs.click(myAccount);
	}
	
	public void navigateToMyFundraising() {
		clickMyAccount();
		abs.click(myFundraisingLink);
		//abs.navigateToURL("/fundraiser-portal/showFundraiserActivities");
	}
	
	public void navigateToMyDonations() {
		clickMyAccount();
		abs.click(myDonationsLink);
	}
	
	public void navigateToCharitySignIn() {
		abs.click(charitiesPages);
		abs.click(charitySignInLink);
	}
	
	public void navigateToAccountSetting() {
		abs.click(myAccount);
		abs.click(accountSettings);
		abs.waitForElementPresent(accountSettingsHeading, abs.maxTimeOut.intValue());
	}
	
	public void navigateToCreateAPage() {
		abs.click(fundraiserLink);
		abs.click(CreateAPageLink);
	}
}

