Feature: Make donation using card to Fundraiser

  @SmokeTest
  @RegressionTest
  Scenario Outline: User is able to sign up
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Test"
    When User select first of fundraisers
    When Enter amount "1"
    And Enters message "test message" donation transaction fee "True" and show amount "True" checkboxes 
		And Click pay by card
   	And User enters an email address "<username>"
   	And User enters password "<password>"
    When User selects No to gift aid
    And Clicks terms&conditions and donate
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull

    Examples: 
       | username      			| 	password	| cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
       | guzzmenow@gmail.com |   Welcome1$ |268899747383|test User|09|22|123|
      