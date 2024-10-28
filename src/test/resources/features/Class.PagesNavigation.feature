
@ClassModuleNavigation
Feature: Navigation Validation from Manage Class to other Pages


Background: 
			Given Admin launch the browser
   		When Admin gives the correct LMS portal URL
			Then Admin should land on dashboard page
		
		@ClassLink				
 Scenario: Class link on navigation bar
 			When Admin clicks on Class link 
 			Then Admin is re-directed to Manage class page
 	 
 	 @NavigationToOtherPages
 Scenario: Class link to other module on navigation bar
 	When Admin clicks on any module link on Manage Class page
 	Then Admin is re-directed to which module link they clicked
 	 
 	 @logoutLink
 Scenario: Logout link on navigation bar
 	When Admin clicks on Logout link on Manage class page
 	Then Admin is re-directed to Login page
 	