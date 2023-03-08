package steps;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void startBrowser(){
        BaseClass.setUp();
    }
    @After
    public void quiteBrowser(){
        BaseClass.tearDown();
    }
}
