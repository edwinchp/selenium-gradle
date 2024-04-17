package steps;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.GoogleMainPage;

public class GoogleSteps {

    GoogleMainPage googleMainPage = new GoogleMainPage();

    @Given("I navigate to www.google.com")
    public void iNavigateToGoogle(){
        googleMainPage.navigateToGoogle();
    }

    @When("I click Voy a tener suerte")
    public void I_click_Voy_a_tener_suerte() {
        googleMainPage.clickVoyATenerSuerte();
    }

    @When("I can see results")
    public void I_can_see_results() {
        Assert.assertTrue(googleMainPage.isNavbarDisplayed());
    }
}
