package com.vmg.stepdefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.CampaignPage;
import com.vmg.pagefactory.CharityPage;
import com.vmg.pagefactory.FundraiserPage;
import com.vmg.pagefactory.HomePage;
import com.vmg.pagefactory.LoginPage;
import com.vmg.pagefactory.MakeDonenationPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.MyDonationsPage;
import com.vmg.pagefactory.PayPalPage;
import com.vmg.pagefactory.SignUpPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyDonationSteps {

	LoginSteps baseSteps;
	LoginPage login;
	WebDriver driver;
	AbstractPage abs;
	HomePage hp;
	SignUpPage sp;
	MakeDonenationPage mdp;
	PayPalPage pp;
	CampaignPage cp;
	FundraiserPage fr;
	CharityPage chtp;
	MyDashboardPage mydbp;
	MyDonationsPage mydon;
	public MyDonationSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		hp = new HomePage(driver);
		sp = new SignUpPage(driver);
		mdp = new MakeDonenationPage(driver);
		pp = new PayPalPage(driver);
		cp = new CampaignPage(driver);
		fr = new FundraiserPage(driver);
		chtp = new CharityPage(driver);
		login = new LoginPage(driver);
		mydbp = new MyDashboardPage(driver);
		mydon = new MyDonationsPage(driver);
	}
	
	@When("^User navigates to My Donations page$")
	public void myDonationsTab() throws Throwable {
		mydbp.navigateToMyDonations();
	}
	
	
	@When("^User clicks on view details button$")
	public void clickViewDetails() throws Throwable {
		mydon.clickViewDetails();
	}
	
	@Then("^Verify Total donations heading$")
    public void verifyTotalDonationsHeading() throws Throwable {
        assertTrue(mydon.isTotalDonationsHeadingPresent());
	}
	
	
	@Then("^Verify Regular giving heading$")
    public void verifyRegularGivingHeading() throws Throwable {
        assertTrue(mydon.isRegularGivingHeadingPresent());
	}
	
	@Then("^Verify My donation history heading$")
    public void verifyMyDonationHistoryHeading() throws Throwable {
        assertTrue(mydon.isMyDonationHistoryHeadingPresent());
	}
	
	@Then("^Verify donation details are shown$")
    public void verifyDonationDetails() throws Throwable {
        assertTrue(abs.isTextPresent("Donation ID"));
        assertTrue(abs.isTextPresent("Payment method"));
        assertTrue(abs.isTextPresent("Payment method"));
	}
}
