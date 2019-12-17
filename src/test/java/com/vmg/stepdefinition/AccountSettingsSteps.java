package com.vmg.stepdefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.model.Log;
import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.AccountSettingsPage;
import com.vmg.pagefactory.FacebookLoginPage;
import com.vmg.pagefactory.LoginPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.ShowFundraiserActivitiesPage;
import com.vmg.pagefactory.HomePage;
import com.vmg.pagefactory.LoginPage;
import com.vmg.pagefactory.AccountSettingsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountSettingsSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	FacebookLoginPage fb;
	AccountSettingsPage as;
	MyDashboardPage myDash;
	FaceboookSignInSteps fbsignInSteps;
	HomePage hp;
	LoginPage loginpage;
	AccountSettingsPage asp;
	

	public AccountSettingsSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		fb = new FacebookLoginPage(driver);
		as = new AccountSettingsPage(driver);
		fbsignInSteps = new FaceboookSignInSteps(bs);
		myDash = new MyDashboardPage(driver);
		hp = new HomePage(driver);
		loginpage = new LoginPage(driver);
		asp = new AccountSettingsPage(driver);
	}
	
	@When("^Connect with facebook if disconnected using credential \"([^\"]*)\" and \"([^\"]*)\"$")
	public void connectWithFacebook(String emailId, String pass) throws Throwable {
	   myDash.navigateToAccountSetting();
		if(as.isDisconnectFBLinkEnabled()) {
		   as.clickDisconnectFBLink();
		   abs.log.info("User is disconnected with facebook");
	   }else {
		   as.clickConnectFBLink();
		   //fbsignInSteps.enterFacebookCredentials(emailId, pass);
			fb.enterFbEmailId(emailId);
			fb.enterFbPassword(pass);
			fb.clickFbLogin();
			if(fb.isConfirmPresent()) {
				fb.clickConfirm();
			}
		   assertTrue(as.isDisconnectFBLinkEnabled());
		   abs.log.info("User is just connected with facebook");
	   }
	}

	@When("^Disconnect with facebook$")
	public void disconnectWithFacebook() throws Throwable {
		if(as.isDisconnectFBLinkEnabled()) {
			   as.clickDisconnectFBLink();
		   }else {
			  abs.log.info("User is disconnected with facebook");
		   }
	}
	
	@When("^User clicks on My Account$")
	public void user_clicks_on_My_Account() throws Throwable {
	    hp.clickMyAccount();
	}
	
	@When("^User clicks on MyAccount Link$")
	public void user_clicks_on_MyAccount_Link() throws Throwable {
	    hp.clickAccountSettingsLink();
	}

	@When("^User clicks on close account checkbox$")
	public void user_clicks_on_close_account_checkbox() throws Throwable {
	    asp.clickCloseAccountCheckbox();
	}

	@When("^User clicks on close account button$")
	public void user_clicks_on_close_account_button() throws Throwable {
	    asp.clickCloseAccountbtn();
	}

	@When("^User clicks on confirm close account button$")
	public void user_clicks_on_confirm_close_account_button() throws Throwable {
	    asp.clickConfirmCloseAccountbtn();
	}

	@Then("^Verify whether account closed or not$")
	public void verify_whether_account_closed_or_not() throws Throwable {
	    loginpage.isLoginButtonPresent();
	}
	

}
