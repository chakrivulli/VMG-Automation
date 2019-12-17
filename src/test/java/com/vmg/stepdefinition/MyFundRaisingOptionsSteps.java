package com.vmg.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.CreateTeamPage;
import com.vmg.pagefactory.EditTeamPage;
import com.vmg.pagefactory.FundraiserPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.ShowFundraiserActivitiesPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyFundRaisingOptionsSteps {

	LoginSteps baseSteps;
	WebDriver driver;
	AbstractPage abs;
	MyDashboardPage mdb;
	ShowFundraiserActivitiesPage sfa ;
	EditTeamPage etp;
	CreateTeamPage ctp;
	FundraiserPage fp;
	public MyFundRaisingOptionsSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		mdb = new MyDashboardPage(driver);
		sfa = new ShowFundraiserActivitiesPage(driver);
		etp = new EditTeamPage(driver);
		ctp = new CreateTeamPage(driver);
		fp = new FundraiserPage(driver);
		
	}
	
	@When("^User navigates to My Fundraiser page$")
    public void navigateToInMemoryPage() throws Throwable {
        mdb.navigateToMyFundraising();
        
    }

	@When("^ User selects fundraiser \"([^\"]*)\"$")
    public void select_fundraiser(String strArg1) throws Throwable {
        abs.click(driver.findElement(By.xpath("//h3[text()='"+strArg1+"']")));
    }
	
	@When("^User clicks options of a Team$")
	public void selectOptionsTeam() throws Throwable {
		sfa.clickFirstOptionUserTeamSecion();
	}

	@When("^User clicks last options of a Team$")
	public void selectOptionsOfLastTeam() throws Throwable {
		sfa.clickLastOptionUserTeamSecion();
	}
	
	@When("^User links In Memory page$")
	public void linksInMemPage() throws Throwable {
		sfa.clickLinkToInMemoryPageLast();
	    sfa.searchToLinkInMemoryPage("memory");
	    sfa.clickInMemoryPageSearchButton();
	    sfa.clickFirstInMemorySearchResultsPlusIcon();
	}
	
	@Then("^Verify Unlink In Memory Page option$")
	public void verifyLinkToInMemoryPageOption() throws Throwable {
	    sfa.isUnLinkMemPagePresent();
	    sfa.clickUnLinkMemPage();
	}

	@Then("^Verify Link To Campaign$")
	public void verifyLinkToCampaign() throws Throwable {
	   sfa.clickLinkToCampaign();
	   Assert.assertTrue(sfa.isLinkToCampaignHeadingPresent());
	   Assert.assertTrue(sfa.isCampaignSearchFeildPresent());
	   Assert.assertTrue(sfa.isCampaignSearchButtonPresent());
	}

	@Then("^Verify Add or Remove Team Members option$")
	public void verifyAddOrRemoveTeamMembers() throws Throwable {
	    sfa.clickEditTeamMembers();
        //etp.removeTeamMember();
        //etp.clickDoneAfterRemovingTeamMem();
        //etp.isEditTeamMembersClikable();
        //etp.clickEditTeamMembers();
		ctp.searchForMember("surekha1234@prod.vmg");
	    ctp.clickSearchButton();
        ctp.addToTeam();
        ctp.clickDoneButtonOnAddTeamMember();
        etp.isEditTeamMembersClikable();
	    
	    
	}

	@Then("^Verify Edit Charities option$")
	public void verifyEditCharities() throws Throwable {
	    sfa.clickEditCharities();
	    /*Assert.assertTrue(sfa.isSearchCharityField());
	    Assert.assertTrue(sfa.isChooseYourCharityHeading());*/
	    etp.updateCharity();
        etp.clickDoneButtonOnUpdateCharities();
        etp.isEditCharitiesClickable();
	}

	@Then("^Verify View Donation History option$")
	public void verifyViewDonationHistory() throws Throwable {
	    sfa.clickViewDonationHistory();
	    Assert.assertTrue(sfa.isMyDonorsHeadingPresent());
	}

	@Then("^Verify Close page option$")
	public void verifyClosePage() throws Throwable {
	    sfa.clickClosePage();
	    sfa.clickClosePageButton();
	    //sfa.clickFirstOptionUserTeamSecion();
	    abs.waitForElementClickable(By.xpath("//h3[text()='Inactive pages']/following::a[text()='Options'][1]"),
	    		abs.maxTimeOut);
	    abs.click(By.xpath("//h3[text()='Inactive pages']/following::a[text()='Options'][1]"));
	    Assert.assertTrue(sfa.isReOpenPresent());
	    sfa.clickReOpenLink();
	    sfa.clickReOpenPageButton();
	}	
	
	@Then("^User is displayed Fundraiser, In Memory and Team pages$")
    public void verifyFundraiserImemoryAndTeamPagesUnderMyFundraiser() throws Throwable {
		Assert.assertTrue(fp.isSomeonespecialHeadingPresent());
		Assert.assertTrue(fp.isTeamChallengeHeadingPresent());
		Assert.assertTrue(fp.isMyChallengeHeadingPresent());
    }
	
	@Then("^User is displayed Load more button uder Fundraiser, In Memory and Team sections$")
    public void verifyLoadMoreButtonsPresent() throws Throwable {
		Assert.assertTrue(fp.isLoadMoreMyChallengeBtnPresent());
		Assert.assertTrue(fp.isLoadMoreSomeoneSpecialBtnPresent());
		Assert.assertTrue(fp.isLoadMoreTeamBtnPresent());
    }
}
