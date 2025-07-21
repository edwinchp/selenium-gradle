package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.EnvConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestChromeDriver {

    static String USERNAME = EnvConfig.getRequired("LT_USERNAME");
    static String ACCESS_KEY = EnvConfig.getRequired("LT_ACCESS_KEY");

    public static String hubURL = "https://hub.lambdatest.com/wd/hub";

    public static WebDriver getDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = getLtOptions();
        capabilities.setCapability("LT:Options", ltOptions);

        try {
            return new RemoteWebDriver(new URL(hubURL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Object> getLtOptions() {
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", USERNAME);
        ltOptions.put("accessKey", ACCESS_KEY);
        ltOptions.put("project", "selenium-gradle");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("console", "true");
        return ltOptions;
    }
}
