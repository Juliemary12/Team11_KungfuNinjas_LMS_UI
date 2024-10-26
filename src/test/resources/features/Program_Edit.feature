Feature: Manage Program - Edit Program
Background: Admin is on program module after reaching dashboard
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Given Admin enter valid credentials and clicks login button 
     When Admin clicks "Program" on the navigation bar
     Given Admin is on Program module
     And Admin clicks on searchfield box to particular program
    When Admin clicks on Edit option for particular program
    

  Scenario: Admin navigates to Program details
  Then Admin lands on Program details form

Scenario: Verify title of the pop up window
Then Admin should see window title as "Program Details"

Scenario: Verify mandatory fields with red "*" mark 
Then Admin should see red "*" mark beside mandatory field "Name"

Scenario: Verify edit Program Name
When Admin edits the program name and click on save button
Then Updated program name is seen by the Admin

Scenario: Verify edit Description
When Admin edits the description text and click on save button
Then Admin can see the description is updated

Scenario: Verify edit Status
When Admin can change the status of the program and click on save button
Then Status updated can be viewed by the Admin

Scenario: Verify Admin is able to click Save
When Admin click on save button
Then Admin can see the updated program details

Scenario: Verify Admin is able to click Cancel
When Admin click on cancel button
Then Admin can see the Program details form disappears

Scenario: Verify edited Program details
When Admin searches with newly updated "Program Name"
Then Admin verifies that the details are correctly updated

Scenario: Verify close the window with "X" 
When Admin Click on "X" button
Then Admin can see program details form disappear