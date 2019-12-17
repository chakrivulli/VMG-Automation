package com.vmg.pagefactory;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class MakeDonenationPage 
{

	AbstractPage abs ;
	
	@FindBy(id="q")
	WebElement friendOrCharitySearchBox;

	@FindBy(id="btn-generic-search")
	WebElement searchButton;
	
	@FindBy(xpath="//span[@id='fundraiserResultCount']/following::a[text()='Donate'][1]")
	WebElement firstSearchResult;
	
	@FindBy(id="donation-type-Charity")
	WebElement charityTitleLable;
	
	@FindBy(id="donation-type-Fundraiser")
	WebElement fundraiserTitleLable;
	
	@FindBy(xpath="//span[@id='charityResultCount']/following::a[text()='Donate'][1]")
	WebElement firstCharitySearchResult;
	
	@FindBy(xpath="//span[@id='campaignResultCount']/following::a[text()='Donate'][1]")
	WebElement firstCampaignSearchResultDonateButton;
	
	@FindBy(xpath="//span[@id='campaignResultCount']/following::h4[1]")
	WebElement firstCampaignSearchResultHeading;
	
	@FindBy(xpath="//div[@id='campaignFundraisers']/descendant::h4[1]")
	WebElement firstCampaignLinkedFundraiser;
	
	@FindBy(id="donate-link")
	WebElement fudraiserDonateButton;
	
	@FindBy(id="field-donate-value")
	WebElement donationAmountField;
	
	@FindBy(id="radio-monthly")
	WebElement payMonthlyRadio;
	
	@FindBy(id="donation-date")
	WebElement mothlyDonationDateOption;
	
	@FindBy(id="donation-month")
	WebElement monthlyDonationMonthOption;
	
	@FindBy(xpath="//input[@value='another-card']")
	WebElement selectAnotherCard;
	
	@FindBy(id="nickName")
	WebElement donorNickNameField;
	
	@FindBy(id="feePaidByDonor")
	WebElement feePaidBydonorCheckBox;
	
	@FindBy(id="showDonationOnPage")
	WebElement showDonationOnPageCheckBox;
	
	@FindBy(id="btn-submit-payment")
	WebElement payByCardButton;
	
	@FindBy(id="header_donation-amount")
	WebElement donationAmountOnPayByCard;
	
	@FindBy(id="btn-sign-in")
	WebElement continueAsGuestButton;
		
	@FindBy(id="paypal-button")
	WebElement paypalButton;
	
	@FindBy(id="comment")
	WebElement messageTextArea;
	
	@FindBy(id="emailAddress")
	WebElement emailAddressField;
	
	@FindBy(xpath="//a[text()='(Not you?)']")
	WebElement notYouLink;
	
	@FindBy(id="btn-sign-in")
	WebElement continueButton;
	
	@FindBy(id="first-name")
	WebElement firstNameField;
	
	@FindBy(id="last-name")
	WebElement lastNameField;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(id="registerAccount")
	WebElement setUpAnAccountCheckBox;
	
	@FindBy(xpath="//div[@class='pcaautocomplete pcatext']/div[@class='pca pcalist'][1]/div[@class='pcaitem'][1]")
	WebElement addressAutoFillFirstItem;
	
	@FindBy(id="manual-address-btn")
	WebElement enterAddressManualButton;
	
	@FindBy(id="AddressAreaSingleField")
	WebElement addressAreaSingleFieldLabel;
	
	@FindBy(id="first-line-address")
	WebElement firstLineAddressField;
	
	@FindBy(id="second-line-address")
	WebElement secondLineAddressField;
	
	@FindBy(id="city-town-address")
	WebElement cityTownAddressField;
	
	@FindBy(id="county-address")
	WebElement countyAddressField; 
	
	@FindBy(id="postcode-address")
	WebElement postcodeAddressField;
	
	@FindBy(id="country-address")
	WebElement countryAddressFeild;
	
	@FindBy(id="over18Ind-yes")
	WebElement over18YesRadio;
	
	@FindBy(id="over18Ind-no")
	WebElement over18NoRadio;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="confirm-password")
	WebElement confirmPassword;
	
	@FindBy(id="btn-register")
	WebElement signUpButton;
	
	@FindBy(id="btn-sign-in_iframe")
	WebElement signInBtnInMiddle;
	
	@FindBy(id="giftAidYes")
	WebElement giftAidYesRadio;
	
	@FindBy(id="giftAidCheck1")
	WebElement giftAidCheckBox1;
	
	@FindBy(id="giftAidCheck2")
	WebElement giftAidCheckBox2;
	
	@FindBy(id="giftAidCheck3")
	WebElement giftAidCheckBox3;
	
	@FindBy(id="giftAidCheck4")
	WebElement giftAidCheckBox4;
	
	@FindBy(id="giftAidCheck5")
	WebElement iAmNotRelatedToFundraiserCheckBox;
	
	@FindBy(id="giftAidNo")
	WebElement giftAidNoRadio;
	
	@FindBy(id="btn-giftaid")
	WebElement continueGiftButton;
	
	@FindBy(id="contactByVMGIndicator")
	WebElement contactByVMGIndicatorCheckBox;
	
	@FindBy(id="btn-confirmation")
	WebElement nextButton;
	
	@FindBy(xpath="//strong[text()='TEST VALLEY CITIZENS ADVICE BUREAU']/../input")
	WebElement testValleyCitizensAdviceBureauCheckBox;
	
	@FindBy(xpath="//strong[text()='FutureSense Foundation']/../input")
	WebElement futureSenseFoundationCheckBox;
	
	@FindBy(id="contactByFundraiserIndicator")
	WebElement contactByFundraiserIndicatorCheckBox;
	
	@FindBy(id="agreeToAgreement")
	WebElement agreeToAgreementCheckBox;
	
	@FindBy(id="cardNumber")
	WebElement cardNumberField;
	
	@FindBy(id="cardholderName")
	WebElement cardHolderNameField;
	
	@FindBy(id="expiryMonth")
	WebElement expiryMonthField;
	
	@FindBy(id="expiryYear")
	WebElement expiryYearField;
	
	@FindBy(id="securityCode")
	WebElement securityCodeField;
	
	@FindBy(id="submitButton")
	WebElement makePaymentButton;
	
	@FindBy(xpath="//strong[text()='Amount']/../../p[2]")
	WebElement amountOnReviewDonation;
	
	@FindBy(name="rememberCardDetails")
	WebElement rememberCardDetailsCheckBox;
	
	public MakeDonenationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	public void clickSearchButton() {
		
		abs.click(searchButton);
	}
	
	public void clickFirstSearchResult() {
		abs.click(firstSearchResult);
	}
	
	public void clickFirstCharitySearchResult() {
		abs.click(firstCharitySearchResult);
	}
	
	public void clickOnFirstCharitySearchResult() {
		abs.click(firstCharitySearchResult);
	}
	
	public void clickFirstCampaignSearchResult() {
		abs.click(firstCampaignSearchResultDonateButton);
	}
	
	
	public void clickOnFirstCampaignSearchResult() {
		abs.click(firstCampaignSearchResultHeading);
	}
	
	public void enterDataInCharitySearch(String data){
		abs.type(friendOrCharitySearchBox, data);
	}
	
	public void enterDonationAmount(String amount){
		abs.type(donationAmountField, amount);
	}
	
	public void enterMessage(String message) {
		abs.type(messageTextArea, message);
	}
	
	public void enterDonorNickName(String name){
		abs.type(donorNickNameField,name);
	}
	
	public boolean isFeePaidByDonorChecked() {
		
		return feePaidBydonorCheckBox.isSelected();
	}
	
	public boolean isShowDonationOnPageChecked() {
		
		return showDonationOnPageCheckBox.isSelected();
	}
	
	public void checkFeePaidByDonor(boolean status) {
		if(status) {
			if(!isFeePaidByDonorChecked()) {
				abs.click(feePaidBydonorCheckBox);
			}else {
				System.out.println("Fee Paid check box is already checked");
			}
		}else {
			if(isFeePaidByDonorChecked()) {
				abs.click(feePaidBydonorCheckBox);
			}else {
				System.out.println("Fee Paid check box is already unchecked");
			}
		}
	}
	
	public void checkShowDonationOnPage(boolean status) {
		if(status) {
			if(!isShowDonationOnPageChecked()) {
				abs.click(showDonationOnPageCheckBox);
			}
		}else {
			
		}
	}
	
	public void UncheckShowDonationOnPage() {
			if(isShowDonationOnPageChecked()) {
				abs.click(showDonationOnPageCheckBox);
			}
	}
	public void clickPayByCard() {
		abs.click(payByCardButton);
	}
	
	public void verifyDonationAmount(String amount) {
		boolean res = abs.getText(donationAmountOnPayByCard).contains(amount);
		Assert.assertTrue(res);
	}
	public void clickPayByPayPal() {
		abs.click(paypalButton);
		
	}
	
	public void enterEmail(String email){
		abs.type(emailAddressField,email);
	}
	
	public void clickContinueButton() {
		abs.click(continueButton);
	}
	
	public void clickNotYouLink() {
		abs.click(notYouLink);
	}
	
	public void enterAddress(String add) throws Exception {
		abs.type(address, add);
		abs.waitForElementPresent(addressAutoFillFirstItem, 60);
		abs.click(addressAutoFillFirstItem);
		boolean res = abs.isWebElementPresent(addressAreaSingleFieldLabel);
		System.out.println("+++"+res);
		if(!res) {
			abs.click(enterAddressManualButton);
			enterAddressManually("Loqate", "Waterside, Basin Road", 
					"Worcester", "Worcestershire",
					"WR5 3DA", "United Kingdom");
		}
	}
	
	public void clickEnterAddressManualButton() {
		abs.click(enterAddressManualButton);
	}
	
	/*public void enterAddressManually(String firstLineAdd, String secondLineAdd, 
			String city, String county, String postalCode, String country) throws Exception {
			abs.click(enterAddressManualButton);
			enterAddressManually("Loqate", "Waterside, Basin Road", 
					"Worcester", "Worcestershire",
					"WR5 3DA", "United Kingdom");
	}*/
	
	public void uncheckSetUpAnAccount() {
		abs.click(setUpAnAccountCheckBox);
	}
	public void enterPassword(String psw){
		final String pass = psw;
		//abs.switchToFrame(0, false);
		abs.type(passwordField,pass);
		//passwordField.sendKeys(pass);
		abs.type(confirmPassword,pass);
		//confirmPassword.sendKeys(pass);
	}

	public void enterPasswordOnce(String pass) {
		abs.type(passwordField,pass);
	}
	
	public void clickSignUpButton() {
		abs.click(signUpButton);
	}
	
	public void clickSignInBtnInMiddle() {
		abs.click(signInBtnInMiddle);
	}
	
	public void clickGiftAidYes() {
		abs.click(giftAidYesRadio);
	}
	
	public void clickGiftAidYesWithAllChecks() throws InterruptedException {
		abs.click(giftAidYesRadio);
		abs.wait(10);
		abs.waitForElementPresent(giftAidCheckBox1, 60);
		abs.wait(10);
		abs.waitForElementClickable(giftAidCheckBox1, abs.maxTimeOut);
		abs.click(giftAidCheckBox1);
		abs.waitForElementPresent(giftAidCheckBox2, 60);
		abs.click(giftAidCheckBox2);
		abs.waitForElementPresent(giftAidCheckBox3, 60);
		abs.click(giftAidCheckBox3);
		abs.waitForElementPresent(giftAidCheckBox4, 60);
		abs.click(giftAidCheckBox4);
	}
	
	public void selectIAmNotRelatedToFundraiser() {
		abs.click(iAmNotRelatedToFundraiserCheckBox);
	}
	
	public void clickGiftAidNo() {
		abs.click(giftAidNoRadio);
	}
	
	public void clickContinueGift() {
		abs.click(continueGiftButton);
	}

	
	public void enterCardNumber(String cardNumber) {
		abs.type(cardNumberField, cardNumber);
	}
	
	public void enterCardHolderName(String cardHolderName) {
		abs.type(cardHolderNameField, cardHolderName);
	}
	
	public void enterMonthOfExpiry(String expiryMonth) {
		abs.type(expiryMonthField, expiryMonth);
	}
	
	public void enterYearofExpiry(String expiryYear) {
		abs.type(expiryYearField, expiryYear);
	}
	
	public void enterCVV(String cvv) {
		abs.type(securityCodeField, cvv);
	}
	
	public void clickMakeDonation() {
		abs.click(makePaymentButton);
	}
	public boolean isPaymentStatusTextPresent(String paymentStatus) {
		return abs.isTextPresent(paymentStatus);
	}
	
	public String getCharityTitle() {
		return abs.getText(charityTitleLable);
	}
	
	public String getFundraiserTitle() {
		return abs.getText(fundraiserTitleLable);
	}
	
	public void clickContinueAsGuest() {
		abs.click(continueAsGuestButton);
	}
	
	public void selectPay() {
		abs.click(payMonthlyRadio);
	}
	
	public void selectMonthlyDonationDate(String date) {
		abs.selectDropDownData(mothlyDonationDateOption, date);
	}
	
	public void selectMonthlyDonationMonth(String month) {
		abs.selectDropDownDataByText(monthlyDonationMonthOption, month);
	}
	
	public boolean isSelectAnotherCardRadioExists() {
		return abs.isWebElementPresent(selectAnotherCard);
	}
	
	public void clickSelectAnotherCard() {
		abs.click(selectAnotherCard);
	}
	
	public void verifyAmountOnReviewDonation(String amount) {
		String actualAmt = abs.getText(amountOnReviewDonation);
		boolean res = actualAmt.contains(amount);
		System.out.println("Exp:"+amount+",Actual:"+actualAmt);
		Assert.assertTrue(res);
	}
	
	public void uncheckRememberCardDetailsOnReviewDonation() {
		abs.click(rememberCardDetailsCheckBox);
	}
	
	public void verifyFirstCharityDonationButtoDisabled() {
		boolean res = abs.isWebElementClickable(firstCharitySearchResult);
		Assert.assertFalse(res);
	}
	
	public void selectFirstCampaignLinkedFundraiser() {
		abs.click(firstCampaignLinkedFundraiser);
	}
	
	public void clickFundraiserDonateButton() {
		abs.click(fudraiserDonateButton);
	}
	
	public void enterAddressManually(String firstLineAdd, String secondLineAdd, 
			String city, String county, String postalCode, String country) {
		abs.type(firstLineAddressField, firstLineAdd);
		abs.type(secondLineAddressField, secondLineAdd);
		abs.type(cityTownAddressField, city);
		//abs.updateText(cityTownAddressField, Keys.TAB);
		abs.pressTab(cityTownAddressField);
		abs.type(countyAddressField, county);
		abs.pressTab(countyAddressField);
		abs.type(postcodeAddressField, postalCode);
		abs.pressTab(postcodeAddressField);
		abs.selectDropDownDataByText(countryAddressFeild, country);
	}
	
	public void selectOver18YesRadio() {
		abs.click(over18YesRadio);
	}
	
	public void selectOver18NoRadio() {
		abs.click(over18NoRadio);
	}
	
	public void selectTestValleyCitizensAdviceBureauCheckBox() {
		abs.click(testValleyCitizensAdviceBureauCheckBox);
	}
	
	public boolean isTestValleyCitizensAdviceBureauCheckBoxPresent() {
		return abs.isWebElementAbscent(testValleyCitizensAdviceBureauCheckBox);
	}
	
	public void selectFutureSenseFoundationCheckBoxCheckBox() {
		abs.click(futureSenseFoundationCheckBox);
	}
	
	public boolean isFutureSenseFoundationCheckBoxCheckBoxPresent() {
		return abs.isWebElementAbscent(futureSenseFoundationCheckBox);
	}
	
	public void selectContactByFundraiserIndicatorCheckBox() {
		abs.click(contactByFundraiserIndicatorCheckBox);
	}
	
	public boolean isContactByFundraiserIndicatorCheckBoxPresent() {
		return abs.isWebElementAbscent(contactByFundraiserIndicatorCheckBox);
	}
	
	public void clickNextButton() {
		abs.click(nextButton);
	}
}



