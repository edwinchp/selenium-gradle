package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Guru99DemoSitePage;

public class FileUploadSteps {

    private Guru99DemoSitePage guru99DemoSitePage = new Guru99DemoSitePage();

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        guru99DemoSitePage.visitPage(url);
    }

    @When("I select a file to upload")
    public void i_select_a_file_to_upload() {
        guru99DemoSitePage.uploadFile();
    }

    @When("I click on the Submit File button")
    public void i_click_on_the_submit_file_button() {
        guru99DemoSitePage.clickOnSubmitButton();
    }

    @Then("I should see a success message confirming the file upload")
    public void i_should_see_a_success_message_confirming_the_file_upload() {
        Assert.assertTrue(guru99DemoSitePage.isMessageDisplayed("1 file has been successfully uploaded."));
    }
}
