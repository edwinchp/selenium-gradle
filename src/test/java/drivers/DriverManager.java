package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.EnvConfig;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver() {
        String browser = EnvConfig.getOptional("browser", "chrome");
        boolean headless = Boolean.parseBoolean(EnvConfig.getOptional("headless", "false"));
        boolean maximize = Boolean.parseBoolean(EnvConfig.getOptional("maximize", "true"));

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver.set(new FirefoxDriver(firefoxOptions));
                break;
            case "lambda-test":
                driver.set(LambdaTestChromeDriver.getDriver());
                break;
            case "chrome":
            default:
                driver.set(ChromeBrowserDriver.getDriver());
                break;
        }

        if (maximize) {
            driver.get().manage().window().maximize();
        }

        driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}