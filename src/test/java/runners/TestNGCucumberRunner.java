package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",  // Path to your .feature files
        glue = "stepDefinitions",                  // Package containing your step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests{
    // no code needed
}
