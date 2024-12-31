package steps;

import factory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.WalmartPage;

public class PriceScrapperSteps {

    private WalmartPage walmartPage;
    private Scenario scenario;

    @Given("Yo navego por todas las tiendas busco el producto {string}")
    public void yoNavegoPorTodasLasTiendasBuscoElProducto(String product) {
        walmartPage = new WalmartPage(DriverFactory.createDriver());
        walmartPage.goToSearchPage(product);
        System.out.println("Navegando por todas las tiendas y buscando el producto: " + product);
        System.out.println("Precio encontrado: " + walmartPage.getProductPrice());
        Hooks.log("Precio encontrado: " + walmartPage.getProductPrice());
        walmartPage.closePopUpIfVisible();
    }

    @Then("Debería ver el precio del producto")
    public void deberiaVerElPrecioDelProducto() {
        // Implementación para verificar que se ve el precio del producto
        System.out.println("Verificando que se ve el precio del producto");
        // Aquí iría el código para verificar el precio del producto
    }
}