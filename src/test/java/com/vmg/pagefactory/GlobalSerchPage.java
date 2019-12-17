
package com.vmg.pagefactory;
import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalSerchPage 
{

	AbstractPage abs ;
		
	@FindBy(xpath="//ul[@id='fundraiserResults']/li[contains(@id,'fundraiser_')]")
	List<WebElement> fundraiserResults;
	
	@FindBy(id="loadMoreFundraisers")
	WebElement loadMoreUnderFundraiserButton;
	
	@FindBy(xpath="//ul[@id='fundraiserResults']/li[contains(@id,'fundraiser_')][1]/descendant::a[contains(@href,'handleDonationAction?')]")
	WebElement donateButtonForFundraiser;
	
	
	@FindBy(xpath="//ul[@id='charityResults']/li[contains(@id,'charity_')]")
	List<WebElement> charityResults;
	
	@FindBy(id="loadMoreCharities")
	WebElement loadMoreUnderCharityButton;
	
	@FindBy(xpath="//ul[@id='charityResults']/li[contains(@id,'charity_')][1]/descendant::a[contains(@href,'handleDonationAction?')]")
	WebElement donateButtonForCharity;
	
	
	@FindBy(xpath="//ul[@id='eventResults']/li[contains(@id,'event_')]")
	List<WebElement> eventResults;
	
	@FindBy(id="loadMoreEvents")
	WebElement loadMoreEventsButton;
	
	@FindBy(xpath="//ul[@id='eventResults']/li[contains(@id,'event_')][1]/descendant::a[contains(@href,'startFundraising?')]")
	WebElement startFundraisingButtonforEvents;
	
	
	@FindBy(xpath="//ul[@id='campaignResults']/li[contains(@id,'campaign_')]")
	List<WebElement> campaignsResults;
		
	@FindBy(xpath="//ul[@id='campaignResults']/li[contains(@id,'campaign_')][1]/descendant::a[contains(@href,'handleDonationAction?')]")
	WebElement donateButtonForCampaigns;
	
	@FindBy(id="loadMoreCampaign")
	WebElement loadMoreCampaignButton;
	
	@FindBy(xpath="//ul[@id='charityResults']/li[contains(@id,'charity_')]/descendant::img")
	List<WebElement> campaignResultsLogo;
	
	@FindBy(xpath="//ul[@id='charityResults']/li[contains(@id,'charity_')]/descendant::h4")
	List<WebElement> charityResultsHeading;
	
	@FindBy(xpath="//ul[@id='charityResults']/li[contains(@id,'charity_')]/descendant::a[contains(@href,'handleDonationAction?')]")
	List<WebElement> charityResultsDonateBtn;
	
	@FindBy(xpath="//ul[@id='charityResults']/li[contains(@id,'charity_')]/descendant::a[contains(@href,'startFundraising?')]")
	List<WebElement> charityResultsStartFundraisingLink;
	
	public GlobalSerchPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public int countFundraiserResults() {
		return fundraiserResults.size();
	}
	
	public int countCampaignResults() {
		return campaignsResults.size();
	}
	
	public boolean isLoadMoreButtonUnderFundraiserPresent() {
		return abs.isWebElementPresent(loadMoreUnderFundraiserButton);
	}
	
	public boolean isLoadMoreButtonUnderCampaignPresent() {
		return abs.isWebElementPresent(loadMoreCampaignButton);
	}
	
	public boolean isDonateButtonForFundraiserPresent() {
		return abs.isWebElementPresent(donateButtonForFundraiser);
	}
	
	public boolean isDonateButtonForCampaignPresent() {
		return abs.isWebElementPresent(donateButtonForCampaigns);
	}
	
	
	public int countCharityResults() {
		return charityResults.size();
	}
	
	public boolean isLoadMoreButtonUnderCharityPresent() {
		return abs.isWebElementPresent(loadMoreUnderCharityButton);
	}
	
	public boolean isDonateButtonForCharityPresent() {
		return abs.isWebElementPresent(donateButtonForCharity);
	}
	
	
	public int countEventResults() {
		return eventResults.size();
	}
	
	public boolean isLoadMoreButtonEventsPresent() {
		return abs.isWebElementPresent(loadMoreEventsButton);
	}
	
	public boolean isStartFundraisingButtonforEventsPresent() {
		return abs.isWebElementPresent(startFundraisingButtonforEvents);
	}
	
	public void verifyCampaignSearchResultsAttributes() {
		for(WebElement name:campaignsResults) {
			assertNotNull(name);
		}
		for(WebElement heading:charityResultsHeading) {
			assertTrue(abs.isWebElementClickable(heading));
		}
		for(WebElement donateBtn:charityResultsDonateBtn) {
			assertTrue(abs.isWebElementClickable(donateBtn));
		}
		for(WebElement startFundraisingLink:charityResultsStartFundraisingLink) {
			assertTrue(abs.isWebElementClickable(startFundraisingLink));
		}
		
		for(WebElement logo:campaignResultsLogo) {
			assertNotNull(logo);
		}
	}
}

