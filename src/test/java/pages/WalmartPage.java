package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import interfaces.OnlineStore;

public class WalmartPage extends BasePage implements OnlineStore {

    private final By _inputSearch = By.xpath("//input[@placeholder='Buscar en Walmart']");
    private final By _buttonSearch = By.xpath("//button[@aria-label='Icono de búsqueda']");
    private final By _productPrice = By.xpath("(//div[@id='results-container']/following-sibling::section//div[@role='group']//div[@data-automation-id='product-price']//div[starts-with(text(),'$')])[1]");
    private final By _popUpCloseButton = By.xpath("//button[@aria-label='Cerrar']");
    private String productUrl;

    public WalmartPage(WebDriver driver) {
        super(driver);
    }  

    @Override
    public void goToSearchPage(String productName) {
        String productNameFormatted = productName.trim().replace(" ", "+").toLowerCase();
        productUrl = "https://super.walmart.com.mx/search?q=" + productNameFormatted;
        navigateTo(getProductUrl());
    }

    @Override
    public void searchProduct(String productName){
        type(_inputSearch, productName);
    }

    @Override
    public void clickSearchButton() {
        clickElement(_buttonSearch);
    }

    @Override
    public double getProductPrice() {
        String priceText = getText(_productPrice);
        String priceNumbers = "";

        Pattern pattern = Pattern.compile("[\\d.]+");
        Matcher matcher = pattern.matcher(priceText);

        while (matcher.find()) {
           priceNumbers = matcher.group();
        }

        double price = Double.parseDouble(priceNumbers);
        return price;
    }

    public void closePopUpIfVisible(){
        clickIfVisible(_popUpCloseButton);
    }

    @Override
    public String getProductUrl(){
        return productUrl;
    }

    public void enterKeys(Keys keys){
        pressKeys(keys);
    }
}
