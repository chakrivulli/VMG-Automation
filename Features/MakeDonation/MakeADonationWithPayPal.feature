Feature: Make donation using PayPal to Charity

  @SmokeTest
  @RegressionTest
  Scenario: User is able to sign up
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Test"
    When  User select first of charity
    When Enter amount "1"
    And Enters message "test message"
		And Click pay by PayPal
		When User enters an "vmgtest002@gmail.com" and "Cardinal27"
		And User enters an email address "surekha1234@prod.vmg"
    And Verify donation amount "1"
		And User clicks on continue as guest
    And User enters data like firstName lastName and address
    And User clicks continue
    When User selects "Yes" to gift aid
    Then Verify donation successfull

      