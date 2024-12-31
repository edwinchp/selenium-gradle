package runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/", 
    glue="steps",
    plugin={"pretty", "html:target/cucumber-reports.html"},
    tags = "@PriceScrapper")

public class TestRunner {

    @AfterClass
    public static void cleanDriver(){
        try {
            new ProcessBuilder("powershell.exe", "Stop-Process", "-Name", "chromedriver", "-Force").start();
            new ProcessBuilder("powershell.exe", "Stop-Process", "-Name", "chrome", "-Force").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}