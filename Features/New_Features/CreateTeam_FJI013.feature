Feature: Create Team

  @SmokeTest
  Scenario Outline: Create a Team
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
		And User clicks on team to edit
    And Updates title of the team
    And User clicks on edit link and updates it
    And User clicks on edit Target and updates Target amount
    And User updates Team story
    And User edits and updates Charity
    And User removes and adds a Team member
    Examples: 
      |username            | password   |
      |surekha1234@prod.vmg| pavankumar1|
