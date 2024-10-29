@ClassModuleNavigation
Feature: Navigation Validation from Manage Class to other Pages

  Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on dashboard page

  @ClassLink
  Scenario: Class link on navigation bar
    When Admin clicks on Class link page for navigation
    Then Admin is re-directed to Manage class page and navigated

  @NavigationToOtherPages
  Scenario: Class link to other module on navigation bar
  	When Admin clicks on Class link page for navigation
    And Admin clicks on any module link on Manage Class page for navigation
    Then Admin is re-directed to which module link they clicked and navigated

  @logoutLink
  Scenario: Logout link on navigation bar
    When Admin clicks on Logout link on Manage class page for navigation
    Then Admin is re-directed to Login page and navigated
