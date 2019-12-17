Feature: Forgot password

  @SmokeTest
  Scenario Outline: User is able to reset password using forgotten password feature
    Given Open browser and start "<url>"
    When User enter valid "<username>" and hits forgotten password
    #Use only gmail
    Then User is shared temporty password to login and reset password using "<gmailId>" and "<gmailPassword>"

    Examples: 
     | url                         | username      			 | 	password	 |gmailId|gmailPassword|
     |/fundraiser-portal/userSignIn| test222@gmail.com |   Cardinal27 |test222@gmail.com|password123$|