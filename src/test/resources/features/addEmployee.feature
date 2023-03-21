Feature: adding new employee
  i.Add an employee with first name and last name only
  ii.Add an employee without an employee ID
  iii.Add an employee with login credentials

  Background: initial common steps
    When admin user logs in with valid credentials
    And admin user logs in successfully
    Then user navigates to addEmployee Page

  Scenario Outline: Add an employee with first name and last name only
    When user enters "<firstName>" and "<lastName>"
    And user enters employeeID"<employeeId>"
    And user clicks save button
    Then user verifies employee "<verify full name>" successfully created
    Examples:
      | firstName | lastName | employeeId | verify full name |
      | Jasper    | Carter   | 3001       | Jasper Carter    |

  Scenario Outline: Add an employee without an employee ID
    When user enters "<firstName>" and "<lastName>"
    And user enters employeeID"<employeeId>"
    And user clicks save button
    Then user verifies employee "<verify full name>" successfully created
    Examples:
      | firstName | lastName | employeeId | verify full name |
      | Sophia    | Kim      |            | Sophia Kim       |

  Scenario Outline: Add an employee with login credentials
    When user enters "<firstName>" and "<lastName>"
    And user enters employeeID"<employeeId>"
    And user click on create login Details "<checkbox>"
    And user enters username "<username>" and  password "<password>"
    And user clicks save button
    Then user verifies employee "<verify full name>" successfully created
    Examples:
      | firstName | lastName | employeeId | checkbox | username | password       | verify full name |
      | Liam      | Patel    | 2003       | YES      | Liapat   | Exelenter2023! | Liam Patel       |


  Scenario Outline:
    When user enters "<firstName>" and "<lastName>"
    And user enters employeeID"<employeeId>"
    And user click on create login Details "<checkbox>"
    And user enters username "<username>" and  password "<password>"
    And user clicks save button
    Then user verifies employee "<verify full name>" successfully created
    Examples:
      | firstName | lastName | employeeId | checkbox | username | password       | verify full name |
      | Tony      | Rip      | 2001       |          |          |                | Tony Rip         |
      | Bob       | Star     |            |          |          |                | Bob Star         |
      | Emma      | Maria    | 2002       | YES      | Emmmar   | Exelenter2023! | Emma Maria       |


  Scenario: Adding multiple employee
    When user enters employee full name and click on save button
      | FirstName | MiddleName | LastName |
      | Tatum     | T.         | Carson   |
      | Malia     | S.         | Santana  |
      | Bear      | B.         | Franco   |
    Then employee is added successfully

  @excel
  Scenario: Adding multiple employee from excel
    When user enters employee data from the "Employee" sheet
    Then new employee is added successfully using Excel import
