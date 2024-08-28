package runner;

import io.cucumber.java.AfterAll;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", 
    glue="steps",
    plugin={"pretty", "json:target/cucumber-reports.json"},
    tags = "@Test")

public class TestRunner {

    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    } 
}
