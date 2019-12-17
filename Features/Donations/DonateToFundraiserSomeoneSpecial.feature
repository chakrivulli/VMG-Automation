Feature: Donate to Fundraiser linked to someone special with card

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify donation to Fundraiser someone special using card as a new user
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "For Test Mem"
    When User select first of fundraisers
    And Verity Fundraiser Title "Test Mem"
    When Enter amount "1"
    And Enters message "test message" donation transaction fee "True" and show amount "True" checkboxes 
		And Click pay by card
		When User enters an email address
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
  
    Examples: 
       |cardNumber  |cardHolderName|expiryMonth|expiryYear|cvv|
       |268899747383|test User     |09         |22        |123|