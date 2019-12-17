package com.vmg.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{

	AbstractPage abs ;
	

	@FindBy(xpath="//body/descendant::input[@class='give-now-button'][1]")
	WebElement giveNowButton;
	
	public CampaignPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void clickGiveNowButton() {
		abs.click(giveNowButton);
	}
}


