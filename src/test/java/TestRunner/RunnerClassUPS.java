package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",    // Path to feature files
        glue = {"StepDefinitions","hooks"},         // Step definition and hooks package
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Report generation
        monochrome = true                            // Clean console output
)



public class RunnerClassUPS {

}
