Feature: Create page for Raise fund in Memory

  @SmokeTest
  Scenario Outline: User is able to perform login with valid email and valid password
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    Then  User is dispalyed My Account
    When User navigates to Raise Funds In Memory page
    And User enters details first-name last-name and relation
    And Searches for a charity "Test"
    And User selects "yes" to Have any of your selected charities contributed to the cost of your event? question
    And Clicks createMyPage button
    Then User is displayed confirmation text as "Your fundraising page is ready to go"
    

    Examples: 
      | username      			 | 	password	|
      | ginaedkins@gmail.com |   Test1990 |