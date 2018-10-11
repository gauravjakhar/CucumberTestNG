package testrunner;

import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
			
				
@CucumberOptions(features="src//features"
					,glue={"stepdefinition","utility"}
					,plugin = {"pretty", "html:target/cucumber"}
					,dryRun = false
				)

@Test
public class Runner extends AbstractTestNGCucumberTests	
{		
	
}