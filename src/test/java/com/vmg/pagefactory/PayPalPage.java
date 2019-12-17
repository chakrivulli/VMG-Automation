package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayPalPage 
{

	AbstractPage abs ;
	
	@FindBy(id="acceptAllButton")
	WebElement acceptCookiesOnPayPal;
	
	@FindBy(id="email")
	WebElement email;

	@FindBy(id="btnNext")
	WebElement nextButtton;
	
	@FindBy(id="password")
	WebElement password;

	@FindBy(xpath="//*[@id='top']/div/div/a[4]/span[2]")
	WebElement navigateToSignInButton;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	@FindBy(id="confirmButtonTop")
	WebElement continueButton;
	
	@FindBy(id="notNowLink")
	WebElement notNowLink;

	public PayPalPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void clickAcceptCookiesButton() {
		abs.click(acceptCookiesOnPayPal);
	}
	
	public void clickNextButton() {
		abs.click(nextButtton);
	}
	
	public boolean isNextPresent() {
		return abs.isWebElementPresent(nextButtton);
	}
	public void clickSignInButton() {
		abs.click(navigateToSignInButton);
	}
	public void enterEmail(String emailId){
		abs.type(email,emailId);
	}
	
	public void enterPassword(String psw){
		abs.type(password,psw);
	}

	public boolean isLoginPresent() {
		return abs.isWebElementPresent(loginButton);
	}
	public void clickLoginButton() {
		abs.click(loginButton);
	}
	
	public void clickContinueButton() {
		abs.click(continueButton);
	}
	
	public void clickNotNowButton() {
		if(abs.isWebElementPresent(notNowLink)) {
			abs.click(notNowLink);
		}
	}
}

