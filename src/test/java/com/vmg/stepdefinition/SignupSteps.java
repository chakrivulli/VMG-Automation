package com.vmg.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.LoginPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.pagefactory.SignUpPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignupSteps {

	WebDriver driver;
	AbstractPage abs;
	LoginSteps baseSteps;
	LoginPage loginPage;
	MyDashboardPage myDb;
	SignUpPage sp;
	
	
	public SignupSteps(LoginSteps bs) {
		this.baseSteps = bs;
		
		driver = baseSteps.getDriver();
		abs = new AbstractPage(driver);
		loginPage = new LoginPage(driver);
		myDb = new MyDashboardPage(driver);
		sp = new SignUpPage(driver);
	}
	
	@When("^User navigates to signUp page$")
	public void navigateToSignUp() throws Throwable {
		loginPage.clickSignInButton();
	}
	
	@When("^User enters valid email address$")
	public void enterEmail() throws Throwable {
		loginPage.enterEmail("surekha_" + abs.getTimeStamp() + "@gmail.com");
		loginPage.clickNextButton();
	}

	@When("^User enters valid required data like firstName lastName and address$")
	public void entersRequiredDetails() throws Throwable {
		System.out.println("from enter req data");
		sp.enterFirstName(abs.genarateString(11));
		sp.enterLastName(abs.genarateString(11));
		sp.enterAddress(abs.genarateNumericString(3));
	}

	@When("^User enters valid password$")
	public void entersPassword() throws Throwable {
		System.out.println("from enter password");
		sp.enterPassword(abs.genaratePassword(8));
		sp.clickHappyToContactCheckBox();
		sp.clickTermsAndConditions();
		sp.clickRegisterButton();
	}

	@Then("^Verify user is successfully signed up$")
	public void verifySignedUp() throws Throwable {
		System.out.println("from Verified succesfully signed up");
		Assert.assertTrue(myDb.isMyAccountPresent());
	}

}
