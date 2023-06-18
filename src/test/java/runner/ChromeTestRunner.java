package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.app.commons.BrowserUtils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:src/main/resources/cucumber-reports/reports.html" }, features = {
		"src/test/resources/features" }, glue = { "stepdefinitions" })
public class ChromeTestRunner {
	
	@BeforeClass
	public static void browserInitialization() {
		BrowserUtils.setUpDriver("chrome");
	}
	
	@AfterClass
	public static void tearDown() {
		BrowserUtils.tearDown();
	}
}
