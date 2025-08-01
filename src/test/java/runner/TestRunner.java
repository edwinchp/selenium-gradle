package runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/",
        glue= {"steps", "hooks"},
        plugin={"pretty", "html:target/cucumber-reports.html"},
        tags = "@Test")

public class TestRunner {}