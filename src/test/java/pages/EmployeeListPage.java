package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends BaseClass {
    public EmployeeListPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "empsearch_id")
    public WebElement employeeIdSearchField;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement employeeNameSearchField;

    @FindBy(id = "searchBtn")
    public WebElement employeeListSearchButton;

    public void searchEmployeeIdById(String empId){
        employeeIdSearchField.sendKeys(empId);
    }
    public void searchEmployeeIdByName(String empName){
        wait(1);
        employeeNameSearchField.sendKeys(empName);
    }
}
