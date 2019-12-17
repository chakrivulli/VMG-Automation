Feature: Attempt to donate to a Campaign that has disabled Direct Donations 

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify disablement of direct donation
    Given Open browser and start "<url>"
    When User navigate to charity signIn page
    When User logs in to charity with "java.applications@virginmoney.com" and "telephone!"
    And User navigates to create new campaign
    And Creates new campaign with allow gift aid "No" and allow direct donation "No"
    When User navigates to Make a Donation tab
    And User select search for a campaign
    When Verify first campaign's donation button is disabled
      