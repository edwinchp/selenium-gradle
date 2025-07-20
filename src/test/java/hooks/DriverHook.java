package hooks;

import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHook {

    @Before
    public void beforeScenario() {
        DriverManager.createDriver();
    }


    @After
    public void afterSuite() {
        DriverManager.quitDriver();
    }
}