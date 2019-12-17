Feature: Make single donation to someone special page with card

  @SmokeTest
  @RegressionTest
  Scenario Outline: Verify make single donation to someone special page as logged in user
    Given Open browser and start "<url>"
    And User clicks on signin button
    When User enter valid "<username>" and "<password>"
    When Navigate to url "<url>"
    When User clicks on Donate button
    And Verity Fundraiser Title "Test Mem"
    When Enter amount "1"
   	##And Enters message "test message"
		And Click pay by card
		##And Select donation transaction fee "True"
    ##And Click pay by card
    When User selects "Yes" to gift aid only
    When Select use another card if user's card is saved
    And Verify amount "1" on Review Donation page
    And Clicks terms&conditions and donate
    When User enters card details "<cardNumber>" "<cardHolderName>" "<expiryMonth>" "<expiryYear>" "<cvv>"
    Then Verify donation successfull
    Examples: 
      | url                                     | username             | password |cardNumber|cardHolderName|expiryMonth|expiryYear|cvv|
      | https://uk.virginmoneygiving.com/SomeoneSpecial/TestMem |ginaedkins@gmail.com | Test1990|268899747383|test User|09|22|123|