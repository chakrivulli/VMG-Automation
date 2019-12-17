Feature: Create page for Raise fund in Memory

  @SmokeTest
  Scenario Outline: Create My page
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
   	Then User is dispalyed My Account
    When User navigates to Fundraise as a team page
    And User enters team name
    And Searches for an email "ginaedkins@gmail.com"
    And User adds the searched person to team
    And Clicks Next button
    And Searches for challenge "Test"
    And User selects "yes" to Have any of your selected charities contributed to the cost of your event? question
    And Clicks createMyPage button
    Then User is displayed confirmation text as "Your fundraising page is ready to go."

    Examples: 
      |username            | password   |
      |surekha1234@prod.vmg| pavankumar1|
