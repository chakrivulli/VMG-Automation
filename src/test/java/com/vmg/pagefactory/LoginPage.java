package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	AbstractPage abs ;
	@FindBy(xpath="//*[@id='emailAddress']")
	WebElement username;

	@FindBy(xpath="//*[@id='btn-next']")
	WebElement fNextBtn;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement password;

	@FindBy(xpath="//*[@id='top']/div/div/a[4]/span[2]")
	WebElement navigateToSignInButton;
	
	@FindBy(id="btn-sign-in")
	WebElement loginButton;
	
	@FindBy(id="password.errors")
	WebElement passwordErrorLabel;
	
	@FindBy(id="accountLockedErrorMessage")
	WebElement accountLockedErrMsg;
	
	@FindBy(id="forgottenPassword")
	WebElement forgottenPasswordLink;
	
	@FindBy(id="btnTempPassword")
	WebElement sendTempPasswordBtn;
	
	@FindBy(css ="#alert-message_error > div > div > ul > li")
	WebElement forgotPasswordPageEmailErr;
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void clickNextButton() {
		abs.click(fNextBtn);
	}
	
	public boolean isNextPresent() {
		return abs.isWebElementPresent(fNextBtn);
	}
	
	public void clickSignInButton() {
		abs.click(navigateToSignInButton);
	}
	
	public void enterEmail(String email){
		abs.type(username,email);
	}

	
	public void enterPassword(String psw){
		abs.switchToFrame(0, false);
		abs.type(password,psw);
	}

	public boolean isLoginPresent() {
		abs.switchToFrame(0, false);
		return abs.isWebElementPresent(loginButton);
	}
	public void clickLoginButton() {
		abs.click(loginButton);
	}
	public void login(String user,String pass)
	{ 
		abs.type(username,user);
		abs.click(fNextBtn);
		abs.switchToFrame(0, false);
		abs.type(password,pass);
		abs.click(loginButton);
        
	}
	public void loginByClickingOnSignIn(String user,String pass)
	{ 
		abs.click(navigateToSignInButton);
		abs.type(username,user);
		abs.click(fNextBtn);
		abs.switchToFrame(0, false);
		abs.type(password,pass);
		abs.click(loginButton);
        
	}
	public boolean isPasswordErrorPresent() {
		return abs.isWebElementPresent(passwordErrorLabel);
	}
	
	public boolean isUserNameFieldPresent() {
		return abs.isWebElementPresent(username);
	}
	
	
	
	public void fundariserLoginCookiee(String username1, String password1) 
	{
		
		abs.type(username,username1);
		abs.click(fNextBtn);
		abs.switchToFrame(0, false);
		abs.type(password,password1);
		abs.click(loginButton);
        
		System.out.println("after set= "+abs.driver.manage().getCookieNamed("JSESSIONID"));
		System.out.println("after set= "+abs.driver.manage().getCookieNamed("vmgdc"));
	}
	
	public void isLoginButtonPresent() {
		 abs.isWebElementPresent(loginButton);
	}
	public void isaccountLockedErrorMsgpresent() {
		 abs.isWebElementPresent(accountLockedErrMsg);
	}
	
	public void clickOnForgotPasswordLink() {
		 abs.click(forgottenPasswordLink);
	}
	
	public void EnterInvalidEmailId(String Email) {
		 abs.type(username, Email);
	}
	
	public void ClickOnSendTempPasswordButton(){
		 abs.click(sendTempPasswordBtn);
	}
	
	public void isInvalidEmailErrorMessagePresent(){
		 //abs.isTextPresent("Sorry, the email address you've entered does not match our records");
		abs.isWebElementPresent(forgotPasswordPageEmailErr);
	}

}

