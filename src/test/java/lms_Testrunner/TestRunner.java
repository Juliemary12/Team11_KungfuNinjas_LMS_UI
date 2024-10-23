package lms_Testrunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", 
glue = { "lms_Hooks","lms_StepDefinition"},

//tags = "@all",

plugin={"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        		"html:target/cucumber-reports/Team11_LMS.html","json:target/MyReports/report.json",
        		"html:target/MyReports/report2.json",
        		"timeline:test-output-thread/"},
		
dryRun = false, monochrome = true, publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
			return super.scenarios();
	}
	@BeforeTest
	@Parameters({ "browser" })
	public void browserFromTestNG(@Optional String browser) {

	}

}
