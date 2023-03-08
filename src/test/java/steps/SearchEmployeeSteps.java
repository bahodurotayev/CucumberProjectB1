package steps;

import static base.BaseClass.*;
import io.cucumber.java.en.*;
import pages.EmployeeListPage;
import pages.PIMPage;
import utils.ConfigsReader;

public class SearchEmployeeSteps {

    String expectedEmployeeID = "0856";
    String expectedEmployeeName = "William";

    @Given("user is on the Exelenter homepage")
    public void user_is_on_the_exelenter_homepage() {
        setUp();
    }

    @Given("user logs in with valid admin credentials")
    public void user_logs_in_with_valid_admin_credentials() {
        //1 way
//        sendText(loginPage.username, ConfigsReader.getProperties("username"));
//        sendText(loginPage.password, ConfigsReader.getProperties("password"));
//        clickButWaitForClickability(loginPage.loginBtn);

        // 2 way
        loginPage.loginToWebsite("username", "password");
    }

    @Given("user navigates to the employee list page")
    public void user_navigates_to_the_employee_list_page() {
        pimPage.navigateToEmployeeList();
    }

    @Given("user enters an existing employee ID in the id-search-field")
    public void user_enters_an_existing_employee_id_in_the_id_search_field() {
        employeeListPage.searchEmployeeIdById(expectedEmployeeID);
    }

    @When("user clicks on the search button")
    public void user_clicks_on_the_search_button() {
        clickButWaitForClickability(employeeListPage.employeeListSearchButton);
    }

    @Then("the employee information is displayed on the employee list table")
    public void the_employee_information_is_displayed_on_the_employee_list_table() {
        System.out.println("");
    }

    @And("user enters an existing employee Name in the name-search-field")
    public void userEntersAnExistingEmployeeNameInTheNameSearchField() {
        employeeListPage.searchEmployeeIdByName(expectedEmployeeName);
    }
}
