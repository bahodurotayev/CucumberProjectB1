package steps;

import static base.BaseClass.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.DashboardPage;
import utils.ConfigsReader;

public class LoginSteps {


    String invalidCredentials = "Invalid credentials";
    String emptyCredentials = "Username cannot be empty";

    @Given("user navigates to exelenter page")
    public void user_navigates_to_exelenter_page() {
        setUp();
    }

    @Given("user login with valid username and password")
    public void user_login_with_valid_username_and_password() {
        loginPage.loginToWebsite("username", "password");
    }

    @Then("user successfully logged in")
    public void user_successfully_logged_in() {
        Assert.assertTrue("Dashboard logo is not displayed",dashboardPage.dashboardLogo.isDisplayed());
        System.out.println("Successfully logged in");
        tearDown();
    }

    @Given("user login with valid username and invalid password")
    public void user_login_with_valid_username_and_invalid_password() {
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        sendText(loginPage.password, "asdasdasd");
        clickButWaitForClickability(loginPage.loginBtn);
    }

    @Given("user login with empty credentials")
    public void user_login_with_empty_credentials() {
        loginPage.loginToWebsite2("","");
    }

    @Then("user should get invalid error message")
    public void userShouldGetInvalidErrorMessage() {
        Assert.assertEquals(loginPage.loginErrorMessage.getText(), invalidCredentials);
        System.out.println(invalidCredentials);
        tearDown();
    }

    @Then("user should get empty error message")
    public void userShouldGetEmptyErrorMessage() {
        Assert.assertEquals(loginPage.loginErrorMessage.getText(), emptyCredentials);
        System.out.println(emptyCredentials);
        tearDown();
    }
}
