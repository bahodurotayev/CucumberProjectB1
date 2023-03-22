package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DashboardPage extends BaseClass {
    @FindBy(id = "welcome")
    public WebElement welcome;       // <== public WebElement welcome = driver.findElement(By.id("welcome"));

    @FindBy(css = "div#branding a img:nth-child(1)")
    public WebElement dashboardLogo;

    @FindBy(css = "#mainMenu b")
    public List<WebElement> mainMenu;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
}
