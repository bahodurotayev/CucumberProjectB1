package steps;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;

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
        if (!arg0.isBlank()){
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
}
