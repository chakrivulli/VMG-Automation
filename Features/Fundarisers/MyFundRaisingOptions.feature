Feature: Verify options for team

  @SmokeTest3
  Scenario Outline: User is able to perform login with valid email and valid password
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    Then User is dispalyed My Account
    When User navigates to My Fundraiser page
    #When User clicks last options of a Team
    #When User links In Memory page
    #When User clicks last options of a Team
    #Then Verify Unlink In Memory Page option
    #When User navigates to My Fundraiser page
    #When User clicks options of a Team
    #Then Verify Link To Campaign
    #When User navigates to My Fundraiser page
    When User clicks options of a Team
    Then Verify Add or Remove Team Members option
    When User navigates to My Fundraiser page
    When User clicks options of a Team
    Then Verify Edit Charities option
    When User navigates to My Fundraiser page
    When User clicks options of a Team
    Then Verify View Donation History option
    When User navigates to My Fundraiser page
    When User clicks options of a Team
    Then Verify Close page option

    Examples: 
      | username            | password  |
      | ginaedkins@gmail.com | Test1990 |
