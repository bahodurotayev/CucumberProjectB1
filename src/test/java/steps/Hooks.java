package steps;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks {
    @Before
    public void startBrowser(){
        BaseClass.setUp();
    }
    @After
    public void quiteBrowser(Scenario scenario){
        if (scenario.isFailed()){
            CommonMethods.takeScreenshot("FaildTest/" + scenario.getName());
        }
        BaseClass.tearDown();
    }
}
