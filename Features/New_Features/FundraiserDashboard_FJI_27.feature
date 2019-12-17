Feature: Fundraiser Dashboard

  @SmokeTest
  Scenario Outline: Verify user is able to navigate to Fundraiser and see its sections
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    And User navigates to My Fundraiser page
    Then User is displayed Fundraiser, In Memory and Team pages
    And User is displayed Load more button uder Fundraiser, In Memory and Team sections
    Examples:
      | url                         | username      			|password|
      |/fundraiser-portal/userSignIn| ginaedkins@gmail.com|Test1990|