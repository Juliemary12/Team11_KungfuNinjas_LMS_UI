#@Batch @all
Feature: Batch Module
 As an Admin, I want to navigate to Batch Page and add/edit/delete Batch

	Background: Verify Admin Navigate to Batch page successfully 
    Given Admin gives the correct LMS portal URL
    When  Admin enter valid credentials and clicks login button 
  #  Then Admin should land on dashboard page
    And   Admin Clicks on the Batch menu from the header
   
   
  
   Scenario: verify navigated to manage batch page
    Then Admin should be in the Manage Batch Page
   
    Scenario: Validate "Title" in Batch Page
    Then Admin should see the "LMS-Learning Management System" Title
    
    Scenario: Validate "heading" in the Batch Page
    Then Admin should see the "Manage Batch" Heading
    
    Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    Then Admin should see the disabled "Delete Icon" under the header
    
    Scenario: Validate pagination in the Batch Page
    Then Admin should see the enabled pagination controls under the data table
    
    Scenario: Validate edit icon in each data rows
    Then Admin should see the edit icon in each row
    
    Scenario: validate delete icon in each data rows
    Then Admin should see the delete icon in each row
   
    Scenario: validate checkbox in each data rows
    Then Admin should the checkbox in each row
    
    Scenario: Validate Datatable headers
    Then Admin should see the datatable headers Batch name, Batch Description,Batch Status,No Of classes, Program Name, Edit/Delete 
         
    
    Scenario: Validate "Checkbox" in the Datatable header row
    Then Admin should see the checkbox  in the datatable header row
    
    Scenario: Validate "Checkbox" in the Datatable header row
    Then Admin should see the sort icon next to all Datatable headers
