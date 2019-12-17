package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTeamPage 
{

	AbstractPage abs ;
	
	@FindBy(xpath="//a[@href='/fundraiser-portal/handleFundraisingAction/teamPage']")
	WebElement fundraiserAsATeamLink;
	
	@FindBy(id="teamName")
	WebElement teamNameField;
	
	@FindBy(id="userEmailAddress")
	WebElement teamMemberEmailSearchFeild;

	@FindBy(id="btnSearchTeamMember")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@id='userSearchResults']/descendant::a[@id='addToTeam'][1]")
	WebElement firstAddToTeamLinkOfSearchResults;
	
	@FindBy(id="createMyPage")
	WebElement nextButton;
	
	@FindBy(xpath="//div[@id='teamMemberList']/descendant::a[@class='removeVmgTeamMember link-left link-left_cancel small'][1]")
	WebElement firstRemoveTeamMemberLinkFromAddedTeamMembersList;
	
	@FindBy(id="addAnotherTeam")
	WebElement addAnotherTeamMemberButton;
	
	@FindBy(id="editTeamMember")
	WebElement doneButtonOnUpdateTeamPage;
	
	@FindBy(id="searchDescription")
	WebElement challengeSearchField;
	
	@FindBy(id="btn-eventSearch")
	WebElement challengeSearchButton;
	
	@FindBy(xpath="//div[@id='eventResults']/descendant::li[1]")
	WebElement firstChallengeFromSearchResults;
	
	@FindBy(id="charityContribution-yes")
	WebElement charityContributionYesRadio;
	
	@FindBy(id="btn-charitypercent-id")
	WebElement createMyPageButton;
	
	@FindBy(linkText="Send a personal thank you.")
	WebElement setEmailMessageTitle;
	
	@FindBy(xpath="//div[@id='editorEmailMessage']/div[1]")
	WebElement editorEmailMessageTextArea;
	
	@FindBy(id="saveEmailMessage")
	WebElement saveEmailMessageButton;
	
	@FindBy(id="editEmailMessage")
	WebElement editEmailMessageLink;
	
	public CreateTeamPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void enterTeamName(String teamName) {
		
		abs.type(teamNameField, teamName);
	}
	
	public void searchForMember(String emailId) {
		abs.type(teamMemberEmailSearchFeild, emailId);
	}
	
	public void clickSearchButton() {
		abs.click(searchButton);
	}
	
	public void addToTeam() {
		abs.click(firstAddToTeamLinkOfSearchResults);
	}
	
	public void clickNextButton() {
		abs.click(nextButton);
	}
	
	public void searchChallenge(String searchString) {
		abs.type(challengeSearchField, searchString);
	}
	public void clickSearchChallengeButton() {
		abs.click(challengeSearchButton);
	}
	
	public void selectFirstFromChallengeSerch() {
		abs.click(firstChallengeFromSearchResults);
	}
	
	public void clickCreateMyPage() {
		abs.click(createMyPageButton);
	}
	
	public void clickDoneButtonOnAddTeamMember() {
		abs.click(doneButtonOnUpdateTeamPage);
	}
	
	public void clickSetEmailMessageTitle() {
		abs.click(setEmailMessageTitle);
	}
	
	public boolean isEditorEmailMessageTextAreaClicable() {
		return abs.isWebElementClickable(editorEmailMessageTextArea);
	}
	
	public boolean isEmailMessageTextPresent() {
		return abs.isWebElementPresent(editorEmailMessageTextArea);
	}
	
	public void enterEmailMessageText(String text) {
		abs.type(editorEmailMessageTextArea, text);
	}
	
	public void clickSaveEmailMessageButton() {
		abs.click(saveEmailMessageButton);
	}
	
	public void clickEditEmailMessageLink() {
		abs.click(editEmailMessageLink);
	}
}

