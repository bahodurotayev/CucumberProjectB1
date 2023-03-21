package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"                 //specify path form ContentRoot for Feature
        , glue = "steps"                                           //specify path from SourceRoot for Steps
        , dryRun = true
        , monochrome = false,
        //        , tags = "@regression or @smoke"
        //        ,tags = "@smoke"       // run test(s) with provided tag name
        //        ,tags = "@regression or @smoke"       // Run any scenario test that has either regression OR smoke test.  ||
                tags = "@login"       // Run any scenario test that has BOTH regression AND smoke test. If one missing it will not run.  &&
)

public class TestRunner {
    //path for my feature files
    //path for my steps files
    //@smoke, @regression
}
