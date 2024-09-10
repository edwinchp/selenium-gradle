package pages;


public class GoogleMainPage extends BasePage{

    public GoogleMainPage() {
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void clickVoyATenerSuerte(){
        clickElement("(//input[@aria-label='Voy a tener suerte'])[2]");
    }

    public boolean isNavbarDisplayed() {
        return isDisplayed("//header[@class='glue-header glue-header--single glue-header--no-cta']");
    }
}
