
package com.vmg.pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowFundraiserActivitiesPage 
{

	AbstractPage abs ;
		
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Options'][1]")
	WebElement firstOptionUserTeamSecion;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Options'][last()]")
	WebElement lastOptionUserTeamSecion;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Share'][1]")
	WebElement firstShareUserTeamSecion;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[@class='social-facebook'][1]")
	WebElement facebookShareIcon;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::img[@alt='Share on Twitter. Link opens in a new window/tab'][1]")
	WebElement twitterShareIcon;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::img[@alt='Share on LinkedIn. Link opens in a new window/tab'][1]")
	WebElement linkedinShareIcon;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Link to In Memory page'][1]")
	WebElement linkToInMemoryPage;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Link to In Memory page'][last()]")
	WebElement linkToInMemoryPageLast;
	
	@FindBy(xpath="//body/descendant::h3[contains(@id,'userPageTitle_')][last()]")
	WebElement lastTeamChallengeTitle;
	
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Link to Campaign'][1]")
	WebElement linkToCampaign;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Add / Remove Team Members'][1]")
	WebElement editTeamMembers;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Edit Charities'][1]")
	WebElement editCharities;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='View Donation History'][1]")
	WebElement viewDonationHistory;
	
	@FindBy(xpath="//div[@id='team_section']/descendant::a[text()='Close page'][1]")
	WebElement closePage;
	
	@FindBy(id="_closePage")
	WebElement closePageButton;
	
	@FindBy(xpath="//h1[text()='Link to in memory page']")
	WebElement linkToInMemoryPageHeading;
	
	@FindBy(id="inMemPageNameSearchBtn")
	WebElement inMemoryPageSearchButton;
	
	@FindBy(xpath="//ul[@id='inMemPageResults']/descendant::img[@src='/giving/assets/img/icon_plus.svg'][1]")
	WebElement inMemPageResultsFirstPlusIcon;
	
	@FindBy(className="unlinkInMem accessibleLink")
	WebElement unlinkInMemLink;
	
	@FindBy(id="searchInMemPageTxt")
	WebElement inMemoryPageSearchField;
	
	@FindBy(xpath="//h1[text()='Link to Campaign']")
	WebElement linkToCampaignHeading;
	
	@FindBy(id="campaignNameSearchBtn")
	WebElement campaignSearchButton;
	
	@FindBy(id="searchCampaignTxt")
	WebElement campaignSearchFeild;
	

	
	@FindBy(xpath="//h1[contains(text(),'Update your team')]")
	WebElement updateTeamHeading;
	
	@FindBy(id="btnSearchTeamMember")
	WebElement searchTeamMemberButton;
	
	@FindBy(id="userEmailAddress")
	WebElement teamMemberEmailSearchFeild;

	@FindBy(xpath="//div[@id='userSearchResults']/descendant::a[@id='addToTeam'][1]")
	WebElement firstAddToTeamLinkOfSearchResults;
	
	@FindBy(xpath="//div[@id='teamMemberList']/descendant::a[@class='removeVmgTeamMember link-left link-left_cancel small'][1]")
	WebElement firstRemoveTeamMemberLinkFromAddedTeamMembersList;
	
	@FindBy(id="addAnotherTeam")
	WebElement addAnotherTeamMemberButton;
	
	@FindBy(id="editTeamMember")
	WebElement doneButtonOnUpdateTeamPage;
	
	
	@FindBy(xpath="//h1[text()='Choose your charity']")
	WebElement chooseYourCharityHeading;
	
	@FindBy(id="searchCharityDescription")
	WebElement searchCharityField;
	
	@FindBy(id="btn-charity-search")
	WebElement charitySearchButton;
	
	@FindBy(id="btn-updateCharity")
	WebElement doneCharityButton;
	
	
	@FindBy(id="addAnotherCharity")
	WebElement addAnotherCharityButton;
	
	@FindBy(xpath="//h1[text()='My donors']")
	WebElement myDonorsHeading;
	
	@FindBy(xpath="//button[@id='_closePage']")
	WebElement closeButton;
	
	@FindBy(xpath="//*[@id='myModalLabel'][text()='Close fundraising page']")
	WebElement closeDialogHeading;
	
	@FindBy(id="_cancelClosePage")
	WebElement cancleOnCloseDialog;
	
	@FindBy(xpath="//a[text()='Reopen page']")
	WebElement reOpenLink;
	
	@FindBy(id="_reactivatePage")
	WebElement reOpenPageButton;
	
	
	
	public ShowFundraiserActivitiesPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void clickFirstOptionUserTeamSecion() {
		abs.click(firstOptionUserTeamSecion);
	}
	
	public void clickLastOptionUserTeamSecion() {
		abs.click(lastOptionUserTeamSecion);
	}
	
	public void clickLinkToInMemoryPage() {
		abs.click(linkToInMemoryPage);
	}
	
	public void clickLinkToInMemoryPageLast() {
		abs.click(linkToInMemoryPageLast);
	}
	
	public String getTeamChallengeTitle() {
		return abs.getText(lastTeamChallengeTitle);
	}
	
	public void clickLinkToCampaign() {
		abs.click(linkToCampaign);
	}
	
	public void clickEditTeamMembers() {
		abs.click(editTeamMembers);
	}
	
	public void clickEditCharities() {
		abs.click(editCharities);
	}
	
	public void clickViewDonationHistory() {
		abs.click(viewDonationHistory);
	}
	
	public void clickClosePage() {
		abs.click(closePage);
	}
	public void isForClosePagePresent() {
		abs.isWebElementPresent(closePage);
	}
	
	public void clickClosePageButton() {
		abs.click(closeButton);
	}
	
	public boolean isReOpenPresent() {
			return abs.isWebElementPresent(reOpenLink);
	}
	
	public void clickReOpenLink() {
		abs.click(reOpenLink);
	}
	
	public void clickReOpenPageButton() {
		abs.click(reOpenPageButton);
	}
	
	public boolean isInMemoryPageHeadingPresent() {
		return abs.isWebElementPresent(linkToInMemoryPageHeading);
	}
	public boolean isInMemoryPageSearchButtonPresent() {
		return abs.isWebElementPresent(inMemoryPageSearchButton);
	}
	
	public void clickInMemoryPageSearchButton() {
		abs.click(inMemoryPageSearchButton);
	}
	
	public void clickFirstInMemorySearchResultsPlusIcon() {
		abs.click(inMemPageResultsFirstPlusIcon);
	}
	
	public boolean isUnLinkMemPagePresent() {
		return abs.isWebElementPresent(unlinkInMemLink);
	}
	
	public void clickUnLinkMemPage() {
		abs.click(unlinkInMemLink);
	}
	
	public boolean isInMemoryPageSearchFieldPresent() {
		return abs.isWebElementPresent(inMemoryPageSearchField);
	}
	
	public void searchToLinkInMemoryPage(String str) {
		abs.type(inMemoryPageSearchField, str);
		
	}
	
	public boolean isLinkToCampaignHeadingPresent() {
		return abs.isWebElementPresent(linkToCampaignHeading);
	}
	public boolean isCampaignSearchButtonPresent() {
		return abs.isWebElementPresent(campaignSearchButton);
	}
	public boolean isCampaignSearchFeildPresent() {
		return abs.isWebElementPresent(campaignSearchFeild);
	}
	
	
	public boolean isUpdateTeamHeadingPresent() {
		return abs.isWebElementPresent(updateTeamHeading);
	}
	public boolean isSearchTeamMemberButtonPresent() {
		return abs.isWebElementPresent(searchTeamMemberButton);
	}
	public boolean isTeamMemberEmailSearchFeildPresent() {
		return abs.isWebElementPresent(teamMemberEmailSearchFeild);
	}
	public boolean isDoneButtonOnUpdateTeamPage() {
		return abs.isWebElementPresent(doneButtonOnUpdateTeamPage);
	}
	public boolean isAddAnotherTeamMemberButton() {
		return abs.isWebElementPresent(addAnotherTeamMemberButton);
	}
	
	
	public boolean isChooseYourCharityHeading() {
		return abs.isWebElementPresent(chooseYourCharityHeading);
	}
	
	public boolean isSearchCharityField() {
		return abs.isWebElementPresent(searchCharityField);
	}
	
	public boolean isCharitySearchButton() {
		return abs.isWebElementPresent(charitySearchButton);
	}
	
	public boolean isMyDonorsHeadingPresent() {
		return abs.isWebElementPresent(myDonorsHeading);
	}
	
	public boolean isCloseButtonPresent() {
		return abs.isWebElementPresent(closeButton);
	}
	
	
	public boolean isCloseDialogHeadingPresent() {
		return abs.isWebElementPresent(closeDialogHeading);
	}
	
	public boolean isCancleOnCloseDialogPresent() {
		return abs.isWebElementPresent(cancleOnCloseDialog);
	}
	
	public void clickFirstShareUserTeamSecion() {
		abs.click(firstShareUserTeamSecion);
	}
	public boolean isFacebookSharePresent() {
		return abs.isWebElementPresent(facebookShareIcon);
	}
	
	public boolean isTwitterSharePresent() {
		return abs.isWebElementPresent(twitterShareIcon);
	}
	
	public boolean isLinkedInSharePresent() {
		return abs.isWebElementPresent(linkedinShareIcon);
	}
	
	public void clickFacebookShare() {
		abs.click(facebookShareIcon);
	}
}

