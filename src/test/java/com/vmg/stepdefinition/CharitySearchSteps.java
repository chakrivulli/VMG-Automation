package com.vmg.stepdefinition;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.CharitySearchPage;
import com.vmg.pagefactory.EventSearchPage;
import com.vmg.pagefactory.FacebookLoginPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.ShowFundraiserActivitiesPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CharitySearchSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	MyDashboardPage mdp;
	EventSearchPage esp;
	CharitySearchPage csp;

	public CharitySearchSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		mdp = new MyDashboardPage(driver);
		esp = new EventSearchPage(driver);
		csp = new CharitySearchPage(driver);
	}
	
	@Then("^User is displayed text \"([^\"]*)\" on top of search$")
	public void verifyTextDisplayedOnSearchPage(String arg1) throws Throwable {
	   assertTrue( csp.getCharityHeading().equalsIgnoreCase(arg1));
	}

	@Then("^User is displayed link Invite them to register with us$")
	public void verifyInviteDisplayed() throws Throwable {
		csp.isInviteToRegisterLinkPresent();
	}
	
	@Then("^User selects first five charities from search results$")
	public void selectCharitiesFromSearchResults() throws Throwable {
		csp.addCharities(5);
	}
	
	@Then("^User is displayed load more button$")
	public void verifyLoadMoreButtonDisplayed() throws Throwable {
	   assertTrue(csp.isLoadMoreCharityButtonPresent());
	}
	
	
	@When("^User navigates to charity search page$")
    public void navigateToCharity() throws Throwable {
		Calendar now = Calendar.getInstance();
		int currYear = now.get(Calendar.YEAR);
		int currMonth = now.get(Calendar.MONTH) + 1;
		int currDate = now.get(Calendar.DATE);
		mdp.navigateToCreateAPage();
		
    	esp.enterSearch(abs.genarateString(6)+"_"+System.currentTimeMillis());
 	    esp.clickNextButton();
 	    csp.waitForEventDatePresent();
 	    csp.selectEventDate(currDate);
 	    csp.selectEventMonth(currMonth);
 	    csp.selectEventYear(currYear+1);	
 	    csp.clickNextButton();
 	    csp.waitForCharitySearchField();
    }
	
	@When("^User select search for charity \"([^\"]*)\"$")
	public void searchCharity(String charityName) throws Throwable {
	    csp.enterCharitySearchString(charityName);
	    csp.clickCharitySearch();
	    csp.waitForSearchResultsListSection();
	}
	
	@Then("^User is displayed text \"([^\"]*)\"$")
	public void user_is_displayed_text(String arg1) throws Throwable {
	    abs.isTextPresent(arg1);
	}
}
