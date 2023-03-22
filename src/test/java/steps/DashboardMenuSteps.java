package steps;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardMenuSteps extends BaseClass {
    /**
     * As of Cucumber 7.0 and later asList(), asLists(), and asMaps() have changed:
     * Replace DataTable.asList() with -> DataTable.values()
     * Replace DataTable.asLists() with -> DataTable.cells()
     * Replace DataTable.asMaps() with -> DataTable.entries()
     */
    @Then("user should see dashboard manu displayed")
    public void user_should_see_dashboard_manu_displayed(DataTable menu) {

        List<String> expectedAdminMenu = menu.values();

        List<String> actualAdminMenu = new ArrayList<>();

        for (int i = 0; i < dashboardPage.mainMenu.size(); i++) {
            actualAdminMenu.add(dashboardPage.mainMenu.get(i).getText());
            Assert.assertEquals("menu does not match",expectedAdminMenu.get(i),actualAdminMenu.get(i));
        }


        System.out.println("Expected" + expectedAdminMenu);
        System.out.println("Actual" + actualAdminMenu);


        //2way
       /* for (WebElement eachMenu: dashboardPage.mainMenu) {
            actualAdminMenu.add(eachMenu.getText());
        }*/
    }
}
