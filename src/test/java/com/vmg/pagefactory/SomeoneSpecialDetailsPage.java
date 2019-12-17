
package com.vmg.pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SomeoneSpecialDetailsPage 
{

	AbstractPage abs ;
	
	
	@FindBy(id="ss-first-name")
	WebElement ssFirstNameField;

	@FindBy(id="ss-last-name")
	WebElement ssLastNameField;
	
	@FindBy(id="ss-relationship")
	WebElement relationshipDropDown;
	
	@FindBy(id="btnSaveSomeoneSpecialDetails")
	WebElement ssNextButton;
	
	
	@FindBy(id="searchCharityDescription")
	WebElement searchCharityField;
	
	@FindBy(id="btn-charity-search")
	WebElement charitySearchButton;
	
	public SomeoneSpecialDetailsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	
	public void enterSS_FirstName(){
		abs.type(ssFirstNameField, abs.genarateString(10));
	}
	
	public void enterSS_LastName(){
		abs.type(ssLastNameField, abs.genarateString(10));
	}
	
	public void clickssNext() {
		abs.click(ssNextButton);
	}
	
	public void selectRelationship(String relation) {
		
		if(relation.equalsIgnoreCase("Other")) {
			abs.selectDropDownData(relationshipDropDown, "Other");
		} else {

			if ((relation.equalsIgnoreCase("Husband or wife")) | (relation.contains("usband"))
					| (relation.contains("USBAND")) | (relation.contains("ife")) | (relation.contains("IFE"))) {
				abs.selectDropDownData(relationshipDropDown, "Husband or wife");
			} else if (relation.equalsIgnoreCase("Partner")) {
				abs.selectDropDownData(relationshipDropDown, "Partner");
			} else if (relation.equalsIgnoreCase("Son or daughter")) {
				abs.selectDropDownData(relationshipDropDown, "Partner");
			} else if (relation.equalsIgnoreCase("Grandparent")) {
				abs.selectDropDownData(relationshipDropDown, "Grandparent");
			} else if (relation.equalsIgnoreCase("Grandchild")) {
				abs.selectDropDownData(relationshipDropDown, "Grandchild");
			} else if (relation.equalsIgnoreCase("Other family member")) {
				abs.selectDropDownData(relationshipDropDown, "Other family member");
			} else if (relation.equalsIgnoreCase("Friend")) {
				abs.selectDropDownData(relationshipDropDown, "Friend");
			} else if (relation.equalsIgnoreCase("Colleague")) {
				abs.selectDropDownData(relationshipDropDown, "Colleague");
			}
		}
	}
}

