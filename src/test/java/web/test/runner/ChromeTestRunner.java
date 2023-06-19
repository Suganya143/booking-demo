package web.test.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import web.app.commons.BrowserUtils;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:src/main/resources/web-reports/reports.html" }, features = {
		"src/test/resources/features/UI" }, glue = { "web/stepdefinitions" })
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
