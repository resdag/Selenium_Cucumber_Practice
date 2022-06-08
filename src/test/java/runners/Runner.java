package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//JUnit'ten geldigi icin Cucumber'da TestNG kullanilmaz
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@herokuapp or @dtso",
        //tags = "@ikisi and @java",
        dryRun = false
)

public class Runner {

    // Runner class'i body'si bostur.

}
