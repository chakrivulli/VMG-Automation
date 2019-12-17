Feature: Donation History

  @SmokeTest @RegressionTest
  Scenario Outline: Verify Donation History
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    When User navigates to My Donations page
    Then Verify My donation history heading
    Then Verify Regular giving heading
    When User clicks on view details button
    Then Verify Total donations heading
    Then Verify donation details are shown

    Examples: 
      | username             | password | cardNumber   | cardHolderName | expiryMonth | expiryYear | cvv |
      | ginaedkins@gmail.com | Test1990 | 268899747383 | test User      |          09 |         22 | 123 |
