Feature: Make donation using card to Fundraiser

  @SmokeTest
  @RegressionTest
  Scenario Outline: User is able to sign up
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Test"
    When User select first of campaign
    When Enter amount "1"
    And Enters message "test message" donation transaction fee "True" and show amount "True" checkboxes
		And Click pay by PayPal
		When User enters an "Vmgtest002@gmail.com" and "C@rdinal27"
		When User enters an email address
		And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    Then Verify donation successfull

    Examples: 
       | username      			| 	password	| cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
       | ginaedkins@gmail.com |   Test1990 |268899747383|test User|09|22|123|
      