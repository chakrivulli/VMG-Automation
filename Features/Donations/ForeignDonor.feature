Feature: Make donation to Fundraiser as a foreign donor using foreign card

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify foreigner is able to donate using foreign card
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Test"
    When User select first of fundraisers
    When Enter amount "1"
    And Enters message "test message" donation transaction fee "True" and show amount "True" checkboxes 
		And Click pay by card
		When User enters an email address
    And User enters first name
    And User enters last name
    And User enters address manually
    And User enters valid password and confirm password
    When Clicks terms&conditions and donate
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull

    Examples: 
       | username      			| 	password	| cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
       | surekha1234@prod.vmg |   pavankumar1 |268899747383|test User|09|22|123|
      