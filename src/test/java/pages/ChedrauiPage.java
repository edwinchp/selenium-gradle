package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import interfaces.OnlineStore;

public class ChedrauiPage extends BasePage implements OnlineStore {

    private final By _inputSearch = By.xpath("//input[@id='downshift-2-input']");
    private final By _firstResultName = By.xpath("(//div[@id='gallery-layout-container']//section)[1]//h3");
    private final By _firstResultPrice = By.xpath("(//div[@id='gallery-layout-container']//section)[1]//span[@class='chedrauimx-add-to-cart-button-0-x-currencyContainer chedrauimx-add-to-cart-button-0-x-currencyContainer--global__vitrina--boton']");

    public ChedrauiPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToSearchPage(String productName) {
        navigateTo("https://www.chedraui.com.mx/supermercado");
    }

    @Override
    public void searchProduct(String productName) {
        type(_inputSearch, productName + Keys.ENTER);
    }

    @Override
    public void clickSearchButton() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clickSearchButton'");
    }

    @Override
    public double getProductPrice() {
        String priceText = getText(_firstResultPrice);
        String priceNumbers = "";

        Pattern pattern = Pattern.compile("[\\d.]+");
        Matcher matcher = pattern.matcher(priceText);

        while (matcher.find()) {
           priceNumbers = matcher.group();
        }

        double price = Double.parseDouble(priceNumbers);
        return price;
    }

    @Override
    public String getProductUrl() {
        return getUrl();
    }
    
}
