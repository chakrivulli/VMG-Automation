Feature: Login to Fundraiser using Facebook

  @SmokeTest
  Scenario Outline: Verify user is able to login with Facebook credentials
    Given Open browser and start "<url>"
    And User clicks on signin button    
    When User enter facebook credential "<facebookId>" and "<facebookIdPassword>"
    When User is displayed "We just need a few more details" text
		#This scenario requires new Facebook data for each run
    Examples: 
      | facebookId|facebookIdPassword|
      |0000000000 |   Welcome1$      |