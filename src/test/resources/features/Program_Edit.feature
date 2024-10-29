Feature: Manage Program - Edit Program  #######Manage Program - Delete Program##########
Background: Admin is on program module after reaching dashboard
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Given Admin enter valid credentials and clicks login button 
     When Admin clicks "Program" on the navigation bar
    
    ############Edit program################
 #Scenario: Verify Edit option
     #Given Admin is on Program module
         #When Admin clicks on Edit option for particular program
      #Then Admin lands on Program details form
#
#Scenario: Verify title of the pop up window
     #Given Admin is on Program module
#When Admin clicks on Edit option for particular program
#Then Admin should see window title as "Program Details"
#
#Scenario: Verify mandatory fields with red "*" mark 
    #Given Admin is on Program module
#When Admin clicks on Edit option for particular program
     #And Admin clicks on searchfield box to particular program
#Then Admin should see red "*" mark beside mandatory field "Name"
#
#Scenario: Verify edit Program Name
     #Given Admin is on Program module
#When Admin edits the program name and click on save button
#Then Updated program name is seen by the Admin
#
#Scenario: Verify edit Description
     #Given Admin is on Program module
#When Admin edits the description text and click on save button
#Then Admin can see the description is updated
#
#Scenario: Verify edit Status
     #Given Admin is on Program module
#When Admin can change the status of the program and click on save button
#Then Status updated can be viewed by the Admin
#
#Scenario: Verify Admin is able to click Save
     #Given Admin is on Program module
     #When Admin click on save button
#Then Admin can see the updated program details
#
#Scenario: Verify Admin is able to click Cancel
     #Given Admin is on Program module
#When Admin click on cancel button
#Then Admin can see the Program details form disappears
#
#Scenario: Verify edited Program details
     #Given Admin is on Program module
#When Admin searches with newly updated "Program Name"
#Then Admin verifies that the details are correctly updated
#
#Scenario: Verify close the window with "X" 
     #Given Admin is on Program module
#When Admin Click on "X" button
#Then Admin can see program details form disappear
#
###################Manage Program - Delete Program######################
#
#Scenario: Verify delete feature
#When Admin clicks on delete button for a program
#Then Admin will get confirm deletion popup
#
#Scenario: Verify Admin is able to click Yes
#Given Admin is on Confirm deletion form
#When Admin clicks on "Yes" button
#Then Admin can see 'Successful Program Deleted' message
#
#Scenario: Verify Admin is able to deleted program
#When Admin Searches for "Deleted Program name"
#Then There should be zero results.
#
#Scenario: Verify Admin is able to click No
#Given Admin is on Program Confirm Deletion Page after selecting a program to delete
#When Admin clicks on No button
#Then Admin can see Confirmation form disappears
#
#Scenario: Verify Admin is able to close the window with "X" 
#Given after selecting a program to delete
#When Admin Click on "X" button
#Then Admin can see Confirm Deletion form disappear

############ Delete Multiple #################

Scenario: Verify Admin is able to select multiple programs
Given Admin is on Program module
When Admin selects more than one program by clicking on the checkbox
Then Programs get selected

Scenario: Verify Admin is able to delete Multiple programs
Given Admin is on Program module
When Admin clicks on the delete button on the left top of the program page
Then Admin lands on Confirmation form

Scenario: Verify Admin is able to click 'Yes'
Given Admin is on Confirmation form
When Admin clicks on "Yes" button
Then Admin can see "Successful  program deleted" message

Scenario: Verify Admin is able to deleted program
Given Admin is on Program module
When Admin Searches for "Deleted Program names"
Then There should be zero results.

Scenario: Verify Admin is able to click 'No'
Given Admin is on Confirmation form
When Admin clicks on "No" button
Then Admin can see Programs are still selected and not deleted

Scenario: Verify Admin is able to click 'No'
Given Admin is on Confirmation form
When Admin clicks on "No" button
Then Admin can see Programs are still selected and not deleted

Scenario: Verify Admin is able to close the window with "X" 
Given Admin is on Program Confirm Deletion Page 
When Admin Click on "X" button
Then Admin can see Confirm Deletion form disappear

