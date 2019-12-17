Feature: Sign up to Fundraiser application

  @SmokeTest
  Scenario Outline: User is able to sign up
    Given Open browser and start "<url>"
    When User navigates to signUp page
    When User enters valid email address
    And User enters valid required data like firstName lastName and address
    And User enters valid password
    Then Verify user is successfully signed up
		Examples: 
      | url|
      |/fundraiser-portal/userSignIn|
