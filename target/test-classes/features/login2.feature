Feature: Login Test
  This is my description and it is totally optional - where you describe your feature, in more details.

  @smoke
#  This is declarative style
  Scenario: valid admin login
    When admin user logs in with valid credentials
    Then admin user logs in successfully

  @smoke
  Scenario: valid ess login
    When ess user logs in with valid credentials
    Then ess user logs in successfully

  @smoke
  Scenario Outline:
    When user enters a valid "<username>" and a valid "<password>"
    And user clicks on the login button
    Then user logs in successfully and a welcome "<user message>" is displayed
    Examples:
      | username | password         | user message    |
      | Admin    | Exelent2022Sdet! | Welcome Admin   |
      | EssUser  | Ess@2023         | Welcome Johnaa    |
      | EssUser  | Ess@2023         | Welcome John111 |


