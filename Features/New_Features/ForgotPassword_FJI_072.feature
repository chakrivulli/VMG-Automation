Feature: Login to Fundraiser application

#FJI_072 Verification of valid email address for the forgot password
  @SmokeTest
  Scenario Outline: User is able to perform login with valid email and valid password
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    When User clicks on Forgot password link
    When User enter the invalid "<Email>" address
    And User clicks on Send Temporary password button
    Then Verify system displayed Error message for invalid email

    Examples: 
     | url                         | username      			    | 	password	 | Email |
     |/fundraiser-portal/userSignIn| surekaauto@test.vmg   |   Cardinal27 | surekenomail@test.vmg|