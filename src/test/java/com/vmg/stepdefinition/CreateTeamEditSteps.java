package com.vmg.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.CreateTeamPage;
import com.vmg.pagefactory.EditTeamPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTeamEditSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	EditTeamPage etp;
	CreateTeamPage ctp;
	
	public CreateTeamEditSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		etp = new EditTeamPage(driver);
		ctp = new CreateTeamPage(driver);
	}

	@When("^User selects a team$")
	public void user_selects_a_team() throws Throwable {
	        etp.clickFirstTeamChallenge();
    }
	 
	@When("^User clicks on team to edit$")
    public void editTeamTeam() throws Throwable {
        etp.clickEditTitle();
    }

	@When("^Updates title of the team$")
    public void updateTeamTitle() throws Throwable {
        etp.updateTeamTitleText();
        etp.clickSaveOnUpdateTitle();
        etp.isEditTitleClickable();
    }
	
	

	@When("^User clicks on edit link and updates it$")
	public void updateTeamLink() throws Throwable {
	  etp.clickEditTeamLink();		
	  etp.updateTeamTitleLink();
	  etp.clickDoneButtonOnEditTeamLink();
	  etp.isEditTeamLinkClickable();
	 }

	 @When("^User clicks on edit Target and updates Target amount$")
	 public void updateTargetAmount() throws Throwable {
		 if(etp.editTargetLink1Clickable()) {
			 etp.clickEditTargetLink();
			 etp.updateTargetAmount();
			 etp.clickSaveTargetButton();
			 etp.isEditTargetLinkClickable();
		 }else {
			 etp.clickEditTarget2Link();
			 etp.updateTarget2Amount();
			 etp.clickSaveTarget2Button();
		 }
	 }

	 @When("^User updates Team story$")
	 public void updateTeamStory() throws Throwable {
        //etp.clickUpdateTeamStroyLink() ;
        etp.updateTeamStory();
        etp.clickSaveStoryButton();
        etp.isUpdateTeamStroyLinkClickable();
	 }

	 @When("^User edits and updates Charity$")
	 public void updateCharity() throws Throwable {
		etp.clickEditCharities() ;
        etp.updateCharity();
        etp.clickDoneButtonOnUpdateCharities();
        etp.isEditCharitiesClickable();
	 }

	@When("^User removes and adds a Team member$")
    public void removeATeamMember() throws Throwable {
		etp.isEditTeamMembersClikable();
		etp.clickEditTeamMembers();
		if(etp.isRemoveTeamMemberPresent()) {
			etp.removeTeamMember();
			etp.clickDoneAfterRemovingTeamMem();
			etp.isEditTeamMembersClikable();
		}else {
			ctp.searchForMember("ginaedkins@gmail.com");
		    ctp.clickSearchButton();
	        ctp.addToTeam();
	        ctp.clickDoneButtonOnAddTeamMember();
	        etp.isEditTeamMembersClikable();
		}
    }
	 
	@Then("^User adds a member to Team$")
    public void addsATeamMember() throws Throwable {
		etp.isEditTeamMembersClikable();
		etp.clickEditTeamMembers();
		ctp.searchForMember("ginaedkins@gmail.com");
	    ctp.clickSearchButton();
        ctp.addToTeam();
        ctp.clickDoneButtonOnAddTeamMember();
        etp.isEditTeamMembersClikable();
    }
	
	@When("^User sets personalised email message for donors$")
	public void user_sets_personalised_email_message_for_donors() throws Throwable {
	    ctp.clickSetEmailMessageTitle();
	    if(!ctp.isEmailMessageTextPresent()) {
	    	ctp.clickEditEmailMessageLink();
	    }
	    ctp.enterEmailMessageText("Thanking You Donor!");
	    ctp.clickSaveEmailMessageButton();
	}
}
