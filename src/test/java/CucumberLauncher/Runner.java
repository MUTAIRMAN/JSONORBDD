package CucumberLauncher;

import static org.junit.Assert.assertArrayEquals;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Features/JSONReaderTest.feature"},
		glue ="StepDef/",
		format= "html:muthu.html",
		tags= {"@dimple"},
		monochrome=true
		)  
public class Runner {
	
	
}
