package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="./src/main/resources/TestCase2.feature",
        glue={"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty","json:target/surefire-reports/report_TC2.json", "html:target/surefire-reports/report_TC2.html"}
)
public class TestRunner_TC2 {
}

