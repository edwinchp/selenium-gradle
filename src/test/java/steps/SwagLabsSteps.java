package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class SwagLabsSteps {

    private LoginPage loginPage = new LoginPage();

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
        Assert.assertFalse(loginPage.getProductList().isEmpty());
    }
}