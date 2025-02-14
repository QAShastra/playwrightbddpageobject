package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "/src/test/resources/features",
    glue = {"stepdefinitions","hooks"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-reports/Cucumber.html",
                "timeline:target/cucumber-reports/CucumberTimeline"}
)
public class TestRunner {

}