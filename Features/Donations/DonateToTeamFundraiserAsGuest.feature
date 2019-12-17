Feature: Donate to team Fundraiser page as a guest donor

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify donate to team Fundraiser page as a guest donor with card
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "<charityName>"
    When User select first of fundraisers
    And Verity Fundraiser Title "<title>"
    When Enter amount "1"
    And User unchecks show my donation on page
		And Click pay by card
		When User enters an email address
		And Verify donation amount "1"
    And User unchecks setup an account
    And User enters data like firstName lastName and address
    And User clicks continue
    When User selects "Yes" to gift aid with I am not related to fundraiser
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    
    Examples: 
      |charityName|title |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      |Test123|Test123|268899747383|test User|09|22|123|