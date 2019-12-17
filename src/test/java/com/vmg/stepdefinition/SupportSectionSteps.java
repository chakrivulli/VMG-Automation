package com.vmg.stepdefinition;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.FundraiserPage;
import com.vmg.pagefactory.MyDashboardPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SupportSectionSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	MyDashboardPage mdb;
	FundraiserPage fp;
	public SupportSectionSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		mdb = new MyDashboardPage(driver);
		fp = new FundraiserPage(driver);
	}
	
	
	 @When("^User navigates to My Fundraiser page to select \"([^\"]*)\"$")
	    public void selectFundraiser(String fundraiserTitle) throws Throwable {
	       mdb.navigateToMyFundraising();
	       fp.selectFundraiser(fundraiserTitle);
	       fp.isUserPageUrlPresent();
	    }
	 
	 @Then("^User is displayed supporter name \"([^\"]*)\" and donation amount \"([^\"]*)\"$")
	    public void verifySupporterNameDonationAmount(String name, String amount) throws Throwable {
	       assertEquals(name, fp.getSupporterNameFirst());
	       assertTrue(fp.getSupporterDonationAmount().contains(amount));
	    }
}
