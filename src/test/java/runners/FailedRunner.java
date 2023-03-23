package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt"
        , glue = "steps"
        , plugin = {
        "pretty",
        "rerun:target/failed.txt"
//        "html:target/cucumber-report/cucumberReport.html",
//        "json:target/cucumber-report/cucumberReport.json",
}
)

public class FailedRunner {


}
