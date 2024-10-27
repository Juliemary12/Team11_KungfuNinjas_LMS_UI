@Program @all
Feature: Program Module
 As an Admin, I want to navigate to Program Page and add/edit/delete Program

	Background:
    Given Admin launch the browser
    Given Admin gives the correct LMS portal URL 
    Given Admin clicks the login button with valid username and password 
    When Admin clicks "Program" on the navigation bar
    
    
   ##################### Navigation ################################
    
#		Scenario: Validate landing in Program page			
    #Then Admin should be navigated to "Program module"
    
    ##################### Menu Bar ################################
    
    #Scenario: Verify heading in menu bar
    #Then Admin should see the heading "LMS - Learning Management System"
    #
    #Scenario: Verify other module names displayed in menu bar
    #Then Admin should see the module names as in order "Home Program Batch Class Admin Assignment Attendance"
    #
    #Scenario: Verify Logout displayed in menu bar
    #Then Admin should see Logout in menu bar
    #
    #Scenario: Verify sub menu displayed in program menu bar
    #Then Admin should see sub menu in menu bar as "Add New Program"
    
    ##################### Manage Program Page validation ################################
    
    #Scenario: Verify heading in manage program
    #Then Admin should see the heading Manage Program
    
    #Scenario: Verify view details of programs
    #Then Admin should able to see Program name, description, and status for each program
    
    #Scenario: Verify the Multiple Delete button state 
    #Then Admin should see a Delete button in left top is disabled
    
    #@ProgValidation_searchInnerText
	  #Scenario: Verify the Search button  
    #Then Admin should see Search bar with text as "Search..."
    
    #Scenario: Verify column header name of data table  
    #Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete
    
    #Scenario: Verify checkbox default state beside Program Name column header  
    #Then Admin should see checkbox default state as unchecked beside Program Name column header as 
    
    #Scenario: Verify checkboxes default state beside each Program names in the data table   
    #Then Admin should see check box default state as unchecked on the left side in all rows against program name 
    #
    #Scenario: Verify Sort icon in manage program   
    #Then Admin should see the sort arrow icon beside to each column header except Edit and Delete   
    #
    #Scenario: Verify edit and delete icon in manage program   
    #Then Admin should see the Edit and Delete buttons on each row of the data table  
    #
    #Scenario: Verify pagination icons below data table in manage program   
    #Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table. 
    #
    #Scenario: Verify footer message in manage program   
    #Then Admin should see the footer as "In total there are z programs".
    
    ##################### Add New Program validation ################################
    
    #Scenario: Verify add New Program
    #When Admin clicks Add New Program button
    #Then Admin should see pop up window for Program Details
    #
    #Scenario: Verify title of the pop up window
    #When Admin clicks Add New Program button
    #Then Admin should see window title as "Program Details"
    
    #Scenario: Verify mandatory fields with red "*" mark 
    #When Admin clicks Add New Program button
    #Then Admin should see red * mark beside mandatory field Name
    #
    ###################### Seach box feature and functionality validation ***********************

	  
	  
#	  @ProgSearchFunctionality_ProgName
#	  Scenario: Verify Search bar on the Program page
#	  When Admin enters existing program name in search box on Manage Program page
#	  Then Admin should see record
#	  
#	  @ProgSearchFunctionality_ProgDesc
#	  Scenario: Verify Search bar on the Program page
#	  When Admin enters existing programs description in search box on Manage Program page
