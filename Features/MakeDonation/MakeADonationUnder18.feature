Feature: Make donation using card to Fundraiser

  @SmokeTest
  @RegressionTest
  Scenario Outline: User is able to sign up
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Georgina Edkins gina"
    When User select first of fundraisers
    When Enter amount "1"
    And Enters message "test message" donation transaction fee "True" and show amount "True" checkboxes 
		And Click pay by card
		When User enters an email address
    And User enters data like firstName lastName and address
    And User selects I am under 18 option
    And User enters valid password and confirm password
    When User selects "Yes" to gift aid and click continue
    And Verify VMG marketing & Fundraiser contact consent questions not displayed
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull

    Examples: 
      | username      			| 	password	| cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | ginaedkins@gmail.com |   Test1990 |268899747383|test User|09|22|123|
      