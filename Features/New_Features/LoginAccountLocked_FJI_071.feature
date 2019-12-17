Feature: Login to Fundraiser application

#FJI_071 Verify that the account should be locked when user enters an invalid combination of email address & password for 3 consecutive attempts
@SmokeTest
Scenario Outline: User account is locked when user trys to login with invalid credentials multiple times
    
Given Open browser and start "<url>"
    
And User clicks on signin button
    
When User enter valid "<username>" and "<password>"

When User enter valid "<username>" and "<password>"

And User clicks on signin button

When User enter valid "<username>" and "<password>"
    
Then User account locked error message displayed

    
Examples: 
     | url                         | username      			    | 	password	 |
     
|/fundraiser-portal/userSignIn| surekaauto@test.vmg |   canada13574 |