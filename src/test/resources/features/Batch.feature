@Program @all
Feature: Batch Module
 As an Admin, I want to navigate to Batch Page and add/edit/delete Batch

	Background:
    Given Admin gives the correct LMS portal URL
    And  Admin enter valid credentials and clicks login button 
    Then Admin should land on dashboard page(centre of the page will be empty , menu bar is present)

    Scenario: Verify Admin Navigate to Batch page successfully 
    Given Admin is on the Dashboard Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page
    
    #Scenario: Validate "Title" in Batch Page
    #Given Admin is on the Dashboard Page
    #When Admin Clicks on the Batch menu from the header
    #Then Admin should see the "LMS-Learning Management System" Title
    #
    #Scenario: Validate "heading" in the Batch Page
    #
    #Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    #
    #Scenario: Validate pagination in the Batch Page
    #
    #Scenario: Validate edit icon in each data rows
    #
    #Scenario: validate delete icon in each data rows
    #
    #Scenario: validate checkbox in each data rows
    #
    #Scenario: Validate Datatable headers
    #
    #Validate "Checkbox" in the Datatable header row
    #
    #Validate "Checkbox" in the Datatable header row
    #
    #
    
    
