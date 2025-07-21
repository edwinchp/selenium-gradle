package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.EnvConfig;

public class ChromeBrowserDriver {

    static boolean headless = Boolean.parseBoolean(EnvConfig.getOptional("headless", "false"));

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless");
        }
        return new ChromeDriver(chromeOptions);
    }
}
