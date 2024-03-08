package pages;


public class GoogleMainPage extends BasePage{

    public GoogleMainPage() {
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }
}
