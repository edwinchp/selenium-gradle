package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageII {

    protected static WebDriver driver;
    private WebDriverWait wait;

    public BasePageII(WebDriver driver){
        BasePageII.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    private WebElement find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected List<WebElement> getElements(By ele){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ele));
    }

    private WebElement find(By ele){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
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

    public void closeBrowser(){
        driver.close();
    }

    protected void type(By ele, String text){
        find(ele).sendKeys(text);
    }

    protected String getText(By ele){
        return find(ele).getText();
    }

    public static void quitDriver(){
        BasePageII.driver.quit();
    }

    public void clickIfVisible(By ele){
        Duration currentDuration = driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        try {
            driver.findElement(ele).click();;
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + ele);
        } finally {
            driver.manage().timeouts().implicitlyWait(currentDuration);
        }
    }

    protected void pressKeys(Keys key){
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }
}