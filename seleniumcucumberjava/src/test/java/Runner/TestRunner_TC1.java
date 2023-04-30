package Runner;


import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="./src/main/resources/TestCase1.feature",
        glue={"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty","json:target/surefire-reports/report_TC1.json", "html:target/surefire-reports/report_TC1.html"}
)
public class TestRunner_TC1 {
}

