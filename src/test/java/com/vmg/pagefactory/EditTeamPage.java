package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditTeamPage 
{

	AbstractPage abs ;
	
	
	@FindBy(xpath="//div[@id='team_section']/descendant::img[@src='/giving/assets/img/icon_right-arrow.svg'][1]")
	WebElement firstTeamChallenge;
	
	@FindBy(id="updatePageTitle")
	WebElement editTeamTitleLink;
	
	@FindBy(id="pageTitle")
	WebElement teamTitleField;
	
	@FindBy(id="savePageTitle")
	WebElement saveTeamTitleButton;
	
	@FindBy(id="updateTeamPageUrl")
	WebElement linkToEditTeamLink;
	
	@FindBy(id="teamUrl")
	WebElement teamLinkField;
	
	@FindBy(id="saveTeamUrlUpdate")
	WebElement saveTeamLinkButton;
	
	@FindBy(id="editUserTarget")
	WebElement editTargetLink;
	
	@FindBy(id="updateRaisedOffline")
	WebElement updateRaisedOfflineLink;
	
	@FindBy(id="target")
	WebElement targetField;
	
	@FindBy(id="raisedOffline")
	WebElement raisedOfflineField;
	
	@FindBy(id="saveUserTarget")
	WebElement saveTargetButton;
	
	@FindBy(id="saveRaisedOffline")
	WebElement saveRaisedOfflineButon;
	
	@FindBy(id="editUserStory")
	WebElement updateTeamStroyLink;
	
	@FindBy(id="setUserStoryTitle")
	WebElement setUserStoryTitleLink;
	
	@FindBy(xpath="//div[@id='editorStory']/div[1]")
	WebElement editStoryTextArea;
	
	@FindBy(id="saveUserStory")
	WebElement saveStoryButton;
	
	@FindBy(id="changeCharityLink")
	WebElement editCharitiesLink;
	
	@FindBy(id="charityContribution-no")
	WebElement charityContributionNoRadio;
	
	@FindBy(id="btn-updateCharity")
	WebElement doneButtonOnUpdateCharity;
	
	@FindBy(xpath="//div[@id='fundraisers']/descendant::span[@class='glyph-right-wht'][1]")
	WebElement UpdateTeamMembersLink;
	
	@FindBy(xpath="//span[text()='Remove']")
	WebElement removeTeamMember;
	
	@FindBy(id="editTeamMember")
	WebElement doneButtonOnEditTeamMem;
	
	
	public EditTeamPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void clickFirstTeamChallenge() {
		abs.click(firstTeamChallenge);
	}
	
	public void clickEditTitle() {
		abs.click(editTeamTitleLink);
	}
	public void isEditTitleClickable() {
		abs.waitForElementClickable(editTeamTitleLink,abs.maxTimeOut);
	}
	public void updateTeamTitleText() {
		abs.updateText(teamTitleField, "1");
	}
	
	public void clickSaveOnUpdateTitle() {
		abs.click(saveTeamTitleButton);
	}
	
	
	
	public void clickEditTeamLink() {
		abs.click(linkToEditTeamLink);
	}
	public void isEditTeamLinkClickable() {
		abs.waitForElementClickable(linkToEditTeamLink,abs.maxTimeOut);
	}
	public void updateTeamTitleLink() {
		abs.updateText(teamLinkField, "1");
	}
	public void clickDoneButtonOnEditTeamLink() {
		abs.click(saveTeamLinkButton);
	}
	
	public boolean editTargetLink1Clickable() {
		return abs.isWebElementClickable(editTargetLink);
	}
	
	public void clickEditTargetLink() {
		abs.click(editTargetLink);
	}
	
	public void clickEditTarget2Link() {
		abs.click(updateRaisedOfflineLink);
	}
	
	public void isEditTargetLinkClickable() {
		abs.waitForElementClickable(editTargetLink,abs.maxTimeOut);
	}
	
	public void updateTargetAmount() {
		abs.updateText(targetField, "100");
	}
	
	public void updateTarget2Amount() {
		abs.updateText(raisedOfflineField, "1");
	}
	
	public void clickSaveTargetButton() {
		abs.click(saveTargetButton);
	}
	
	public void clickSaveTarget2Button() {
		abs.click(saveRaisedOfflineButon);
	}
	
	public void clickUpdateTeamStroyLink() {
		abs.click(updateTeamStroyLink);
	}
	public void isUpdateTeamStroyLinkClickable() {
		abs.waitForElementClickable(updateTeamStroyLink,abs.maxTimeOut);
	}
	public void updateTeamStory() {
		if(abs.isWebElementClickable(setUserStoryTitleLink)){
			abs.click(setUserStoryTitleLink);
		}else {
			if(abs.isWebElementClickable(updateTeamStroyLink)){
				abs.click(updateTeamStroyLink);
			}
			abs.click(editStoryTextArea);
		}
		abs.updateText(editStoryTextArea, "1");
		abs.click(saveStoryButton);
	}
	
	public void clickSaveStoryButton() {
		abs.click(saveStoryButton);
	}
	
	public void clickEditCharities() {
		
		abs.click(editCharitiesLink);
	}
	public void isEditCharitiesClickable() {
		abs.waitForElementClickable(editCharitiesLink,abs.maxTimeOut);
	}
	public void updateCharity() {
		abs.click(charityContributionNoRadio);
	}
	public void clickDoneButtonOnUpdateCharities() {
		abs.click(doneButtonOnUpdateCharity);
	}
	
	
	public void clickEditTeamMembers() {
		abs.click(UpdateTeamMembersLink);
	}
	public void isEditTeamMembersClikable() {
		abs.waitForElementClickable(UpdateTeamMembersLink,abs.maxTimeOut);
	}
	public boolean isRemoveTeamMemberPresent() {
		return abs.isWebElementPresent(removeTeamMember);
	}
	public void removeTeamMember() {
		abs.click(removeTeamMember);
	}
	
	public void clickDoneAfterRemovingTeamMem() {
		abs.click(doneButtonOnEditTeamMem);
	}
	
}

