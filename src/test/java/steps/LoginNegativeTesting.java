package steps;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginNegativeTesting extends BaseClass {
    @When("user enter username and password credential and click login")
    public void user_enter_username_and_password_credential_and_click_login(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();
        for (Map<String, String> each :maps) {
            if(each.get("Username") != null){
                sendText(loginPage.username,each.get("Username"));
            }else {
                loginPage.username.clear();
            }
            wait(3);
            if (each.get("Password") != null){
                sendText(loginPage.password,each.get("Password"));
            }
            clickButWaitForClickability(loginPage.loginBtn);
            Assert.assertEquals(each.get("ErrorMess"), loginPage.loginErrorMessage.getText());
            //driver.navigate().refresh();
        }
    }

    @Then("validate error message")
    public void validate_error_message() {

    }
}
