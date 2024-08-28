package runner;

import io.cucumber.java.AfterAll;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.AfterTest;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", 
    glue="steps",
    plugin={"pretty", "html:target/cucumber-reports.html"},
    tags = "@Test")

public class TestRunner {

    @AfterAll
    public static void cleanDriver(){
        BasePage.closeBrowser();
    } 
}
