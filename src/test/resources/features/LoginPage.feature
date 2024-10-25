@Login
Feature: Login Page Verification
		Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    
  @LandLPage
  Scenario: Verify Admin is able to land on login page
    Then Admin should land on the login page
    
  @LoginValid
  Scenario Outline: Validate login with valid credentials
    When Admin enters sheetname "<sheetName>" and rownumber <rowNumber>
    And Admin enters userusername "<UserName>" and password "<Password>" and click on login button
    Then Admin should land on dashboard page(centre of the page will be empty , menu bar is present)

    Examples: 
      | sheetName | rowNumber |
      | LMSLogin |         0 |