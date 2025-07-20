package steps;

import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages.ProductsPage;

public class SwagLabsSteps {

    private final WebDriver driver = DriverManager.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);
    private final ProductsPage productsPage = new ProductsPage(driver);

    @Given("I have the browser opened in {string}")
    public void iHaveTheBrowserOpenedIn(String url) {
        loginPage.goToLoginPage(url);
    }

    @When("I enter the {string} and password {string}")
    public void iEnterTheAndPassword(String username, String password) {
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I can see the Products section")
    public void iCanSeeTheProductsSection() {
        Assert.assertFalse(productsPage.getProductList().isEmpty());
    }

    @And("I add {int} products to cart")
    public void iAddProductsToCart(int productAmount) {
        productsPage.addProductsToCart(productAmount);
    }

    @And("I click cart icon")
    public void iClickCartIcon() {
        loginPage.clickCartIcon();
    }

    @Then("I should see {int} products added")
    public void iShouldSeeProductsAdded(int productAmount) {
        Assert.assertEquals(productAmount, loginPage.getProductsInCart().size());
    }

    @When("I click menu button")
    public void iClickMenuButton() {
        productsPage.clickMenuButton();
    }

    @Then("I should see all menu options")
    public void iShouldSeeAllMenuOptions() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productsPage.isItemMenuDisplayed("All Items"));
        softAssert.assertTrue(productsPage.isItemMenuDisplayed("About"));
        softAssert.assertTrue(productsPage.isItemMenuDisplayed("Logout"));
        softAssert.assertTrue(productsPage.isItemMenuDisplayed("Reset App State"));
        softAssert.assertAll();
    }
}
