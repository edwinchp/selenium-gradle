package pages;

import org.openqa.selenium.By;

public class Guru99DemoSitePage extends BasePage {
    
    public Guru99DemoSitePage(){
        super(driver);
    }

    public void visitPage(String url){
        navigateTo(url);
    }

    public void uploadFile(){
        type(By.id("uploadfile_0"), "/home/edwinchi/Downloads/2d491365de5bed886d1d79b328df7679.jpg");
    }

    public boolean isMessageDisplayed(String message) {
        return isDisplayed(By.xpath("//center[normalize-space()='"+message+"']"));
    }

    public void clickOnSubmitButton() {
        clickElement(By.id("submitbutton"));
    }
}
