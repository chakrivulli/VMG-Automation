package com.vmg.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundraiserPage 
{

	AbstractPage abs ;
	

	@FindBy(id="donate-link")
	WebElement donateButton;
	
	@FindBy(id="userPageURL")
	WebElement userPageURL;
	
	@FindBy(xpath="//h3[text()='Supporters']/../div/div/p")
	WebElement supporterNameFirst;
	
	@FindBy(xpath="//h3[text()='Supporters']/../div/div[2]/p/span")
	WebElement supporterDonationAmount;
	
	@FindBy(xpath="//h3[text()='My challenge']")
	WebElement myChallengeHeading;
	
	@FindBy(xpath="//h3[text()='Someone special']")
	WebElement someonespecialHeading;
	
	@FindBy(xpath="//h3[text()='Team challenge']")
	WebElement teamChallengeHeading;
	
	@FindBy(id="loadMoreActivity")
	WebElement loadMoreMyChallengeBtn;
	
	@FindBy(id="loadMoreSSActivity")
	WebElement loadMoreSomeoneSpecialBtn;
	
	@FindBy(id="loadMoreTeamActivity")
	WebElement loadMoreTeamBtn;
	
	public FundraiserPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void clickDonateButton() {
		abs.click(donateButton);
	}
	
	public void selectFundraiser(String title) {
		abs.waitForElementClickable(By.xpath("//a[contains(@href,'fundraiserPage?')]/descendant::h3[text()='"+title+"']"),
				abs.maxTimeOut);
		abs.click(By.xpath("//a[contains(@href,'fundraiserPage?')]/descendant::h3[text()='"+title+"']"));
	}
	
	public boolean isUserPageUrlPresent() {
		return abs.isWebElementPresent(userPageURL);
	}
	
	public String getSupporterNameFirst() {
		return abs.getText(supporterNameFirst);
	}
	
	public String getSupporterDonationAmount() {
		return abs.getText(supporterDonationAmount);
	}
	
	public boolean isMyChallengeHeadingPresent() {
		return abs.isWebElementPresent(myChallengeHeading);
	}
	
	public boolean isSomeonespecialHeadingPresent() {
		return abs.isWebElementPresent(someonespecialHeading);
	}
	
	public boolean isTeamChallengeHeadingPresent() {
		return abs.isWebElementPresent(teamChallengeHeading);
	}
	
	
	
	public boolean isLoadMoreMyChallengeBtnPresent() {
		return abs.isWebElementPresent(loadMoreMyChallengeBtn);
	}
	
	public boolean isLoadMoreSomeoneSpecialBtnPresent() {
		return abs.isWebElementPresent(loadMoreSomeoneSpecialBtn);
	}
	
	public boolean isLoadMoreTeamBtnPresent() {
		return abs.isWebElementPresent(loadMoreTeamBtn);
	}
}


