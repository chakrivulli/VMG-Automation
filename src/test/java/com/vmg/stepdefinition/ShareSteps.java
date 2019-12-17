package com.vmg.stepdefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.FacebookLoginPage;
import com.vmg.pagefactory.ShowFundraiserActivitiesPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShareSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	FacebookLoginPage fb;
	ShowFundraiserActivitiesPage sfa ;

	public ShareSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		fb = new FacebookLoginPage(driver);
		sfa = new ShowFundraiserActivitiesPage(driver);
		
	}
	
	
	
	@When("^User clicks share link of a Team$")
	public void selectShareTeam() throws Throwable {
		sfa.clickFirstShareUserTeamSecion();
	}

	
	@Then("^User is displayed share with Facebook , Twitter and LinkedIn links$")
	public void share_with_Facebook_Twitter_and_LinkedIn_links() throws Throwable {
		assertTrue(sfa.isFacebookSharePresent());
		assertTrue(sfa.isTwitterSharePresent());
		assertTrue(sfa.isLinkedInSharePresent());
	}

	@When("^User clicks share with Facebook$")
	public void click_share_with_Facebook() throws Throwable {
	    sfa.clickFacebookShare();
	}

	@When("^Enters facebook login details \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enters_fb_login_details(String FbemailId, String fbPassword) throws Throwable  {
		
	    abs.switchToWindowWithTitle("Post to Facebook");
	    fb.enterFbEmailId(FbemailId);
		fb.enterFbPassword(fbPassword);
		fb.clickFbLogin();
	    
	}

	@Then("^User is given option to Post Fundraising on Facebook with image and text$")
	public void user_is_given_option_to_Post_Fundraising_on_Facebook_with_image_and_text() throws Throwable {
	    assertTrue(fb.isFundraiserImagePresentOnFacebook());
	    assertTrue(fb.ispostButtonPresentOnFacebook());
	}

}
