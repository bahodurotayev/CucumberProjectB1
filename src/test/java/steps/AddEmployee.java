package steps;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddEmployee extends BaseClass {

    @Then("user navigates to addEmployee Page")
    public void userNavigatesToAddEmployeePage() {
        pimPage.navigateToAddEmployee();
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String string, String string2) {
        addEmployeePage.firstName.sendKeys(string);
        addEmployeePage.lastName.sendKeys(string2);
    }

    @When("user enters employeeID{string}")
    public void user_enters(String string) {
        addEmployeePage.employeeId.clear();
        addEmployeePage.employeeId.sendKeys(string);
    }

    @And("user click on create login Details {string}")
    public void userClickOnCreateLoginDetails(String arg0) {
        if (!arg0.isBlank()) {
            wait(1);
            clickButWaitForClickability(addEmployeePage.createLoginDetailsCheckbox);
        }
    }

    @And("user enters username {string} and  password {string}")
    public void userEntersUsernameAndPassword(String arg0, String arg1) {
        if (!arg0.isBlank()) {
            addEmployeePage.username.sendKeys(arg0);
            addEmployeePage.password.sendKeys(arg1);
            addEmployeePage.confirmPassword.sendKeys(arg1);
        }
    }

    @When("user clicks save button")
    public void user_clicks_save_button() {
        clickButWaitForClickability(addEmployeePage.saveButton);
    }

    @Then("user verifies employee {string} successfully created")
    public void userVerifiesEmployeeSuccessfullyCreated(String arg0) {
        Assert.assertEquals("Full name does not match", arg0, employeeListPage.personalPicHeader.getText());
    }


    @When("user enters employee full name and click on save button")
    public void user_enters_employee_full_name_and_click_on_save_button(DataTable dataTable) {
        List<Map<String, String>> mapList = dataTable.asMaps();
        int count = mapList.size();
        for (Map<String, String> each : mapList) {

            addEmployeePage.firstName.sendKeys(each.get("FirstName"));               //1.way
            addEmployeePage.middleName.sendKeys(each.get("MiddleName"));
            sendText(addEmployeePage.lastName, each.get("LastName"));               //2.way

            clickButWaitForClickability(addEmployeePage.saveButton);

            String expectedFullName = each.get("FirstName") + " " + each.get("MiddleName")+" " + each.get("LastName");
            String actualFullName = employeeListPage.personalPicHeader.getText();

            Assert.assertEquals("user does not match", expectedFullName, actualFullName);

            System.out.println(count);
            wait(3);
            if (count!= 1){
                pimPage.addEmployee.click();
            }
            count--;
            wait(1);
        }
    }

    @Then("employee is added successfully")
    public void employee_is_added_successfully() {

    }
}
