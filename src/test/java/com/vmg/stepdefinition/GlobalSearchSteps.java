package com.vmg.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.GlobalSerchPage;
import com.vmg.pagefactory.HomePage;
import com.vmg.pagefactory.LoginPage;
import com.vmg.pagefactory.MakeDonenationPage;
import com.vmg.pagefactory.SignUpPage;
import com.vmg.pagefactory.CharitySignInPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GlobalSearchSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	HomePage hp;
	LoginPage lp;
	SignUpPage sp;
	MakeDonenationPage mdp;
	GlobalSerchPage gsp;
	CharitySignInPage csp;

	public GlobalSearchSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		sp = new SignUpPage(driver);
		mdp = new MakeDonenationPage(driver);
		gsp = new GlobalSerchPage(driver);
		csp=new CharitySignInPage(driver);
		
	}
	
	
	
	@Then("^User is dispalyed top \"([^\"]*)\" Fundraisers$")
	public void top_Fundraisers(String arg1) throws Throwable {
	  assertEquals(Integer.parseInt(String.valueOf(arg1)), gsp.countFundraiserResults());
	}
	
	@Then("^User is dispalyed top \"([^\"]*)\" Campaigns$")
	public void top_Campaigns(String arg1) throws Throwable {
	  assertEquals(Integer.parseInt(String.valueOf(arg1)), gsp.countFundraiserResults());
	}

	@Then("^User is Donate button for Fundraisers search results$")
	public void donate_button_for_Fundraisers() throws Throwable {
		assertTrue(gsp.isDonateButtonForFundraiserPresent());
	}
	
	@Then("^User is Donate button for Campaigns search results$")
	public void donate_button_for_Campaigns() throws Throwable {
		assertTrue(gsp.isDonateButtonForCampaignPresent());
	}

	@Then("^User is displayed load more button for Fundraisers search results$")
	public void load_more_button_for_Fundraisers() throws Throwable {
		assertTrue(gsp.isLoadMoreButtonUnderFundraiserPresent());
	}

	@Then("^User is displayed load more button for Campaigns search results$")
	public void load_more_button_for_Campaigns() throws Throwable {
		assertTrue(gsp.isLoadMoreButtonUnderCampaignPresent());
	}
	
	@Then("^User is displayed Campaign attributes$")
	public void verifyAllEventAttributesDisplayed() throws Throwable {
		gsp.verifyCampaignSearchResultsAttributes();
	}
	
	
	@Then("^User is displayed top \"([^\"]*)\" Charities$")
	public void top_Charities(String arg1) throws Throwable {
		assertEquals(Integer.parseInt(String.valueOf(arg1)), gsp.countCharityResults());
	}

	@Then("^User is dispalyed Donate button for Charities search results$")
	public void donate_button_for_Charities() throws Throwable {
		assertTrue(gsp.isDonateButtonForCharityPresent());
	}

	@Then("^User is dispalyed load more button for Charities search results$")
	public void load_more_button_for_Charities() throws Throwable {
		assertTrue(gsp.isLoadMoreButtonUnderCharityPresent());
	}

	@Then("^User is displayed top \"([^\"]*)\" Events$")
	public void top_Events(String arg1) throws Throwable {
		assertEquals(Integer.parseInt(String.valueOf(arg1)), gsp.countEventResults());
	}

	@Then("^User is displayed Start Fundraising button for Events search results$")
	public void start_Fundraising_button_for_Events() throws Throwable {
		assertTrue(gsp.isStartFundraisingButtonforEventsPresent());
	}

	@Then("^User is displayed load more button for Events search results$")
	public void loadMoreButton_for_Events() throws Throwable {
		assertTrue(gsp.isLoadMoreButtonEventsPresent());
	}

	

	
	@When("^User set cookies$")
	public void setCookies(Map<String,String> Values)
	{
		abs.setCookies(Values.get("JSESSIONID"),Values.get("vmgdc"));
	}
	
	@When("^User clicks Don't show me this again$")
	public void dissmissCookies()
	{
		//con.cookies(locatorKey);
		hp.clickDismissCookies();
		
	}
	
	
	@When("^User Logsin into fundariser application$")
	public void loginFundraiser(Map<String,String> data) throws Throwable {
	   lp.fundariserLoginCookiee(data.get("Username"),data.get("Password"));
	}

	@Then ("^Login should be successful with cookiee values$")
	public void validateLogin(Map<String,String> Values)
	{
		if(Values.get("vmgdc").equals("A")) {
			hp.validateLoginCookiee("JSESSIONID",Values.get("JSESSIONID"));
		}else if(Values.get("vmgdc").equals("B")) {
			hp.validateLoginCookiee("JSESSIONID",Values.get("JSESSIONID"));
		}
		hp.validateLoginCookiee("vmgdc",Values.get("vmgdc"));
	}
	
	
	@Then ("^Charity Login should be successful with cookiee values$")
	public void validateCharityLogin(Map<String,String> Values)
	{
		if(Values.get("vmgdc").equals("A")) {
			csp.validateCharityLoginCookiee("JSESSIONID",Values.get("JSESSIONID"));
		}else if(Values.get("vmgdc").equals("B")) {
			csp.validateCharityLoginCookiee("JSESSIONID",Values.get("JSESSIONID"));
		}
		csp.validateCharityLoginCookiee("vmgdc",Values.get("vmgdc"));
	}

}
