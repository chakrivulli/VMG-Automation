Feature: Login to Fundraiser using Facebook

  @SmokeTest
  Scenario Outline: Verify user is able to login with Facebook credentials
    Given Open browser and start "<url>"
    And User clicks on signin button    
    When User enter facebook credential "<facebookId>" and "<facebookIdPassword>"
    Then Verify facebook signout is present
    And Verify user is asked to Complete profile

    Examples: 
      | facebookId      	 			 |facebookIdPassword	|
      |facebookLoginId 	 |facebookLoginPassword |