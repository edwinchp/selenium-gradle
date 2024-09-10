package pages;

import org.openqa.selenium.By;
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

    public ProductsPage clickLoginButton() {
        clickElement(By.id("login-button"));
        return new ProductsPage();
    }

    public void clickCartIcon() {
        clickElement(By.id("shopping_cart_container"));
    }

    public List<WebElement> getProductsInCart() {
        return getElements(By.xpath("//div[@class='cart_item']"));
    }
}
