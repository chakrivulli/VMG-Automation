package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	
	AbstractPage abs ;
	@FindBy(id="first-name")
	WebElement firstName;

	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(xpath="//div[@class='pca pcalist']/div[@class='pcaitem pcafirstitem'][1]")
	WebElement addressAutoFillFirstItem;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="contactByVMGIndicator")
	WebElement happyToContactedByCheckBox;
	
	@FindBy(id="contactByVMGIndicator")
	WebElement contactByVMGIndicatorCheckBox;
	
	@FindBy(id="agree-to-terms")
	WebElement termssAndConditionsCheckBox;
	
	@FindBy(id="btn-confirmation")
	WebElement registerButton;
	
	
	
	public SignUpPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void enterLastName(String lName) {
		abs.type(lastName, lName);
	}
	
	public void enterFirstName(String fName) {
		abs.type(firstName, fName);
	}
	public void enterAddress(String add) {
		abs.type(address, add);
		abs.waitForElementPresent(addressAutoFillFirstItem, 60);
		abs.click(addressAutoFillFirstItem);
	}
	public void enterPassword(String psw) {
		abs.type(password, psw);
	}
	
	public void clickTermsAndConditions() {
		abs.click(termssAndConditionsCheckBox);
	}
	
	public void clickContactByVMGIndicator() {
		abs.click(contactByVMGIndicatorCheckBox);
	}
	public void clickRegisterButton() {
		abs.click(registerButton);
	}
	
	public void clickHappyToContactCheckBox() {
		abs.click(happyToContactedByCheckBox);
	}
}
