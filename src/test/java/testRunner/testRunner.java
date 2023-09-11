package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/",
        glue = {"stepDefinitions"},
        plugin = {"json:target/cucumber.json"},
        monochrome = true
        )
public class testRunner {
}
