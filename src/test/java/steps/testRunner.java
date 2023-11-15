package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        monochrome = false,
        dryRun = false,
		plugin = { "pretty",
//				"junit:target/JunitReports/report.xml",
//				"json:target/JsonReports/report.json",
				"html:target/cucumber-reports/report.html",
				},

        tags = "@web")
public class testRunner{}