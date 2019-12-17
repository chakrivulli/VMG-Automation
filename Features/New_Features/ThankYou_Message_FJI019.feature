Feature: Edit page for Raise fund in Memory

  @SmokeTest2
  Scenario Outline: Verify user is able to edit a team 
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
   	Then User is dispalyed My Account
    When User navigates to My Fundraiser page
    And User selects a team
    And User clicks on team to edit
    And User sets personalised email message for donors
    Then User is displayed "You've set a personalised email message for your donors."
    When Donate amount "1"
		And Click pay by card
    When User selects No to gift aid
    And Clicks terms&conditions and donate
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
       | username             | password    | cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
       | surekha1234@prod.vmg | pavankumar1 |268899747383|test User|09|22|123|
