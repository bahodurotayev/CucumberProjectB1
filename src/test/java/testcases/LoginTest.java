package testcases;

import base.BaseClass;
import utils.ConfigsReader;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * US 16457: As an Admin User, I should not be able to login to the application using invalid credentials.    <== High Level explanation of the feature.
 */
public class LoginTest extends BaseClass {
    @Test(groups = "smoke")
    public void validAdminLogin() {
        loginPage.loginToWebsite("username", "password");
        String expectedText = "Welcome Admin";
        String actualText = dashboardPage.welcome.getText();
        Assert.assertEquals(actualText, expectedText, "'Welcome Admin' text is incorrect");
    }

    @Test(groups = "smoke")
    public void validUserInvalidPassword() {
        String invalidPassword = "Pass1234";
        String expectedErrorMessage = "Invalid credentials";
        sendText(loginPage.username, ConfigsReader.getProperties("username"));    // Valid Username
        sendText(loginPage.password, invalidPassword);                                // Invalid Password
        click(loginPage.loginBtn);
        Assert.fail();
        Assert.assertEquals(loginPage.loginErrorMessage.getText(), expectedErrorMessage, "Error message is incorrect");
    }

    @Test(groups = "smoke")
    public void validUserEmptyPassword() {
        String expectedErrorMessage = "Password cannot be empty";
        sendText(loginPage.username, ConfigsReader.getProperties("username"));   // Valid Username, Password empty (skipped).
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(), expectedErrorMessage, "Error message is incorrect");
    }

}
