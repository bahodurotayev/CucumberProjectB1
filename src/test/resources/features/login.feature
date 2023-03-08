Feature: Login Test
  @smoke
  Scenario: user login with valid credentials
    #Given user navigates to exelenter page            <=This line is replaced with Hooks
    And user login with valid username and password
    Then user successfully logged in

  Scenario: user login with valid username and invalid password
   # Given user navigates to exelenter page
    And user login with valid username and invalid password
    Then user should get invalid error message

  Scenario: user login with empty credentials
   # Given user navigates to exelenter page
    And user login with empty credentials
    Then user should get empty error message


