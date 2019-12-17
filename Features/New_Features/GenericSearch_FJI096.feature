Feature: Search cartity or fundraiser or even globally 

  @SmokeTest
  @RegressionTest
  Scenario: User is able to sign up
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "campaign"
    Then User is dispalyed top "5" Campaigns
    And User is Donate button for Campaigns search results
    And User is displayed load more button for Campaigns search results
    And User is displayed Campaign attributes
    
    
      