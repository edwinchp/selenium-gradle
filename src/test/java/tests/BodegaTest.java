package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import factory.DriverFactory;
import pages.WalmartPage;

public class BodegaTest {

    private  WalmartPage walmartPage;

    @DataProvider(name = "productData")
    public Object[][] productData() {
        return new Object[][] {
            //{"Tomate kg"},
            {"Platano kg"},
            {"Tomate kg"}
        };
    }

    @Test(dataProvider = "productData")
    public void BodegaTest_test(String product) {
        walmartPage = new WalmartPage(DriverFactory.createDriver());
        walmartPage.goToSearchPage(product);
        System.out.println("Navegando por todas las tiendas y buscando el producto: " + product);
        System.out.println("Precio encontrado: " + walmartPage.getProductPrice());
    }

    @AfterMethod
    public void tearDown(){
        walmartPage.closeBrowser();
    }
}