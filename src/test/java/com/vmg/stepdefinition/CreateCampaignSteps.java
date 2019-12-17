package com.vmg.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.CharityHomePage;
import com.vmg.pagefactory.CharitySignInPage;
import com.vmg.pagefactory.LoginPage;
import com.vmg.pagefactory.MakeDonenationPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.SignUpPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateCampaignSteps {

	WebDriver driver;
	AbstractPage abs;
	LoginSteps baseSteps;
	LoginPage loginPage;
	MyDashboardPage myDb;
	SignUpPage sp;
	MakeDonenationPage mdp;
	CharitySignInPage csp;
	CharityHomePage chp;
	
	 String campaignName;
	public CreateCampaignSteps(LoginSteps bs) {
		this.baseSteps = bs;
		
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		loginPage = new LoginPage(driver);
		myDb = new MyDashboardPage(driver);
		sp = new SignUpPage(driver);
		csp = new CharitySignInPage(driver);
		chp = new CharityHomePage(driver);
		mdp = new MakeDonenationPage(driver);
	}
	
	@When("^User navigate to charity signIn page$")
	public void navigateToCharitySignIn() throws Throwable {
		myDb.navigateToCharitySignIn();
	}
	
	@When("^User logs in to charity with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void logInToCharity(String userName, String pass) throws Throwable {
        csp.typeUserName(userName);
        csp.typePassword(pass);
        csp.clickSignInButton();
    }


	@When("^User navigates to create new campaign$")
	public void navigateToCreateCampaign() throws Throwable {
		chp.clickCampaignLink();
		chp.clickCreatACampaignLink();
		chp.clickCreateCampaignButton();
	}

	@When("^Creates new campaign with allow gift aid \"([^\"]*)\" and allow direct donation \"([^\"]*)\"$")
	public void create_new_campaign(String arg1, String arg2) throws Throwable {
		campaignName = abs.genarateNumericString(10);
	    System.out.println(campaignName);
		chp.typeCampaignName(campaignName);
		chp.typeCampaignUrl(campaignName);
		chp.clickNextButton();
		chp.typeCampaignDesc();
		chp.selectDisplayTotalAmountNo();
		chp.typeFundrisingTargetAmount("100");
		chp.clickNextButton();
		chp.collectGiftAidRadio(arg1);
		chp.allowDirectDonationsRadio(arg2);
		chp.publishCampaign();
	}
	
	@When("^User select search for a campaign$")
	public void searchCharity() throws Throwable {
		mdp.enterDataInCharitySearch(campaignName);
		mdp.clickSearchButton();
	}
	

}
