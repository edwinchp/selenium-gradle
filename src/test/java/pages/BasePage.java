package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;

public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    static {
        driver = DriverFactory.createDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void injectSessionCookie(String name, String value, String domain) {
        Cookie cookie = new Cookie.Builder(name, value)
                .domain(domain)
                .build();
        driver.manage().addCookie(cookie);
    }

    private WebElement find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected List<WebElement> getElements(By ele){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ele));
    }

    private WebElement find(By ele){
        return wait.until(ExpectedConditions.presenceOfElementLocated(ele));
    }

    protected void clickElement(String locator){
        find(locator).click();
    }

    protected void clickElement(By ele){
        find(ele).click();
    }

    protected boolean isDisplayed(String locator){
        return find(locator).isDisplayed();
    }

    protected boolean isDisplayed(By ele){
        return find(ele).isDisplayed();
    }

    public static void closeBrowser(){
        driver.close();
    }

    protected void type(By ele, String text){
        find(ele).sendKeys(text);
    }

    protected String getText(By ele){
        return find(ele).getText();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}