Feature: Donate to campaign using Deeplink

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify donation to Campaign using deeplink - pay with card - new Donor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "vmgautomation"
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
      | url               |cardNumber      |cardHolderName|expiryMonth|expiryYear|cvv   |
      | /fund/vmgautomation |4444333322221111|test User     |09         |22        | 123  |
      
      

  @RegressionTest
  Scenario Outline: Verify donation to Campaign using deeplink - pay with paypal - new donor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "vmgautomation"
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
      | /fund/vmgautomation |
      

  @RegressionTest
  Scenario Outline: Verify donation to Campaign using deeplink - pay with Card - GUestDonor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "vmgautomation"
    When Enter amount "1"
   	And Enters message "test message"
    And Click pay by card
		And User enters an email address "surekha1234@prod.vmg"
		And Verify donation amount "1"
		And User clicks on continue as guest
    And User enters data like firstName lastName and address
    And User clicks continue
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
      | url               |cardNumber      |cardHolderName|expiryMonth|expiryYear|cvv   |
      | /fund/vmgautomation |4444333322221111|test User     |09         |22        | 123  |
      

  @RegressionTest
  Scenario Outline: Verify donation to Campaign using deeplink - pay with paypal - guest donor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "vmgautomation"
    When Enter amount "1"
   	And Enters message "test message"
 		And Click pay by PayPal
		When User enters an "vmgtest003@gmail.com" and "Cardinal27"
		And User enters an email address "surekha1234@prod.vmg"
    And Verify donation amount "1"
		And User clicks on continue as guest
    And User enters data like firstName lastName and address
    And User clicks continue
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    Examples: 
      | url                 |
      | /fund/vmgautomation |
      
      
  @RegressionTest
  Scenario Outline: Verify donation to Campaign using deeplink - pay with card - Existing donor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "vmgautomation"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by card
    When User enter valid "<username>" and "<password>"
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
      | url                 |cardNumber      |cardHolderName|expiryMonth|expiryYear|cvv   |
      | /fund/vmgautomation |4444333322221111|test User     |09         |22        | 123  |
      

  @RegressionTest
  Scenario Outline: Verify donation to Campaign using deeplink - pay with paypal - Existing donor
    Given Open browser and start "<url>"
    When User clicks on GiveNow button
    And Verity Title "vmgautomation"
    When Enter amount "1"
   	And Enters message "test message"
 		And Click pay by PayPal
		When User enters an "vmgtest003@gmail.com" and "Cardinal27"
    When User enter valid "vmgautomation@test.vmg" and "Cardinal27"
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    Examples: 
      | url                 |
      | /fund/vmgautomation |