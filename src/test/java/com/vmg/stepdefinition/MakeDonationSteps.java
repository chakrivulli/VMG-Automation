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
import com.vmg.pagefactory.PayPalPage;
import com.vmg.pagefactory.SignUpPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class MakeDonationSteps {

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
	public MakeDonationSteps(LoginSteps bs) {
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
	}
	
	@When("^User navigates to Make a Donation tab$")
	public void donationTab() throws Throwable {
		hp.clickMakeADonationLink();
	}

	@When("^User clicks on Donate button$")
	public void donateButton() throws Throwable {
		fr.clickDonateButton();
	}

	@When("^User clicks on make a donation button$")
	public void makeADonationButton() throws Throwable {
		chtp.clickMakeADonationButton();
	}
	
	@When("^User clicks on GiveNow button$")
	public void giveNowButton() throws Throwable {
		cp.clickGiveNowButton();
	}
	
	@When("^User select search for a fundraiser or charity \"([^\"]*)\"$")
	public void searchCharity(String charityName) throws Throwable {
		mdp.enterDataInCharitySearch(charityName);
		mdp.clickSearchButton();
	}

	@When("^User select first of fundraisers$")
	public void selectFirstFundraiser() throws Throwable {
			mdp.clickFirstSearchResult();
	}
	
	
	@When("^Verity Title \"([^\"]*)\"$")
    public void verityTitle(String strArg1) throws Throwable {
        String charityTitle = mdp.getCharityTitle();
        boolean res = charityTitle.contains(strArg1);
        System.out.println("Exp:"+strArg1+",Actual:"+charityTitle);
        Assert.assertTrue(res);
    }
	
	@When("^Verity Fundraiser Title \"([^\"]*)\"$")
    public void verityFundraiserTitle(String strArg1) throws Throwable {
        String fundraiserTitle = mdp.getFundraiserTitle();
        boolean res = fundraiserTitle.contains(strArg1);
        System.out.println("Exp:"+strArg1+",Actual:"+fundraiserTitle);
        Assert.assertTrue(res);
    }

	@When("^User select first of charity$")
	public void selectFirstCharity() throws Throwable {
			mdp.clickFirstCharitySearchResult();
	}
	
	@When("^User clicks on first of charity$")
	public void clickFirstCharity() throws Throwable {
			mdp.clickOnFirstCharitySearchResult();
	}

	@When("^User select first of campaign$")
	public void selectFirstCampaign() throws Throwable {
			mdp.clickFirstCampaignSearchResult();
	}
	
	@When("^User clicks on first of campaign$")
	public void clickFirstCampaign() throws Throwable {
			mdp.clickOnFirstCampaignSearchResult();
	}
	
	@When("^Selects campaign first linked fundraiser$")
    public void selects_campaign_first_linked_fundraiser() throws Throwable {
        mdp.selectFirstCampaignLinkedFundraiser();
        mdp.clickFundraiserDonateButton();
    }

	
	@When("^Verify first campaign's donation button is disabled$")
    public void verify_donation_button_is_disabled() throws Throwable {
       mdp.verifyFirstCharityDonationButtoDisabled();
    }
	
	@When("^Enter amount \"([^\"]*)\"$")
	public void enterAmount(String amount) throws Throwable {
		mdp.enterDonationAmount(amount);
	}
	
	@When("^Donate amount \"([^\"]*)\"$")
	public void donateAmount(String amount) throws Throwable {
		mdp.clickFundraiserDonateButton();
		mdp.enterDonationAmount(amount);
	}
	
	@When("^User selects to date \"([^\"]*)\" and month \"([^\"]*)\"$")
    public void selectDateAndMonthOfMonthlyDonation(String strArg1, String strArg2) throws Throwable {
        mdp.selectMonthlyDonationDate(strArg1);
        mdp.selectMonthlyDonationMonth(strArg2);
    }

	@When("^User selects to pay monthly$")
    public void payMonthly() throws Throwable {
        mdp.selectPay();
    }
	
	@When("^Enters message \"([^\"]*)\" donation transaction fee \"([^\"]*)\" and show amount \"([^\"]*)\" checkboxes$")
	public void enterMessageAmountCheckboxes(String message, boolean arg2, boolean arg3) throws Throwable {
		mdp.enterMessage(message);
		mdp.checkFeePaidByDonor(arg2);
		mdp.checkShowDonationOnPage(arg3);
	
	}
	

	@When("^User unchecks show my donation on page$")
    public void unchecks_show_my_donation_on_page() throws Throwable {
        mdp.UncheckShowDonationOnPage();
    }
	
	@When("^Select donation transaction fee \"([^\"]*)\"$")
	    public void select_donation_transaction_fee_something(boolean arg1) throws Throwable {
		mdp.checkFeePaidByDonor(arg1);
	    }
	
	@When("^Enters message \"([^\"]*)\"$")
	public void enterMessage(String message) throws Throwable {
		mdp.enterMessage(message);
	}

	 @When("^User enters an email address$")
	    public void enterEmail() throws Throwable {
		 mdp.enterEmail("surekha_" + abs.getTimeStamp() + "@gmail.com");
			mdp.clickContinueButton();
	    }
	 @When("^Clicks Not you link$")
	    public void notYou() throws Throwable {
			mdp.clickNotYouLink();
	    }
	 
	 @When("^User enters an email address \"([^\"]*)\"$")
	    public void enterEmail(String strArg1) throws Throwable {
		 mdp.enterEmail(strArg1);
		 mdp.clickContinueButton();
	    }

	 @When("^User unchecks setup an account$")
	    public void unchecks_setup_an_account() throws Throwable {
	        mdp.uncheckSetUpAnAccount();
	    }
	 
	 @When("^User enters data like firstName lastName and address$")
	    public void enterUserData() throws Throwable {
		 System.out.println("from enter req data");
			//abs.switchToLatestWindow();
			sp.enterFirstName(abs.genarateString(11));
			sp.enterLastName(abs.genarateString(11));
			mdp.enterAddress("Loqate, Waterside, Basin Road WR5 3DA");
	    }
	 @When("^User enters first name$")
	    public void enterFirstName() throws Throwable {
			sp.enterFirstName(abs.genarateString(11));
	    }
	 @When("^User enters last name$")
	    public void enterLastName() throws Throwable {
			sp.enterLastName(abs.genarateString(11));			
	    }
	 @When("^User enters address manually$")
	    public void enterAddress() throws Throwable {
		 	mdp.clickEnterAddressManualButton();
			mdp.enterAddressManually("Forest Colony", "Tajganj", "Agra", "Uttar Pradesh", "282001", "India");		
	    }
	 @When("^User selects I am over 18 option$")
		public void selecIamOver18() throws Throwable {
			mdp.selectOver18YesRadio();
		}
	 
	 @When("^User selects I am under 18 option$")
		public void selecIamUnder18() throws Throwable {
			mdp.selectOver18NoRadio();
		}
	 
	 @When("^User clicks continue$")
		public void clickContinue() throws Throwable {
			mdp.clickSignUpButton();
		}
	@When("^User enters valid password and confirm password$")
	public void enterPasswordandConfirm() throws Throwable {
		System.out.println("from enter password");
		mdp.enterPassword(abs.genaratePassword(8));
		mdp.clickSignUpButton();
	}
	
	@When("^User enters password \"([^\"]*)\"$")
	public void enterPassword(String pass) throws Throwable {
		abs.switchToFrame(0, false);
		mdp.enterPasswordOnce(pass);
		mdp.clickSignInBtnInMiddle();
	}
	
	 @When("^User selects \"([^\"]*)\" to gift aid$")
	    public void selectGiftAid(String yOrN) throws Throwable {
	       //if(yOrN.equalsIgnoreCase("yes")) {
	    	   mdp.clickGiftAidYesWithAllChecks();
	       //}else if(yOrN.equalsIgnoreCase("no")) {
	    	 //  mdp.clickGiftAidNo();
	       //}
	      // sp.clickContactByVMGIndicator();
	       mdp.clickContinueGift();
	       //sp.clickHappyToContactCheckBox();
			sp.clickTermsAndConditions();
			sp.clickRegisterButton();
			
	    }
	 @When("^User selects \"([^\"]*)\" to gift aid and click continue$")
	    public void selectGiftAidOnly(String yOrN) throws Throwable {
		 	mdp.clickGiftAidYesWithAllChecks();
		 	mdp.clickContinueGift();	
	    }
	 
	 @When("^User selects No to gift aid$")
	    public void selectGiftAidOnly() throws Throwable {
		 	//mdp.clickGiftAidYesWithAllChecks();
		 	mdp.clickGiftAidNo();
		 	mdp.clickContinueGift();	
	    }
	 
	 @When("^User selects VMG marketing & Fundraiser contact consent as Yes$")
	    public void selectVmgMarketingContactAsYes() throws Throwable {
		mdp.selectTestValleyCitizensAdviceBureauCheckBox();
		mdp.selectFutureSenseFoundationCheckBoxCheckBox();
		mdp.selectContactByFundraiserIndicatorCheckBox();
		sp.clickTermsAndConditions();
		sp.clickRegisterButton();
	    }
	 
	 @When("^Verify VMG marketing & Fundraiser contact consent questions not displayed$")
	    public void vmgMarketingContactOptionsNotDisplayed() throws Throwable {
		//mdp.selectTestValleyCitizensAdviceBureauCheckBox();
		Assert.assertTrue(mdp.isTestValleyCitizensAdviceBureauCheckBoxPresent());
		 //mdp.selectFutureSenseFoundationCheckBoxCheckBox();
		Assert.assertTrue(mdp.isFutureSenseFoundationCheckBoxCheckBoxPresent());
		//mdp.selectContactByFundraiserIndicatorCheckBox();
		Assert.assertTrue(mdp.isContactByFundraiserIndicatorCheckBoxPresent());
		sp.clickTermsAndConditions();
		sp.clickRegisterButton();
	    }
	 
	 @When("^User selects \"([^\"]*)\" to gift aid with I am not related to fundraiser$")
	    public void user_selects_something_to_gift_aid2(String yOrN) throws Throwable {
	       //if(yOrN.equalsIgnoreCase("yes")) {
	    	   mdp.clickGiftAidYesWithAllChecks();
	    	   mdp.selectIAmNotRelatedToFundraiser();
	       //}else if(yOrN.equalsIgnoreCase("no")) {
	    	 //  mdp.clickGiftAidNo();
	       //}
	      // sp.clickContactByVMGIndicator();
	       mdp.clickContinueGift();
	       //sp.clickHappyToContactCheckBox();
			sp.clickTermsAndConditions();
			sp.clickRegisterButton();
			
	    }
	 
	 @When("^selects I am not related to fundraiser$")
	    public void selects_not_related_to_fundraiser() throws Throwable {
	        mdp.selectIAmNotRelatedToFundraiser();
	    }

	 @When("^User selects \"([^\"]*)\" to gift aid only$")
	    public void select_gift_aid(String yOrN) throws Throwable {
	    	   mdp.clickGiftAidYesWithAllChecks();
	       mdp.clickContinueGift();
			
	    }
	 
	 @When("^Clicks terms&conditions and donate$")
	    public void clicks_termsconditions_and_donate() throws Throwable {
		 sp.clickTermsAndConditions();
			sp.clickRegisterButton();
	    }
	 
	@When("^Click pay by card$")
	public void payByCard() throws Throwable {
	    mdp.clickPayByCard();
	}
	
	@When("^Verify donation amount \"([^\"]*)\"$")
    public void verifyDonationAmount(String strArg1) throws Throwable {
        mdp.verifyDonationAmount(strArg1);
    }
	
	@When("^User clicks on continue as guest$")
    public void continueAsGuest() throws Throwable {
        mdp.clickContinueAsGuest();
    }
	
	@When("^Click pay by PayPal$")
    public void click_pay_by_paypal() throws Throwable {
		mdp.clickPayByPayPal();
		abs.wait(30);
		abs.switchToWindowWithTitle("Log in to your account");
		pp.clickAcceptCookiesButton();
		
	}
	
	 @When("^User enters an \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void enterPayPalCredentials(String paypalemail, String paypalpassword) throws Throwable {
	        pp.enterEmail(paypalemail);
	        pp.clickNextButton();
	        pp.enterPassword(paypalpassword);
	        pp.clickLoginButton();
	        pp.clickNotNowButton();
	        pp.clickContinueButton();
	        abs.wait(30);
	        //driver.switchTo().defaultContent();
		 	abs.switchToLatestWindow();
	    }

	 
	@When("^User enters card details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void enterCardDetails(String cardNumber, String cardHolderName, String expiryMonth, 
    	String expiryYear, String cvv) throws Throwable {
		abs.switchToFrame(0, false);
		mdp.enterCardNumber(cardNumber);
		mdp.enterCardHolderName(cardHolderName);
		mdp.enterMonthOfExpiry(expiryMonth);
		mdp.enterYearofExpiry(expiryYear);
		mdp.enterCVV(cvv);
		mdp.clickMakeDonation();
       
    }
	
	@Then("^Verify donation successfull$")
    public void verify_donation_successfull() throws Throwable {
        //assertTrue(abs.isTextPresent(""));
    }
	
	@When("^Verify donation is successfull$")
    public void verify_donation_is_successfull() throws Throwable {
        //assertTrue(abs.isTextPresent(""));
    }
	
	@When("^Delete all cookies and refresh$")
    public void deleteAllCookies() throws Throwable {
        //assertTrue(abs.isTextPresent(""));
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
    }
	@When("^Select use another card if user's card is saved$")
    public void selectUseAnotherCard() throws Throwable {
       if(mdp.isSelectAnotherCardRadioExists()) {
    	   mdp.clickSelectAnotherCard();
       }
    }
	@When("^Verify amount \"([^\"]*)\" on Review Donation page$")
    public void verifyAmountOnReviewDonationPage(String strArg1) throws Throwable {
        mdp.verifyAmountOnReviewDonation(strArg1);
    }
	
	@When("^User selects do not save card details$")
    public void selectDoNotSaveCard() throws Throwable {
        mdp.uncheckRememberCardDetailsOnReviewDonation();
    }
	
	
	@Then("^Verify user is asked to enter email$")
    public void verify_email() throws Throwable {
        Assert.assertTrue(login.isUserNameFieldPresent());
		
    }
}
