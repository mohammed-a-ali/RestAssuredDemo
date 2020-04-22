package runner;

import io.cucumber.testng.CucumberOptions;
import steps.Hooks;

@CucumberOptions(features = "src/test/java/features",
        glue = {"runner","steps"},
        tags ={"not @ignore"},
        plugin = {"pretty", "html: target/cucumber-html-report"})
public class TestRunner extends Hooks {
}
