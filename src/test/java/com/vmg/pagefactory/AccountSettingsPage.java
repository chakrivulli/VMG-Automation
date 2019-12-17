package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingsPage 
{

	AbstractPage abs ;
	
	@FindBy(linkText="Disconnect")
	WebElement disconnectFacebookLink;
	
	@FindBy(id="disconnectFbBtn")
	WebElement disconnectFacebookBtn;
	
	@FindBy(linkText="Connect")
	WebElement connectFacebookLink;
	
	@FindBy(id="closeAccountYes")
	WebElement closeAccountCheckBox;
	
	@FindBy(id="btn-close-profile")
	WebElement closeAccountBtn;

	@FindBy(id="_confirmCloseAccount")
	WebElement confirmCloseAccountBtn;
	
	public AccountSettingsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	
	
	public void clickConnectFBLink() {
		abs.click(connectFacebookLink);
	}
	
	public void clickDisconnectFBLink() {
		abs.click(disconnectFacebookLink);
	}
	
	public boolean isDisconnectFBLinkEnabled() {
		if(abs.isWebElementPresent(disconnectFacebookLink)) {
			return abs.isWebElementClickable(disconnectFacebookLink);
		}
		return false;
	}
	
	public void clickCloseAccountCheckbox() {
		abs.click(closeAccountCheckBox);
	}
	public void clickCloseAccountbtn() {
		abs.click(closeAccountBtn);
	}
	
	public void clickConfirmCloseAccountbtn() {
		abs.click(confirmCloseAccountBtn);
	}
}

