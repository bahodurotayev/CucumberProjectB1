Feature: log in with different user

  Scenario Outline: valid credentials
    When user enters a valid username "<username>" and a valid password "<password>"
    And user click on the login button
    Then user logged in successfully and Welcome user "<message>" is displayed
    Examples:
      | username | password         | message       |
      | Admin    | Exelent2022Sdet! | Welcome Admin |
      | EssUser  | Ess@2023         | Welcome John  |