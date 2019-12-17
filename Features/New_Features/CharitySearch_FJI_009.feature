Feature: Search Charity  

  @SmokeTest
  @RegressionTest
  Scenario Outline: User is able to search for a charity
    Given Open browser and start "<url>"
    When User enter valid "<username>" and "<password>"
    When User navigates to charity search page
    And User select search for charity "Virgin"
    Then User is displayed text "Choose your charity" on top of search
    And User is displayed load more button
    And User is displayed text "Can't find them?" below search results 
    And User is displayed link Invite them to register with us
    And User selects first five charities from search results
    And User is displayed text "Donations will be split evenly between your chosen charities."
    
    
    Examples: 
       | url                         | username      			  |password	  |
       |/fundraiser-portal/userSignIn| surekha1234@prod.vmg |pavankumar1|