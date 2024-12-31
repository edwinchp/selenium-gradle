package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.BasePageII;

public class Hooks extends BasePageII {

    private static Scenario scenario;

    public Hooks(){
        super(driver);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    @After
    public void attachScreenshot(Scenario scenario){
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
    }

    public static void log(String message) {
        if (scenario != null) {
            scenario.log(message);
        }
    }
}