Feature: Login to Fundraiser using Facebook

  @SmokeTest
  Scenario Outline: Verify user is able to login with Facebook credentials
    Given Open browser and start "<url>"
    And User clicks on signin button    
    When User enter facebook credential "<facebookId>" and "<facebookIdPassword>"
    When User completes filling profile
		#This scenario requires new Facebook data for each run
    Examples: 
      | facebookId      	 | 	facebookIdPassword	|
      |test222@gmail.com 	 |  password123  |