package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import drivers.DriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class ScreenshotHook {

    @AfterStep()
    public void attachScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
            scenario.log("Scenario failed: " + scenario.getName());
        }
    }
}