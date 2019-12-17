Feature: Search Event  

  @SmokeTest
  @RegressionTest
  Scenario Outline: User is able to search an Event
    Given Open browser and start "<url>"
    When User enter valid "<username>" and "<password>"
    Then User is dispalyed My Account
    When User navigates to event search page
    And User select search for event "Dummy Event"
    Then User is displayed relevent search results containing text "Event"
    And User is displayed "Are you doing one of these events?" text above search results
    And User is displayed Event name, Event location,Event date, Event logo, Name of the charity, Event Description
    #And User is displayed "No, I am doing my own event"
    
    Examples: 
       | url                         | username      			  |password	  |
       |/fundraiser-portal/userSignIn| surekha1234@prod.vmg |pavankumar1|