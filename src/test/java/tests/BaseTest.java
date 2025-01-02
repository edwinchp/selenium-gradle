package tests;
import org.openqa.selenium.WebDriver;
import pages.WalmartPage;

public class BaseTest {

    protected WalmartPage walmartPage;

    public BaseTest(WebDriver driver) {
        walmartPage = new WalmartPage(driver);
    }
}
