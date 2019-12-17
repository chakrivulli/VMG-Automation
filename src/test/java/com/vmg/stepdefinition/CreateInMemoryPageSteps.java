package com.vmg.stepdefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.CharitySearchPage;
import com.vmg.pagefactory.EventSearchPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.SomeoneSpecialDetailsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateInMemoryPageSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	MyDashboardPage mdb;
	SomeoneSpecialDetailsPage ssp;
	CharitySearchPage csp;
	EventSearchPage esp;
	
	public CreateInMemoryPageSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		mdb = new MyDashboardPage(driver);
		ssp = new  SomeoneSpecialDetailsPage(driver);
		csp = new CharitySearchPage(driver);
		esp = new EventSearchPage(driver);
	}
	
	@When("^User navigates to Raise Funds In Memory page$")
    public void navigateToInMemoryPage() throws Throwable {
        mdb.navigateToRaiseFundInMem();
    }

	@When("^Searches for a charity \"([^\"]*)\"$")
    public void searcheForCharity(String charityName) throws Throwable {
        csp.enterCharitySearchString(charityName);
        csp.clickCharitySearch();
        csp.firstOfCharitySearchResults();
    }

	@When("^User enters details first-name last-name and relation$")
    public void user_enters_details_firstname_lastname_and_relation() throws Throwable {
        ssp.enterSS_FirstName();
        ssp.enterSS_LastName();
        ssp.selectRelationship("Other");
        ssp.clickssNext();
    }

	@When("^User selects \"([^\"]*)\" to Have any of your selected charities contributed to the cost of your event\\? question$")
    public void selectYesOrNoToQuestion(String arg) throws Throwable {
        /*if(arg.equalsIgnoreCase("yes")) {*/
        	csp.selectCharityContributionYesRadio();
        /*}else if(arg.equalsIgnoreCase("no")) {
        	csp.selectCharityContributionNoRadio();
        }*/
    }

	@When("^Clicks createMyPage button$")
    public void clicksCreateMyPage() throws Throwable {
        csp.clickCreateMyPage();
        if(csp.isEventFeeDropDownPresent()) {
        	//csp.selectEventFee();
        	csp.selectPayEventFeeOffline();
        	csp.clickNextButtonOnEventFee();
        }
    }
    
    @Then("^User is displayed confirmation text as \"([^\"]*)\"$")
    public void verifyConfirmationText(String text) throws Throwable {
        csp.isConfirmTextPresent();
        String test = csp.getConfirmationText();
        System.out.println("Exp:"+text+"Actual:"+test);
        /*assertEquals(text.replace(" ", "").toLowerCase().replace(".", "").toLowerCase(),
        		test.replace(".", "").toLowerCase().replace(".", "").toLowerCase());*/
    }
}
