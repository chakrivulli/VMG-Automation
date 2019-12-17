Feature: Donate to Fundraiser using Deeplink

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify donation to Fundraiser using deeplink - pay with card - new Donor
    Given Open browser and start "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "<title>"
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
      | url           |title|cardNumber   |cardHolderName|expiryMonth|expiryYear|cvv|
      | /TestTest200 |Test Test|268899747383 |test User     |09         |22        |123|     
      

  @RegressionTest
  Scenario Outline: Verify donation to Fundraiser using deeplink - pay with paypal - new donor
    Given Open browser and start "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "<title>"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by PayPal
		When User enters an "Vmgtest002@gmail.com" and "C@rdinal27"
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    Examples: 
      | url                 |title|
      | /TestTest200     |Test Test|
      


  @RegressionTest
  Scenario Outline: Verify donation to Fundraiser using deeplink - pay with card - Guest donor
    Given Open browser and start "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "<title>"
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
      | url          |title|cardNumber   |cardHolderName|expiryMonth|expiryYear|cvv|
      | /TestTest200 |Test Test|268899747383 |test User     |09         |22        |123|     
      

  @RegressionTest
  Scenario Outline: Verify donation to Fundraiser using deeplink - pay with paypal - Guest donor
    Given Open browser and start "<url>"
    #When User clicks on GiveNow button
    When User clicks on Donate button
    And Verity Fundraiser Title "<title>"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by PayPal
		When User enters an "Vmgtest002@gmail.com" and "C@rdinal27"
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    Examples: 
      | url                 |title|
      | /TestTest200        |Test Test|
      
      
  @RegressionTest
  Scenario Outline: Verify donation to Fundraiser using deeplink - pay with card - Existing donor
    Given Open browser and start "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "<title>"
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
      | url          |title|cardNumber   |cardHolderName|expiryMonth|expiryYear|cvv|
      | /TestTest200 |Test Test|268899747383 |test User     |09         |22        |123|     
      

  @RegressionTest
  Scenario Outline: Verify donation to Fundraiser using deeplink - pay with paypal - Existing donor
    Given Open browser and start "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "<title>"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by PayPal
		When User enters an "Vmgtest002@gmail.com" and "C@rdinal27"
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    Examples: 
      | url                 |title|
      | /TestTest200        |Test Test|