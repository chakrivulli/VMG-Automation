Feature: Login to Fundraiser application

  
@SmokeTest
  
Scenario Outline: User is able to perform login with valid email and valid password
    
Given Open browser and start "<url>"
    
And User clicks on signin button
    
When User enter valid "<username>" and "<password>"
    
And User is dispalyed My Account

    
When User clicks on My Account 
And User clicks on close account checkbox
And User clicks on close account button
Then Verify whether account closed or not

Examples: 
     | url                         | username      			    | 	password	 |
     
|/fundraiser-portal/userSignIn| surekaauto@test.vmg  |   canada1357 |