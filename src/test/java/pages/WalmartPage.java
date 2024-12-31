package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import interfaces.OnlineStore;

public class WalmartPage extends BasePageII implements OnlineStore {

    private final By _inputSearch = By.xpath("//input[@placeholder='Buscar en Walmart']");
    private final By _buttonSearch = By.xpath("//button[@aria-label='Icono de búsqueda']");
    private final By _productPrice = By.xpath("(//div[@id='results-container']/following-sibling::section//div[@role='group']//div[@data-automation-id='product-price']//div[starts-with(text(),'$')])[1]");
    private final By _popUpCloseButton = By.xpath("//button[@aria-label='Cerrar']");

    public WalmartPage(WebDriver driver) {
        super(driver);
    }  

    @Override
    public void goToSearchPage(String productName) {
        String productNameFormatted = productName.trim().replace(" ", "+").toLowerCase();
        navigateTo("https://super.walmart.com.mx/search?q=" + productNameFormatted);
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
        String priceNumbers = priceText.replaceAll("[^\\d.]", "");
        double price = Double.parseDouble(priceNumbers);
        return price;
    }

    public void closePopUpIfVisible(){
        clickIfVisible(_popUpCloseButton);
    }
}
