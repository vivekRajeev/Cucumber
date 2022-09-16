package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
features= "src/test/java/features",
glue="stepDefination",monochrome=true,tags="@kpi")

public class Testrunner extends AbstractTestNGCucumberTests 
{

}

