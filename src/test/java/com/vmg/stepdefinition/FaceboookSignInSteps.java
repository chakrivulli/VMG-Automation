package com.vmg.stepdefinition;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.FacebookLoginPage;
import com.vmg.pagefactory.LoginPage;
import com.vmg.pagefactory.MakeDonenationPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.SignUpPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FaceboookSignInSteps {

	WebDriver driver;
	AbstractPage abs;
	LoginSteps baseSteps;
	LoginPage loginPage;
	MyDashboardPage myDashboard; 	
	//SignUpPage sp;
	FacebookLoginPage fb;
	MakeDonenationPage mdp;

	public FaceboookSignInSteps(LoginSteps bs) {
		this.baseSteps = bs;
		
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		loginPage = new LoginPage(driver);
		myDashboard = new MyDashboardPage(driver);
		//sp = new SignUpPage(driver);
		fb = new FacebookLoginPage(driver);
		mdp =  new MakeDonenationPage(driver);
	}

	@When("^User enter facebook credential \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterFacebookCredentials(String emailId, String password) throws Throwable {
		loginPage.clickSignInButton();
		fb.continueWithFacebook();
		fb.enterFbEmailId(emailId);
		fb.enterFbPassword(password);
		fb.clickFbLogin();
		if(fb.isConfirmPresent()) {
			fb.clickConfirm();
		}
	}

	@Then("^Verify facebook signout is present$")
	public void verifyLoggedIn() throws Throwable {
			Assert.assertTrue(myDashboard.isMyAccountPresent());
	}
	
	@Then("^Verify user is asked to Complete profile$")
    public void verifycompleteProfile() throws Throwable {
			Assert.assertTrue(abs.isTextPresent("Complete your profile"));
			Assert.assertTrue(abs.isTextPresent("we're excited to have you on board. "
				+ "We just need a few more details before you can get going."));
	    }
	
	
	@When("^User completes filling profile$")
    public void verifycompleteProfile2() throws Throwable {
		if(abs.isTextPresent("Are your details up-to-date?")) {
			Assert.assertTrue("This Facebook data is aready used, "
					+ "please use new Facebook data ", false);
		}else {
			Assert.assertTrue(abs.isTextPresent("Complete your profile"));
			mdp.enterAddress("Loqate, Waterside, Basin Road WR5 3DA");
			mdp.selectOver18YesRadio();
			mdp.clickNextButton();
			assertTrue(abs.isTextPresent("Are your details up-to-date?"));
		}
		
    }
	
	@When("^User is displayed \"([^\"]*)\" text$")
	public void user_is_displayed_text(String arg1) throws Throwable {
		Assert.assertTrue(abs.isTextPresent("We just need a few more details"));
	}

}
