package com.vmg.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.CreateTeamPage;
import com.vmg.pagefactory.MyDashboardPage;

import cucumber.api.java.en.When;

public class CreateTeamPageSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	MyDashboardPage mdb;
	CreateTeamPage ctp;
	
	public CreateTeamPageSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		mdb = new MyDashboardPage(driver);
		ctp = new CreateTeamPage(driver);
		
	}
	
	@When("^User navigates to Fundraise as a team page$")
    public void navigateToInMemoryPage() throws Throwable {
        mdb.navigateToFundraiseAsATeam();
    }

	@When("^User enters team name$")
    public void entersTeamName() throws Throwable {
        ctp.enterTeamName("Team_"+abs.genarateString(5));
    }

	@When("^Searches for an email \"([^\"]*)\"$")
    public void searchesForEmail(String email) throws Throwable {
        ctp.searchForMember(email);
        ctp.clickSearchButton();
    }

	@When("^User adds the searched person to team$")
    public void addSearchedPersonToTeam() throws Throwable {
        ctp.addToTeam();
    }

	@When("^Clicks Next button$")
    public void clicks_next_button() throws Throwable {
        ctp.clickNextButton();
    }
	
	@When("^Searches for challenge \"([^\"]*)\"$")
    public void searches_for_challenge(String strArg1) throws Throwable {
        ctp.searchChallenge(strArg1);
        ctp.clickSearchChallengeButton();
        ctp.selectFirstFromChallengeSerch();
    }
	
	
}
