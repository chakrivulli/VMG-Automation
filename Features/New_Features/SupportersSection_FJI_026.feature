Feature: Connect and disconnect application to Fundraiser account

  @SmokeTest
  Scenario Outline: Verify user is able to connect and disconnect app to Facebook account
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    And User navigates to My Fundraiser page to select "<FundraiserTitle>"
    Then User is displayed supporter name "<Supporters>" and donation amount "<DonationAmount>"
    Examples: 
      | url                         | username      			|password|FundraiserTitle|Supporters|DonationAmount|
      |/fundraiser-portal/userSignIn| ginaedkins@gmail.com|Test1990|		gina   		 |  Sonia   | 1.00        | 