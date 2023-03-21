package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"                 //specify path form ContentRoot for Feature
        , glue = "steps"                                           //specify path from SourceRoot for Steps
        , dryRun = false
        , monochrome = true,
        //        , tags = "@regression or @smoke"
        //        ,tags = "@smoke"       // run test(s) with provided tag name
        //        ,tags = "@regression or @smoke"       // Run any scenario test that has either regression OR smoke test.  ||
        tags = "@excel"       // Run any scenario test that has BOTH regression AND smoke test. If one missing it will not run.  &&
        , plugin = {
        "pretty",  // Prints Gherkin steps in the console AND terminal/command line
        "html:target/cucumber-report/cucumberReport.html",
        "json:target/cucumber-report/cucumberReport.json",
}
)

public class TestRunner {
    //path for my feature files
    //path for my steps files
    //@smoke, @regression
}
