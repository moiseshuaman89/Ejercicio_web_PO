package hitoriaDeUsuario.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumberHtmlReport",
                "json:target/userstory-report.json"
        },
        glue = "hitoriaDeUsuario.steps",
        features = "src/test/java/hitoriaDeUsuario/feature/AutomationPractice.feature"
        ,tags = "@testPruebaweb01"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
