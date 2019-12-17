Feature: Donate to Fundraiser linked to Campaign as a guest donor

  @SmokeTest
  Scenario: Verify donate to Fundraiser linked to Campaign as a guest donor with paypal
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "LLST Test Campaign 2018"
    When User clicks on first of campaign
    And Selects campaign first linked fundraiser
    When Enter amount "1"
    And Enters message "test message"
		And Click pay by PayPal
		When User enters an "vmgtest003@gmail.com" and "C@rdinal27"
		When User enters an email address
    And Verify donation amount "1"
    And User unchecks setup an account
    And User enters data like firstName lastName and address
    And User clicks continue
    When User selects "Yes" to gift aid
    Then Verify donation successfull
    