@Login
Feature: VMG Fundariser login
  This feature verifies the functionality on VMG Homepage
  
 
@Login
  Scenario Outline: Check fundariser login works
    Given Open browser and start "https://uk.virginmoneygiving.com/fundraiser-portal/userSignIn"
    And User set cookies
      | JSESSIONID | <JSESSIONID> |
      | vmgdc      | <vmgdc>      |
    When User enter valid "surekha1234@prod.vmg" and "pavankumar1"
    Then Login should be successful with cookiee values
			| JSESSIONID | <JSESSIONID> |
      | vmgdc      | <vmgdc>      |
    Examples: 
      | Result  | JSESSIONID | vmgdc |
      | Success |          fail1| B   |      
      | Success |          fail2| B   |
      
      @Login
  Scenario Outline: Check fundariser login works
    Given Open browser and start "https://uk.virginmoneygiving.com/charity-web/charity/charityportal.action"
    And User set cookies
      | JSESSIONID | <JSESSIONID> |
      | vmgdc      | <vmgdc>      |
    When User logs in to charity with "java.applications@virginmoney.com" and "telephone!"
    Then Charity Login should be successful with cookiee values
			| JSESSIONID | <JSESSIONID> |
      | vmgdc      | <vmgdc>      |
    Examples: 
      | Result  | JSESSIONID | vmgdc |
      | Success |          fail1| B   |      
      | Success |          fail2| B   |
      
      
    Scenario Outline: New Donor -Donation to a fundariser - Pay By Card
    Given Open browser and start "<url>"
    And User clicks Don't show me this again
    And User set cookies
      | JSESSIONID | <JSESSIONID> |
      | vmgdc      | <vmgdc>      |
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Test"
    When User select first of fundraisers
    When Enter amount "1"
    And Enters message "test message" donation transaction fee "True" and show amount "True" checkboxes 
		And Click pay by card
		When User enters an email address
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    Then Login should be successful with cookiee values
			| JSESSIONID | <JSESSIONID> |
      | vmgdc      | <vmgdc>      |
    Examples: 
      | Result  | JSESSIONID    | vmgdc |
      | Success |          prod1| A   |
      | Success |          prod2| A   |
      | Success |          prod3| A   |      
      | Success |          prod4| A   |
      | Success |          prod5| A   |
      | Success |          prod6| A   |
      | Success |          fail1| B   |      
      | Success |          fail2| B   |
      | Success |          fail3| B   |      
      | Success |          fail4| B   |
      | Success |          fail5| B   |      
      | Success |          fail6| B   |


    Examples: 
      | url                                                      			| username      			| 	password	| cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | https://uk.virginmoneygiving.com/fundraiser-portal/userSignIn | ginaedkins@gmail.com |   Test1990 |268899747383|test User|09|22|123|
      
    
     

