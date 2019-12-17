Feature: Search cartity or fundraiser or even globally 

  @SmokeTest
  @RegressionTest
  Scenario: User is able to sign up
    Given Open browser and start "<url>"
    When User navigates to Make a Donation tab
    And User select search for a fundraiser or charity "Test"
    Then User is dispalyed top "5" Fundraisers
    And User is Donate button for Fundraisers search results
    And User is displayed load more button for Fundraisers search results
    Then User is displayed top "5" Charities
    And User is dispalyed Donate button for Charities search results
    And User is dispalyed load more button for Charities search results
    Then User is displayed top "5" Events
    And User is displayed Start Fundraising button for Events search results
    And User is displayed load more button for Events search results
    
      