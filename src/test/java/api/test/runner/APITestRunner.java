package api.test.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:src/main/resources/api-reports/reports.html" }, features = {
		"src/test/resources/features/API" }, glue = { "api/stepdefinitions" })
public class APITestRunner {
	
}
