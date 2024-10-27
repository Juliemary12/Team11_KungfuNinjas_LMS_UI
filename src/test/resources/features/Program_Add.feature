@Program @all @program_add

Feature: Program Module
 As an Admin, I want to add a Program

	Background:
    Given Admin launch the browser
    Given Admin gives the correct LMS portal URL 
    Given Admin clicks the login button with valid username and password 
    Given Admin clicks "Program" on the navigation bar
    Given Admin clicks Add New Program button
    #Given Admin is on Program details form
    
    ##################### Add New Program validation ################################
    
    Scenario: Verify empty form submission
    When Admin clicks save button without entering mandatory  
    Then Admin gets message field is required
    
    Scenario: Verify cancel button
    When Admin clicks Cancel button  
    Then Admin can see Program Details form disappears     
      
    Scenario: Verify close window with "X" 
    When Admin Click on X button  
    Then Admin can see Program Details form disappears
    
     Scenario: Verify enter program name
    When Admin enters the "Name" in the text box  
    Then Admin can see the "KungfuNinja" entered 
    
    Scenario: Verify enter description
    When Admin enters the "Description" in description text box  
    Then Admin can see the text entered "SDET" in description box 
    
    #Scenario: Verify select Status
    #When Admin selects the status of the program by clicking on the radio button Active/InActive 
    #Then Admin can see Active or Inactive status selected
    
    Scenario: Verify Admin is able to save the program details    
    When Admin enter valid details for mandatory fields "Name", "Description", status and Click on save button  
    Then Admin gets message 'Successful Program created'
    
    Scenario: Verify added Program is created
    Given Admin Click on X button
    When Admin searches with newly created Program Name  
    Then Records of the newly created  Program Name is displayed and match the data entered
    
   
    
    
    
    
    
    
    
    
    