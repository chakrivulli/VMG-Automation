Feature: Edit page for Raise fund in Memory

  @SmokeTest
  Scenario Outline: Verify user is able to edit a team 
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
   	Then User is dispalyed My Account
    When User navigates to My Fundraiser page
    And User selects a team
    And User clicks on team to edit
    And Updates title of the team
    And User clicks on edit link and updates it
    And User clicks on edit Target and updates Target amount
    And User updates Team story
    And User edits and updates Charity
    And User removes and adds a Team member
    #Then User adds a member to Team
    Examples: 
       | username             | password    |
       | surekha1234@prod.vmg | pavankumar1 |
