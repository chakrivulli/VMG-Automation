package com.vmg.stepdefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.EventSearchPage;
import com.vmg.pagefactory.FacebookLoginPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.ShowFundraiserActivitiesPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EventSearchSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	ShowFundraiserActivitiesPage sfa ;
	MyDashboardPage mdp;
	EventSearchPage esp;

	public EventSearchSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		sfa = new ShowFundraiserActivitiesPage(driver);
		mdp = new MyDashboardPage(driver);
		esp = new EventSearchPage(driver);
	}
	
	@When("^User navigates to event search page$")
	public void user_navigates_to() throws Throwable {
		mdp.navigateToCreateAPage();
	}

	@When("^User select search for event \"([^\"]*)\"$")
	public void searchEvent(String arg1) throws Throwable {
	    esp.enterSearch(arg1);
	    esp.clickNextButton();
	}

	@Then("^User is displayed relevent search results containing text \"([^\"]*)\"$")
	public void VerifyReleventSearchResultsApperied(String text) throws Throwable {
	    esp.verifyEventSearchResultsContainsSearchString(text);
	}

	@Then("^User is displayed \"([^\"]*)\" text above search results$")
	public void user_is_displayed_text_above_search_results(String arg1) throws Throwable {
	    assertTrue(esp.verifyTextOnTopOfEventResults().equalsIgnoreCase(arg1));
	}

	
	@Then("^User is displayed text \"([^\"]*)\" below search results$")
	public void verifyTextDisplayedAboveSearchResults(String arg1) throws Throwable {
	    assertTrue(abs.isTextPresent(arg1));
	}

	@Then("^User is displayed Event name, Event location,Event date, Event logo, Name of the charity, Event Description$")
	public void verifyAllEventAttributesDisplayed() throws Throwable {
	   esp.verifyEventSearchResultsAttributes();
	}

	@Then("^User is displayed \"([^\"]*)\"$")
	public void verifyLinkDisplayed(String text) throws Throwable {
		assertTrue(abs.isTextPresent(text));
	}
	
	

}
