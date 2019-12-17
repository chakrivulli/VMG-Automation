package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage 
{

	AbstractPage abs ;
	@FindBy(id="forgottenPassword")
	WebElement forgottenPasswordLink;

	@FindBy(id="btnTempPassword")
	WebElement sendTempPasswordBtn;
	
	@FindBy(xpath="//span[contains(text(),'ve sent you a temporary password')]")
	WebElement confirmationText;

	@FindBy(xpath="//a[@href=['/fundraiser-portal/userSignIn']")
	WebElement signInButton;
	
	@FindBy(xpath="//button[text()='Update Password']")
	WebElement updatePasswordBtn;
	
	@FindBy(id="password.errors")
	WebElement passwordErrorLabel;
	
	public ForgotPasswordPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void clickForgottenPasswordLink() {
		abs.click(forgottenPasswordLink);
	}
	
	public boolean isForgottenPasswordLinkPresent() {
		return abs.isWebElementClickable(forgottenPasswordLink);
	}
	
	public void clickSendTempPasswordBtn() {
		abs.click(sendTempPasswordBtn);
	}
	//We've sent you a temporary password
	public void waitForConfirmationText() {
		abs.waitForElementPresent(confirmationText, 30);
	}
	public void clickSignInButton() {
		abs.click(signInButton);
	}
	public void clickUpdatePasswordBtn() {
		abs.click(updatePasswordBtn);
	}
	
}

