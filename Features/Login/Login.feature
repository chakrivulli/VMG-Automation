Feature: Login to Fundraiser application

  @SmokeTest
  Scenario Outline: User is able to perform login with valid email and valid password
    
Given Open browser and start "<url>"
    
And User clicks on signin button
    
When User enter valid "<username>" and "<password>"
    
Then User is dispalyed My Account

    
Examples: 
     | url                         | username      			    | 	password	 |
     
|/fundraiser-portal/userSignIn| VMGAutomation@test.vmg |   Cardinal27 |
      
 
	Scenario Outline: User is able to see error with valid email and invalid password
    Given Open browser and start "<url>"
    When User enter valid "<username>" and "<password>"
    Then Verify user is able to see error for invalid password

    Examples: 
       | url                         | username      			    | 	password	  |
       |/fundraiser-portal/userSignIn| vmgautomation@test.vmg |   Cardinal273 |
      


