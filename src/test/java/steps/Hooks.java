package steps;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import models.Product;
import pages.BasePage;

public class Hooks extends BasePage {

    private static Scenario scenario;
    private static List<Product> productList;

    public Hooks(){
        super(driver);
    }

    @BeforeAll
    public static void setUp(){
        Hooks.productList = new ArrayList<>();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    @After
    public void attachScreenshot(Scenario scenario){
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
            generateAndAttachCSV();
        }

    public static void log(String message) {
        if (scenario != null) {
            scenario.log(message);
        }
    }

    public static void addProduct(Product product){
        productList.add(product);
    }

    public static List<Product> getProducts(){
        return productList;
    }

    private void generateAndAttachCSV() {
        String csvFile = "target/products.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("Product Name,Price,Store,URL\n");
            for (Product product : productList) {
                writer.append(product.getName()).append(",");
                writer.append(String.valueOf(product.getPrice())).append(",");
                writer.append(product.getStoreName()).append(",");
                writer.append(product.getProductUrl()).append("\n");
            }
            writer.flush();
            scenario.attach(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(csvFile))), "text/csv", "products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}