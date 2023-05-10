package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.CommonMethods;
import utils.ConfigsReader;
import utils.Constants;

import java.time.Duration;

// NOTE: THIS CLASS IS USED TO LAUNCH AND QUIT THE BROWSER

public class BaseClass extends CommonMethods {
    public static WebDriver driver;
    public static void setUp() {
        ConfigsReader.loadProperties(Constants.CONFIGURATION_FILEPATH); // Replaced hard-coded filePath with Constants
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        String headless = ConfigsReader.getProperties("headless");
        switch (ConfigsReader.getProperties("browser").toLowerCase()) {
            case "chrome" -> {
                //System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                WebDriverManager.chromedriver().setup();
                if (headless.equalsIgnoreCase("true")){
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless", "--log-level=3");
                    options.addArguments("--disable-logging");
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                }else {
                    driver = new ChromeDriver();
                }
            }
            case "edge" -> {
                //System.setProperty("webdriver.edge.verboseLogging", Constants.EDGE_DRIVER_PATH);
                WebDriverManager.edgedriver().setup();
                if (headless.equalsIgnoreCase("true")){
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--disable-logging");
                    options.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(options);
                }else {
                    driver = new EdgeDriver();
                }
            }
            default -> throw new RuntimeException("Browser is not supported");
        }

        driver.get(ConfigsReader.getProperties("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
        initialize();
    }

    public static void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        if (driver != null) {     // This line is optional. We only use it to prevent NullPointerException.
        driver.quit();
        }
    }

}
