package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//JUnit'ten geldigi icin Cucumber'da TestNG kullanilmaz
@CucumberOptions(
        plugin = {"html:target/cucumber-reports2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml"
        },
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@excel1",
        dryRun = false
)

public class TestRunner2 {

    // Runner class'i body'si bostur.

}
