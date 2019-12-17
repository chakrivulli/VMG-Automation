Feature: Share using Facebook Twitter and LinkedIn

  @SmokeTest
  Scenario Outline: User is able to perform login with valid email and valid password
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    Then User is dispalyed My Account
    When User navigates to My Fundraiser page
    When User clicks share link of a Team
    Then User is displayed share with Facebook , Twitter and LinkedIn links
    When User clicks share with Facebook
    And Enters facebook login details "<fbEmail>" and "<fbPassword>"
    Then User is given option to Post Fundraising on Facebook with image and text
    

    Examples: 
      | username            | password  |fbEmail|fbPassword|
      | guzzmenow@gmail.com | Welcome1$ |test222@gmail.com | password123$   |
