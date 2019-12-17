
package com.vmg.pagefactory;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CharitySearchPage 
{

	AbstractPage abs ;
	
	
		
	@FindBy(id="searchCharityDescription")
	WebElement searchCharityField;
	
	@FindBy(id="btn-charity-search")
	WebElement charitySearchButton;
	
	@FindBy(xpath="//ul[@class='eventResults_List']")
	WebElement searchResultsListSection;
	
	@FindBy(xpath="//div[@id='charityResultsList']/ul[@class='eventResults_List']/li[1]")
	WebElement firstOfCharitySearchResultsListItem;
	
	@FindBy(xpath="//div[@id='charityResultsList']/ul[@class='eventResults_List']/li/descendant::img[@alt='select']")
	List<WebElement> plusIcons;
	
	@FindBy(id="charityContribution-yes")
	WebElement charityContributionYesRadio;
	
	@FindBy(id="charityContribution-no")
	WebElement charityContributionNoRadio;
	
	@FindBy(id="btn-charitypercent-id")
	WebElement createMyPageButton;
	
	@FindBy(xpath="//span[@class='confirmation-message_before-text']")
	WebElement confirmationTextLabel;
	
	@FindBy(id="eventDate")
	WebElement eventDateDropDown;
	
	@FindBy(id="eventMonth")
	WebElement eventMonthDropDown;
	
	@FindBy(id="eventYear")
	WebElement eventYearDropDown;
	
	@FindBy(id="btn-event-next")
	WebElement nextButton;
	
	@FindBy(xpath="//div[@id='chairtySearch']/descendant::h1")
	WebElement charityHeading;
	
	@FindBy(id="loadMoreCharity")
	WebElement loadMoreCharityButton;
	
	@FindBy(linkText="Invite them to register with us")
	WebElement inviteToRegisterlink;
	
	@FindBy(id="event-fee")
	WebElement eventFeeDropDown;
	
	@FindBy(id="pay-offline")
	WebElement payEventFeeOfflineCheckBox;
	
	@FindBy(id="save-fee-button")
	WebElement nextButtonOnEventFee;
	
	
	public CharitySearchPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void waitForCharitySearchField() {
		abs.waitForElementPresent(searchCharityField, abs.maxTimeOut.intValue());
	}
	
	public void enterCharitySearchString(String searchString) {
		abs.type(searchCharityField, searchString);
	}
	
	public void clickCharitySearch() {
		abs.click(charitySearchButton);
	}
	
	public void firstOfCharitySearchResults() {
		abs.click(firstOfCharitySearchResultsListItem);
	}
	
	public void selectCharityContributionYesRadio() {
		abs.click(charityContributionYesRadio);
	}
	
	public void selectCharityContributionNoRadio() {
		abs.click(charityContributionNoRadio);
	}
	
	public void clickCreateMyPage() {
		abs.click(createMyPageButton);
	}
	
	public boolean isEventFeeDropDownPresent() {
		return abs.isWebElementPresent(eventFeeDropDown);
	}
	
	public void selectEventFee() {
		abs.selectDropDownDataByText(eventFeeDropDown, "Invited Guests - £45.00");
	}
	
	public void selectPayEventFeeOffline() {
		abs.click(payEventFeeOfflineCheckBox);
	}
	
	public void clickNextButtonOnEventFee() {
		abs.click(nextButtonOnEventFee);
	}
	
	public boolean isConfirmTextPresent() {
		return abs.isWebElementPresent(confirmationTextLabel);
	}
	
	public String getConfirmationText() {
		return abs.getText(confirmationTextLabel);
	}
	
	public void waitForEventDatePresent() {
		abs.waitForElementPresent(eventDateDropDown, abs.maxTimeOut.intValue());
	}
	
	public void selectEventDate(int date) {
		abs.selectDropDownDataByText(eventDateDropDown, Integer.toString(date));
	}
	
	public void selectEventMonth(int month) {
		if(month>12) {
			month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		}
		abs.selectDropDownData(eventMonthDropDown, Integer.toString(month));
	}
	
	public void selectEventYear(int futureYear) {
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		if(futureYear<currYear) {
			futureYear = currYear;
		}
		abs.selectDropDownDataByText(eventYearDropDown, Integer.toString(futureYear));
	}
	
	public void clickNextButton() {
		abs.click(nextButton);
	}
	
	public String getCharityHeading() {
		return charityHeading.getText();
	}
	
	public boolean isLoadMoreCharityButtonPresent() {
		return abs.isWebElementPresent(loadMoreCharityButton);
	}
	
	public boolean isInviteToRegisterLinkPresent() {
		return abs.isWebElementPresent(inviteToRegisterlink);
	}
	
	public void addCharities(int count) {
		if(!(count<=plusIcons.size())) {
			count=plusIcons.size();
		}
		for(WebElement we : plusIcons) {
			abs.click(we);
			if(plusIcons.indexOf(we)==count-1)
				break;
		}
	}
	
	public void waitForSearchResultsListSection() {
		abs.waitForElementPresent(searchResultsListSection, abs.maxTimeOut.intValue());
	}
}