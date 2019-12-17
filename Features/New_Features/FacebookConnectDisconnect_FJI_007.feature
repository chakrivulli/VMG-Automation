Feature: Connect and disconnect application to Fundraiser account

  @SmokeTest
  Scenario Outline: Verify user is able to connect and disconnect app to Facebook account
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    And Connect with facebook if disconnected using credential "<facebookId>" and "<facebookIdPassword>"
    And Disconnect with facebook 
    #When User completes filling profile
		#This scenario requires new Facebook data for each run
    Examples: 
       | url                         | username      			    | 	password	 | facebookId      	 | 	facebookIdPassword	|
      |/fundraiser-portal/userSignIn| facebookLoginId |   appLoginPassword |facebookLoginId 	 |  facebookLoginPassword.  |