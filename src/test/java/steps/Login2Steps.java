package steps;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.ConfigsReader;

import static base.PageInitializer.*;


public class Login2Steps {
    @When("admin user logs in with valid credentials")
    public void admin_user_logs_in_with_valid_credentials() {
        //1st way
        loginPage.loginToWebsite2(ConfigsReader.getProperties("username"), ConfigsReader.getProperties("password"));

        //2nd way
//        sendText(loginPage.username, ConfigsReader.getProperties("username"));
//        sendText(loginPage.password, ConfigsReader.getProperties("password"));
//        click(loginPage.loginBtn);

        //3rd way
//        loginPage.username.sendKeys("Admin");  // hardcode
//        loginPage.password.sendKeys(ConfigsReader.getProperties("password")); // from ConfigsReader
//        loginPage.loginBtn.clear();
    }
    @Then("admin user logs in successfully")
    public void admin_user_logs_in_successfully() {
        String expectedMessage = "Welcome Admin";
        String actualMessage = dashboardPage.welcome.getText();
        Assert.assertEquals("Admin user unable to log in",expectedMessage,actualMessage);
    }

    @When("ess user logs in with valid credentials")
    public void ess_user_logs_in_with_valid_credentials() {
        loginPage.loginToWebsite2("EssUser", "Ess@2023");
    }
    @Then("ess user logs in successfully")
    public void ess_user_logs_in_successfully() {
        String expectedMessage = "Welcome John";
        String actualMessage = dashboardPage.welcome.getText();
        Assert.assertEquals("ESS user unable to log in",expectedMessage,actualMessage);
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
    }

    @When("user enters a valid {string} and a valid {string}")
    public void userEntersAValidAndAValid(String arg0, String arg1) {
        loginPage.loginToWebsite2(arg0, arg1);
    }

    @Then("user logs in successfully and a welcome {string} is displayed")
    public void userLogsInSuccessfullyAndAWelcomeIsDisplayed(String arg0) {

        String actualMessage = dashboardPage.welcome.getText();
        Assert.assertEquals("Messages doesn't match",arg0, actualMessage);

    }
}
