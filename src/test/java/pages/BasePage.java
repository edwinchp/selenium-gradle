package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/home/edwinchi/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
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
        driver.quit();
    }

    protected void type(By ele, String text){
        find(ele).sendKeys(text);
    }
}