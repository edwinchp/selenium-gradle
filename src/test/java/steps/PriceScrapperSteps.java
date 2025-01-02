package steps;

import org.openqa.selenium.Keys;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.Product;
import pages.WalmartPage;

public class PriceScrapperSteps {

    private WalmartPage walmartPage;
    private Product product;

    @Given("Yo navego por todas las tiendas busco el producto {string}")
    public void yoNavegoPorTodasLasTiendasBuscoElProducto(String productName) {
        walmartPage = new WalmartPage(DriverFactory.createDriver());
        walmartPage.goToSearchPage(productName);
        walmartPage.closePopUpIfVisible();
        walmartPage.enterKeys(Keys.ESCAPE);
        walmartPage.enterKeys(Keys.PAGE_DOWN);
        System.out.println("Navegando por todas las tiendas y buscando el producto: " + productName);
        System.out.println("Precio encontrado: " + walmartPage.getProductPrice());
        Hooks.log("Precio encontrado: " + walmartPage.getProductPrice());
        product = new Product(productName, walmartPage.getProductPrice(), "Walmart", walmartPage.getProductUrl());
        Hooks.addProduct(product);
    }

    @Then("Debería ver el precio del producto")
    public void deberiaVerElPrecioDelProducto() {
        Hooks.getProducts().forEach(product -> {
            Hooks.log(product.getName() + " " + product.getPrice() + " " + product.getStoreName() + " " + product.getProductUrl());
        });
    }
}