Feature: Donate to charity using Deeplink

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify donation to Charity using deeplink - pay with card - new Donor
    Given Open browser and start "<url>"
    When User clicks on make a donation button
    And Verity Title "Callum Pite's Smile Charity"
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
      | url                                     |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | /charity-web/charity/finalCharityHomepage.action?charityId=1007597 |4444333322221111|test User|09|22|123|
      
 @RegressionTest
  Scenario Outline: Verify donation to Charity using deeplink - pay with paypal - new Donor
    Given Open browser and start "<url>"
    When User clicks on make a donation button
    And Verity Title "Callum Pite's Smile Charity"
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
      | url                                     |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | /charity-web/charity/finalCharityHomepage.action?charityId=1007597 |4444333322221111|test User|09|22|123|
      
        @RegressionTest
  Scenario Outline: Verify donation to Charity using deeplink - pay with card - Guest Donor
    Given Open browser and start "<url>"
    When User clicks on make a donation button
    And Verity Title "Callum Pite's Smile Charity"
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
      | url                                     |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | /charity-web/charity/finalCharityHomepage.action?charityId=1007597 |4444333322221111|test User|09|22|123|
      
 @RegressionTest
  Scenario Outline: Verify donation to Charity using deeplink - pay with paypal - Guest Donor
    Given Open browser and start "<url>"
    When User clicks on make a donation button
    And Verity Title "Callum Pite's Smile Charity"
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
      | url                                     |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | /charity-web/charity/finalCharityHomepage.action?charityId=1007597 |4444333322221111|test User|09|22|123|
      
        @RegressionTest
  Scenario Outline: Verify donation to Charity using deeplink - pay with card - Existing Donor
    Given Open browser and start "<url>"
    When User clicks on make a donation button
    And Verity Title "Callum Pite's Smile Charity"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by card
    When User enter valid "vmgautomation@test.vmg" and "Cardinal27"
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
      | url                                     |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | /charity-web/charity/finalCharityHomepage.action?charityId=1007597 |4444333322221111|test User|09|22|123|
      
 @RegressionTest
  Scenario Outline: Verify donation to Charity using deeplink - pay with paypal - Existing Donor
    Given Open browser and start "<url>"
    When User clicks on make a donation button
    And Verity Title "Callum Pite's Smile Charity"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by card
    When User enter valid "vmgautomation@test.vmg" and "Cardinal27"
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
      | url                                     |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | /charity-web/charity/finalCharityHomepage.action?charityId=1007597 |4444333322221111|test User|09|22|123|