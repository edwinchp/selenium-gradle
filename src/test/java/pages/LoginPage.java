package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage() {
        super(driver);
    }

    public void goToLoginPage(String url) {
        navigateTo(url);
    }

    public void typeUsername(String username) {
        type(By.id("user-name"), username);
    }

    public void typePassword(String username) {
        type(By.id("password"), username);
    }

    public void clickLoginButton() {
        clickElement(By.id("login-button"));
    }

    public List<WebElement> getProductList(){
        return getElements(By.xpath("//div[@data-test='inventory-list']//div[@data-test='inventory-item']"));
    }
}
