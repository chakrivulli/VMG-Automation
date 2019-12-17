package com.vmg.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CharityHomePage 
{

	AbstractPage abs;
	

	@FindBy(xpath="//a[@href='/charity-web/j_spring_security_logout']")
	WebElement signOutButton;
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="next-btn")
	WebElement signInButton;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	WebElement campaignLink;
	
	@FindBy(xpath="//a[@href='createCampaignDisplay.action']")
	WebElement createACampaignLink;
	
	@FindBy(xpath="//body/descendant::input[@alt='Create campaign'][1]")
	WebElement createCampaignButton;
	
	@FindBy(xpath="//input[@id='campaignName']")
	WebElement campaignNameField;
	
	@FindBy(xpath="//input[@id='campaignUrl']")
	WebElement campaignUrlField;
	
	@FindBy(xpath="//input[@alt='Next']")
	WebElement nextButton;
	
	@FindBy(id="tinymce")
	WebElement aboutCampaignTexArea;
	
	@FindBy(name="fundraisingTarget")
	WebElement fundraisingTargetField;
	
	@FindBy(id="appealDetails1_showRunningTotalIndN")
	WebElement displayTotalAmountNoRadio;
	
	
	@FindBy(id="giftAidIndN")
	WebElement collectGiftAidNoRadio;
	
	@FindBy(id="giftAidIndY")
	WebElement collectGiftAidYesRadio;
	
	@FindBy(id="allowDirectDonationsIndY")
	WebElement allowDirectDonationsYesRadio;
	
	@FindBy(id="allowDirectDonationsIndN")
	WebElement allowDirectDonationsIndNoRadio;
	
	@FindBy(id="appealDetails1_donorMessageIndY")
	WebElement showDonorMessageYesRadio;
	
	@FindBy(id="appealDetails1_donorMessageIndN")
	WebElement showDonorMessageNoRadio;
	
	@FindBy(id="customiseDonationAmountsIndY")
	WebElement customiseDonationAmountsYesRadio;
	
	@FindBy(id="customiseDonationAmountsIndN")
	WebElement customiseDonationAmountsIndNoRadio;
	
	@FindBy(id="appealDetails1_allowOtherAmountIndY")
	WebElement allowOtherAmountIndYesRadio;
	
	@FindBy(id="appealDetails1_allowOtherAmountIndN")
	WebElement allowOtherAmountIndNoRadio;
	
	@FindBy(id="additionalDonorInfoIndY")
	WebElement additionalDonorInfoYesRadio;
	
	@FindBy(id="additionalDonorInfoIndN")
	WebElement additionalDonorInfoNoRadio;
	
	@FindBy(id="allowFundraisingIndY")
	WebElement allowFundraisingYesRadio;
	
	@FindBy(id="allowFundraisingIndN")
	WebElement allowFundraisingNoRadio;
	
	@FindBy(id="appealDetails1_displayFundraiserInfoIndY")
	WebElement displayFundraiserInfoYesRadio;
	
	@FindBy(id="appealDetails1_displayFundraiserInfoIndN")
	WebElement displayFundraiserInfoNoRadio;
	
	@FindBy(xpath="//input[@alt='Publish campaign']")
	WebElement publishCampaignButton;
	
	
	public CharityHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void isSignOutPresent() {
		abs.isWebElementPresent(signInButton);
	}
	
	public void clickCampaignLink() {
		abs.click(campaignLink);
	}
	
	public void clickCreateCampaignButton() {
		abs.click(createCampaignButton);
	}
	public void clickCreatACampaignLink() {
		abs.click(createACampaignLink);
	}
	public void typeCampaignName(String campaignName) {
		abs.click(campaignNameField);
		abs.type(campaignNameField, campaignName);
	}
	
	public void typeCampaignUrl(String campaignUrl) {
		abs.type(campaignUrlField, campaignUrl);
	}
	
	public void clickNextButton() {
		abs.click(nextButton);
	}
	
	
	public void typeCampaignDesc() {
		abs.switchToFrame(By.id("step2-description_ifr"));
		abs.click(aboutCampaignTexArea);
		abs.updateText(aboutCampaignTexArea, abs.genarateString(5));
		abs.driver.switchTo().defaultContent();
	}
	
	
	public void selectDisplayTotalAmountNo() {
		abs.click(displayTotalAmountNoRadio);
	}
	
	public void typeFundrisingTargetAmount(String amount) {
		abs.type(fundraisingTargetField, amount);
	}
	
	
	public void collectGiftAidRadio(String arg) {
		if(arg.equalsIgnoreCase("yes")) {
			abs.click(collectGiftAidYesRadio);
		}else {
			abs.click(collectGiftAidNoRadio);
		}
	}
	
	public void allowDirectDonationsRadio(String arg) {
		if(arg.equalsIgnoreCase("yes")) {
			abs.click(allowDirectDonationsYesRadio);
		}else {
			abs.click(allowDirectDonationsIndNoRadio);
		}
	}
	
	public void selectNoToOtherRadios() {
		abs.click(showDonorMessageYesRadio);
		
		abs.click(customiseDonationAmountsIndNoRadio);
		
		abs.click(allowOtherAmountIndNoRadio);
		
		abs.click(additionalDonorInfoNoRadio);
		
		abs.click(allowFundraisingNoRadio);
		
		abs.click(displayFundraiserInfoNoRadio);
	}
	
	public void publishCampaign() {
		abs.waitForElementClickable(publishCampaignButton,Long.valueOf(60));
		abs.click(publishCampaignButton);
	}
}


