Feature: Deeplink to Tommy Splashathon Fundraiser pay with card|

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify donation to Tommy Splashathon Fundraiser using deeplink - pay with card - new donor
    Given Open browser and start "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "Donate to Ana Maria Ene's page"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by card
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
      | url          |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | /AnaMariaEne |268899747383|test User   |09         |22        |123|
      
      
        @RegressionTest
  Scenario Outline: Verify donation to Tommy Splashathon Fundraiser using deeplink - pay with paypal - new donor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "Test Test"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by PayPal
		When User enters an "vmgtest003@gmail.com" and "Cardinal27"
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    Examples: 
      | url                 |
      | /AnaMariaEne        |
      


  @RegressionTest
  Scenario Outline: Verify donation to Tommy Splashathon Fundraiser using deeplink - pay with card - Guest donor
    Given Open browser and start "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "Test Test"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by card
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
      | url          |cardNumber   |cardHolderName|expiryMonth|expiryYear|cvv|
      | AnaMariaEne  |268899747383 |test User     |09         |22        |123|     
      

  @RegressionTest
  Scenario Outline: Verify donation to Tommy Splashathon Fundraiser using deeplink - pay with paypal - Guest donor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "Test Test"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by PayPal
		When User enters an "vmgtest003@gmail.com" and "Cardinal27"
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    Examples: 
      | url                 |
      | /AnaMariaEne         |
      
      
  @RegressionTest
  Scenario Outline: Verify donation to Tommy Splashathon Fundraiser using deeplink - pay with card - Existing donor
    Given Open browser and start "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "Test Test"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by card
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
      | url           |cardNumber   |cardHolderName|expiryMonth|expiryYear|cvv|
      | /AnaMariaEne  |268899747383 |test User     |09         |22        |123|     
      

  @RegressionTest
  Scenario Outline: Verify donation to Tommy Splashathon Fundraiser using deeplink - pay with paypal - Existing donor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "Test Test"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by PayPal
		When User enters an "vmgtest003@gmail.com" and "Cardinal27"
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    Examples: 
      | url                  |
      | /AnaMariaEne         |