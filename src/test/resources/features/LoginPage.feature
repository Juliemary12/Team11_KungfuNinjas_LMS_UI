@Login
Feature: Login Page Verification

  Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL

  @LandLPage
  Scenario: Verify Admin is able to land on login page
    Then Admin should land on the login page

  @BrokenLink
  Scenario: Verify for any broken link
    Then HTTP response >=400 and  the link is broken

  @CompanyLogo
  Scenario: Verify the company logo
    Then Admin should see logo on the left  side on login page

  @AppName
  Scenario: Verify application name
    Then Admin should see  LMS - Learning Management System on login page

  @CompanyName
  Scenario: Verify company name
    Then Admin should see company name below the app name on login page

  @Content
  Scenario: Validate sign in content
    Then Admin should see "Please login to LMS application" on login page

  @TextField
  Scenario: Verify text field is present
    Then Admin should see two text field on login page

  @1TextField
  Scenario: Verify text on the first text field
    Then Admin should see "user" in the first text field on login page

  @*User
  Scenario: Verify asterik next to user text
    Then Admin should see * symbol next to user text on login page

  @2TextField
  Scenario: Verify text on the second text field
    Then Admin should "password" in the second text field on login page

  @*Password
  Scenario: Verify asterik next to password text
    Then Admin should see * symbol next to password text on login page

  @InputFieldAllignment
  Scenario: Verify the alignment input field for the login
    Then Admin should see input field on the centre of the page

  @LButton
  Scenario: verify Login button is present
    Then Admin should see Login button on login page

  @AlignmentLButton
  Scenario: Verify the alignment of the login button
    Then Admin should see login button on the centre of the login page

  @UserInGrey
  Scenario: Verify input descriptive test in user field
    Then Admin should see user in gray color on login page

  @PWDGrey
  Scenario: Verify input descriptive test in password field
    Then Admin should see password in gray color on login page

  @LoginValid
  Scenario Outline: Validate login with valid credentials
    When Admin enters sheetname "<sheetName>" and rownumber <rowNumber>
    And Admin enters userusername "<userName>" and password "<password>" and click on login button
    Then Admin should land on dashboard page

    Examples: 
      | sheetName | rowNumber |
      | LMSLogin  |         0 |

  @LoginInvalid
  Scenario: Validate login with invalid credentials
    When Admin enter invalid Username and Password then clicks login button
    Then Error message errorMessage should display

  @NullAdminName
  Scenario: Validate login credentials with null Admin name
    When Admin enter value only in password and clicks login button
    Then Error message should display for admin field

  @NullPassword
  Scenario: Validate login credentials with null password
    When Admin enter only in Adminname and clicks login button
    Then Error message should display for pwd field

  @LoginKeyboard
  Scenario: verify login button action through keyboard
    When Admin enter valid credentials and clicks login button through keyboard
    Then Admin should land on dashboard page

  @LoginActionMouse
  Scenario: verify login button action through mouse
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on dashboard page
	
	@SpellingOnThePage
  Scenario: Verify the text spelling in the page
    Then Admin should see correct spellings in all fields

	@LoginButton
  Scenario: verify Login button is present
    Then Admin should see login button

	@AllignLoginBtn
  Scenario: Verify the alignment of the login button
    Then Admin should see login button on the centre of the login page
