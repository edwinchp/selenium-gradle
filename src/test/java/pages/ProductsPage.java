package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    public ProductsPage() {
        super(driver);
    }

    public List<WebElement> getProductList(){
        return getElements(By.xpath("//div[@data-test='inventory-list']//div[@data-test='inventory-item']"));
    }

    public void addProductsToCart(int productAmount) {
        getElements(By.xpath("//div[@data-test='inventory-list']//div[@data-test='inventory-item']//button"))
                .stream().limit(productAmount).forEach(button->button.click());
    }

    public void clickMenuButton(){
        clickElement(By.id("react-burger-menu-btn"));
    }

    public boolean isItemMenuDisplayed(String menu){
        return isDisplayed(By.linkText(menu));
    }
}
