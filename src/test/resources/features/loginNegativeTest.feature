Feature: As an Invalid User, I should not be able to login using invalid login credentials, and if I try, I should see an error message.

  Scenario:
    When user enter username and password credential and click login
      | Username | Password         | ErrorMess                |
      | Admin    | 123162           | Invalid credentials      |
      | Adminn   | Exelent2022Sdet! | Invalid credentials      |
      | Addmin   | 123132           | Invalid credentials      |
      | Admin    |                  | Password cannot be empty |
      | Admiin   |                  | Password cannot be empty |
      |          | Exelent2022Sdet! | Username cannot be empty |
      |          | 16545ad          | Username cannot be empty |
      |          |                  | Username cannot be empty |
    Then validate error message
