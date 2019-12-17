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