Feature: Make monthly donation using card to charity as a logged in user

  @SmokeTest @RegressionTest
  Scenario Outline: User is able to sign up
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Test"
    When User select first of charity
    And User selects to pay monthly
    When Enter amount "1"
    And User selects to date "11" and month "August"
    And Select donation transaction fee "True"
    And Click pay by card
    When User selects "Yes" to gift aid only
    When Select use another card if user's card is saved
    And Verify amount "1" on Review Donation page
    And Clicks terms&conditions and donate
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull

    Examples: 
      | username             | password | cardNumber   | cardHolderName | expiryMonth | expiryYear | cvv |
      | ginaedkins@gmail.com | Test1990 | 268899747383 | test User      |          09 |         22 | 123 |
