package steps;

import io.cucumber.java.en.Given;
import pages.GoogleMainPage;

public class GoogleSteps {

    GoogleMainPage googleMainPage = new GoogleMainPage();

    @Given("I navigate to www.google.com")
    public void iNavigateToGoogle(){
        googleMainPage.navigateToGoogle();
    }
}
