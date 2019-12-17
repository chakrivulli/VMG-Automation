package com.vmg.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"Features/New_Features"/*,"Features/Deeplink",
				"Features/Donations","Features/MakeDonation","Features/Fundarisers","Features"*/},
 		glue = {"classpath:com.vmg.stepdefinition"},
		tags = {"@SmokeTest2"},
		plugin={"json:target/cucumber-reports/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:Reports/cucumber-reports/report.html"
				//"html:target/selenium-reports"
				},
		monochrome = true
		
		)


public class Runner {

	@AfterClass
	public static void setup()
	{
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", "Surekha");
		Reporter.setSystemInfo("Application Name", "Test App");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("'Virgin Money giving' Report");
	}
}
	

