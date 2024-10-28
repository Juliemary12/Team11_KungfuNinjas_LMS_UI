Feature: User is able to navigate to Home Page and Login
Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
	 
	  Scenario:
   # Given Admin launch the browser
   # When Admin gives the correct LMS portal URL 
    Then Admin should land on the login page
    
    
  Scenario Outline: Validate login with valid credentials
    When Admin enters sheetname "<sheetName>" and rownumber <rowNumber>
    And Admin enters userusername "<userName>" and password "<password>" and click on login button
    Then Admin should land on dashboard page ( centre of the page will be empty , menu bar is present)
    Examples: 
      | sheetName  | rowNumber |
      | LMSLogin  |         0 |