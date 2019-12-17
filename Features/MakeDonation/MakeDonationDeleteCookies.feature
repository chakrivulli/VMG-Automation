Feature: Make donation using card to charity as Guest

  @SmokeTest
  @RegressionTest
  Scenario Outline: User is able to sign up
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Friends Of Conservation"
    When  User select first of charity
    And Verity Title "Friends Of Conservation"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by card
    When User selects "Yes" to gift aid only
    When Select use another card if user's card is saved
    And Clicks terms&conditions and donate
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    And Verify donation is successfull
		When Delete all cookies and refresh
		When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Friends Of Conservation"
    When  User select first of charity
    And Verity Title "Friends Of Conservation"
    When Enter amount "1"
   	And Enters message "test message"
		And Click pay by card
		Then Verify user is asked to enter email
		   

    Examples: 
      | username      			| 	password	| cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | ginaedkins@gmail.com |   Test1990 |268899747383|test User|09|22|123|
      