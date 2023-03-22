package steps;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginWithOutlineSteps extends BaseClass {
    @When("user enters a valid username {string} and a valid password {string}")
    public void user_enters_a_valid_username_and_a_valid_password(String string, String string2) {
        loginPage.username.sendKeys(string);
        loginPage.password.sendKeys(string2);
    }

    @When("user click on the login button")
    public void user_click_on_the_login_button() {
      clickButWaitForClickability(loginPage.loginBtn);
    }

    @Then("user logged in successfully and Welcome user {string} is displayed")
    public void user_logged_in_successfully_and_welcome_user_is_displayed(String string) {
        System.out.println(string);
        Assert.assertEquals("Message does not match", string, dashboardPage.welcome.getText());
    }
}
