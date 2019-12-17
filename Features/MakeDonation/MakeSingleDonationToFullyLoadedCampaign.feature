Feature: Make a single donation to a campaign as logged in user with card by not you link

  @SmokeTest @RegressionTest
  Scenario Outline: Make a single donation to a campaign as logged in user with card
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "test"
    When User select first of campaign
    And Verity Title "test"
    When Enter amount "1"
		And Click pay by card
		When User enters an email address "surekha1234@prod.vmg"
		And Clicks Not you link
		And Click pay by card
		When User enters an email address
		And Verify donation amount "1"
    And User enters data like firstName lastName and address
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull

    Examples: 
      | username             | password | cardNumber   | cardHolderName | expiryMonth | expiryYear | cvv |
      | ginaedkins@gmail.com | Test1990 | 268899747383 | test User      |          09 |         22 | 123 |
