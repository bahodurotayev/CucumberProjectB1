Feature: Dashboard menu of Exelenter
  Testing presence of all manu on the Admin homepage
#@dashboard
#  Scenario: Dashboard manu view for Admin User
#    When user login with valid username and password
#    Then user should see dashboard manu displayed
#      | Admin | PIM | Leave | Time | Recruitment | My info | Performance | Dashboard | Directory | Maintenance | Buzz |


#  you can also sort menus in vertically
  @dashboard
  Scenario: Dashboard manu view for Admin User
    When user login with valid username and password
    Then user should see dashboard manu displayed
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Buzz        |
