Feature: Make donation using card to charity as Guest

  @SmokeTest
  @RegressionTest
  
Scenario Outline: User is able to sign up
    
Given Open browser and start "<url>"
    
When User navigates to Make a Donation tab
    
And User select search for a fundraiser or charity "Friends Of Conservation"
    
When  User select first of charity
    
And Verity Title "Friends Of Conservation"
    
When Enter amount "1"
   	
And Enters message "test message"
		
And Click pay by card
		
And User enters an email address "surekha1234@prod.vmg"
		
And Verify donation amount "1"
		
And User clicks on continue as guest
    
And User enters data like firstName lastName and address
    
And User clicks continue
    
When User selects "Yes" to gift aid
    
When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    
Then Verify donation successfull

    
Examples: 
        
| username      			| 	password	| cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
        
| ginaedkins@gmail.com |   Test1990 |268899747383|test User|09|22|123|
      