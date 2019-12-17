
package com.vmg.pagefactory;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventSearchPage 
{

	AbstractPage abs ;
		
	
	@FindBy(id="searchDescription")
	WebElement searchField;
	
	@FindBy(id="btn-eventSearch")
	WebElement nextBtn;
	
	@FindBy(xpath="//ul[@class='eventResults_List']/li")
	List<WebElement> eventResults;
	
	@FindBy(xpath="//ul[@class='eventResults_List']/li/descendant::h4")
	List<WebElement> eventResultsName;
	
	@FindBy(xpath="//ul[@class='eventResults_List']/li/descendant::p[1]")
	List<WebElement> eventResultsLocation;
	
	@FindBy(xpath="//ul[@class='eventResults_List']/li/descendant::p[2]")
	List<WebElement> eventResultsCharity;
	
	@FindBy(xpath="//ul[@class='eventResults_List']/li/descendant::img[1]")
	List<WebElement> eventResultsLogo; 
	
	@FindBy(xpath="//div[@id='eventResults']/descendant::strong[1]")
	WebElement textOnTopOfEventResults;
	
	public EventSearchPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		abs = new AbstractPage(driver);
	}
	
	public void enterSearch(String eventName) {
		abs.type(searchField, eventName);
	}
	
	public void clickNextButton() {
		abs.click(nextBtn);
	}
	
	public void verifyEventSearchResultsAttributes() {
		for(WebElement name:eventResults) {
			assertNotNull(name);
		}
		for(WebElement locDate:eventResultsLocation) {
			assertNotNull(locDate);
		}
		for(WebElement charity:eventResultsCharity) {
			assertNotNull(charity);
		}
		for(WebElement charity:eventResultsCharity) {
			assertNotNull(charity);
		}
		
		for(WebElement logo:eventResultsLogo) {
			assertNotNull(logo);
		}
	}
	
	public void verifyEventSearchResultsContainsSearchString(String searchString) {
		abs.wait(abs.maxTimeOut.intValue());
		for(WebElement name:eventResultsName) {
			String tempText = name.getText().toUpperCase();
			System.out.println(tempText);
			assertTrue(tempText.contains(searchString.toUpperCase()));
		}
	}
	
	public String verifyTextOnTopOfEventResults() {
		return textOnTopOfEventResults.getText();
	}
	
	
}

