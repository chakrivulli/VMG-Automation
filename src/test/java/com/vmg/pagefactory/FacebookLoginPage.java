package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {

	AbstractPage abs ;

	
	@FindBy(id="btn-facebook")
	WebElement continueWithFacebookButton;
	
	@FindBy(id="email")
	WebElement facebookEmailInputField;
	
	@FindBy(id="pass")
	WebElement facebookPasswordInputField;
	
	@FindBy(id="loginbutton")
	WebElement facebookLoginButton;
	
	@FindBy(name="__CONFIRM__")
	WebElement confirmButton;
	
	@FindBy(xpath="//div[@class='unclickableMask']")
	WebElement fundraiserImageOnFacebook;
	
	@FindBy(xpath="//span[text()='Post to Facebook']")
	WebElement postButtonOnFacebook;
	
	
	public FacebookLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void continueWithFacebook() {
		abs.click(continueWithFacebookButton);
	}
	public void enterFbEmailId(String emailId) {
		abs.type(facebookEmailInputField, emailId);
	}
	
	public void enterFbPassword(String password) {
		abs.type(facebookPasswordInputField, password);
	}
	
	public void clickFbLogin() {
		abs.click(facebookLoginButton);
	}
	
	public boolean isConfirmPresent() {
		return abs.isWebElementPresent(confirmButton);
	}
	
	public void clickConfirm() {
		abs.click(confirmButton);
	}
	
	public boolean isFundraiserImagePresentOnFacebook() {
		return abs.isWebElementPresent(fundraiserImageOnFacebook);
	}
	
	public boolean ispostButtonPresentOnFacebook() {
		return abs.isWebElementPresent(postButtonOnFacebook);
	}
	
}
